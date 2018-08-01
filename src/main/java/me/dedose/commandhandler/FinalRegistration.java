package me.dedose.commandhandler;

import me.dedose.commandhandler.api.CommandExecutor;
import net.dv8tion.jda.core.JDA;

public class FinalRegistration {

    public static JDA jda;

    public FinalRegistration(JDA jda){
        this.jda = jda;
    }

    public void complete(){
        jda.addEventListener(new CommandExecutor());
    }
}
