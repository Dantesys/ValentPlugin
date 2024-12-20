package me.dantesys.valentCity.events;

import com.destroystokyo.paper.event.server.ServerTickEndEvent;
import me.dantesys.valentCity.Temporizador;
import me.dantesys.valentCity.ValentCity;
import me.dantesys.valentCity.items.Reliquias;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;

public class TickEvent implements Listener {
    @EventHandler
    public void timers(ServerTickEndEvent event){
        int tick = event.getTickNumber();
        if(tick%20==0){
            //COOLDOWN DE ESPECIAL E EFEITOS
            Bukkit.getServer().getOnlinePlayers().forEach(player -> {
                PersistentDataContainer conteiner = player.getPersistentDataContainer();
                if(conteiner.has(ValentCity.getPlugin(ValentCity.class).getKey(),PersistentDataType.INTEGER)){
                    int tempo = conteiner.get(ValentCity.getPlugin(ValentCity.class).getKey(),PersistentDataType.INTEGER);
                    conteiner.set(ValentCity.getPlugin(ValentCity.class).getKey(),PersistentDataType.INTEGER,tempo-1);
                    if(tempo<=1){
                        player.sendActionBar(Component.text("Special: OK"));
                    }else{
                        player.sendActionBar(Component.text("Special em "+(tempo-1)+"s"));
                    }
                }else{
                    conteiner.set(ValentCity.getPlugin(ValentCity.class).getKey(),PersistentDataType.INTEGER,0);
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
                if(pinv.contains(Reliquias.arco))player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,60,0));
                if(pinv.contains(Reliquias.farmer))player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK,60,0));
                if(pinv.contains(Reliquias.marreta))player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH,60,0));
                if(pinv.contains(Reliquias.besta))player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE,60,0));
                if(pinv.contains(Reliquias.miner)){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,60,0));
                    player.removePotionEffect(PotionEffectType.MINING_FATIGUE);
                }
                if(pinv.contains(Reliquias.barbaro))player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,60,0));
                if(pinv.contains(Reliquias.peitoral))player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE,60,0));
                if(pinv.contains(Reliquias.hulk))player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH,60,1));
                if(pinv.contains(Reliquias.fenix)){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,60,0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,60,0));
                }
                //NA MAO
                ItemStack item = pinv.getItemInMainHand();
                ItemStack item2 = pinv.getItemInOffHand();
                if(item.isSimilar(Reliquias.guerreiro) || item2.isSimilar(Reliquias.guerreiro)) player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH,60,0));
                if(item.isSimilar(Reliquias.ceifador) || item2.isSimilar(Reliquias.ceifador)) player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,60,0));
                if(item.isSimilar(Reliquias.arco) || item2.isSimilar(Reliquias.arco)) player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,60,0));
                if(item.isSimilar(Reliquias.farmer) || item2.isSimilar(Reliquias.farmer)) player.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE,60,5));
                if(item.isSimilar(Reliquias.besta) || item2.isSimilar(Reliquias.besta)) player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,60,0));
                if(item.isSimilar(Reliquias.miner) || item2.isSimilar(Reliquias.miner)){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK,60,0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH,60,0));
                }
                if(item.isSimilar(Reliquias.barbaro) || item2.isSimilar(Reliquias.barbaro)) player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH,60,1));
                if(item.isSimilar(Reliquias.fenix) || item2.isSimilar(Reliquias.fenix)){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,60,0));
                    final int finalRange = 3;
                    final Location location = player.getLocation();
                    final World world = player.getWorld();
                    Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class), 1,
                            ()->{
                            },()-> {
                    },(t)->{
                        double area = (double) finalRange /(t.getSegundosRestantes());
                        for (double i = 0; i <= 2*Math.PI*area; i += 0.05) {
                            double x = (area * Math.cos(i)) + location.getX();
                            double z = (location.getZ() + area * Math.sin(i));
                            Location particle = new Location(world, x, location.getY() + 1, z);
                            world.spawnParticle(Particle.LARGE_SMOKE,particle,1);
                        }
                        Collection<Entity> pressf = location.getWorld().getNearbyEntities(location,area,2,area);
                        while(pressf.iterator().hasNext()){
                            Entity surdo = pressf.iterator().next();
                            if(surdo instanceof LivingEntity vivo){
                                if(vivo instanceof Player p){
                                    if(p!=player)vivo.setFireTicks(10);
                                }else{
                                    vivo.setFireTicks(10);
                                }
                            }
                            pressf.remove(surdo);
                        }
                    });
                    timer.scheduleTimer(1L);
                }
            });

        }
    }
}
