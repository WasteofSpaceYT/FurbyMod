package com.waste.furbymod.item;

import com.waste.furbymod.FurbyMod;
import com.waste.furbymod.entity.ModEntityTypes;
import com.waste.furbymod.item.custom.ModSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FurbyMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<ModSpawnEggItem> BUFF_ZOMBIE_SPAWN_EGG = ITEMS.register("furby_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.Furby, 0xFF00FF, 0x964B00,
                    new Item.Properties().group(ItemGroup.MISC)));
}
