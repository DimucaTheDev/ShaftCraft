package com.dimucathedev.shaftcraft;

import com.dimucathedev.shaftcraft.Blocks.DecoCrafter;
import com.dimucathedev.shaftcraft.Items.RawGraphite;
import it.unimi.dsi.fastutil.booleans.Boolean2ObjectFunction;
import it.unimi.dsi.fastutil.ints.Int2BooleanFunction;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.HORIZONTAL_FACING;
import static net.minecraft.world.phys.shapes.Shapes.join;

public class Registry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final CreativeModeTab tabMisc = new CreativeModeTab("tab0") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RAW_GRAPHITE.get());
        }
    };
    public static final CreativeModeTab tabOres = new CreativeModeTab("tab1") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BAUXITE_ORE.get());
        }
    };
    public static final CreativeModeTab tabDeco = new CreativeModeTab("tab2") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(SYNTHETIC_RUBY.get());
        }
    };
    public static final CreativeModeTab tabBlocks = new CreativeModeTab("tab3") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(TRAVERTINE_TILE_ITEM.get());

        }
    };
    public static final CreativeModeTab tabDev = new CreativeModeTab("tab4") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.COMMAND_BLOCK);
        }

        @Override
        public CreativeModeTab setBackgroundImage(ResourceLocation texture) {
            return super.setBackgroundImage(new ResourceLocation("shaftcraft","dnu.png"));
        }
    };

    public static final RegistryObject<Block> GRAPHITE_ORE = BLOCKS.register("graphite_ore", () -> new GraphiteOre(){
        @Override
        public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction direction) {
            return true;
        }
    });
    public static final RegistryObject<BlockItem> GRAPHITE_ORE_ITEM = ITEMS.register("graphite_ore", () -> new BlockItem(GRAPHITE_ORE.get(), new Item.Properties().tab(tabOres)));
    public static final RegistryObject<Item> RAW_GRAPHITE = ITEMS.register("raw_graphite", () -> new RawGraphite(){
        @Override
        public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
            p_41423_.add(new TextComponent(ChatFormatting.GRAY+"Use Blast Furnace for smelting this item"));
            super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        }

        @Override
        public Item asItem() {
            return super.asItem();
        }
    });
    public static final RegistryObject<Item> GRAPHITE = ITEMS.register("graphite", () -> new Item(new Item.Properties().tab(tabMisc).fireResistant()){
        @Override
        public void appendHoverText(ItemStack p_40572_, @Nullable Level p_40573_, List<Component> p_40574_, TooltipFlag p_40575_) {
            p_40574_.add(new TextComponent(ChatFormatting.GOLD+"C"));
            super.appendHoverText(p_40572_, p_40573_, p_40574_, p_40575_);
        }
    });

    public static final RegistryObject<Block> BAUXITE_ORE = BLOCKS.register("bauxite_ore", () -> new GraphiteOre());
    public static final RegistryObject<BlockItem> BAUXITE_ORE_ITEM = ITEMS.register("bauxite_ore", () -> new BlockItem(BAUXITE_ORE.get(), new Item.Properties().tab(tabOres)));
    public static final RegistryObject<Item> RAW_BAUXITE = ITEMS.register("raw_bauxite", () -> new RawGraphite() {
        @Override
        public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
            p_41423_.add(new TextComponent(ChatFormatting.GRAY+"Use Blast Furnace for smelting this item"));
            super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        }

        @Override
        public void onUseTick(Level p_41428_, LivingEntity p_41429_, ItemStack p_41430_, int p_41431_) {
            super.onUseTick(p_41428_, p_41429_, p_41430_, p_41431_);
        }
    });//Боксит, использует класс графита тк там "hover" текст
    public static final RegistryObject<Item> BAUXITE = ITEMS.register("bauxite", () -> new Item(new Item.Properties().tab(tabMisc).fireResistant()){
        @Override
        public void appendHoverText(ItemStack p_40572_, @Nullable Level p_40573_, List<Component> p_40574_, TooltipFlag p_40575_) {
            p_40574_.add(new TextComponent(ChatFormatting.GOLD+"Al2O3*xH2O"));
            super.appendHoverText(p_40572_, p_40573_, p_40574_, p_40575_);
        }
    });

    public static final RegistryObject<Item> TRAVERTINE = ITEMS.register("travertine", () -> new Item(new Item.Properties().tab(tabMisc)) {
        @Override
        public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
            p_41423_.add(new TextComponent(ChatFormatting.GOLD+"Ca(HCO3)2 -> CaCO3+H2O+CO2"));
            super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        }
    });
    public static final RegistryObject<Block> TRAVERTINE_TILE = BLOCKS.register("travertine_tile", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));
    public static final RegistryObject<Item> TRAVERTINE_TILE_ITEM = ITEMS.register("travertine_tile", () -> new BlockItem(TRAVERTINE_TILE.get(), new Item.Properties().tab(tabBlocks)));

    public static final RegistryObject<Block> LIMONITE_ORE = BLOCKS.register("limonite_ore", () -> new GraphiteOre() {
        @Override
        public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {return 4;}

        @Override
        public void animateTick(BlockState p_49888_, Level p_49889_, BlockPos p_49890_, Random p_49891_) {

            BlockPos p_152432_ = p_49890_;
            Random r = new Random();
            if(r.nextInt(0,100)<10)
                for (int i = 0; i < r.nextInt(1,20); i++)
                    p_49889_.addParticle(ParticleTypes.ASH, p_152432_.getX()+r.nextFloat(0,1.3f),
                            p_152432_.getY()+0.3+r.nextFloat(0,1.3f),
                            p_152432_.getZ()+r.nextFloat(0,1.3f),
                            0,0,0);
            super.animateTick(p_49888_, p_49889_, p_49890_, p_49891_);
        }});
    public static final RegistryObject<BlockItem> LIMONITE_ORE_ITEM = ITEMS.register("limonite_ore", () -> new BlockItem(LIMONITE_ORE.get(), new Item.Properties().tab(tabOres)));
    public static final RegistryObject<Item> LIMONITE = ITEMS.register("limonite", () -> new Item(new Item.Properties().tab(tabMisc)){
        @Override
        public void appendHoverText(ItemStack p_40572_, @Nullable Level p_40573_, List<Component> p_40574_, TooltipFlag p_40575_) {
            p_40574_.add(new TextComponent(ChatFormatting.GOLD+"FeOOH·(Fe2O3·nH2O)"));
            super.appendHoverText(p_40572_, p_40573_, p_40574_, p_40575_);
        }
    });

    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new GraphiteOre());
    public static final RegistryObject<BlockItem> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () -> new BlockItem(RUBY_ORE.get(), new Item.Properties().tab(tabOres)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(tabMisc).fireResistant()){
        @Override
        public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
            p_41423_.add(new TextComponent(ChatFormatting.GOLD+"Al2O3"));
            super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        }
    });


    //TEST
    public static final RegistryObject<Block> VOID_BLOCK = BLOCKS.register("void", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).noCollission().friction(1)));
    public static final RegistryObject<BlockItem> VOID_BLOCK_ITEM = ITEMS.register("void", () -> new BlockItem(VOID_BLOCK.get(), new Item.Properties().tab(tabDev)));
    public static final RegistryObject<Block> DECO = BLOCKS.register("deco", () -> new Block(Block.Properties.copy(LIMONITE_ORE.get())){
        @Override
        public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_) {
            if(!p_60504_.isClientSide)
            {
               // p_60506_.sendMessage(new TextComponent("Not the end!"), null);
                if (p_60506_.getMainHandItem().getItem() == RUBY.get())
                {
                    p_60506_.sendMessage(new TextComponent("" + p_60506_.getInventory().contains(new ItemStack(RUBY.get()))), null);
                    p_60506_.getInventory().removeItem(new ItemStack(RUBY.get()));

                    p_60504_.getServer().getCommands().performCommand(null, "/clear @s shaftcraft:ruby");

                    p_60506_.getInventory().add(new ItemStack(SYNTHETIC_RUBY.get()));
                }
                return InteractionResult.FAIL;
            }
            return InteractionResult.CONSUME;
        }
    });

    //DEcoration
    public static final RegistryObject<Item> SYNTHETIC_RUBY = ITEMS.register("synthetic_ruby", () -> new Item(new Item.Properties().tab(tabDeco)));

}

/*
* package com.DimDima09.SomeStuff;


public class Registry {

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