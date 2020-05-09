package de.erdbeerbaerlp.unifiedores;

import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class Util {
    public static boolean containsOreName(final ResourceLocation loc) throws IllegalAccessException {
        final String name = loc.getPath();
        for (Field f : Tags.class.getFields()) {
            if (f.getType().equals(ResourceLocation.class)) {
                final String name2 = ((ResourceLocation) f.get(new ResourceLocation("air"))).getPath().replace("ores/", "");
                if (StringUtils.containsIgnoreCase(name, name2)) return true;
            }
        }
        return false;
    }
}
