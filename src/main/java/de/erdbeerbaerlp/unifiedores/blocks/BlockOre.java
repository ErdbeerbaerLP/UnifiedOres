package de.erdbeerbaerlp.unifiedores.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

public class BlockOre extends Block {
    final Item dropItem;
    final int quantity;

    public BlockOre(final Properties p, final String name) {
        super(p);
        setRegistryName(new ResourceLocation("unifiedores", name));
        this.dropItem = null;
        this.quantity = 1;
    }

    public BlockOre(final Properties p, final String name, final Item dropItem, final int quantity) {
        super(p);
        setRegistryName(new ResourceLocation("unifiedores", name));
        this.dropItem = dropItem;
        this.quantity = quantity;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        final ArrayList<ItemStack> out = new ArrayList<>();
        if (dropItem == null)  out.add(new ItemStack(BlockContainer.copper_ore));
        else out.add(new ItemStack(dropItem, quantity));
        return out;
    }
}
