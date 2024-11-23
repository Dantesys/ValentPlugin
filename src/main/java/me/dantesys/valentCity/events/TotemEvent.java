package me.dantesys.valentCity.events;

import me.dantesys.valentCity.Temporizador;
import me.dantesys.valentCity.ValentCity;
import me.dantesys.valentCity.items.Reliquias;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class TotemEvent implements Listener {
    @EventHandler
    public void reviver(EntityResurrectEvent e) {
        LivingEntity deadEntity = e.getEntity();
        EntityEquipment equip = deadEntity.getEquipment();
        ItemStack hand = null;
        boolean main = true;
        if (equip != null && equip.getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING) {
            hand = equip.getItemInMainHand();
            if (!hand.getEnchantments().containsKey(Enchantment.INFINITY)) {
                hand = null;
            }
        }
        if (equip != null && equip.getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
            hand = equip.getItemInOffHand();
            if (!hand.getEnchantments().containsKey(Enchantment.INFINITY)) {
                hand = null;
            }
            main = false;
        }
        if (hand != null) {
            boolean finalMain = main;
            ItemStack finalHand = Reliquias.totem;
            Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class),
                    5,
                    () -> deadEntity.sendActionBar(Component.text("Totem Ativado!")),
                    () -> {
                        if (finalMain) {
                            deadEntity.getEquipment().setItemInMainHand(finalHand);
                        } else {
                            deadEntity.getEquipment().setItemInOffHand(finalHand);
                        }
                    },
                    (t) -> deadEntity.sendActionBar(Component.text("Falta "+ (t.getSegundosRestantes()) + " Segundo para reativar"))
            );
            timer.scheduleTimer(20L);
        }
    }
}