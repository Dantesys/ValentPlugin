package me.dantesys.valentCity.commands;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import me.dantesys.valentCity.ReliquiaArgType;
import me.dantesys.valentCity.ReliquiaType;
import me.dantesys.valentCity.ValentCity;
import me.dantesys.valentCity.items.Reliquias;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class GiveReliquia implements BasicCommand {
    @Override
    public void execute(CommandSourceStack stack, String[] args) {
        if (args.length == 2) {
            FileConfiguration config = ValentCity.getPlugin(ValentCity.class).getConfig();
            Player player = stack.getSender().getServer().getPlayer(args[0]);
            String jg = PlainTextComponentSerializer.plainText().serialize(player.name());
            String reliquiaArg = args[1];
            ReliquiaType reliquia;
            try {
                reliquia = new ReliquiaArgType().convert(reliquiaArg);
            } catch (CommandSyntaxException e) {
                throw new RuntimeException(e);
            }
            switch (reliquia) {
                case ReliquiaType.GUERREIRO:
                    player.getInventory().addItem(Reliquias.guerreiro);
                    config.set("reliquia.guerreiro", jg);
                    break;
                case ReliquiaType.CEIFADOR:
                    player.getInventory().addItem(Reliquias.ceifador);
                    config.set("reliquia.ceifador", jg);
                    break;
                case ReliquiaType.TOTEM:
                    player.getInventory().addItem(Reliquias.totem);
                    config.set("reliquia.totem", jg);
                    break;
                case ReliquiaType.SPY:
                    player.getInventory().addItem(Reliquias.spy);
                    config.set("reliquia.spy", jg);
                    break;
                case ReliquiaType.POSEIDON:
                    player.getInventory().addItem(Reliquias.poseidon);
                    config.set("reliquia.poseidon", jg);
                    break;
                case ReliquiaType.VENTO:
                    player.getInventory().addItem(Reliquias.poseidon);
                    config.set("reliquia.vento", jg);
                    break;
                case ReliquiaType.ARCO:
                    player.getInventory().addItem(Reliquias.arco);
                    config.set("reliquia.arco", jg);
                    break;
                case ReliquiaType.FARMER:
                    player.getInventory().addItem(Reliquias.farmer);
                    config.set("reliquia.farmer", jg);
                    break;
                case ReliquiaType.MARRETA:
                    player.getInventory().addItem(Reliquias.marreta);
                    config.set("reliquia.marreta", jg);
                    break;
                case ReliquiaType.BESTA:
                    player.getInventory().addItem(Reliquias.besta);
                    config.set("reliquia.besta", jg);
                    break;
                case ReliquiaType.MINER:
                    player.getInventory().addItem(Reliquias.miner);
                    config.set("reliquia.miner", jg);
                    break;
                case ReliquiaType.BARBARO:
                    player.getInventory().addItem(Reliquias.barbaro);
                    config.set("reliquia.barbaro", jg);
                    break;
                case ReliquiaType.PEITORAL:
                    player.getInventory().addItem(Reliquias.peitoral);
                    config.set("reliquia.peitoral", jg);
                    break;
                case ReliquiaType.ESCUDO:
                    player.getInventory().addItem(Reliquias.escudo);
                    config.set("reliquia.escudo", jg);
                    break;
                case ReliquiaType.HULK:
                    player.getInventory().addItem(Reliquias.hulk);
                    config.set("reliquia.hulk", jg);
                    break;
                case ReliquiaType.FENIX:
                    player.getInventory().addItem(Reliquias.fenix);
                    config.set("reliquia.fenix", jg);
                    break;
            }
            ValentCity.getPlugin(ValentCity.class).saveConfig();
            stack.getSender().sendRichMessage("Reliquia enviada!");
        }
    }
}
