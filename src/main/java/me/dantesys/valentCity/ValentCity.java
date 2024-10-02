package me.dantesys.valentCity;

import me.dantesys.valentCity.commands.Comandos;
import me.dantesys.valentCity.events.*;
import me.dantesys.valentCity.items.Reliquias;
import org.bukkit.*;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;


public final class ValentCity extends JavaPlugin{
    FileConfiguration config = getConfig();
    @Override
    public void onEnable() {
        Reliquias.init();
        Objects.requireNonNull(getCommand("reliquia")).setExecutor(new Comandos());
        Objects.requireNonNull(getCommand("livro")).setExecutor(new Comandos());
        Objects.requireNonNull(getCommand("rlist")).setExecutor(new Comandos());
        NamespacedKey key_espa1 = new NamespacedKey(this, "ESPA1");
        ItemStack espa1 = new ItemStack(Reliquias.espadamd1);
        NamespacedKey key_espa2 = new NamespacedKey(this, "ESPA2");
        ItemStack espa2 = new ItemStack(Reliquias.espadamd2);
        NamespacedKey key_cros1 = new NamespacedKey(this, "CROS1");
        ItemStack cros1 = new ItemStack(Reliquias.espadamd1);
        NamespacedKey key_cros2 = new NamespacedKey(this, "CROS2");
        ItemStack cros2 = new ItemStack(Reliquias.espadamd2);
        NamespacedKey key_spy1 = new NamespacedKey(this, "SPY1");
        ItemStack spy1 = new ItemStack(Reliquias.spy_modelo1);
        NamespacedKey key_spy2 = new NamespacedKey(this, "SPY2");
        ItemStack spy2 = new ItemStack(Reliquias.spy_modelo2);
        NamespacedKey key_tri1 = new NamespacedKey(this, "TRI1");
        ItemStack tri1 = new ItemStack(Reliquias.tridente_modelo1);
        NamespacedKey key_tri2 = new NamespacedKey(this, "TRI2");
        ItemStack tri2 = new ItemStack(Reliquias.tridente_modelo2);
        NamespacedKey key_arc1 = new NamespacedKey(this, "ARC1");
        ItemStack arco1 = new ItemStack(Reliquias.arco_modelo1);
        NamespacedKey key_arc2 = new NamespacedKey(this, "ARC2");
        ItemStack arco2 = new ItemStack(Reliquias.arco_modelo2);
        NamespacedKey key_far1 = new NamespacedKey(this, "FAR1");
        ItemStack farm1 = new ItemStack(Reliquias.farm_modelo1);
        NamespacedKey key_far2 = new NamespacedKey(this, "FAR2");
        ItemStack farm2 = new ItemStack(Reliquias.farm_modelo2);
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
        ItemStack fen1 = new ItemStack(Reliquias.peitoral_md1);
        NamespacedKey key_fen2 = new NamespacedKey(this, "FEN2");
        ItemStack fen2 = new ItemStack(Reliquias.peitoral_md2);
        NamespacedKey key_bk = new NamespacedKey(this, "BKINFO");
        ItemStack bk = new ItemStack(Reliquias.livro);
        ShapelessRecipe espa1_recipe = new ShapelessRecipe(key_espa1,espa1);
        ShapelessRecipe espa2_recipe = new ShapelessRecipe(key_espa2,espa2);
        ShapelessRecipe cros1_recipe = new ShapelessRecipe(key_cros1,cros1);
        ShapelessRecipe cros2_recipe = new ShapelessRecipe(key_cros2,cros2);
        ShapelessRecipe spy1_recipe = new ShapelessRecipe(key_spy1,spy1);
        ShapelessRecipe spy2_recipe = new ShapelessRecipe(key_spy2,spy2);
        ShapelessRecipe tri1_recipe = new ShapelessRecipe(key_tri1,tri1);
        ShapelessRecipe tri2_recipe = new ShapelessRecipe(key_tri2,tri2);
        ShapelessRecipe arco1_recipe = new ShapelessRecipe(key_arc1,arco1);
        ShapelessRecipe arco2_recipe = new ShapelessRecipe(key_arc2,arco2);
        ShapelessRecipe farm1_recipe = new ShapelessRecipe(key_far1,farm1);
        ShapelessRecipe farm2_recipe = new ShapelessRecipe(key_far2,farm2);
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
        cros1_recipe.addIngredient(Reliquias.crossbowmd2);
        cros2_recipe.addIngredient(Reliquias.crossbowmd1);
        espa1_recipe.addIngredient(Reliquias.espadamd2);
        espa2_recipe.addIngredient(Reliquias.espadamd1);
        spy1_recipe.addIngredient(Reliquias.spy_modelo2);
        spy2_recipe.addIngredient(Reliquias.spy_modelo1);
        tri1_recipe.addIngredient(Reliquias.tridente_modelo2);
        tri2_recipe.addIngredient(Reliquias.tridente_modelo1);
        arco1_recipe.addIngredient(Reliquias.arco_modelo2);
        arco2_recipe.addIngredient(Reliquias.arco_modelo1);
        farm1_recipe.addIngredient(Reliquias.farm_modelo2);
        farm2_recipe.addIngredient(Reliquias.farm_modelo1);
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
        getServer().addRecipe(espa1_recipe);
        getServer().addRecipe(espa2_recipe);
        getServer().addRecipe(spy1_recipe);
        getServer().addRecipe(spy2_recipe);
        getServer().addRecipe(tri1_recipe);
        getServer().addRecipe(tri2_recipe);
        getServer().addRecipe(arco1_recipe);
        getServer().addRecipe(arco2_recipe);
        getServer().addRecipe(farm1_recipe);
        getServer().addRecipe(farm2_recipe);
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
        getServer().getPluginManager().registerEvents(new JoinQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new ReliquiasEvent(), this);
        getServer().getPluginManager().registerEvents(new EspadaEvent(), this);
        getServer().getPluginManager().registerEvents(new TotemEvent(), this);
        getServer().getPluginManager().registerEvents(new EnxadaEvent(), this);
        getServer().getPluginManager().registerEvents(new PicaretaEvent(), this);
        getServer().getPluginManager().registerEvents(new ArcoEvent(), this);
        getServer().getPluginManager().registerEvents(new FazendeiroEvent(), this);
        getServer().getPluginManager().registerEvents(new EspiaoEvent(), this);
        getServer().getPluginManager().registerEvents(new TridenteEvent(), this);
        getServer().getPluginManager().registerEvents(new MagoEvent(), this);
        getServer().getPluginManager().registerEvents(new CrossbowEvent(), this);
        getServer().getPluginManager().registerEvents(new DomadorEvent(), this);
        getServer().getPluginManager().registerEvents(new VentoEvent(), this);
        getServer().getPluginManager().registerEvents(new PisanteEvent(), this);
        getServer().getPluginManager().registerEvents(new EscudoEvent(), this);
        getServer().getPluginManager().registerEvents(new MarretaEvent(), this);
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
        config.addDefault("limite.vida", 200);
        config.addDefault("limite.dano", 100);
        config.addDefault("registro.guerreiro", "");
        config.addDefault("registro.ceifador", "");
        config.addDefault("registro.infinidade", "");
        config.addDefault("registro.espiao", "");
        config.addDefault("registro.tridente", "");
        config.addDefault("registro.vento", "");
        config.addDefault("registro.arco", "");
        config.addDefault("registro.fazendeiro", "");
        config.addDefault("registro.crossbow", "");
        config.addDefault("registro.mineiro", "");
        config.addDefault("registro.domador", "");
        config.addDefault("registro.mago", "");
        config.addDefault("registro.pisante", "");
        config.addDefault("registro.escudo", "");
        config.addDefault("registro.marreta", "");
        config.addDefault("registro.capacete", "");
        config.addDefault("registro.pescador", "");
        config.addDefault("registro.peitoral", "");
        config.addDefault("registro.calca", "");
        config.addDefault("registro.barbaro", "");
        config.addDefault("registro.escavacao", "");
        config.addDefault("registro.ladrao", "");
        config.addDefault("registro.hulk", "");
        config.addDefault("registro.fenix", "");
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