package me.dantesys.valentCity.events;

import io.papermc.paper.event.player.PlayerShieldDisableEvent;
import me.dantesys.valentCity.ValentCity;
import me.dantesys.valentCity.items.Reliquias;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;


public class ReliquiasEvent implements Listener {
    /*@EventHandler
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
    }*/
    @EventHandler
    public void instamine(PlayerInteractEvent event){
        Player player = event.getPlayer();
        PersistentDataContainer container = player.getPersistentDataContainer();
        if(container.has(ValentCity.getPlugin(ValentCity.class).getHabKey(), PersistentDataType.BOOLEAN)){
            if(player.getInventory().getItemInMainHand().isSimilar(Reliquias.miner)){
                if(Boolean.TRUE.equals(container.get(ValentCity.getPlugin(ValentCity.class).getHabKey(), PersistentDataType.BOOLEAN))){
                    Block bloco = event.getClickedBlock();
                    if(bloco != null){
                        Location l = bloco.getLocation();
                        World w = bloco.getWorld();
                        Material m = bloco.getType();
                        w.dropItemNaturally(l,new ItemStack(m));
                        bloco.setType(Material.AIR);
                    }
                }
            }
        }
    }
    @EventHandler
    public void ataque(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Arrow flecha) {
            /*if(flecha.hasMetadata("magic")) {
                double damage = flecha.getMetadata("magic").getFirst().asDouble();
                event.setDamage(event.getDamage()+damage);
            }*/
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
        if(event.getEntity() instanceof Player player){
            PersistentDataContainer container = player.getPersistentDataContainer();
            if(container.has(ValentCity.getPlugin(ValentCity.class).getHabKey(), PersistentDataType.BOOLEAN)){
                if(Boolean.TRUE.equals(container.get(ValentCity.getPlugin(ValentCity.class).getHabKey(), PersistentDataType.BOOLEAN))){
                    event.setDamage(0);
                }
            }
        }
        if(event.getEntity() instanceof Player player){
            Entity atacante = event.getDamager();
            if(atacante instanceof Projectile projetil){
                if(player.getInventory().getItemInOffHand().isSimilar(Reliquias.escudo) || player.getInventory().getItemInMainHand().isSimilar(Reliquias.escudo)){
                    event.setCancelled(true);
                    Vector vec = projetil.getVelocity();
                    vec.multiply(-1);
                    projetil.setVelocity(vec);
                    Projectile revers = player.launchProjectile(projetil.getClass());
                    projetil.remove();
                    revers.setVelocity(vec);
                }
            }
            if(player.getInventory().contains(Reliquias.escudo)){
                double dmg = event.getDamage();
                event.setDamage(dmg/4);
            }
        }
    }
    @EventHandler
    public void defender(PlayerShieldDisableEvent event){
        Player player = event.getPlayer();
        if(player.getInventory().getItemInOffHand().isSimilar(Reliquias.escudo)){
            int cd = event.getCooldown();
            event.setCooldown(cd/2);
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
}