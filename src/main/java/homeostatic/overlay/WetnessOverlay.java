package homeostatic.overlay;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import homeostatic.common.capabilities.CapabilityRegistry;
import homeostatic.common.wetness.WetnessInfo;
import homeostatic.Homeostatic;
import homeostatic.util.OverlayHelper;

public class WetnessOverlay extends Overlay {

    public final static ResourceLocation WETNESS_OVERLAY = Homeostatic.loc("textures/gui/wetness.png");

    public WetnessOverlay() {}

    @Override
    public void render(PoseStack matrix, Minecraft mc, @Nullable BlockPos pos, int scaledWidth, int scaledHeight) {
        final Player player = mc.player;

        if (player == null) return;

        player.getCapability(CapabilityRegistry.WETNESS_CAPABILITY).ifPresent(data -> {
            float wetnessPercentage = (float) data.getWetnessLevel() / (float) WetnessInfo.MAX_WETNESS_LEVEL;

            if (wetnessPercentage > 0.0F) {
                OverlayHelper.renderTexture(WETNESS_OVERLAY, scaledWidth, scaledHeight, wetnessPercentage);
            }

        });
    }

}
