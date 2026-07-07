package cn.kycraft.kuayue.parts;

import cn.kycraft.kuayue.KuaYue;
import cn.kycraft.kuayue.parts.locomotives.df11.I11Panel;
import io.micronaut.context.annotation.Context;
import lib.kasuga.registration.Registry;
import lib.kasuga.registration.RegistryGroup;
import lib.kasuga.registration.minecraft.creative_tab.CreativeTabReg;
import net.minecraft.network.chat.Component;

@Context
public class KuaYueTrainPanelModule {
    public static RegistryGroup REGISTRY_GROUP = new RegistryGroup()
            .setParent(KuaYue.REGISTRY);

    public static final CreativeTabReg TRAIN_PANEL_TAB = new CreativeTabReg("train_panel_tab")
            .title(Component.translatable("train_panel_tab")).icon(()->I11Panel.DF11_DOOR.getItem().getDefaultInstance())
            .setParent(REGISTRY_GROUP);
}
