package me.shurik.hitboxentity.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ExecuteCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.Box;

@Mixin(ExecuteCommand.class)
public class ExecuteCommandMixin {
    // private static LiteralArgumentBuilder<ServerCommandSource> addOnArguments(CommandNode<ServerCommandSource> node, LiteralArgumentBuilder<ServerCommandSource> builder)
    @Inject(method = "addOnArguments", at = @At("TAIL"), cancellable = true)
    private static void addOnArguments(CommandNode<ServerCommandSource> node, LiteralArgumentBuilder<ServerCommandSource> builder, CallbackInfoReturnable<LiteralArgumentBuilder<ServerCommandSource>> info) {
        info.getReturnValue()
		.then(CommandManager.literal("colliders").fork(node, ExecuteCommand.createMultiEntityModifier((entity) -> {
			Box box = entity.getBoundingBox();
			return entity.world.getOtherEntities(entity, box).stream();
        })));
    }
}
