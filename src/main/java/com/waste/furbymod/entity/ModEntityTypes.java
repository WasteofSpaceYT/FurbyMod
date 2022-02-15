package com.waste.furbymod.entity;

import com.waste.furbymod.FurbyMod;
import com.waste.furbymod.entity.custom.FurbyEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, FurbyMod.MOD_ID);

    public static RegistryObject<EntityType<FurbyEntity>> Furby = ENTITY_TYPES.register("furby_entity", () -> EntityType.Builder.create(FurbyEntity::new, EntityClassification.CREATURE).size(1f,3f).build(new ResourceLocation(FurbyMod.MOD_ID, "furby_entity").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
