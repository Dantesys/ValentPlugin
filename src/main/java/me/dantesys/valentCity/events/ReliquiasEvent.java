package me.dantesys.valentCity.events;

import me.dantesys.valentCity.Temporizador;
import me.dantesys.valentCity.ValentCity;
import me.dantesys.valentCity.items.Reliquias;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class ReliquiasEvent implements Listener {
    @EventHandler
    public void morreu(EntityDeathEvent e) {
        Entity dead = e.getEntity();
        if (dead instanceof Player pressf) {
            Objects.requireNonNull(pressf.getAttribute(Attribute.MAX_HEALTH)).setBaseValue(20);
            Objects.requireNonNull(pressf.getAttribute(Attribute.ATTACK_DAMAGE)).setBaseValue(1);
            Objects.requireNonNull(pressf.getAttribute(Attribute.ARMOR)).setBaseValue(0);
            Objects.requireNonNull(pressf.getAttribute(Attribute.ARMOR_TOUGHNESS)).setBaseValue(0);
            Objects.requireNonNull(pressf.getAttribute(Attribute.MAX_ABSORPTION)).setBaseValue(0);
            Objects.requireNonNull(pressf.getAttribute(Attribute.OXYGEN_BONUS)).setBaseValue(0);
            pressf.sendActionBar(Component.text(""));
        }
    }
    @EventHandler
    public void tpEndeperal(PlayerTeleportEvent event){
        Player p = event.getPlayer();
        if(event.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL){
            if(p.getInventory().getItemInMainHand().isSimilar(Reliquias.mago)){
                event.setCancelled(true);
                p.setNoDamageTicks(10);
                p.teleport(event.getTo());
            }
        }
    }
    @EventHandler
    public void ataque(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Arrow flecha) {
            if(flecha.hasMetadata("magic")) {
                double damage = flecha.getMetadata("magic").getFirst().asDouble();
                event.setDamage(event.getDamage()+damage);
            }
            if(flecha.hasMetadata("sniper")) {
                double damage = flecha.getMetadata("sniper").getFirst().asDouble();
                event.setDamage(event.getDamage()*damage);
            }
            if(flecha.hasMetadata("explosive")) {
                double damage = flecha.getMetadata("explosive").getFirst().asDouble();
                Location l = event.getEntity().getLocation();
                World w = event.getEntity().getWorld();
                float power = (float) (damage*4);
                w.createExplosion(l,power,false,false);
            }
        }
        if(event.getDamager() instanceof Snowball bola) {
            if(bola.hasMetadata("freeze")) {
                int gelo = bola.getMetadata("freeze").getFirst().asInt();
                event.getEntity().setFreezeTicks(event.getEntity().getMaxFreezeTicks()*gelo);
            }
        }
        if(event.getDamager() instanceof Fireball fogo) {
            if(fogo.hasMetadata("fire")) {
                int tempo = fogo.getMetadata("fire").getFirst().asInt();
                event.getEntity().setFireTicks(event.getEntity().getMaxFreezeTicks()*tempo);
            }
        }
    }
    @EventHandler
    public void acertou(ProjectileHitEvent event){
        if(event.getEntity() instanceof Snowball bola){
            if(bola.hasMetadata("freeze")){
                int gelo = bola.getMetadata("freeze").getFirst().asInt();
                if(gelo>0 && event.getHitBlock() != null){
                    event.getHitBlock().setType(Material.BLUE_ICE);
                }
            }
        }
        if(event.getEntity() instanceof Fireball bola){
            if(bola.hasMetadata("fire")){
                event.setCancelled(true);
                int fogo = bola.getMetadata("fire").getFirst().asInt();
                if(fogo>0 && event.getHitBlock() != null){
                    event.getHitBlock().setType(Material.MAGMA_BLOCK);
                    event.getEntity().remove();
                }
            }
        }
        if(event.getEntity() instanceof Arrow flecha){
            if(flecha.hasMetadata("magic")){
                int magic = flecha.getMetadata("magic").getFirst().asInt();
                if(magic>0 && event.getHitBlock() != null){
                    event.getHitBlock().setType(Material.BUDDING_AMETHYST);
                    event.getEntity().remove();
                }
            }
            if(flecha.hasMetadata("explosive") && event.getHitBlock() != null) {
                double damage = flecha.getMetadata("explosive").getFirst().asDouble();
                Location l = event.getHitBlock().getLocation();
                World w = event.getHitBlock().getWorld();
                float power = (float) (damage*4);
                w.createExplosion(l,power,false,false);
            }
        }
    }
    public static void efeitos(LivingEntity toma, boolean bom, int tempo, int power){
        if(bom){
            toma.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.HASTE,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.INSTANT_HEALTH,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.LUCK,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE,tempo,power));
        }else{
            toma.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.INSTANT_DAMAGE,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.POISON,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK,tempo,power));
            toma.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS,tempo,power));
        }
    }
    public static void mina(World w, Location l, Player player,boolean meta) {
        TNTPrimed tnt = w.spawn(l, TNTPrimed.class);
        tnt.setFuseTicks(10000);
        tnt.setMetadata("guardiao",new FixedMetadataValue(ValentCity.getPlugin(ValentCity.class),meta));
        tnt.setYield(10);
        Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class),10,
                () -> player.sendMessage("Dinamite ativada!"),
                () -> {
                    tnt.getLocation().getWorld().createExplosion(tnt.getLocation(),10,false,true);
                    tnt.remove();
                },
                (t) -> {
                    player.sendActionBar(Component.text("Falta "+ (t.getSegundosRestantes()) + " Segundo para explosão!"));
                    tnt.customName(Component.text((t.getSegundosRestantes())+"s"));
                    tnt.setCustomNameVisible(true);
                }
        );
        timer.scheduleTimer(20L);
    }
}