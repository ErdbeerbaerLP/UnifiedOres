package de.erdbeerbaerlp.unifiedores.itemGroup;

import de.erdbeerbaerlp.unifiedores.items.ItemContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.lang.reflect.Field;

public class GroupUnifiedOres extends ItemGroup {
    public GroupUnifiedOres(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemContainer.copper_ingot);
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }

    @SuppressWarnings("NoTranslation")
    @Override
    public String getTabLabel() {
        return I18n.format("unifiedores.name");
    }

    @Override
    public void fill(NonNullList<ItemStack> items) {
        for(Field f : ItemContainer.class.getDeclaredFields()){
            f.setAccessible(true);
            try {
                items.add(new ItemStack((Item) f.get(new Item(new Item.Properties()))));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
