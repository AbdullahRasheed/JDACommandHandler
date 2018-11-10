package me.dedose.commandhandler;

import me.dedose.commandhandler.api.Command;
import me.dedose.commandhandler.api.CommandCreator;
import me.dedose.commandhandler.api.CommandExecutor;
import me.dedose.commandhandler.api.CommandHandler;
import net.dv8tion.jda.core.JDA;

import java.util.LinkedList;

public class FinalRegistration {

    private CommandHandler handler;

    private static JDA jda;
    public static LinkedList<Command> commands = new LinkedList<>();
    public static String prefix = "!";
    private LinkedList<CommandCreator> commandCreators = new LinkedList<>();

    public FinalRegistration(JDA jda){
        this.jda = jda;
    }

    public void complete(){
        this.handler = new CommandHandler();
        commandCreators.forEach(c -> c.getCommand().register());
        jda.addEventListener(new CommandExecutor(handler));
    }

    public void registerCommandCreator(CommandCreator commandCreator){
        commandCreators.add(commandCreator);
    }
}