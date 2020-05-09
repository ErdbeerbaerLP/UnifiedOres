package de.erdbeerbaerlp.unifiedores.world;

import de.erdbeerbaerlp.unifiedores.blocks.BlockContainer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
    public static void setupOregen() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockContainer.copper_ore.getDefaultState(), 8))
                            .func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(16, 0, 0, 60))));
            /*biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockContainer.tin_ore.getDefaultState(), 8))
                            .func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(14,0,0,60))));
*/
        }
    }
}
