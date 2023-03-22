package fr.iamacat.catmod.init;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.iamacat.catmod.entities.CatAgressiveEntity;
import fr.iamacat.catmod.entities.CatPassiveEntity;
import fr.iamacat.catmod.entities.tnt.EntityCatTnt;
import fr.iamacat.catmod.handler.EntityHandler;
import fr.iamacat.catmod.models.ModelCatAgressiveEntity;
import fr.iamacat.catmod.models.ModelCatPassiveEntity;
import fr.iamacat.catmod.renders.RenderCatAgressiveEntity;
import fr.iamacat.catmod.renders.RenderCatPassiveEntity;
import fr.iamacat.catmod.renders.tnt.RenderCatTnt;

public class RegisterEntity {
    public static void init(){

        RenderingRegistry.registerEntityRenderingHandler(CatAgressiveEntity.class, new RenderCatAgressiveEntity(new ModelCatAgressiveEntity(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(CatPassiveEntity.class, new RenderCatPassiveEntity(new ModelCatPassiveEntity(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCatTnt.class, new RenderCatTnt());//tnt render not terminated or not fixed

        EntityHandler.registerMonster(CatAgressiveEntity.class, "CatAgressiveEntity");
        EntityHandler.registerMonster(EntityCatTnt.class, "EntityCatTnt");
        EntityHandler.registerCreature(CatPassiveEntity.class,"CatPassiveEntity");
    }
}
