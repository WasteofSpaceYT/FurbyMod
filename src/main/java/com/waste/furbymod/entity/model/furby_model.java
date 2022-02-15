package com.waste.furbymod.entity.model;// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.waste.furbymod.entity.custom.FurbyEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.math.MathHelper;

public class furby_model<T extends FurbyEntity> extends EntityModel<T> {

	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer lLeg;
	private final ModelRenderer rLeg;

	public furby_model() {
		int textureWidth = 16;
		int textureHeight = 16;



		head = new ModelRenderer(this);
		body = new ModelRenderer(this);
		lLeg = new ModelRenderer(this);
		rLeg = new ModelRenderer(this);

		head.setRotationPoint(0.5F, -4.0F, 0.0F);
		head.setTextureOffset(0, 4).addBox(-1.0F, -5.0F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		body.setRotationPoint(0.0F, 26.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, 1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		lLeg.setRotationPoint(4.0F, 11.0F, 0.0F);
		lLeg.setTextureOffset(7, 7).addBox(-2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rLeg.setRotationPoint(-4.0F, 11.0F, 1.0F);
		rLeg.setTextureOffset(6, 4).addBox(1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}


	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount,
								  float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.rLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.lLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		lLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		rLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}