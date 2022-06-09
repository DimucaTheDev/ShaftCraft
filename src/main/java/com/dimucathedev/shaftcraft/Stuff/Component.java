package com.dimucathedev.shaftcraft.Stuff;

import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

public class Component implements net.minecraft.network.chat.Component {

    @Override
    public Style getStyle() {
        return null;
    }

    @Override
    public ComponentContents getContents() {
        return null;
    }

    @Override
    public List<net.minecraft.network.chat.Component> getSiblings() {
        return null;
    }

    @Override
    public FormattedCharSequence getVisualOrderText() {
        return null;
    }
}
