package me.dedose.commandhandler;

import me.dedose.commandhandler.api.Command;
import me.dedose.commandhandler.api.CommandExecutor;
import me.dedose.commandhandler.api.CommandHandler;
import net.dv8tion.jda.core.JDA;

import java.util.LinkedList;

public class FinalRegistration {

    private CommandHandler handler;

    public static JDA jda;
    public static LinkedList<Command> commands = new LinkedList<>();

    public FinalRegistration(JDA jda){
        this.jda = jda;
    }

    public void complete(){
        this.handler = new CommandHandler();
        jda.addEventListener(new CommandExecutor(handler));
    }
}
