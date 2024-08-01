package fr.dawan.listener;

import com.sun.tools.javac.util.List;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.Optional;


public class BotListener extends ListenerAdapter {
    @Override // Se déclenche quand le bot est prêt à interagir dans un serveur
    public void onGuildReady(GuildReadyEvent event) {
        Guild guild = event.getGuild(); // Est la classe représentant un serveur Discord
        guild.updateCommands().addCommands(
                Commands.slash("speak", "Envoyer un message")
                        .addOption(OptionType.STRING, "message", "Texte à envoyer", true)
                        .addOption(OptionType.CHANNEL, "channel", "Channel où envoyer le message")
        ).queue();
    }

    @Override // Réagis à l'appel d'une commande type Slash
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("speak"))
            sendMessageToChannel(
                Optional.ofNullable(event.getOption("channel"))
                        .map(channel -> channel.getAsChannel().asTextChannel())
                        .orElse(event.getChannel().asTextChannel()),
                event.getOption("message").getAsString()
        );
        event.reply("Effectué")// Il faut toujours répondre à une interception
                .setEphemeral(true)// Réponse uniquement visible par l'utilisateur ayant lancé la commande
                .queue();

    }

    private void sendMessageToChannel(TextChannel channel, String message) {
        channel.sendMessage(message).queue();
    }
}
