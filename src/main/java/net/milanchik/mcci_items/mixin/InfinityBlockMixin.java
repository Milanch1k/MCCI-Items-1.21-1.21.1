package net.milanchik.mcci_items.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class InfinityBlockMixin {
    private int tickCounter = 0;
    private static final int TICKS_PER_SECOND = 20;
    private static final int UPDATE_INTERVAL = TICKS_PER_SECOND;

    @Inject(method = "tick", at = @At("HEAD"))
    private void keepConcreteStacked(CallbackInfo ci) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

        tickCounter++;

        if (tickCounter >= UPDATE_INTERVAL) {
            ItemStack mainHandStack = player.getStackInHand(Hand.MAIN_HAND);
            ItemStack offHandStack = player.getStackInHand(Hand.OFF_HAND);

            if (isConcrete(mainHandStack) && mainHandStack.getCount() < 64) {
                mainHandStack.setCount(64);
                if (player instanceof ServerPlayerEntity serverPlayer) {
                    serverPlayer.currentScreenHandler.sendContentUpdates();
                }
            }

            if (isConcrete(offHandStack) && offHandStack.getCount() < 64) {
                offHandStack.setCount(64);
                if (player instanceof ServerPlayerEntity serverPlayer) {
                    serverPlayer.currentScreenHandler.sendContentUpdates();
                }
            }

            tickCounter = 0;
        }
    }

    private boolean isConcrete(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return false;
        String itemId = stack.getItem().toString();
        return itemId.contains("_concrete") && !itemId.contains("_powder");
    }
}