package net.milanchik.mcci_items.gamerules;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.milanchik.mcci_items.MCCIItems;
import net.minecraft.world.GameRules;

public class RuleRegister {
    public static final GameRules.Key<GameRules.BooleanRule> TNT_AUTO_EXPLOSION = GameRuleRegistry.register("tntAutoExplosion",
            GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));
    public static void register(){
        MCCIItems.LOGGER.info("Registering rules for: " + MCCIItems.MOD_ID);
    }
}
