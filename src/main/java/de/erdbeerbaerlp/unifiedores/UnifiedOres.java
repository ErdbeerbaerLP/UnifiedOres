package de.erdbeerbaerlp.unifiedores;

import de.erdbeerbaerlp.unifiedores.itemGroup.GroupUnifiedOres;
import de.erdbeerbaerlp.unifiedores.world.OreGen;
import net.minecraft.client.gui.recipebook.RecipeList;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("unifiedores")
public class UnifiedOres {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup unifiedoresGroup = new GroupUnifiedOres("unifiedores");
    public UnifiedOres() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(new Events());
    }

    private void setup(final FMLCommonSetupEvent event) {
        OreGen.setupOregen();
    }
}
