package me.dedose.commandhandler.api.listeners;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;

public interface CommandExecuteListener {
    /**
     * Runs when the specified command is run
     * @param sender The member who executed the command
     * @param channel The channel the command was sent in
     * @param args A string array of each word in the command except the command itself
     * @param message The message of the command
     */
    void onCommand(Member sender, TextChannel channel, String[] args, Message message);
}
