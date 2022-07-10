package fr.raksrinana.fallingtree.forge.network;

import fr.raksrinana.fallingtree.common.FallingTreeCommon;
import fr.raksrinana.fallingtree.forge.common.wrapper.ServerPlayerWrapper;
import lombok.RequiredArgsConstructor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nonnull;

@RequiredArgsConstructor
public class PlayerJoinListener{
	@NotNull
	private final FallingTreeCommon<?> mod;
	
	@SubscribeEvent
	public void onPlayerLoggedInEvent(@Nonnull PlayerEvent.PlayerLoggedInEvent event){
		if(event.isCanceled()){
			return;
		}
		
		if(event.getPlayer() instanceof ServerPlayer serverPlayer){
			mod.getServerPacketHandler().onPlayerConnected(new ServerPlayerWrapper(serverPlayer));
		}
	}
}