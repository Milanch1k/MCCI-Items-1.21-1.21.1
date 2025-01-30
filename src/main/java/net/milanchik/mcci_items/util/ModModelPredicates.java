package net.milanchik.mcci_items.util;


import net.milanchik.mcci_items.item.ModItems;
import net.milanchik.mcci_items.item.custom.HeavyCrossbowItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.HEAVY_CROSSBOW, Identifier.of("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0F;
                    } else {
                        return HeavyCrossbowItem.isCharged(stack) ? 0.0F : (float) (stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / (float) HeavyCrossbowItem.getPullTime(stack, entity);
                    }
                });
        ModelPredicateProviderRegistry.register(ModItems.HEAVY_CROSSBOW, Identifier.of("pulling"),
                (stack, world, entity, seed) -> { return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack && !HeavyCrossbowItem.isCharged(stack) ? 1F : 0F; });

        ModelPredicateProviderRegistry.register(ModItems.HEAVY_CROSSBOW, Identifier.of("charged"),
                (stack, world, entity, seed) -> { return HeavyCrossbowItem.isCharged(stack) ? 1.0F : 0.0F; });
    }
}

