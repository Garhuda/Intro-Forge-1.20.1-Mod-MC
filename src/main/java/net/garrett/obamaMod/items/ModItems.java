package net.garrett.obamaMod.items;

import net.minecraft.client.resources.model.Material;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.obj.ObjMaterialLibrary;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import static net.garrett.obamaMod.ObamaMod.MOD_ID;
import static net.minecraftforge.registries.ForgeRegistries.BLOCKS;
//import static net.garrett.obamaMod.items.ModSwords.SOUND_EVENTS;

public class ModItems {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final RegistryObject<Block> obama_cube = BLOCKS.register("obama_cube",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BEDROCK)));

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Item> obama_cube_item = ITEMS.register("obama_cube", () -> {
        System.out.println("Registering item: obama_cube");
        return new BlockItem(obama_cube.get(), new Item.Properties());
    });

    public static final RegistryObject<Item> obama = ITEMS.register("obama",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> obama_ingot = ITEMS.register("obama_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> seventh_ward_lord = ITEMS.register("seventh_ward_lord",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<SwordItem> obama_sword = ITEMS.register("obama_sword",
            () -> new SwordItem(Tiers.DIAMOND, 999999999, 100F, new Item.Properties())
    );

    public static final RegistryObject<SwordItem> poop_sword = ITEMS.register("poop_sword",
            () -> new SwordItem(Tiers.DIAMOND, -1, 0F, new Item.Properties())
    );

    public static final RegistryObject<Item> poo_stick = ITEMS.register("poo_stick",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)  // Stack size of 1
                    //.durability(50)  // Makes the item have durability
                    .food(new FoodProperties.Builder()
                            .nutrition(6)  // Restores 4 hunger points
                            .saturationMod(0.6f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 4500), 1)
                            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 4500), 1)
                            .build())
            )
    );

    public static final SoundEvent SOUND_EVENT = null;


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        //SOUND_EVENTS.register(eventBus);
    }
}


