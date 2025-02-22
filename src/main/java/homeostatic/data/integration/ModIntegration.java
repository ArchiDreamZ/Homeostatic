package homeostatic.data.integration;

import net.minecraft.resources.ResourceLocation;

public class ModIntegration {

    public static final String ALEX_MODID = "alexsmobs";
    public static final String ARS_MODID = "ars_nouveau";
    public static final String BYG_MODID = "byg";
    public static final String CREATE_MODID = "create";
    public static final String CC_MODID = "createcafe";
    public static final String CROPTOPIA_MODID = "croptopia";
    public static final String ECO_MODID = "ecologics";
    public static final String FD_MODID = "farmersdelight";
    public static final String FT_MODID = "fruittrees";
    public static final String IE_MODID = "immersiveengineering";
    public static final String MC_MODID = "minecraft";
    public static final String MORECRAFT_MODID = "morecraft";
    public static final String PATCHOULI_MODID = "patchouli";
    public static final String SPROUT_MODID = "sprout";
    public static final String XERCA_MODID = "xercamod";

    public static ResourceLocation alexLoc(String path) {
        return new ResourceLocation(ALEX_MODID, path);
    }

    public static ResourceLocation arsLoc(String path) {
        return new ResourceLocation(ARS_MODID, path);
    }

    public static ResourceLocation bygLoc(String path) {
        return new ResourceLocation(BYG_MODID, path);
    }

    public static ResourceLocation ccLoc(String path) {
        return new ResourceLocation(CC_MODID, path);
    }

    public static ResourceLocation croptopiaLoc(String path) {
        return new ResourceLocation(CROPTOPIA_MODID, path);
    }

    public static ResourceLocation ecoLoc(String path) {
        return new ResourceLocation(ECO_MODID, path);
    }

    public static ResourceLocation fdLoc(String path) {
        return new ResourceLocation(FD_MODID, path);
    }

    public static ResourceLocation ftLoc(String path) {
        return new ResourceLocation(FT_MODID, path);
    }

    public static ResourceLocation ieLoc(String path) {
        return new ResourceLocation(IE_MODID, path);
    }

    public static ResourceLocation mcLoc(String path) {
        return new ResourceLocation(MC_MODID, path);
    }

    public static ResourceLocation sproutLoc(String path) {
        return new ResourceLocation(SPROUT_MODID, path);
    }

    public static ResourceLocation morecraftLoc(String path) {
        return new ResourceLocation(MORECRAFT_MODID, path);
    }

    public static ResourceLocation xercaLoc(String path) {
        return new ResourceLocation(XERCA_MODID, path);
    }

}
