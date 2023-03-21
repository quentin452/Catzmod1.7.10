package fr.iamacat.catmod.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.iamacat.catmod.entities.CatAgressiveEntity;
import fr.iamacat.catmod.init.RenderMod;
import fr.iamacat.catmod.models.ModelCatAgressiveEntity;
import net.minecraft.client.Minecraft;

public class ClientProxy extends CommonProxy{
    @Override
    public  void registerRenders(){
        RenderMod.init();
    }
}
