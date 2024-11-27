package me.dantesys.valentCity;

import com.mojang.brigadier.Command;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import me.dantesys.valentCity.commands.GiveReliquia;
import me.dantesys.valentCity.events.*;
import me.dantesys.valentCity.items.Reliquias;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.*;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class ValentCity extends JavaPlugin{
    FileConfiguration config = getConfig();
    NamespacedKey specialKey = new NamespacedKey(this, "special");
    NamespacedKey instaminerKey = new NamespacedKey(this, "habilidade");
    public NamespacedKey getKey(){
        return specialKey;
    }
    public NamespacedKey getHabKey(){
        return instaminerKey;
    }
    @Override
    public void onEnable() {
        Reliquias.init();
        LifecycleEventManager<Plugin> manager = this.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            commands.register("reliquia","Para enviar as reliquias",new GiveReliquia());
        });
        NamespacedKey key_bk = new NamespacedKey(this, "BKINFO");
        ItemStack bk = new ItemStack(Reliquias.livro);
        ShapelessRecipe bk_recipe = new ShapelessRecipe(key_bk,bk);
        bk_recipe.addIngredient(Material.WRITTEN_BOOK);
        getServer().addRecipe(bk_recipe);
        getServer().getPluginManager().registerEvents(new TickEvent(), this);
        getServer().getPluginManager().registerEvents(new SpecialEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new ReliquiasEvent(), this);
        getServer().getPluginManager().registerEvents(new TotemEvent(), this);
        getServer().getPluginManager().registerEvents(new VentoEvent(), this);
        config.addDefault("dev", "dantesys");
        config.addDefault("reliquia.guerreiro", "");
        config.addDefault("reliquia.ceifador", "");
        config.addDefault("reliquia.totem", "");
        config.addDefault("reliquia.spy", "");
        config.addDefault("reliquia.poseidon", "");
        config.addDefault("reliquia.vento", "");
        config.addDefault("reliquia.arco", "");
        config.addDefault("reliquia.farmer", "");
        config.addDefault("reliquia.marreta", "");
        config.addDefault("reliquia.besta", "");
        config.addDefault("reliquia.miner", "");
        config.addDefault("reliquia.barbaro", "");
        config.addDefault("reliquia.peitoral", "");
        config.addDefault("reliquia.escudo", "");
        config.addDefault("reliquia.hulk", "");
        config.options().copyDefaults(true);
        saveConfig();
        getServer().getConsoleSender().sendMessage("§2[Valent City]: Plugin Ativado!");
    }
    @Override
    public void onDisable() {
        getServer().clearRecipes();
        getServer().getConsoleSender().sendMessage("§4[Valent City]: Plugin Desativado!");
    }
}