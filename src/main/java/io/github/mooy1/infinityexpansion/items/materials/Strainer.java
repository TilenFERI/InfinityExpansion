package io.github.mooy1.infinityexpansion.items.materials;

import javax.annotation.Nullable;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import io.github.thebusybiscuit.slimefun5.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun5.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun5.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun5.core.attributes.NotPlaceable;

/**
 * Items to be used in the Strainer Base
 *
 * @author Mooy1
 */
public final class Strainer extends SlimefunItem implements NotPlaceable {

    private static final NamespacedKey KEY = new NamespacedKey("infinityexpansion", "strainer_speed");

    public Strainer(SlimefunItemStack item, ItemStack[] recipe, int speed) {
        super(io.github.mooy1.infinityexpansion.categories.Groups.BASIC_MACHINES,
                addSpeed(item, speed), RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
    }

    private static SlimefunItemStack addSpeed(SlimefunItemStack item, int speed) {
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(KEY, PersistentDataType.INTEGER, speed);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * This method gets the speed of strainer from an item
     *
     * @return speed
     */
    public static int getStrainer(@Nullable ItemStack item) {
        if (item != null && item.hasItemMeta()) {
            return item.getItemMeta().getPersistentDataContainer()
                    .getOrDefault(KEY, PersistentDataType.INTEGER, 0);
        }
        return 0;
    }

}
