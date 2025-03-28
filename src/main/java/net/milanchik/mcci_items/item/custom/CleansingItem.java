//package net.milanchik.mcci_items.item.custom;
//
//
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.projectile.ProjectileEntity;
//import net.minecraft.entity.projectile.thrown.PotionEntity;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.PotionItem;
//import net.minecraft.item.ProjectileItem;
//import net.minecraft.stat.Stats;
//import net.minecraft.util.Hand;
//import net.minecraft.util.TypedActionResult;
//import net.minecraft.util.math.Direction;
//import net.minecraft.util.math.Position;
//import net.minecraft.world.World;
//
//public class CleansingItem extends PotionItem implements ProjectileItem {
//    public CleansingItem(Item.Settings settings) {
//        super(settings);
//    }
//
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        ItemStack itemStack = user.getStackInHand(hand);
//        if (!world.isClient) {
//            PotionEntity potionEntity = new PotionEntity(world, user);
//            potionEntity.setItem(itemStack);
//            potionEntity.setVelocity(user, user.getPitch(), user.getYaw(), -20.0F, 0.5F, 1.0F);
//            world.spawnEntity(potionEntity);
//        }
//
//        user.incrementStat(Stats.USED.getOrCreateStat(this));
//        itemStack.decrementUnlessCreative(1, user);
//        return TypedActionResult.success(itemStack, world.isClient());
//    }
//
//    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
//        PotionEntity potionEntity = new PotionEntity(world, pos.getX(), pos.getY(), pos.getZ());
//        potionEntity.setItem(stack);
//        return potionEntity;
//    }
//
////    public ProjectileItem.Settings getProjectileSettings() {
////        return Settings.builder().uncertainty(Settings.DEFAULT.uncertainty() * 0.5F).power(Settings.DEFAULT.power() * 1.25F).build();
////    }
//}
