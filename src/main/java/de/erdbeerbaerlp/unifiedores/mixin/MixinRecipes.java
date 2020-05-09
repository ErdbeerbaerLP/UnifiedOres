package de.erdbeerbaerlp.unifiedores.mixin;

import com.google.gson.JsonObject;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;
import java.util.Map;

@Mixin(RecipeManager.class)
public class MixinRecipes {
    @Shadow private Map<IRecipeType<?>, Map<ResourceLocation, IRecipe<?>>> recipes;
    @Inject(method = "apply", at = @At("RETURN"))
    private void overrideRecipes(Map<ResourceLocation, JsonObject> splashList, IResourceManager resourceManagerIn, IProfiler profilerIn, CallbackInfo ci){
        System.out.println("Attempting to replace recipes...");
        recipes.forEach((a,b)->{
            b.forEach((c,d)->{
                System.out.println(c);
                System.out.println(d);
                for(Field f : d.getClass().getDeclaredFields()){
                    System.out.println(f.getName());
                    System.out.println(f.getType());
                }
            });
        });
    }
}
