package me.shurik.hitboxentity;

import me.shurik.hitboxentity.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;


public class HitboxEntityModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModEntities.initClient();
    }
    
}
