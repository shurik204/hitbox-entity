package me.shurik.hitboxentity.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.decoration.InteractionEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class HitboxEntity extends InteractionEntity {
    private static final TrackedData<Boolean> COLLIDABLE = DataTracker.registerData(HitboxEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final String COLLIDABLE_NBT_KEY = "collidable";

    public HitboxEntity(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    public void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(COLLIDABLE, true);
    }
    
    public boolean isCollidable() {
		return this.dataTracker.get(COLLIDABLE);
	}

    public void setCollidable(boolean isCollidable) {
        this.dataTracker.set(COLLIDABLE, isCollidable);
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean(COLLIDABLE_NBT_KEY, isCollidable());
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        setCollidable(nbt.getBoolean(COLLIDABLE_NBT_KEY));
    }
}