package net.milanchik.mcci_items.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.milanchik.mcci_items.MCCIItems;
import net.milanchik.mcci_items.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MCCI_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MCCIItems.MOD_ID, "items"), // Путь
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.REGEN)) // Иконка
                    .displayName(Text.translatable("itemgroup.mcci-items.items")) // Ключ для локализации
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.REGEN);
                        entries.add(ModItems.SPEED);
                        entries.add(ModItems.LEVETATION);
                        entries.add(ModItems.INVISIBILITY);
//                        entries.add(ModItems.CLEANSING);
                        entries.add(ModItems.HEAVY_CROSSBOW);
                        entries.add(ModBlocks.BUILDING_BLOCK);
                    })
                    .build());


    public static void regiterItemGroups() {
        MCCIItems.LOGGER.info("Registering Item Groups for " + MCCIItems.MOD_ID);
    }
}
