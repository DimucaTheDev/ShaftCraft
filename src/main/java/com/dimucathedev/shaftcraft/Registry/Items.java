package com.dimucathedev.shaftcraft.Registry;

import com.dimucathedev.shaftcraft.Items.RawGraphite;
import com.dimucathedev.shaftcraft.Main;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.dimucathedev.shaftcraft.Registry.ItemTabs.*;

public class Items {

    public static final DeferredRegister<Item> reg = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);


    public static final RegistryObject<BlockItem> GRAPHITE_ORE_ITEM = reg.register("graphite_ore", () -> new BlockItem(Blocks.GRAPHITE_ORE.get(), new Item.Properties().tab(tabOres)));
    public static final RegistryObject<Item> RAW_GRAPHITE = reg.register("raw_graphite", () -> new RawGraphite(){
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
    public static final RegistryObject<Item> GRAPHITE = reg.register("graphite", () -> new Item(new Item.Properties().tab(tabMisc).fireResistant()){
        @Override
        public void appendHoverText(ItemStack p_40572_, @Nullable Level p_40573_, List<Component> p_40574_, TooltipFlag p_40575_) {
            p_40574_.add(new TextComponent(ChatFormatting.GOLD+"C"));
            super.appendHoverText(p_40572_, p_40573_, p_40574_, p_40575_);
        }
    });
    public static final RegistryObject<BlockItem> BAUXITE_ORE_ITEM = reg.register("bauxite_ore", () -> new BlockItem(Blocks.BAUXITE_ORE.get(), new Item.Properties().tab(tabOres)));
    public static final RegistryObject<Item> RAW_BAUXITE = reg.register("raw_bauxite", () -> new RawGraphite() {
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
    public static final RegistryObject<Item> BAUXITE = reg.register("bauxite", () -> new Item(new Item.Properties().tab(tabMisc).fireResistant()){
        @Override
        public void appendHoverText(ItemStack p_40572_, @Nullable Level p_40573_, List<Component> p_40574_, TooltipFlag p_40575_) {
            p_40574_.add(new TextComponent(ChatFormatting.GOLD+"Al2O3*xH2O"));
            super.appendHoverText(p_40572_, p_40573_, p_40574_, p_40575_);
        }
    });
    public static final RegistryObject<Item> TRAVERTINE = reg.register("travertine", () -> new Item(new Item.Properties().tab(tabMisc)) {
        @Override
        public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
            p_41423_.add(new TextComponent(ChatFormatting.GOLD+"Ca(HCO3)2 -> CaCO3+H2O+CO2"));
            super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        }
    });
    public static final RegistryObject<Item> TRAVERTINE_TILE_ITEM = reg.register("travertine_tile", () -> new BlockItem(Blocks.TRAVERTINE_TILE.get(), new Item.Properties().tab(tabBlocks)));
    public static final RegistryObject<BlockItem> LIMONITE_ORE_ITEM = reg.register("limonite_ore", () -> new BlockItem(Blocks.LIMONITE_ORE.get(), new Item.Properties().tab(tabOres)));
    public static final RegistryObject<Item> LIMONITE = reg.register("limonite", () -> new Item(new Item.Properties().tab(tabMisc)){
        @Override
        public void appendHoverText(ItemStack p_40572_, @Nullable Level p_40573_, List<Component> p_40574_, TooltipFlag p_40575_) {
            p_40574_.add(new TextComponent(ChatFormatting.GOLD+"FeOOH·(Fe2O3·nH2O)"));
            super.appendHoverText(p_40572_, p_40573_, p_40574_, p_40575_);
        }
    });
    public static final RegistryObject<BlockItem> RUBY_ORE_ITEM = reg.register("ruby_ore", () -> new BlockItem(Blocks.RUBY_ORE.get(), new Item.Properties().tab(tabOres)));
    public static final RegistryObject<Item> RUBY = reg.register("ruby", () -> new Item(new Item.Properties().tab(tabMisc).fireResistant()){
        @Override
        public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
            p_41423_.add(new TextComponent(ChatFormatting.GOLD+"Al2O3"));
            super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        }
    });
    public static final RegistryObject<Item> WRENCH = reg.register("wrench", () -> new Item(new Item.Properties()));
    public static final RegistryObject<BlockItem> VOID_BLOCK_ITEM = reg.register("void", () -> new BlockItem(Blocks.VOID_BLOCK.get(), new Item.Properties().tab(tabDev)));
    public static final RegistryObject<Item> SYNTHETIC_RUBY = reg.register("synthetic_ruby", () -> new Item(new Item.Properties().tab(tabDeco)));

}
