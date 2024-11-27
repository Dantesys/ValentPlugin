package me.dantesys.valentCity.items;

import net.kyori.adventure.inventory.Book;
import net.kyori.adventure.text.Component;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Banner;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;
import static org.bukkit.attribute.Attribute.*;

public class Reliquias {
    public static ItemStack guerreiro;
    public static ItemStack ceifador;
    public static ItemStack totem;
    public static ItemStack spy;
    public static ItemStack poseidon;
    public static ItemStack vento;
    public static ItemStack arco;
    public static ItemStack farmer;
    public static ItemStack marreta;
    public static ItemStack besta;
    public static ItemStack miner;
    public static ItemStack barbaro;
    public static ItemStack peitoral;
    public static ItemStack escudo;
    public static ItemStack hulk;
    public static ItemStack livro;
    public static ItemStack fenix;
    /*public static ItemStack domador;
    public static ItemStack mago;
    public static ItemStack pisante_md1;
    public static ItemStack pisante_md2;
    public static ItemStack capacete;
    public static ItemStack pescador;
    public static ItemStack escavacao;
    public static ItemStack ladrao;
    //copia (1 - players 2 - mobs), dragão*/
    public static void init() {
        /*createDomador();
        createMago();
        createPis1();
        createPis2();
        createCapacete();
        createPescador();
        createEscavacao();
        createLadrao();
        //*/
        createGuerreiro();
        createCeifador();
        createArco();
        createFarmer();
        createTotem();
        createSpy();
        createPoseidon();
        createVento();
        createMarreta();
        createBesta();
        createMiner();
        createBarbaro();
        createPeitoral();
        createEscudo();
        createHulk();
        createLivro();
        createFenix();
    }
    private static void createGuerreiro(){
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD,1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Guerreiro"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passiva: Resistência"));
        loreitem.add(Component.text("§7Ativa: Força"));
        loreitem.add(Component.text("§7Special: Slash"));
        meta.lore(loreitem);
        meta.addEnchant(Enchantment.BANE_OF_ARTHROPODS,5,true);
        meta.addEnchant(Enchantment.FIRE_ASPECT,2,true);
        meta.addEnchant(Enchantment.LOOTING,3,true);
        meta.addEnchant(Enchantment.SHARPNESS,5,true);
        meta.addEnchant(Enchantment.SMITE,5,true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE,5,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        guerreiro = item;
    }
    private static void createCeifador() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Ceifador"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passiva: Regeneração"));
        loreitem.add(Component.text("§7Ativa: Invisibilidade"));
        loreitem.add(Component.text("§7Special: Soul Colector!"));
        loreitem.add(Component.text("§7Ultra-Special: Soul Reaper!"));
        meta.lore(loreitem);
        meta.addEnchant(Enchantment.BANE_OF_ARTHROPODS,5,true);
        meta.addEnchant(Enchantment.FIRE_ASPECT,2,true);
        meta.addEnchant(Enchantment.LOOTING,3,true);
        meta.addEnchant(Enchantment.SHARPNESS,5,true);
        meta.addEnchant(Enchantment.SMITE,5,true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE,5,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.setCustomModelData(2);
        item.setItemMeta(meta);
        ceifador = item;
    }
    private static void createTotem() {
        ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Totem"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passiva: Regeneração 2"));
        loreitem.add(Component.text("§7Ativa: Infinidade 5s"));
        loreitem.add(Component.text("§7Special: Stop!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.INFINITY,1,true);
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        totem = item;
    }
    private static void createSpy() {
        ItemStack item = new ItemStack(Material.SPYGLASS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Espião"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passiva: Speed e Night Vision"));
        loreitem.add(Component.text("§7Ativa: Microscópio!"));
        loreitem.add(Component.text("§7Special: Ghost"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LOOTING,10,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setCustomModelData(1);
        meta.addAttributeModifier(ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE.getKey(),+10, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(SCALE, new AttributeModifier(SCALE.getKey(),-0.99, AttributeModifier.Operation.ADD_NUMBER));
        item.setItemMeta(meta);
        spy = item;
    }
    private static void createPoseidon() {
        ItemStack item = new ItemStack(Material.TRIDENT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Poseidon"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passivo: Conduit Power e Graça dos golfinho"));
        loreitem.add(Component.text("§7Ativo: No Fall Damage"));
        loreitem.add(Component.text("§7Special: Thunder Rain!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addAttributeModifier(Attribute.SAFE_FALL_DISTANCE, new AttributeModifier(Attribute.SAFE_FALL_DISTANCE.getKey(),100000000, AttributeModifier.Operation.ADD_NUMBER));
        meta.addEnchant(Enchantment.IMPALING,20,true);
        meta.addEnchant(Enchantment.LOOTING,3,true);
        meta.addEnchant(Enchantment.RIPTIDE,5,true);
        meta.addEnchant(Enchantment.SHARPNESS,5,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setCustomModelData(1);
        item.setItemMeta(meta);
        poseidon = item;
    }
    private static void createVento() {
        ItemStack item = new ItemStack(Material.WIND_CHARGE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Vento"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passivo: SlowFall"));
        loreitem.add(Component.text("§7Ativo: Infinito!"));
        loreitem.add(Component.text("§7Special: Go to Space!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.setCustomModelData(1);
        meta.addEnchant(Enchantment.KNOCKBACK,10000,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        vento = item;
    }
    private static void createArco() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Arco"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passivo: Night Vision"));
        loreitem.add(Component.text("§7Ativo: Invisibilidade"));
        loreitem.add(Component.text("§7Special: Magic Arrow!"));
        loreitem.add(Component.text("§7Ultra-Special: Explosive Arrow!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.INFINITY,1,true);
        meta.addEnchant(Enchantment.POWER,20,true);
        meta.addEnchant(Enchantment.FLAME,1,true);
        meta.addEnchant(Enchantment.PUNCH,2,true);
        meta.addEnchant(Enchantment.PIERCING,5,true);
        meta.setCustomModelData(1);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        arco = item;
    }
    private static void createFarmer() {
        ItemStack item = new ItemStack(Material.NETHERITE_HOE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Farmer"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passivo: Sorte"));
        loreitem.add(Component.text("§7Ativo: Negociador"));
        loreitem.add(Component.text("§7Special: Back to Egg!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.setCustomModelData(1);
        meta.addEnchant(Enchantment.FORTUNE,10,true);
        meta.addEnchant(Enchantment.EFFICIENCY,5,true);
        meta.addEnchant(Enchantment.SHARPNESS,10,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        farmer = item;
    }
    private static void createMarreta() {
        ItemStack item = new ItemStack(Material.MACE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia da Marreta"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passiva: Força"));
        loreitem.add(Component.text("§7Ativa: No Fall Damage!"));
        loreitem.add(Component.text("§7Special: Home Run!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.setCustomModelData(1);
        meta.addAttributeModifier(Attribute.SAFE_FALL_DISTANCE, new AttributeModifier(Attribute.SAFE_FALL_DISTANCE.getKey(),100000000, AttributeModifier.Operation.ADD_NUMBER));
        meta.addEnchant(Enchantment.BANE_OF_ARTHROPODS,5,true);
        meta.addEnchant(Enchantment.BREACH,4,true);
        meta.addEnchant(Enchantment.DENSITY,5,true);
        meta.addEnchant(Enchantment.FIRE_ASPECT,2,true);
        meta.addEnchant(Enchantment.LOOTING,3,true);
        meta.addEnchant(Enchantment.SHARPNESS,5,true);
        meta.addEnchant(Enchantment.SMITE,5,true);
        meta.addEnchant(Enchantment.WIND_BURST,3,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        marreta = item;
    }
    private static void createBesta() {
        ItemStack item = new ItemStack(Material.CROSSBOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia da Besta"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passivo: Resistencia"));
        loreitem.add(Component.text("§7Ativo: Speed"));
        loreitem.add(Component.text("§7Special: Minigun"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.setCustomModelData(1);
        meta.addEnchant(Enchantment.MULTISHOT,50,true);
        meta.addEnchant(Enchantment.PIERCING,10,true);
        meta.addEnchant(Enchantment.QUICK_CHARGE,5,true);
        meta.addEnchant(Enchantment.POWER,10,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        besta = item;
    }
    private static void createMiner() {
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Miner"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passivo: Night Vision e remove fadiga"));
        loreitem.add(Component.text("§7Ativo: Luck, Força e encolhimento"));
        loreitem.add(Component.text("§7Special: Instamine!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.setCustomModelData(1);
        meta.addEnchant(Enchantment.FORTUNE,5,true);
        meta.addEnchant(Enchantment.EFFICIENCY,5,true);
        meta.addEnchant(Enchantment.SHARPNESS,5,true);
        meta.addAttributeModifier(SCALE, new AttributeModifier(SCALE.getKey(),-0.5, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(BLOCK_INTERACTION_RANGE, new AttributeModifier(BLOCK_INTERACTION_RANGE.getKey(),10, AttributeModifier.Operation.ADD_NUMBER));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        miner = item;
    }
    private static void createBarbaro() {
        ItemStack item = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Reliquia do Barbaro"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passia: Speed"));
        loreitem.add(Component.text("§7Ativa: Força 2"));
        loreitem.add(Component.text("§7Special: Last Resource!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.setCustomModelData(1);
        meta.addAttributeModifier(ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE.getKey(),+10, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED.getKey(),+2, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(ENTITY_INTERACTION_RANGE, new AttributeModifier(ENTITY_INTERACTION_RANGE.getKey(),+7, AttributeModifier.Operation.ADD_NUMBER));
        meta.addEnchant(Enchantment.BANE_OF_ARTHROPODS,5,true);
        meta.addEnchant(Enchantment.EFFICIENCY,5,true);
        meta.addEnchant(Enchantment.SILK_TOUCH,1,true);
        meta.addEnchant(Enchantment.SHARPNESS,5,true);
        meta.addEnchant(Enchantment.SMITE,5,true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE,5,true);
        meta.addEnchant(Enchantment.LOOTING,3,true);
        meta.addEnchant(Enchantment.FORTUNE,3,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        barbaro = item;
    }
    private static void createPeitoral() {
        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Peitoral"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passivo: Resistencia"));
        loreitem.add(Component.text("§7Ativo: Asas"));
        loreitem.add(Component.text("§7Special: LIFE!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.setCustomModelData(1);
        meta.setGlider(true);
        meta.addEnchant(Enchantment.BLAST_PROTECTION,4,true);
        meta.addEnchant(Enchantment.FIRE_PROTECTION,4,true);
        meta.addEnchant(Enchantment.PROJECTILE_PROTECTION,4,true);
        meta.addEnchant(Enchantment.PROTECTION,4,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        peitoral = item;
    }
    private static void createEscudo() {
        ItemStack item = new ItemStack(Material.SHIELD, 1);
        ItemMeta meta = item.getItemMeta();
        BlockStateMeta bmeta = (BlockStateMeta) meta;
        Banner banner = (Banner) bmeta.getBlockState();
        banner.setBaseColor(DyeColor.BLACK);
        banner.update();
        banner.addPattern(new Pattern(DyeColor.PURPLE, PatternType.BORDER));
        banner.update();
        banner.addPattern(new Pattern(DyeColor.PURPLE, PatternType.RHOMBUS));
        banner.update();
        banner.addPattern(new Pattern(DyeColor.BLACK, PatternType.FLOWER));
        banner.update();
        banner.addPattern(new Pattern(DyeColor.BLACK, PatternType.SQUARE_TOP_LEFT));
        banner.update();
        banner.addPattern(new Pattern(DyeColor.BLACK, PatternType.SQUARE_BOTTOM_RIGHT));
        banner.update();
        bmeta.setBlockState(banner);
        bmeta.displayName(Component.text("§6Relíquia do Escudo"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passivo: Amplificação"));
        loreitem.add(Component.text("§7Ativo: Reversão"));
        loreitem.add(Component.text("§7Special: Vazio Roxo"));
        bmeta.lore(loreitem);
        bmeta.setRarity(ItemRarity.EPIC);
        bmeta.setUnbreakable(true);
        bmeta.addEnchant(Enchantment.THORNS,5,true);
        bmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(bmeta);
        escudo = item;
    }
    private static void createHulk() {
        ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Hulk"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7UPassivo: Força 2"));
        loreitem.add(Component.text("§7Ativo: +20 de vida e +tamanho"));
        loreitem.add(Component.text("§7Special: SMASH!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.BLAST_PROTECTION,4,true);
        meta.addEnchant(Enchantment.FIRE_PROTECTION,4,true);
        meta.addEnchant(Enchantment.PROJECTILE_PROTECTION,4,true);
        meta.addEnchant(Enchantment.PROTECTION,4,true);
        meta.setCustomModelData(1);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addAttributeModifier(SCALE, new AttributeModifier(SCALE.getKey(),0.25, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(MAX_HEALTH, new AttributeModifier(MAX_HEALTH.getKey(),20, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(SAFE_FALL_DISTANCE, new AttributeModifier(SAFE_FALL_DISTANCE.getKey(),100, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(ENTITY_INTERACTION_RANGE, new AttributeModifier(ENTITY_INTERACTION_RANGE.getKey(),10, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(STEP_HEIGHT, new AttributeModifier(STEP_HEIGHT.getKey(),2, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(JUMP_STRENGTH, new AttributeModifier(JUMP_STRENGTH.getKey(),2, AttributeModifier.Operation.ADD_NUMBER));
        item.setItemMeta(meta);
        hulk = item;
    }
    private static void createFenix(){
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia da Fenix"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Passivo: Resistencia a fogo e visão noturna"));
        loreitem.add(Component.text("§7Ativo: Chama da recuperação"));
        loreitem.add(Component.text("§7Special: Fly"));
        loreitem.add(Component.text("§7Ultra-Special: Long Fly"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.setCustomModelData(3);
        meta.addEnchant(Enchantment.BANE_OF_ARTHROPODS,5,true);
        meta.addEnchant(Enchantment.FIRE_ASPECT,50,true);
        meta.addEnchant(Enchantment.LOOTING,3,true);
        meta.addEnchant(Enchantment.SHARPNESS,5,true);
        meta.addEnchant(Enchantment.SMITE,5,true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE,5,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        fenix = item;
    }
    /*private static void createDomador() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Domador"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Um artefato feito"));
        loreitem.add(Component.text("§7pelos anciões"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.SILK_TOUCH,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        domador = item;
    }
    private static void createMago() {
        ItemStack item = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta meta = (BookMeta) item.getItemMeta();
        meta.setAuthor("§kGandalf");
        meta.displayName(Component.text("§6Relíquia do Mago"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7(1) Flecha Mágica"));
        loreitem.add(Component.text("§7(2) Bola de Fogo"));
        loreitem.add(Component.text("§7(3) Esfera de gelo"));
        loreitem.add(Component.text("§7(4) Explosão Sonora"));
        loreitem.add(Component.text("§7(5) Invocação - Cabeça Whiter"));
        loreitem.add(Component.text("§7(6) Invocação - Fogetão"));
        loreitem.add(Component.text("§7(7) Invocação - Poção"));
        loreitem.add(Component.text("§7(8) Invocação - Ender Perl"));
        loreitem.add(Component.text("§7(9) Pele de mana"));
        meta.lore(loreitem);
        List<Component> pages = new ArrayList<>();
        pages.add(Component.text("§lMágia Final\n§kLorem ipsum dolor sit amet, consectetur adipiscing elit. In tincidunt gravida tempus. Aliquot at nib nec dolor posuere efficient sit amet non tells. Interdum et dalesman fames ac ante ipsum."));
        Book bk = meta.pages(pages);

        if(bk.author().examinableName().equals(meta.getAuthor())){
            getServer().getConsoleSender().sendMessage("§6Author: "+meta.getAuthor());
        }
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        mago = item;
    }
    private static void createPis1() {
        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Pisante (1)"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Um artefato feito"));
        loreitem.add(Component.text("§7pelos anciões"));
        loreitem.add(Component.text("§7Modelo: Caminhar!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.PROTECTION,4,true);
        meta.addEnchant(Enchantment.FIRE_PROTECTION,4,true);
        meta.addEnchant(Enchantment.PROJECTILE_PROTECTION,4,true);
        meta.addEnchant(Enchantment.BLAST_PROTECTION,4,true);
        meta.addEnchant(Enchantment.DEPTH_STRIDER,3,true);
        meta.addEnchant(Enchantment.FEATHER_FALLING,4,true);
        meta.addEnchant(Enchantment.SOUL_SPEED,3,true);
        meta.addEnchant(Enchantment.FROST_WALKER,2,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        pisante_md1 = item;
    }
    private static void createPis2() {
        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Pisante (2)"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Um artefato feito"));
        loreitem.add(Component.text("§7pelos anciões"));
        loreitem.add(Component.text("§7Modelo: Rocket!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.PROTECTION,4,true);
        meta.addEnchant(Enchantment.FIRE_PROTECTION,4,true);
        meta.addEnchant(Enchantment.PROJECTILE_PROTECTION,4,true);
        meta.addEnchant(Enchantment.BLAST_PROTECTION,4,true);
        meta.addEnchant(Enchantment.DEPTH_STRIDER,3,true);
        meta.addEnchant(Enchantment.FEATHER_FALLING,20,true);
        meta.addEnchant(Enchantment.SOUL_SPEED,3,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        pisante_md2 = item;
    }
    private static void createCapacete() {
        ItemStack item = new ItemStack(Material.NETHERITE_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Capacete"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Um capacete forjado"));
        loreitem.add(Component.text("§7pelos alquimistas!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.AQUA_AFFINITY,1,true);
        meta.addEnchant(Enchantment.BLAST_PROTECTION,4,true);
        meta.addEnchant(Enchantment.FIRE_PROTECTION,4,true);
        meta.addEnchant(Enchantment.PROJECTILE_PROTECTION,4,true);
        meta.addEnchant(Enchantment.PROTECTION,4,true);
        meta.addEnchant(Enchantment.THORNS,3,true);
        meta.addEnchant(Enchantment.RESPIRATION,3,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        capacete = item;
    }
    private static void createPescador() {
        ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Relíquia do Pescador"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Uma vara de pesca"));
        loreitem.add(Component.text("§7que já pescou até"));
        loreitem.add(Component.text("§7mesmo um Elder Guardian!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LUCK_OF_THE_SEA,3,true);
        meta.addEnchant(Enchantment.LURE,3,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        pescador = item;
    }
    private static void createEscavacao() {
        ItemStack item = new ItemStack(Material.NETHERITE_SHOVEL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Reliquia da Escavação"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Uma pá capaz"));
        loreitem.add(Component.text("§7de achar"));
        loreitem.add(Component.text("§7ruinas ou templos"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.EFFICIENCY,5,true);
        meta.addEnchant(Enchantment.SILK_TOUCH,1,true);
        meta.addEnchant(Enchantment.FORTUNE,3,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        escavacao = item;
    }
    private static void createLadrao() {
        ItemStack item = new ItemStack(Material.BUNDLE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6Reliquia do Ladrão"));
        List<Component> loreitem = new ArrayList<>();
        loreitem.add(Component.text("§7Uma shulker capaz"));
        loreitem.add(Component.text("§7de roubar itens!"));
        loreitem.add(Component.text("§7Faz o L!"));
        meta.lore(loreitem);
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.INFINITY,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ladrao = item;
    }
    */
    private static void createLivro() {
        ItemStack item = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta meta = (BookMeta) item.getItemMeta();
        meta.setAuthor("O Explorador");
        meta.displayName(Component.text("§6Manual das Reliquias"));
        List<Component> pages = new ArrayList<>();
        pages.add(Component.text("§r§0Reliquias:\n(1) - Guerreiro\n(2) - Ceifador\n(3) - Totem\n(4) - Espião\n(5) - Poseidon\n(6) - Vento\n(7) - Arco\n(8) - Farmer\n(9) - Marreta\n(10) - Besta\n(11) - Miner\n(12) - Barbaro"));
        pages.add(Component.text("§r§0(13) - Peitoral\n(14) - Escudo\n(15) - Hulk\n(16) - Fenix"));
        pages.add(Component.text("§r§0Passivo é quando o item está no invetario\nAtivo quando o jogador está segurando o item na mão principal\nPara usar o special precisa está agachado e usar a reliquia, no caso de armadura só está com ela equipada!"));
        pages.add(Component.text("§l§6Relíquia do Guerreiro\n§r§0Special:\nUm corte especial que atravessa blocos chega até 50 blocos de distância e causa 20 de dano bruto por hit!"));
        pages.add(Component.text("§l§6Relíquia do Ceifador\n§r§0Special:\nUma ataque especial que atravessa blocos chega até 50 blocos de distância que tem chance de 1% de transformar seu alvo em um totem ou 99% de tirar 50% de vida do alvo!\nUltra-Special (Reque totem para ativar):Ao gastar o totem envia um ataque que mata a primeira entidade que achar pelo caminho!"));
        pages.add(Component.text("§l§6Relíquia do Spy\n§r§0Special: Entra no modo espectador por 10 segundos!\n"));
        pages.add(Component.text("§l§6Relíquia do Totem\n§r§0Special:\nUma fumaça paralizante que dá slow 5 nas entidades proxímas!"));
        pages.add(Component.text("§l§6Relíquia do Poseidon\n§r§0Special:\nInicia uma tempestade de raios!"));
        pages.add(Component.text("§l§6Relíquia do Vento\n§r§0Special:\nEnvia todos as entidades proximas para o \"espaço\" (levitação)!"));
        pages.add(Component.text("§l§6Relíquia do Arco\n§r§0Special:\nUma flecha que voa mais rapido que uma bala\nUltra-Specual (Reque tnt no inventario): Dispara um flecha rápida que explode no contato, a força da explosão é de no minimo 1 tnt a 64 tnt o máximo\nAVISO A EXPLOSÃO PODE TAMBÉM AFETA O ATIRADOR SE ESTIVER PERTO!"));
        pages.add(Component.text("§l§6Relíquia do Farmer\n§r§0Special:\nTransforma todos os mobs próximos num raio de 15 blocos em spawn egg"));
        pages.add(Component.text("§l§6Relíquia da Marreta\n§r§0Special:\nNo overworld dispara uma rajada de vento, no nether um bola de fogo e no end bafo do dragão"));
        pages.add(Component.text("§l§6Relíquia da Besta\n§r§0Special:\nDispara flechas rapidamente durante 30 segundos!"));
        pages.add(Component.text("§l§6Relíquia do Miner\n§r§0Special:\nAo ativar você é capas de quebrar qualquer bloco instantaneamente durante 10 segundos!"));
        pages.add(Component.text("§l§6Relíquia do Barbaro\n§r§0Special:\nAo ativar você fica invuneravel por 10 segundos!"));
        pages.add(Component.text("§l§6Relíquia do Peitoral\n§r§0Special:\nAo ativar aumenta 80 pontos de vida durante 30 segundos"));
        pages.add(Component.text("§l§6Relíquia do Escudo\n§r§0Special:\nAo ativar dispara um ataque que mata tudo na sua frente!"));
        pages.add(Component.text("§l§6Relíquia do Hulk\n§r§0Special:\nAo ativar esmaga todos os mob proximos!"));
        pages.add(Component.text("§l§6Relíquia da Fenix\n§r§0Special:\nLibera o fly do criativo por 20 segundos\nUltra-Special (Reque pena para usar): Aumenta o tempo de fly de no minimo 21 segundo até 84 segundos"));
        /*pages.add(Component.text("§r§0(13) - Pisante\n(14) - Escudo\n(15) - Marreta\n(16) - Capacete\n(17) - Pescador\n(18) - Peitoral\n(19) - Calça\n(20) - Barbaro\n(21) - Escavação\n(22) - Ladrão\n(23) - Hulk\n(24) - Fenix"));
        pages.add(Component.text("§l§6Relíquia do Domador\n§r§0Efeitos:\nNa mão: -Sem efeito-\nNo ataque: Pode convocar lobos para atacar o seu alvo, em animais domaveis o deixam domados na hora\nHabilidade: Pode coletar spawner"));
        pages.add(Component.text("§l§6Relíquia do Mago\n§r§0Efeitos:\nNa mão: Aleatório\nNo ataque: Aleatório\nHabilidade: Pode disparar feitiços"));
        pages.add(Component.text("§l§6Relíquia do Pisante - Caminhar\n§r§0Efeitos:\nVelocidade\nHabilidade: Criar campo de desaceleração"));
        pages.add(Component.text("§l§6Relíquia do Pisante - Rocket\n§r§0Efeitos:\nJump Bost e Levitação\nHabilidade: Durante a queda, ganha efeito de queda lente"));
        pages.add(Component.text("§l§6Relíquia do Capacete\n§r§0Efeitos:\nVisão noturna e Respiração aquativa quando esta nadando\nHabilidade: Deixa os outros com inveja (má sorte), pode dispara raio lazer"));
        pages.add(Component.text("§l§6Relíquia do Pescador\n§r§0Efeitos:\nRespiração aquativa e sorte\nHabilidade: Pode transformar mobs em peixes"));
        pages.add(Component.text("§l§6Relíquia da Escavação\n§r§0Efeitos:\nVisão noturna e pressa\nHabilidade: Pode localizar estruturas 1 Modo de escavação 2-9 Modo de exploração"));
        pages.add(Component.text("§l§6Relíquia do Ladrão\n§r§0Efeitos:\nNa mão: Invisibilidade e Visão Noturna\nHabilidade: Pode roubar itens!"));
        pages.add(Component.text("§l§6Relíquia da Fenix - Pena\n§r§0Efeitos:\nPermite voar, resistencia a fogo e visão noturna\nHabilidade: Queima todos os mobs proximos e pode curar feridas!"));
        pages.add(Component.text("§l§6Relíquia da Fenix - Garra\n§r§0Efeitos:\nResistencia a fogo e visão noturna\nHabilidade: Pode soltar um corte que queima todos na sua frente!"));
        */
        Book bk = meta.pages(pages);
        if(bk.author().examinableName().equals(meta.getAuthor())){
            getServer().getConsoleSender().sendMessage("§6Author: "+meta.getAuthor());
        }
        meta.setRarity(ItemRarity.EPIC);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        livro = item;
    }
}