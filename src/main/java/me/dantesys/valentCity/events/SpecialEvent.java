package me.dantesys.valentCity.events;

import me.dantesys.valentCity.MobList;
import me.dantesys.valentCity.Temporizador;
import me.dantesys.valentCity.ValentCity;
import me.dantesys.valentCity.items.Reliquias;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.Objects;
import java.util.Random;

public class SpecialEvent implements Listener {
    @EventHandler
    public void special(PlayerInteractEvent event){
        Player player = event.getPlayer();
        PersistentDataContainer conteiner = player.getPersistentDataContainer();
        if(conteiner.has(ValentCity.getPlugin(ValentCity.class).getKey(), PersistentDataType.INTEGER)){
            int tempo = conteiner.get(ValentCity.getPlugin(ValentCity.class).getKey(),PersistentDataType.INTEGER);
            int countdown = tempo;
            if(tempo<=0 && player.isSneaking()){
                countdown = 60;
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
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.totem) || player.getInventory().getItemInOffHand().isSimilar(Reliquias.totem)){
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
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.spy)){
                    GameMode gm = player.getGameMode();
                    Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class), 10,
                            ()->{
                                player.sendActionBar(Component.text("Modo Ghost Ativado!"));
                                player.setGameMode(GameMode.SPECTATOR);
                            },
                            ()->player.setGameMode(gm),
                            (t)->player.sendActionBar(Component.text("Modo Ghost acaba em "+(t.getSegundosRestantes())+" segundos"))
                    );
                    timer.scheduleTimer(20L);
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
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.arco)){
                    PlayerInventory pinv = player.getInventory();
                    Arrow arrow = player.launchProjectile(Arrow.class);
                    arrow.setCritical(true);
                    arrow.setGlowing(true);
                    arrow.setColor(Color.YELLOW);
                    Vector vec = player.getLocation().getDirection();
                    arrow.setVelocity(vec.multiply(100));
                    if(pinv.contains(Material.TNT)){
                        int slot = pinv.first(Material.TNT);
                        ItemStack tnt = pinv.getItem(slot);
                        if(tnt != null){
                            int qtd = tnt.getAmount();
                            pinv.remove(tnt);
                            arrow.setMetadata("explosive",new FixedMetadataValue(ValentCity.getPlugin(ValentCity.class),(double) qtd));
                            event.setCancelled(true);
                        }
                    }else{
                        arrow.setMetadata("sniper",new FixedMetadataValue(ValentCity.getPlugin(ValentCity.class),(double) 10));
                        event.setCancelled(true);
                    }
                }
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.farmer)){
                    final int finalRange = 15;
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
                            world.spawnParticle(Particle.EGG_CRACK,particle,1);
                        }
                        Collection<Entity> pressf = location.getWorld().getNearbyEntities(location,area,2,area);
                        while(pressf.iterator().hasNext()){
                            Entity surdo = pressf.iterator().next();
                            if(surdo instanceof LivingEntity vivo){
                                if(!(vivo instanceof Player)){
                                    Location legg = vivo.getLocation();
                                    World wegg = vivo.getWorld();
                                    ItemStack item = new ItemStack(Objects.requireNonNull(MobList.getEggType(vivo)).getMaterial());
                                    String nome = vivo.getName();
                                    ItemMeta meta = item.getItemMeta();
                                    meta.displayName(Component.text(nome));
                                    item.setItemMeta(meta);
                                    vivo.remove();
                                    wegg.dropItem(legg, item);
                                }
                            }
                            pressf.remove(surdo);
                        }
                    });
                    timer.scheduleTimer(1L);
                }
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.marreta)){
                    Vector vec = player.getEyeLocation().getDirection();
                    if(player.getWorld().getEnvironment().equals(World.Environment.NORMAL)){
                        WindCharge vento = player.launchProjectile(WindCharge.class);
                        vento.setGlowing(true);
                        vento.setMetadata("marreta",new FixedMetadataValue(ValentCity.getPlugin(ValentCity.class),(double) 5));
                        vento.setVelocity(vec.multiply(2));
                    }else if(player.getWorld().getEnvironment().equals(World.Environment.NETHER)){
                        Fireball vento = player.launchProjectile(Fireball.class);
                        vento.setGlowing(true);
                        vento.setMetadata("marreta",new FixedMetadataValue(ValentCity.getPlugin(ValentCity.class),(double) 5));
                        vento.setVelocity(vec.multiply(2));
                    }else if(player.getWorld().getEnvironment().equals(World.Environment.THE_END)){
                        DragonFireball vento = player.launchProjectile(DragonFireball.class);
                        vento.setGlowing(true);
                        vento.setMetadata("marreta",new FixedMetadataValue(ValentCity.getPlugin(ValentCity.class),(double) 5));
                        vento.setVelocity(vec.multiply(2));
                    }
                }
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.besta)){
                    Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class), 30,
                            ()->{player.sendActionBar(Component.text("Modo Minigum Ativado!"));},
                            ()->{},
                            (t)->{
                                player.sendActionBar(Component.text("Modo Minigun acaba em "+(t.getSegundosRestantes())+" segundos"));
                                Vector vec = player.getEyeLocation().getDirection();
                                Arrow flecha = player.launchProjectile(Arrow.class);
                                flecha.setCritical(true);
                                flecha.setGlowing(true);
                                flecha.setColor(Color.YELLOW);
                                flecha.setVelocity(vec.multiply(10));
                            }
                    );
                    timer.scheduleTimer(5L);
                }
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.miner)){
                    Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class), 10,
                            ()->{
                                player.sendActionBar(Component.text("Modo Instaminer Ativado!"));
                                conteiner.set(ValentCity.getPlugin(ValentCity.class).getHabKey(),PersistentDataType.BOOLEAN,true);
                            },
                            ()->conteiner.set(ValentCity.getPlugin(ValentCity.class).getHabKey(),PersistentDataType.BOOLEAN,false),
                            (t)->player.sendActionBar(Component.text("Modo Instaminer acaba em "+(t.getSegundosRestantes())+" segundos"))
                    );
                    timer.scheduleTimer(20L);
                }
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.barbaro)){
                    Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class), 10,
                            ()->{
                                player.sendActionBar(Component.text("Last Resource Ativado!"));
                                conteiner.set(ValentCity.getPlugin(ValentCity.class).getHabKey(),PersistentDataType.BOOLEAN,true);
                            },
                            ()->conteiner.set(ValentCity.getPlugin(ValentCity.class).getHabKey(),PersistentDataType.BOOLEAN,false),
                            (t)->player.sendActionBar(Component.text("Last Resource acaba em "+(t.getSegundosRestantes())+" segundos"))
                    );
                    timer.scheduleTimer(20L);
                }
                if(player.getInventory().getChestplate() != null && player.getInventory().getChestplate().isSimilar(Reliquias.peitoral)){
                    Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class), 30,
                            ()->{
                                player.sendActionBar(Component.text("Life Ativado!"));
                                Objects.requireNonNull(player.getAttribute(Attribute.MAX_HEALTH)).setBaseValue(100);
                                player.setHealth(100);
                            },
                            ()-> {
                                Objects.requireNonNull(player.getAttribute(Attribute.MAX_HEALTH)).setBaseValue(20);
                                player.setHealth(20);
                            },
                            (t)->player.sendActionBar(Component.text("Life acaba em "+(t.getSegundosRestantes())+" segundos")));
                    timer.scheduleTimer(20L);
                }
                if(player.getInventory().getLeggings() != null && player.getInventory().getLeggings().isSimilar(Reliquias.hulk)){
                    final int finalRange = 30;
                    final Location location = player.getLocation();
                    final World world = player.getWorld();
                    final double damage = 30;
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
                                    if(p!=player)vivo.damage(damage);
                                }else{
                                    vivo.damage(damage);
                                }
                            }
                            pressf.remove(surdo);
                        }
                    });
                    timer.scheduleTimer(1L);
                }
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.escudo) || player.getInventory().getItemInOffHand().isSimilar(Reliquias.escudo) ){
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
                        location.getWorld().spawnParticle(Particle.SONIC_BOOM,location,1,0,0,0,0);
                        location.getWorld().playSound(location, Sound.ENTITY_WARDEN_SONIC_BOOM,0.5f,0.7f);
                        Collection<Entity> pressf = location.getWorld().getNearbyEntities(location,2,2,2);
                        while(pressf.iterator().hasNext()){
                            Entity surdo = pressf.iterator().next();
                            if(surdo instanceof LivingEntity vivo){
                                if(vivo instanceof Player pl){
                                    if(pl != player){
                                        vivo.setHealth(0);
                                    }
                                }else{
                                    vivo.setHealth(0);
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
                if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.fenix)){
                    PlayerInventory pinv = player.getInventory();
                    int tempoFly = 20;
                    if(pinv.contains(Material.FEATHER)){
                        int slot = pinv.first(Material.FEATHER);
                        ItemStack pena = pinv.getItem(slot);
                        if(pena != null){
                            int qtd = pena.getAmount();
                            pinv.remove(pena);
                            tempoFly+=qtd;
                        }
                    }
                    Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class), tempoFly,
                            ()->{
                                player.sendActionBar(Component.text("Fly Ativado!"));
                                player.setFlying(true);
                                player.setAllowFlight(true);
                            },
                            ()->{
                                player.setFlying(false);
                                player.setAllowFlight(false);
                            },
                            (t)->player.sendActionBar(Component.text("Fly acaba em "+(t.getSegundosRestantes())+" segundos"))
                    );
                    timer.scheduleTimer(20L);
                }
            }
            conteiner.set(ValentCity.getPlugin(ValentCity.class).getKey(),PersistentDataType.INTEGER,countdown);
        }
    }
}
