package me.shurik.hitboxentity.registry;

// import static me.shurik.hitboxentity.HitboxEntityMod.MOD_ID;
import me.shurik.hitboxentity.entity.HitboxEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.EmptyEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<HitboxEntity> HITBOX_ENTITY = register("minecraft", "hitbox", FabricEntityTypeBuilder
            .create(SpawnGroup.MISC, HitboxEntity::new).dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    private static <T extends Entity> EntityType<T> register(String namespace, String id, EntityType<T> entityType) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(namespace, id), entityType);
    }

    public static void init() {

    }

    public static void initClient() {
        EntityRendererRegistry.register(HITBOX_ENTITY, EmptyEntityRenderer::new);
    }
}
