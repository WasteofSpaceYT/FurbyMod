package com.waste.furbymod.entity.render;

import com.waste.furbymod.FurbyMod;
import com.waste.furbymod.entity.custom.FurbyEntity;
import com.waste.furbymod.entity.model.furby_model;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;

public class FurbyRenderer extends MobRenderer<FurbyEntity, furby_model<FurbyEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(FurbyMod.MOD_ID, "textures/entity/furby.png");

    public FurbyRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new furby_model<>(), 0.7f);
    }

    public ResourceLocation getEntityTexture(FurbyEntity entity){
        return TEXTURE;
    }
}
