package me.dantesys.valentCity.events;

import me.dantesys.valentCity.Temporizador;
import me.dantesys.valentCity.ValentCity;
import me.dantesys.valentCity.items.Reliquias;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class TotemEvent implements Listener {
    @EventHandler
    public void reviver(EntityResurrectEvent e) {
        LivingEntity deadEntity = e.getEntity();
        if(deadEntity instanceof Player player){
            PlayerInventory pinv = player.getInventory();
            ItemStack item = pinv.getItemInMainHand();
            ItemStack item2 = pinv.getItemInOffHand();
            if(item.isSimilar(Reliquias.totem) || item2.isSimilar(Reliquias.totem)){
                Temporizador timer = new Temporizador(ValentCity.getPlugin(ValentCity.class),
                        5,
                        () -> player.sendActionBar(Component.text("Totem Ativado!")),
                        () -> player.getInventory().addItem(Reliquias.totem),
                        (t) -> player.sendActionBar(Component.text("Falta "+ (t.getSegundosRestantes()) + " Segundo para reativar"))
                );
                timer.scheduleTimer(20L);
            }
        }
    }
}