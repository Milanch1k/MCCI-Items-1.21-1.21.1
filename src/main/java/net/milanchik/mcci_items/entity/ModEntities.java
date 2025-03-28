//package net.milanchik.mcci_items.entity;
//
//import net.milanchik.mcci_items.MCCIItems;
//import net.milanchik.mcci_items.entity.custom.CleansingEntity;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.SpawnGroup;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//
//public class ModEntities {
//    public static final EntityType<CleansingEntity> CLEANSING = Registry.register(Registries.ENTITY_TYPE,
//            Identifier.of(MCCIItems.MOD_ID, "cleansing"),
//            EntityType.Builder.create(CleansingEntity::new, SpawnGroup.CREATURE)
//                    .dimensions(1f, 2.5F).build());
//
//
//    public static void registerModEntities() {
//        MCCIItems.LOGGER.info("Registering Mod Entities for " + MCCIItems.MOD_ID);
//    }
//}
