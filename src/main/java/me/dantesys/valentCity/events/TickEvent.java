package me.dantesys.valentCity.events;

import com.destroystokyo.paper.event.server.ServerTickEndEvent;
import me.dantesys.valentCity.ValentCity;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;

public class TickEvent implements Listener {
    @EventHandler
    public void timers(ServerTickEndEvent event){
        int tick = event.getTickNumber();
        if(tick%20==0){
            //COOLDOWN DE ESPECIAL
            Bukkit.getServer().getOnlinePlayers().forEach(player -> {
                if(player.hasMetadata("specialdown")){
                    int tempo = player.getMetadata("specialdown").removeFirst().asInt();
                    player.setMetadata("specialdown", new FixedMetadataValue(ValentCity.getPlugin(ValentCity.class),tempo-1));
                    if(tempo<=1){
                        player.sendActionBar(Component.text("Special: OK"));
                    }else{
                        player.sendActionBar(Component.text("Special em "+(tempo-1)+"s"));
                    }
                }else{
                    player.setMetadata("specialdown", new FixedMetadataValue(ValentCity.getPlugin(ValentCity.class),0));
                }
            });
        }
    }
}
