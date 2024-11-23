package me.dantesys.valentCity.events;

import com.destroystokyo.paper.event.server.ServerTickEndEvent;
import me.dantesys.valentCity.ValentCity;
import me.dantesys.valentCity.items.Reliquias;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TickEvent implements Listener {
    @EventHandler
    public void timers(ServerTickEndEvent event){
        int tick = event.getTickNumber();
        if(tick%20==0){
            //COOLDOWN DE ESPECIAL E EFEITOS
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
                //NO INV
                PlayerInventory pinv = player.getInventory();
                if(pinv.contains(Reliquias.guerreiro))player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE,60,0));
                if(pinv.contains(Reliquias.ceifador))player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,60,0));
                if(pinv.contains(Reliquias.totem))player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,60,1));
                if(pinv.contains(Reliquias.spy)){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,60,0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,60,0));
                }
                if(pinv.contains(Reliquias.poseidon)){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER,60,0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE,60,0));
                }
                if(pinv.contains(Reliquias.vento))player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,60,0));
                //NA MAO
                ItemStack item = pinv.getItemInMainHand();
                if(item.isSimilar(Reliquias.guerreiro)) player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH,60,0));
                if(item.isSimilar(Reliquias.ceifador)) player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,60,0));
            });

        }
    }
}
