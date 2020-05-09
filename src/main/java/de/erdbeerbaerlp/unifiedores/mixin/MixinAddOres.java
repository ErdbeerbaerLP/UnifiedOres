package de.erdbeerbaerlp.unifiedores.mixin;

import de.erdbeerbaerlp.unifiedores.Util;
import de.erdbeerbaerlp.unifiedores.blocks.BlockOre;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Biome.class)
public class MixinAddOres {
    @Inject(method = "addFeature", at = @At("HEAD"), cancellable = true)
    private void oreGen(GenerationStage.Decoration decorationStage, ConfiguredFeature<?, ?> featureIn, CallbackInfo ci) {
        if (decorationStage == GenerationStage.Decoration.UNDERGROUND_ORES && featureIn.config instanceof DecoratedFeatureConfig) {
            DecoratedFeatureConfig in = (DecoratedFeatureConfig) featureIn.config;
            if (in.feature.config instanceof OreFeatureConfig) {
                OreFeatureConfig cfg = (OreFeatureConfig) in.feature.config;
                System.out.println("DEBUG block class: " + cfg.state.getBlock().getClass());
                System.out.println("DEBUG target: " + cfg.target.name());
                if (!(cfg.state.getBlock().getClass() == BlockOre.class) && cfg.target == OreFeatureConfig.FillerBlockType.NATURAL_STONE) {
                    System.out.println("DEBUG ore targetted!");
                    try {
                        if (Util.containsOreName(cfg.state.getBlock().getRegistryName())) {
                            System.out.println("Preventing ore "+cfg.state.getBlock().getRegistryName().toString()+ " to spawn");
                            ci.cancel();
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
