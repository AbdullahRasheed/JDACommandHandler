package me.dedose.commandhandler.api;

import me.dedose.commandhandler.api.listeners.IncorrectUsageEmbed;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class CommandHandler {

    String prefix = "!";
    Message incorrectChannel = new MessageBuilder("You can not use that command here!").build();
    IncorrectUsageEmbed incorrectUsageEmbed = new IncorrectUsageEmbed() {
        @Override
        public EmbedBuilder getIncorrectEmbed(String usage, Member sender) {
            EmbedBuilder builder = new EmbedBuilder();
            builder.setColor(Color.decode("#e74c3c"))
                    .setAuthor(sender.getUser().getName(), sender.getUser().getAvatarUrl(), sender.getUser().getAvatarUrl())
                    .setTitle("Incorrect Usage")
                    .setDescription("Correct usage " + usage);
            return builder;
        }
    };

    LinkedList<Command> commands = new LinkedList<>();

    public void registerCommands(Command... command){
        for(Command cmd : command) commands.add(cmd);
        System.out.println(commands);
    }

    public List<Command> getCommands(){
        System.out.println(commands);
        return commands;
    }

    public void setIncorrectUsageEmbed(IncorrectUsageEmbed incorrectUsageEmbed){
        this.incorrectUsageEmbed = incorrectUsageEmbed;
    }

    public IncorrectUsageEmbed getIncorrectUsageEmbed(){
        return incorrectUsageEmbed;
    }

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    public String getPrefix(){
        return prefix;
    }

    public void setIncorrectChannelMessage(Message incorrectChannel){
        this.incorrectChannel = incorrectChannel;
    }

    public Message getIncorrectChannelMessage(){
        return incorrectChannel;
    }
}
