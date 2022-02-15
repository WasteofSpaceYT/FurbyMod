package com.waste.furbymod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

import static net.minecraft.entity.ai.attributes.AttributeModifierMap.createMutableAttribute;

public class FurbyEntity extends ZombieEntity {
    public FurbyEntity(EntityType<? extends ZombieEntity> p_i48549_1_, World p_i48549_2_) {
        super(p_i48549_1_, p_i48549_2_);
    }
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 10D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 75D)
                .createMutableAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS);

    }
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6f));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }
    protected int getExperiencePoints(PlayerEntity player){
        return 3 + this.world.rand.nextInt(5);
    }
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BAT_AMBIENT;
    }
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }
    protected SoundEvent getHurtSound(DamageSource damageSourceIn){
        return SoundEvents.ENTITY_BAT_HURT;
    }
    protected void playStepSound(BlockPos pos, BlockState blockin){
        this.playSound(SoundEvents.ENTITY_HOGLIN_STEP, 0.2F, 0.5f);
    }
}
