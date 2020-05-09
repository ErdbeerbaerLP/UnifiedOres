package de.erdbeerbaerlp.unifiedores;

import de.erdbeerbaerlp.unifiedores.blocks.BlockContainer;
import de.erdbeerbaerlp.unifiedores.blocks.BlockOre;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Events {
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        System.out.println("Registering blocks");
        registerAllBlocksForOre("copper",1, event);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        System.out.println("Registering items");
        registerAllItemsForOre("copper", BlockContainer.copper_block,BlockContainer.copper_ore, event);
    }

    private static void registerAllItemsForOre(final String name, final Block block, final Block ore, final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(ore, new Item.Properties()).setRegistryName("unifiedores", name + "_ore"));
        event.getRegistry().register(new BlockItem(block, new Item.Properties()).setRegistryName("unifiedores", name + "_block"));
        event.getRegistry().register(new Item(new Item.Properties()).setRegistryName("unifiedores", name + "_ingot"));
        event.getRegistry().register(new Item(new Item.Properties()).setRegistryName("unifiedores", name + "_nugget"));
        event.getRegistry().register(new Item(new Item.Properties()).setRegistryName("unifiedores", name + "_dust"));
    }

    private static void registerAllBlocksForOre(final String name, int harvestLevel, final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockOre(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(harvestLevel), name + "_ore"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)).setRegistryName("unifiedores", name + "_block"));
    }

}