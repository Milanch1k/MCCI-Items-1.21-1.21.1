package net.milanchik.mcci_items.mixin;

import net.milanchik.mcci_items.gamerules.RuleRegister;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class DeathSpectatorMixin {

    @Inject(method = "onDeath", at = @At("TAIL"))
    public void onDeath(CallbackInfo ci) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
        ServerWorld world = player.getServerWorld();
        if (world.getGameRules().getBoolean(RuleRegister.DEATH_SPECTATOR)) {
            player.changeGameMode(GameMode.SPECTATOR);
        }
    }

}