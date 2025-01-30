package net.milanchik.mcci_items.mixin;

import net.milanchik.mcci_items.gamerules.RuleRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TntBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TntBlock.class)
public class TntMixin extends Block {
    public TntMixin(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.getGameRules().getBoolean(RuleRegister.TNT_AUTO_EXPLOSION)) {
            world.removeBlock(pos, false);
            TntBlock.primeTnt(world, pos);
            super.onPlaced(world, pos, state, placer, itemStack);
        }
    }
}