//package net.milanchik.mcci_items.entity.custom;
//
//import it.unimi.dsi.fastutil.doubles.DoubleDoubleImmutablePair;
//import net.milanchik.mcci_items.effect.ModEffects;
//import net.minecraft.block.AbstractCandleBlock;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.CampfireBlock;
//import net.minecraft.component.DataComponentTypes;
//import net.minecraft.component.type.PotionContentsComponent;
//import net.minecraft.entity.*;
//import net.minecraft.entity.damage.DamageSource;
//import net.minecraft.entity.effect.StatusEffect;
//import net.minecraft.entity.effect.StatusEffectInstance;
//import net.minecraft.entity.passive.AxolotlEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.projectile.thrown.PotionEntity;
//import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.potion.Potion;
//import net.minecraft.potion.Potions;
//import net.minecraft.registry.entry.RegistryEntry;
//import net.minecraft.registry.tag.BlockTags;
//import net.minecraft.util.hit.BlockHitResult;
//import net.minecraft.util.hit.EntityHitResult;
//import net.minecraft.util.hit.HitResult;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Box;
//import net.minecraft.util.math.Direction;
//import net.minecraft.world.World;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.function.Predicate;
//
//public class CleansingEntity extends ThrownItemEntity implements FlyingItemEntity {
//    public static final double field_30667 = 4.0;
//    private static final double field_30668 = 16.0;
//    public static final Predicate<LivingEntity> AFFECTED_BY_WATER = (entity) -> {
//        return entity.hurtByWater() || entity.isOnFire();
//    };
//
//    public CleansingEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
//        super(entityType, world);
//    }
//
////    public CleansingEntity(World world, LivingEntity owner) {
////        super(EntityType.POTION, owner, world);
////    }
////
////    public CleansingEntity(World world, double x, double y, double z) {
////        super(EntityType.POTION, x, y, z, world);
////    }
//
//    protected Item getDefaultItem() {
//        return Items.SPLASH_POTION;
//    }
//
//    protected double getGravity() {
//        return 0.04;
//    }
//
//    protected void onBlockHit(BlockHitResult blockHitResult) {
//        super.onBlockHit(blockHitResult);
//        if (!this.getWorld().isClient) {
//            ItemStack itemStack = this.getStack();
//            Direction direction = blockHitResult.getSide();
//            BlockPos blockPos = blockHitResult.getBlockPos();
//            BlockPos blockPos2 = blockPos.offset(direction);
//            PotionContentsComponent potionContentsComponent = (PotionContentsComponent)itemStack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
//            if (potionContentsComponent.matches(Potions.WATER)) {
//                this.extinguishFire(blockPos2);
//                this.extinguishFire(blockPos2.offset(direction.getOpposite()));
//                Iterator var7 = Direction.Type.HORIZONTAL.iterator();
//
//                while(var7.hasNext()) {
//                    Direction direction2 = (Direction)var7.next();
//                    this.extinguishFire(blockPos2.offset(direction2));
//                }
//            }
//
//        }
//    }
//
//    protected void onCollision(HitResult hitResult) {
//        super.onCollision(hitResult);
//        if (!this.getWorld().isClient) {
//            ItemStack itemStack = this.getStack();
//            PotionContentsComponent potionContentsComponent = (PotionContentsComponent)itemStack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
//            if (potionContentsComponent.matches(Potions.WATER)) {
//                this.applyWater();
//            } else if (potionContentsComponent.hasEffects()) {
//                if (this.isLingering()) {
//                    this.applyLingeringPotion(potionContentsComponent);
//                } else {
//                    this.applySplashPotion(potionContentsComponent.getEffects(), hitResult.getType() == net.minecraft.util.hit.HitResult.Type.ENTITY ? ((EntityHitResult)hitResult).getEntity() : null);
//                }
//            }
//
//            int i = potionContentsComponent.potion().isPresent() && ((Potion)((RegistryEntry)potionContentsComponent.potion().get()).value()).hasInstantEffect() ? 2007 : 2002;
//            this.getWorld().syncWorldEvent(i, this.getBlockPos(), potionContentsComponent.getColor());
//            this.discard();
//        }
//    }
//
//    private void applyWater() {
//        Box box = this.getBoundingBox().expand(4.0, 2.0, 4.0);
//        List<LivingEntity> list = this.getWorld().getEntitiesByClass(LivingEntity.class, box, AFFECTED_BY_WATER);
//        Iterator var3 = list.iterator();
//
//        while(var3.hasNext()) {
//            LivingEntity livingEntity = (LivingEntity)var3.next();
//            double d = this.squaredDistanceTo(livingEntity);
//            if (d < 16.0) {
//                if (livingEntity.hurtByWater()) {
//                    livingEntity.damage(this.getDamageSources().indirectMagic(this, this.getOwner()), 1.0F);
//                }
//
//                if (livingEntity.isOnFire() && livingEntity.isAlive()) {
//                    livingEntity.extinguishWithSound();
//                }
//            }
//        }
//
//        List<AxolotlEntity> list2 = this.getWorld().getNonSpectatingEntities(AxolotlEntity.class, box);
//        Iterator var8 = list2.iterator();
//
//        while(var8.hasNext()) {
//            AxolotlEntity axolotlEntity = (AxolotlEntity)var8.next();
//            axolotlEntity.hydrateFromPotion();
//        }
//
//    }
//
//    private void applySplashPotion(Iterable<StatusEffectInstance> effects, @Nullable Entity entity) {
//        Box box = this.getBoundingBox().expand(4.0, 2.0, 4.0);
//        List<LivingEntity> list = this.getWorld().getNonSpectatingEntities(LivingEntity.class, box);
//        if (!list.isEmpty()) {
//            Entity entity2 = this.getEffectCause();
//            Iterator var6 = list.iterator();
//
//            while(true) {
//                LivingEntity livingEntity;
//                double d;
//                do {
//                    do {
//                        if (!var6.hasNext()) {
//                            return;
//                        }
//
//                        livingEntity = (LivingEntity)var6.next();
//                    } while(!livingEntity.isAffectedBySplashPotions());
//
//                    d = this.squaredDistanceTo(livingEntity);
//                } while(!(d < 16.0));
//
//                double e;
//                if (livingEntity == entity) {
//                    e = 1.0;
//                } else {
//                    e = 1.0 - Math.sqrt(d) / 4.0;
//                }
//
//                Iterator var12 = effects.iterator();
//
//                while(var12.hasNext()) {
//                    StatusEffectInstance statusEffectInstance = (StatusEffectInstance)var12.next();
//                    RegistryEntry<StatusEffect> registryEntry = statusEffectInstance.getEffectType();
//                    if (((StatusEffect)registryEntry.value()).isInstant()) {
//                        ((StatusEffect)registryEntry.value()).applyInstantEffect(this, this.getOwner(), livingEntity, statusEffectInstance.getAmplifier(), e);
//                    } else {
//                        int i = statusEffectInstance.mapDuration((duration) -> {
//                            return (int)(e * (double)duration + 0.5);
//                        });
//                        StatusEffectInstance statusEffectInstance2 = new StatusEffectInstance(registryEntry, i, statusEffectInstance.getAmplifier(), statusEffectInstance.isAmbient(), statusEffectInstance.shouldShowParticles());
//                        if (!statusEffectInstance2.isDurationBelow(20)) {
//                            livingEntity.addStatusEffect((StatusEffectInstance) ModEffects.CLEANSING, entity2);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private void applyLingeringPotion(PotionContentsComponent potion) {
//        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.getWorld(), this.getX(), this.getY(), this.getZ());
//        Entity var4 = this.getOwner();
//        if (var4 instanceof LivingEntity livingEntity) {
//            areaEffectCloudEntity.setOwner(livingEntity);
//        }
//
//        areaEffectCloudEntity.setRadius(3.0F);
//        areaEffectCloudEntity.setRadiusOnUse(-0.5F);
//        areaEffectCloudEntity.setWaitTime(10);
//        areaEffectCloudEntity.setRadiusGrowth(-areaEffectCloudEntity.getRadius() / (float)areaEffectCloudEntity.getDuration());
//        areaEffectCloudEntity.setPotionContents(potion);
//        this.getWorld().spawnEntity(areaEffectCloudEntity);
//    }
//
//    private boolean isLingering() {
//        return this.getStack().isOf(Items.LINGERING_POTION);
//    }
//
//    private void extinguishFire(BlockPos pos) {
//        BlockState blockState = this.getWorld().getBlockState(pos);
//        if (blockState.isIn(BlockTags.FIRE)) {
//            this.getWorld().breakBlock(pos, false, this);
//        } else if (AbstractCandleBlock.isLitCandle(blockState)) {
//            AbstractCandleBlock.extinguish((PlayerEntity)null, blockState, this.getWorld(), pos);
//        } else if (CampfireBlock.isLitCampfire(blockState)) {
//            this.getWorld().syncWorldEvent((PlayerEntity)null, 1009, pos, 0);
//            CampfireBlock.extinguish(this.getOwner(), this.getWorld(), pos, blockState);
//            this.getWorld().setBlockState(pos, (BlockState)blockState.with(CampfireBlock.LIT, false));
//        }
//
//    }
//
//    public DoubleDoubleImmutablePair getKnockback(LivingEntity target, DamageSource source) {
//        double d = target.getPos().x - this.getPos().x;
//        double e = target.getPos().z - this.getPos().z;
//        return DoubleDoubleImmutablePair.of(d, e);
//    }
//}
