package me.dedose.commandhandler.api;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class CommandExecutor extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        CommandHandler cmdHandler = new CommandHandler();
        String command = event.getMessage().getContentRaw().split(" ")[0];
        String[] args = Arrays.copyOfRange(event.getMessage().getContentRaw().split(" "), 1, event.getMessage().getContentRaw().split(" ").length);

        for(Command cmd : cmdHandler.getCommands()){
            for(String aliases : cmd.getAliases()){
                if(command.equalsIgnoreCase(cmdHandler.getPrefix() + aliases)) {
                    if (cmd.getRequiredPermissions().isEmpty()) {
                        if (args.length >= cmd.getRequiredArgs()) {
                            if (cmd.getUsableChannels().isEmpty()) {
                                cmd.getCommandExecuteListener().onCommand(event.getMember(), event.getChannel(), args, event.getMessage());
                            } else {
                                if (cmd.getUsableChannels().contains(event.getChannel())) {
                                    cmd.getCommandExecuteListener().onCommand(event.getMember(), event.getChannel(), args, event.getMessage());
                                } else {
                                    event.getChannel().sendMessage(cmdHandler.getIncorrectChannelMessage()).complete().delete().queueAfter(15, TimeUnit.SECONDS);
                                }
                            }
                        } else {
                            event.getChannel().sendMessage(cmdHandler.getIncorrectUsageEmbed().getIncorrectEmbed(cmd.getUsage(), event.getMember()).build()).complete().delete().queueAfter(15, TimeUnit.SECONDS);
                        }
                    }else{
                        for (Permission perms : cmd.getRequiredPermissions()) {
                            if (!event.getMember().getPermissions().contains(perms)) {
                                event.getChannel().sendMessage(cmdHandler.getInsufficientPermissionsMessage()).queue();
                                return;
                            }
                        }
                        if (args.length >= cmd.getRequiredArgs()) {
                            if (cmd.getUsableChannels().isEmpty()) {
                                cmd.getCommandExecuteListener().onCommand(event.getMember(), event.getChannel(), args, event.getMessage());
                            } else {
                                if (cmd.getUsableChannels().contains(event.getChannel())) {
                                    cmd.getCommandExecuteListener().onCommand(event.getMember(), event.getChannel(), args, event.getMessage());
                                } else {
                                    event.getChannel().sendMessage(cmdHandler.getIncorrectChannelMessage()).complete().delete().queueAfter(15, TimeUnit.SECONDS);
                                }
                            }
                        } else {
                            event.getChannel().sendMessage(cmdHandler.getIncorrectUsageEmbed().getIncorrectEmbed(cmd.getUsage(), event.getMember()).build()).complete().delete().queueAfter(15, TimeUnit.SECONDS);
                        }
                    }
                }
            }
        }
    }
}
