package me.dantesys.valentCity.events;

import me.dantesys.valentCity.Temporizador;
import me.dantesys.valentCity.ValentCity;
import me.dantesys.valentCity.items.Reliquias;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

import java.util.Collection;

public class SpecialEvent implements Listener {
    @EventHandler
    public void special(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(player.hasMetadata("specialdown")){
            int tempo = player.getMetadata("specialdown").removeFirst().asInt();
            if(tempo<=0 && player.isSneaking()){
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.guerreiro)){
                    int range = 50;
                    double damage = 10;
                    final int finalRange = range;
                    final double finalDamage = damage;
                    final Location location = player.getLocation();
                    final boolean[] passa = {true};
                    final Vector direction = location.getDirection().normalize();
                    final double[] tp = {0};
                    Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class), 10,
                            ()->{
                            },()-> {
                    },(t)->{
                        tp[0] = tp[0]+3.4;
                        double x = direction.getX()*tp[0];
                        double y = direction.getY()*tp[0]+1.4;
                        double z = direction.getZ()*tp[0];
                        location.add(x,y,z);
                        location.getWorld().spawnParticle(Particle.SWEEP_ATTACK,location,1,0,0,0,0);
                        passa[0] = location.getBlock().isPassable();
                        location.getWorld().playSound(location, Sound.ENTITY_PLAYER_ATTACK_SWEEP,0.5f,0.7f);
                        Collection<Entity> pressf = location.getWorld().getNearbyEntities(location,2,2,2);
                        while(pressf.iterator().hasNext()){
                            Entity surdo = pressf.iterator().next();
                            if(surdo instanceof LivingEntity vivo){
                                if(vivo instanceof Player pl){
                                    if(pl != player){
                                        vivo.damage(finalDamage);
                                    }
                                }else{
                                    vivo.damage(finalDamage);
                                }
                            }
                            pressf.remove(surdo);
                        }
                        location.subtract(x,y,z);
                        if(t.getSegundosRestantes()>finalRange || !passa[0]){
                            t.stop();
                        }
                    });
                    timer.scheduleTimer(1L);
                }
            }
            player.setMetadata("specialdown", new FixedMetadataValue(ValentCity.getPlugin(ValentCity.class),60));
        }
    }
}
