package org.embeddedt.embeddium.compat.littletiles;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.Loader;

public final class LittleTilesCompat {
    private static final boolean LITTLE_TILES_LOADED = Loader.isModLoaded("littletiles");
    private static final String[] LITTLE_TILES_PREFIXES = new String[] {
            "com.creativemd.littletiles.",
            "team.creative.littletiles."
    };

    private LittleTilesCompat() {
    }

    public static boolean isLittleTilesLoaded() {
        return LITTLE_TILES_LOADED;
    }

    public static boolean isLittleTilesTileEntity(TileEntity entity) {
        if (!LITTLE_TILES_LOADED || entity == null) {
            return false;
        }

        Class<?> klass = entity.getClass();

        while (klass != null && klass != Object.class) {
            String className = klass.getName();

            for (String prefix : LITTLE_TILES_PREFIXES) {
                if (className.startsWith(prefix)) {
                    return true;
                }
            }

            if (className.contains(".littletiles.")) {
                return true;
            }

            klass = klass.getSuperclass();
        }

        return false;
    }
}
