package net.milanchik.mcci_items.item;

import net.milanchik.mcci_items.MCCIItems;
import net.milanchik.mcci_items.item.custom.*;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item REGEN = registerItem("regen_spark", new RegenItem(new Item.Settings().maxCount(16)));
    public static final Item SPEED = registerItem("speed_spark", new SpeedItem(new Item.Settings().maxCount(16)));
    public static final Item LEVETATION = registerItem("levetation_spark", new LevetationItem(new Item.Settings().maxCount(16)));
    public static final Item INVISIBILITY = registerItem("invisibility_spark", new InvisibilityItem(new Item.Settings().maxCount(16)));
    //    public static final Item CLEANSING = registerItem("cleansing_orb", new CleansingItem(new Item.Settings().maxCount(16)));
    public static final Item HEAVY_CROSSBOW = registerItem("heavy_crossbow",
        new HeavyCrossbowItem(new Item.Settings().maxDamage(465).maxCount(1)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MCCIItems.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MCCIItems.LOGGER.info("Registering Mod Items for" + MCCIItems.MOD_ID);

    }
}
