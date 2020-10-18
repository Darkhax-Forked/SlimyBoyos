package com.blamejared.slimyboyos;

import com.blamejared.slimyboyos.capability.SlimeAbsorptionCapability;
import com.blamejared.slimyboyos.events.ClientEventHandler;
import com.blamejared.slimyboyos.events.CommonEventHandler;
import com.blamejared.slimyboyos.network.PacketHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("slimyboyos")
public class SlimyBoyos {

    public SlimyBoyos() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
    }

    private void setup(final FMLCommonSetupEvent event) {
        PacketHandler.init();
        SlimeAbsorptionCapability.init();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
    }
}
