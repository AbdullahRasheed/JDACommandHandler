package me.dedose.commandhandler.api.listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;

public interface IncorrectUsageEmbed {
    /**
     * The embed to send when a command is incorrectly used
     * @param usage The correct usage of the command
     * @param sender The member that executed the command
     * @return
     */
    EmbedBuilder getIncorrectEmbed(String usage, Member sender);
}
