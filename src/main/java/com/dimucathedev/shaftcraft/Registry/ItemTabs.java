package com.dimucathedev.shaftcraft.Registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import static com.dimucathedev.shaftcraft.Registry.Blocks.BAUXITE_ORE;
import static com.dimucathedev.shaftcraft.Registry.Items.*;

public class ItemTabs {
    public static final CreativeModeTab tabBlocks = new CreativeModeTab("tab3") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(TRAVERTINE_TILE_ITEM.get());

        }
    }; // Строительные блоки
    public static final CreativeModeTab tabMisc = new CreativeModeTab("tab0") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.RAW_GRAPHITE.get());
        }
    };   // "Другое"
    public static final CreativeModeTab tabOres = new CreativeModeTab("tab1") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BAUXITE_ORE.get());
        }
    };   // Руды
    public static final CreativeModeTab tabDeco = new CreativeModeTab("tab2") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(SYNTHETIC_RUBY.get());
        }
    };   // Декоративные Блоки
    public static final CreativeModeTab tabDev = new CreativeModeTab("tab4") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(WRENCH.get());
        }

        @Override
        public CreativeModeTab setBackgroundImage(ResourceLocation texture) {
            return super.setBackgroundImage(new ResourceLocation("shaftcraft","dnu.png"));
        }
    };    //
    public static final CreativeModeTab tabTools = new CreativeModeTab("tab5") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(net.minecraft.world.item.Items.IRON_SWORD);
        }
    };  //
}
