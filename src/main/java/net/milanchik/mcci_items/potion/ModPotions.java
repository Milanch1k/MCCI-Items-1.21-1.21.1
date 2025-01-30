package net.milanchik.mcci_items.potion;

import net.milanchik.mcci_items.MCCIItems;
import net.milanchik.mcci_items.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> CLEANSING_POTION = registerPotion("cleansing_potion",
            new Potion(new StatusEffectInstance(ModEffects.CLEANSING, 1200, 0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(MCCIItems.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        MCCIItems.LOGGER.info("Registering Mod Potions for " + MCCIItems.MOD_ID);
    }
}