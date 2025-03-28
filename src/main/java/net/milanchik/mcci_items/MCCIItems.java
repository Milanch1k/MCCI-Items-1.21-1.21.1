package net.milanchik.mcci_items;

import net.fabricmc.api.ModInitializer;

import net.milanchik.mcci_items.block.ModBlocks;
import net.milanchik.mcci_items.effect.ModEffects;
import net.milanchik.mcci_items.gamerules.RuleRegister;
import net.milanchik.mcci_items.item.ModItemGroups;
import net.milanchik.mcci_items.item.ModItems;
import net.milanchik.mcci_items.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCIItems implements ModInitializer {
    public static final String MOD_ID = "mcci-items";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModPotions.registerPotions();
        ModEffects.registerEffects();
        ModItems.registerModItems();
        ModItemGroups.regiterItemGroups();
        RuleRegister.register();
        ModBlocks.registerModBlocks();
    }
}