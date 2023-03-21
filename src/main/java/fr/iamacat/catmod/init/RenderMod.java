package fr.iamacat.catmod.init;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.iamacat.catmod.entities.CatAgressiveEntity;
import fr.iamacat.catmod.models.ModelCatAgressiveEntity;
import fr.iamacat.catmod.renders.RenderCatAgressiveEntity;

public class RenderMod
{
    public static void init()
    {
        RenderingRegistry.registerEntityRenderingHandler(CatAgressiveEntity.class, new RenderCatAgressiveEntity(new ModelCatAgressiveEntity(), 0.5F));
    }
}