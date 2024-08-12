package me.dantesys.valentCity;

import me.dantesys.valentCity.commands.GiveItems;
import me.dantesys.valentCity.events.*;
import me.dantesys.valentCity.items.Reliquias;
import org.bukkit.*;

import org.bukkit.inventory.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;


public final class ValentCity extends JavaPlugin{
    @Override
    public void onEnable() {
        Reliquias.init();
        Objects.requireNonNull(getCommand("reliquia")).setExecutor(new GiveItems());
        Objects.requireNonNull(getCommand("livro")).setExecutor(new GiveItems());
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
        NamespacedKey key_bk = new NamespacedKey(this, "BKINFO");
        ItemStack bk = new ItemStack(Reliquias.livro);
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
        ShapelessRecipe bk_recipe = new ShapelessRecipe(key_bk,bk);
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
        bk_recipe.addIngredient(Material.BOOK);
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
        getServer().addRecipe(bk_recipe);
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
        getServer().getConsoleSender().sendMessage("§2[Valent City]: Plugin Ativado!");
    }
    @Override
    public void onDisable() {
        getServer().clearRecipes();
        getServer().getConsoleSender().sendMessage("§4[Valent City]: Plugin Desativado!");
    }
}