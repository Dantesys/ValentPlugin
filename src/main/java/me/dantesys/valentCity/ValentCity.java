package me.dantesys.valentCity;

import com.mojang.brigadier.Command;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
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
    @Override
    public void onEnable() {
        Reliquias.init();
        LifecycleEventManager<Plugin> manager = this.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            commands.register(Commands.literal("reliquia")
                .then(Commands.argument("player", ArgumentTypes.player())
                .then(Commands.argument("reliquia",new ReliquiaArgType()))
                .executes(ctx -> {
                    Player player = ctx.getArgument("player", Player.class);
                    ReliquiaType reliquia = ctx.getArgument("reliquia",ReliquiaType.class);
                    String jg = PlainTextComponentSerializer.plainText().serialize(player.name());
                    switch (reliquia.name()){
                        case "GUERREIRO":
                            player.getInventory().addItem(Reliquias.guerreiro);
                            config.set("reliquia.guerreiro",jg);
                            break;
                        case "CEIFADOR":
                            player.getInventory().addItem(Reliquias.ceifador);
                            config.set("reliquia.ceifador",jg);
                            break;
                        case "TOTEM":
                            player.getInventory().addItem(Reliquias.totem);
                            config.set("reliquia.totem",jg);
                            break;
                        case "SPY":
                            player.getInventory().addItem(Reliquias.spy);
                            config.set("reliquia.spy",jg);
                            break;
                        case "POSEIDON":
                            player.getInventory().addItem(Reliquias.poseidon);
                            config.set("reliquia.poseidon",jg);
                            break;
                        case "VENTO":
                            player.getInventory().addItem(Reliquias.poseidon);
                            config.set("reliquia.vento",jg);
                            break;
                        case "ARCO":
                            player.getInventory().addItem(Reliquias.arco);
                            config.set("reliquia.arco",jg);
                            break;
                        case "FARMER":
                            player.getInventory().addItem(Reliquias.farmer);
                            config.set("reliquia.farmer",jg);
                            break;
                        case "MARRETA":
                            player.getInventory().addItem(Reliquias.marreta);
                            config.set("reliquia.marreta",jg);
                            break;
                        case "BESTA":
                            player.getInventory().addItem(Reliquias.marreta);
                            config.set("reliquia.besta",jg);
                            break;
                    }
                    return Command.SINGLE_SUCCESS;
                })).build(),
                "Comando para receber as reliquias",
                List.of("an-alias"));
        });
        NamespacedKey key_pic1 = new NamespacedKey(this, "PIC1");
        ItemStack pick1 = new ItemStack(Reliquias.picareta_md1);
        NamespacedKey key_pic2 = new NamespacedKey(this, "PIC2");
        ItemStack pick2 = new ItemStack(Reliquias.picareta_md2);
        NamespacedKey key_pis1 = new NamespacedKey(this, "PIS1");
        ItemStack pis1 = new ItemStack(Reliquias.pisante_md1);
        NamespacedKey key_pis2 = new NamespacedKey(this, "PIS2");
        ItemStack pis2 = new ItemStack(Reliquias.pisante_md2);
        NamespacedKey key_esc1 = new NamespacedKey(this, "ESC1");
        ItemStack esc1 = new ItemStack(Reliquias.escudo_md1);
        NamespacedKey key_esc2 = new NamespacedKey(this, "ESC2");
        ItemStack esc2 = new ItemStack(Reliquias.escudo_md2);
        NamespacedKey key_pei1 = new NamespacedKey(this, "PEI1");
        ItemStack pei1 = new ItemStack(Reliquias.peitoral_md1);
        NamespacedKey key_pei2 = new NamespacedKey(this, "PEI2");
        ItemStack pei2 = new ItemStack(Reliquias.peitoral_md2);
        NamespacedKey key_fen1 = new NamespacedKey(this, "FEN1");
        ItemStack fen1 = new ItemStack(Reliquias.fenix1);
        NamespacedKey key_fen2 = new NamespacedKey(this, "FEN2");
        ItemStack fen2 = new ItemStack(Reliquias.fenix2);
        NamespacedKey key_bk = new NamespacedKey(this, "BKINFO");
        ItemStack bk = new ItemStack(Reliquias.livro);
        ShapelessRecipe pick1_recipe = new ShapelessRecipe(key_pic1,pick1);
        ShapelessRecipe pick2_recipe = new ShapelessRecipe(key_pic2,pick2);
        ShapelessRecipe pis1_recipe = new ShapelessRecipe(key_pis1,pis1);
        ShapelessRecipe pis2_recipe = new ShapelessRecipe(key_pis2,pis2);
        ShapelessRecipe esc1_recipe = new ShapelessRecipe(key_esc1,esc1);
        ShapelessRecipe esc2_recipe = new ShapelessRecipe(key_esc2,esc2);
        ShapelessRecipe pei1_recipe = new ShapelessRecipe(key_pei1,pei1);
        ShapelessRecipe pei2_recipe = new ShapelessRecipe(key_pei2,pei2);
        ShapelessRecipe fen1_recipe = new ShapelessRecipe(key_fen1,fen1);
        ShapelessRecipe fen2_recipe = new ShapelessRecipe(key_fen2,fen2);
        ShapelessRecipe bk_recipe = new ShapelessRecipe(key_bk,bk);
        pick1_recipe.addIngredient(Reliquias.picareta_md2);
        pick2_recipe.addIngredient(Reliquias.picareta_md1);
        pis1_recipe.addIngredient(Reliquias.pisante_md2);
        pis2_recipe.addIngredient(Reliquias.pisante_md1);
        esc1_recipe.addIngredient(Reliquias.escudo_md2);
        esc2_recipe.addIngredient(Reliquias.escudo_md1);
        pei1_recipe.addIngredient(Reliquias.peitoral_md2);
        pei2_recipe.addIngredient(Reliquias.peitoral_md1);
        fen1_recipe.addIngredient(Reliquias.fenix2);
        fen2_recipe.addIngredient(Reliquias.fenix1);
        bk_recipe.addIngredient(Material.WRITTEN_BOOK);
        getServer().addRecipe(pick1_recipe);
        getServer().addRecipe(pick2_recipe);
        getServer().addRecipe(pis1_recipe);
        getServer().addRecipe(pis2_recipe);
        getServer().addRecipe(esc1_recipe);
        getServer().addRecipe(esc2_recipe);
        getServer().addRecipe(pei1_recipe);
        getServer().addRecipe(pei2_recipe);
        getServer().addRecipe(fen1_recipe);
        getServer().addRecipe(fen2_recipe);
        getServer().addRecipe(bk_recipe);
        getServer().getPluginManager().registerEvents(new TickEvent(), this);
        getServer().getPluginManager().registerEvents(new SpecialEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new ReliquiasEvent(), this);
        getServer().getPluginManager().registerEvents(new TotemEvent(), this);
        getServer().getPluginManager().registerEvents(new VentoEvent(), this);
        //
        getServer().getPluginManager().registerEvents(new PicaretaEvent(), this);
        getServer().getPluginManager().registerEvents(new MagoEvent(), this);
        getServer().getPluginManager().registerEvents(new DomadorEvent(), this);
        getServer().getPluginManager().registerEvents(new PisanteEvent(), this);
        getServer().getPluginManager().registerEvents(new EscudoEvent(), this);
        getServer().getPluginManager().registerEvents(new CapaceteEvent(), this);
        getServer().getPluginManager().registerEvents(new PescadorEvent(), this);
        getServer().getPluginManager().registerEvents(new PeitoralEvent(), this);
        getServer().getPluginManager().registerEvents(new CalcaEvent(), this);
        getServer().getPluginManager().registerEvents(new MachadoEvent(), this);
        getServer().getPluginManager().registerEvents(new EscavacaoEvent(), this);
        getServer().getPluginManager().registerEvents(new LadraoEvent(), this);
        getServer().getPluginManager().registerEvents(new HulkEvent(), this);
        getServer().getPluginManager().registerEvents(new FenixEvent(), this);
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