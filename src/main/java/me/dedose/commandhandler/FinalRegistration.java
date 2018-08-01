package me.dedose.commandhandler;

import me.dedose.commandhandler.api.Command;
import me.dedose.commandhandler.api.CommandExecutor;
import net.dv8tion.jda.core.JDA;

import java.util.LinkedList;

public class FinalRegistration {

    public static JDA jda;
    public static LinkedList<Command> commands = new LinkedList<>();

    public FinalRegistration(JDA jda){
        this.jda = jda;
    }

    public void complete(){
        jda.addEventListener(new CommandExecutor());
    }
}
