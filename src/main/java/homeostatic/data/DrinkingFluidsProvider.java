package homeostatic.data;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;

import homeostatic.Homeostatic;
import homeostatic.common.fluid.DrinkingFluid;
import homeostatic.common.fluid.DrinkingFluidManager;
import homeostatic.data.integration.ModIntegration;

public class DrinkingFluidsProvider implements DataProvider {

    private final Map<ResourceLocation, DrinkingFluid> DRINKING_FLUIDS = new HashMap<>();
    private final DataGenerator dataGenerator;
    private final String modid;

    public DrinkingFluidsProvider(DataGenerator dataGenerator, String modid) {
        this.dataGenerator = dataGenerator;
        this.modid = modid;
    }

    protected void addDrinkingFluids() {
        add(ModIntegration.mcLoc("water"), 1, 0.0F, 45, 200, 0.2F);
        add(Homeostatic.loc("purified_water"), 3, 0.7F,  0, 0, 0.0F);
    }

    protected void add(ResourceLocation loc, int amount, float saturation, int potency, int duration, float chance) {
        DRINKING_FLUIDS.put(loc, new DrinkingFluid(loc, amount, saturation, potency, duration, chance));
    }

    @Override
    public String getName() {
        return "Homeostatic - Drinking Fluids";
    }

    @Override
    public void run(CachedOutput pOutput) throws IOException {
        addDrinkingFluids();

        Path output = dataGenerator.getOutputFolder();

        for (Map.Entry<ResourceLocation, DrinkingFluid> entry : DRINKING_FLUIDS.entrySet()) {
            Path drinkingFluidsPath = getPath(output, entry.getKey());

            try {
                DataProvider.saveStable(pOutput, DrinkingFluidManager.parseDrinkingFluid(entry.getValue()), drinkingFluidsPath);
            }
            catch (IOException e) {
                Homeostatic.LOGGER.error("Couldn't save homeostatic drinking fluids %s %s", drinkingFluidsPath, e);
            }
        }
    }

    private static Path getPath(Path output, ResourceLocation loc) {
        return output.resolve("data/" + loc.getNamespace() + "/environment/fluids/" + loc.getPath() + ".json");
    }

}