package me.dedose.commandhandler.api;

import me.dedose.commandhandler.api.listeners.CommandExecuteListener;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;

import java.util.ArrayList;
import java.util.List;

public class Command {

    String[] aliases;
    String description = "No description defined";
    String usage = "No usage defined";
    List<TextChannel> usableChannels = new ArrayList<>();
    List<Permission> requiredPermissions = new ArrayList<>();
    int requiredArgs = 0;
    CommandExecuteListener cmdExecuteListener = new CommandExecuteListener() {
        public void onCommand(Member sender, TextChannel channel, String[] args, Message message) {
            // Ignore
        }
    };

    public Command(String[] aliases){
        this.aliases = aliases;
    }

    public void setDescrpition(String description){
        this.description = description;
    }

    public void setUsage(String usage){
        this.usage = usage;
    }

    public void setRequiredArgs(int requiredArgs){
        this.requiredArgs = requiredArgs;
    }

    public void setRequiredPermissions(Permission... permissions) {
        for(Permission perm : permissions) requiredPermissions.add(perm);
    }

    public void setCommandExecuteListener(CommandExecuteListener cmdExecuteListener){
        this.cmdExecuteListener = cmdExecuteListener;
    }

    public void setUsableChannels(TextChannel... usableChannels){
        for(TextChannel channel : usableChannels) this.usableChannels.add(channel);
    }

    public void register(){
        CommandHandler cmdHandler = new CommandHandler();
        cmdHandler.registerCommands(this);
    }

    public String[] getAliases(){
        return aliases;
    }

    public String getDescription(){
        return description;
    }

    public String getUsage(){
        return usage;
    }

    public int getRequiredArgs(){
        return requiredArgs;
    }

    public List<TextChannel> getUsableChannels(){
        return usableChannels;
    }

    public List<Permission> getRequiredPermissions(){
        return requiredPermissions;
    }

    public CommandExecuteListener getCommandExecuteListener(){
        return cmdExecuteListener;
    }
}
