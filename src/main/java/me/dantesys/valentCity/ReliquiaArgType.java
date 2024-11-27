package me.dantesys.valentCity;

import com.mojang.brigadier.Message;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import io.papermc.paper.command.brigadier.MessageComponentSerializer;
import io.papermc.paper.command.brigadier.argument.CustomArgumentType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class ReliquiaArgType implements CustomArgumentType<ReliquiaType,String> {
    public @NotNull ReliquiaType convert(String nativeType) throws CommandSyntaxException {
        try {
            return ReliquiaType.valueOf(nativeType.toUpperCase(Locale.getDefault()));
        } catch (IllegalArgumentException ignored) {
            Message message = MessageComponentSerializer.message().serialize(Component.text("Reliquia %s invalida!".formatted(nativeType), NamedTextColor.RED));

            throw new CommandSyntaxException(new SimpleCommandExceptionType(message), message);
        }
    }

    public ReliquiaType parse(StringReader stringReader) {
        return null;
    }
    @Override
    public @NotNull ArgumentType<String> getNativeType() {
        return StringArgumentType.word();
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        for (ReliquiaType reliquia : ReliquiaType.values()) {
            builder.suggest(reliquia.name(), MessageComponentSerializer.message().serialize(Component.text("Reliquias!", NamedTextColor.GREEN)));
        }

        return builder.buildFuture();
    }
}
