package me.dantesys.valentCity.events;

import me.dantesys.valentCity.Temporizador;
import me.dantesys.valentCity.ValentCity;
import me.dantesys.valentCity.items.Reliquias;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.Random;

public class SpecialEvent implements Listener {
    @EventHandler
    public void special(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(player.hasMetadata("specialdown")){
            int tempo = player.getMetadata("specialdown").removeFirst().asInt();
            if(tempo<=0 && player.isSneaking()){
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.guerreiro)){
                    int range = 50;
                    double damage = 20;
                    final int finalRange = range;
                    final double finalDamage = damage;
                    final Location location = player.getLocation();
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
                        if(t.getSegundosRestantes()>finalRange){
                            t.stop();
                        }
                    });
                    timer.scheduleTimer(1L);
                }
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.ceifador)){
                    final int finalRange = 50;
                    final Location location = player.getLocation();
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
                        location.getWorld().spawnParticle(Particle.SOUL,location,5,0,0,0,0);
                        location.getWorld().playSound(location, Sound.BLOCK_SOUL_SOIL_STEP,0.5f,0.7f);
                        Collection<Entity> pressf = location.getWorld().getNearbyEntities(location,2,2,2);
                        Random rd = new Random();
                        int pct = rd.nextInt(1,100);
                        while(pressf.iterator().hasNext()){
                            Entity surdo = pressf.iterator().next();
                            if(surdo instanceof LivingEntity vivo){
                                if(vivo instanceof Player pl){
                                    if(pct>99 && pl != player){
                                        vivo.setHealth(0);
                                        player.getInventory().addItem(new ItemStack(Material.TOTEM_OF_UNDYING));
                                    }else if(pl != player){
                                        if(player.getInventory().contains(Material.TOTEM_OF_UNDYING)){
                                            player.getInventory().remove(new ItemStack(Material.TOTEM_OF_UNDYING));
                                            vivo.setHealth(0);
                                            t.stop();
                                        }else{
                                            vivo.setHealth(vivo.getHealth()/2);
                                        }
                                    }
                                }else{
                                    if(pct>99){
                                        vivo.setHealth(0);
                                        player.getInventory().addItem(new ItemStack(Material.TOTEM_OF_UNDYING));
                                    }else{
                                        if(player.getInventory().contains(Material.TOTEM_OF_UNDYING)){
                                            player.getInventory().remove(new ItemStack(Material.TOTEM_OF_UNDYING));
                                            vivo.setHealth(0);
                                            t.stop();
                                        }else{
                                            vivo.setHealth(vivo.getHealth()/2);
                                        }
                                    }
                                }
                            }
                            pressf.remove(surdo);
                        }
                        location.subtract(x,y,z);
                        if(t.getSegundosRestantes()>finalRange){
                            t.stop();
                        }
                    });
                    timer.scheduleTimer(1L);
                }
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.totem)){
                    final int finalRange = 10;
                    final Location location = player.getLocation();
                    final World world = player.getWorld();
                    Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class), 10,
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
                                    if(p!=player)vivo.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS,200,4));
                                }else{
                                    vivo.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS,200,4));
                                }
                            }
                            pressf.remove(surdo);
                        }
                    });
                    timer.scheduleTimer(1L);
                }
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.poseidon)){
                    World w = event.getPlayer().getWorld();
                    w.setStorm(true);
                    w.setThundering(true);
                    final int finalRange = 30;
                    final Location location = player.getLocation();
                    final World world = player.getWorld();
                    Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class), 10,
                            ()->{
                            },()-> {
                    },(t)->{
                        double area = (double) finalRange /(t.getSegundosRestantes());
                        for (double i = 0; i <= 2*Math.PI*area; i += 0.05) {
                            double x = (area * Math.cos(i)) + location.getX();
                            double z = (location.getZ() + area * Math.sin(i));
                            Location particle = new Location(world, x, location.getY() + 1, z);
                            world.spawnParticle(Particle.END_ROD,particle,1);
                        }
                        Collection<Entity> pressf = location.getWorld().getNearbyEntities(location,area,2,area);
                        while(pressf.iterator().hasNext()){
                            Entity surdo = pressf.iterator().next();
                            if(surdo instanceof LivingEntity vivo){
                                if(vivo instanceof Player p){
                                    if(p!=player)vivo.getWorld().strikeLightning(vivo.getLocation());
                                }else{
                                    vivo.getWorld().strikeLightning(vivo.getLocation());
                                }
                            }
                            pressf.remove(surdo);
                        }
                    });
                    timer.scheduleTimer(1L);
                }
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.vento)){
                    final int finalRange = 30;
                    final Location location = player.getLocation();
                    final World world = player.getWorld();
                    Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class), 10,
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
                                    if(p!=player)vivo.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,200,10));
                                }else{
                                    vivo.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,200,10));
                                }
                            }
                            pressf.remove(surdo);
                        }
                    });
                    timer.scheduleTimer(1L);
                }
            }
            player.setMetadata("specialdown", new FixedMetadataValue(ValentCity.getPlugin(ValentCity.class),60));
        }
    }
}
