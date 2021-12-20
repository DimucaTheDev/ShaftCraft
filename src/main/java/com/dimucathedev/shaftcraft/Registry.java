package com.dimucathedev.shaftcraft;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}

/*
* package com.DimDima09.SomeStuff;


public class Registry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Main.MOD_ID);
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Main.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Main.MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Main.MOD_ID);

    public static final ResourceLocation WAtER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WAtER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WAtER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    public static final RegistryObject<Coffee> COFFEE = ITEMS.register("coffee", Coffee::new);
    public static final RegistryObject<Item> CUP = ITEMS.register("cup", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_BREWING)));
    public static final RegistryObject<Item> UPDATE_JUMP = ITEMS.register("update_jump", () -> new UpdateJumpItem());
    public static final RegistryObject<Item> GEAR = ITEMS.register("gear", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_REDSTONE)));
    public static final RegistryObject<Radium> RADIUM = ITEMS.register("radium", Radium::new);
    public static final RegistryObject<Radium_fuel> RADIUM_FUEL = ITEMS.register("radium_fuel", Radium_fuel::new);

    public static final RegistryObject<Block> COFFEE_MACHINE = BLOCKS.register("coffee_m", CoffeeMachine::new);
    public static final RegistryObject<Block> JUMP_MACHINE = BLOCKS.register("jump_block", JumpMachine::new);
    public static final RegistryObject<Block> JUMP_MACHINE_TWO = BLOCKS.register("jump_block_two", JumpMachineTwo::new);
    public static final RegistryObject<Block> JUMP_MACHINE_THREE = BLOCKS.register("jump_block_three", JumpMachineThree::new);
    public static final RegistryObject<Block> BOOSTER = BLOCKS.register("booster_three", BoosterBlock::new);
    public static final RegistryObject<Block> RADIUM_ORE = BLOCKS.register("radium_ore", RadiumOre::new);
    public static final RegistryObject<Block> BACKGROUND = BLOCKS.register("radium_ore2", () -> new DispenserBlock(AbstractBlock.Properties.of(Material.BAMBOO)));

    public static final RegistryObject<Item> JUMP_MACHINE_ITEM = ITEMS.register("jump_block", () -> new BlockItemBase(JUMP_MACHINE.get(), new Item.Properties().tab(ItemGroup.TAB_REDSTONE)));
    public static final RegistryObject<Item> JUMP_MACHINE_TWO_ITEM = ITEMS.register("jump_block_two", () -> new BlockItemBase(JUMP_MACHINE_TWO.get(), new Item.Properties().tab(ItemGroup.TAB_REDSTONE)));
    public static final RegistryObject<Item> JUMP_MACHINE_THREE_ITEM = ITEMS.register("jump_block_three", () -> new BlockItemBase(JUMP_MACHINE_THREE.get(), new Item.Properties().tab(ItemGroup.TAB_REDSTONE)));
    public static final RegistryObject<Item> BOOSTER_ITEM = ITEMS.register("booster_three", () -> new BlockItemBase(BOOSTER.get(), new Item.Properties().tab(ItemGroup.TAB_REDSTONE)));
    public static final RegistryObject<Item> COFFEE_MACHINE_ITEM = ITEMS.register("coffee_m", () -> new BlockItemBase(COFFEE_MACHINE.get(), new Item.Properties().tab(ItemGroup.TAB_REDSTONE)));
    public static final RegistryObject<Item> RADIUM_ORE_ITEM = ITEMS.register("radium_ore", () -> new BlockItemBase(RADIUM_ORE.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
public static final RegistryObject<Item> RADIUM_WATER_BUCKET = ITEMS.register("radium_water_bucket", () -> new BucketItem(() -> Registry.RADIUM_WATER.get(), new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static final RegistryObject<SoundEvent> COFFEE_MACHINE_WORKING = SOUNDS.register("item.coffee_machine", () -> new SoundEvent(new ResourceLocation(Main.MOD_ID, "item.coffee_machine")));
    public static final RegistryObject<SoundEvent> CONVEYOR_WORKING = SOUNDS.register("item.booster", () -> new SoundEvent(new ResourceLocation(Main.MOD_ID, "item.booster")));

    public static final RegistryKey<World> TEST_DIMENSION = RegistryKey.create(net.minecraft.util.registry.Registry.DIMENSION_REGISTRY,
            new ResourceLocation(Main.MOD_ID, "test_dim"));

    public static final RegistryObject<FlowingFluid> RADIUM_WATER = FLUIDS.register("radium_water", () -> new ForgeFlowingFluid.Source(Registry.RADIUM_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> RADIUM_WATER_FLOWING = FLUIDS.register("radium_water_flowing", () -> new ForgeFlowingFluid.Flowing(Registry.RADIUM_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties RADIUM_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(() -> RADIUM_WATER.get(), () -> RADIUM_WATER_FLOWING.get(),
            FluidAttributes.builder(WAtER_STILL_RL, WAtER_FLOWING_RL).density(2).luminosity(5).viscosity(1).sound(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS)
        .overlay(WAtER_OVERLAY_RL).color(0xbffed0d0)).slopeFindDistance(5).levelDecreasePerBlock(1).block(() -> Registry.RADIUM_WATER_BLOCK.get()).bucket(() -> Items.WATER_BUCKET);

    public static final RegistryObject<FlowingFluidBlock> RADIUM_WATER_BLOCK = BLOCKS.register("radium_water",
            () -> new FlowingFluidBlock(() -> Registry.RADIUM_WATER.get(), AbstractBlock.Properties.of(Material.WATER).friction(100).noDrops()));

    public static final RegistryObject<LakeRadiumWater> RADIUM_WATER_LAKE = FEATURES.register("radium_water_lake", () -> new LakeRadiumWater(NoFeatureConfig.CODEC));

    /*
    public static final RegistryObject<EntityType<BreakEnitity>> BREAK_PROJECTILE = ENTITIES.register("break_projectile",
            () -> EntityType.Builder.<BreakEnitity>of(BreakEnitity::new, EntityClassification.MISC).sized(0.25f, 0.25f).build("break_projectile"));

}
class CoffeeMachine extends Block {
    public CoffeeMachine() {
        super(AbstractBlock.Properties.of(Material.METAL));

    }
}



/*    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {


            if (player.getItemInHand(handIn).getItem() == Registry.CUP.get())
            {
                a:
                player.addItem(new ItemStack(Registry.COFFEE.get()));
                worldIn.playSound(player, new BlockPos(player.getPosition(0)), Registry.COFFEE_MACHINE_WORKING.get(), SoundCategory.VOICE, 1, 1);
                player.inventory.removeItem(new ItemStack(Registry.CUP.get()));
                return ActionResultType.SUCCESS;
            }
            else {
                player.sendMessage(new StringTextComponent(TextFormatting.RED + "You don't have a cup in your hand!"), null);
            }
            return ActionResultType.CONSUME;
            }

}

***/