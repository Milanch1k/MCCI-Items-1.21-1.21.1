package net.milanchik.mcci_items.effect;

import net.milanchik.mcci_items.MCCIItems;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> CLEANSING = registerStatusEffect("cleansing",
            new CleansingEffect(StatusEffectCategory.NEUTRAL, 0xffffff)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(MCCIItems.MOD_ID, "cleansing"), -0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MCCIItems.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        MCCIItems.LOGGER.info("Registering Mod Effects for " + MCCIItems.MOD_ID);
    }
}