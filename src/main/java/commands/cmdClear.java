package commands;

import net.dv8tion.jda.core.entities.EmbedType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.OffsetDateTime;
import java.util.List;
import core.permsCore;

public class cmdClear implements Command{

    private int getInt(String string){
        try
        {
            return Integer.parseInt(string);
        }catch (Exception e)
            {
                e.printStackTrace();
                return 0;
            }
    }


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(permsCore.check(event))
        {
            return;
        }

        int numb = getInt(args[0]);

        if(args.length < 1)
        {
            event.getTextChannel().sendMessage("Bitte gib nur eine Zahl zwischen 2 und 100 ein!").queue();
        }

        if(numb > 1 && numb <= 100)
        {
            try
            {
                MessageHistory history = new MessageHistory(event.getTextChannel());
                List<Message> msgs;

                event.getMessage().delete().queue();

                msgs = history.retrievePast(numb).complete();
                event.getTextChannel().deleteMessages(msgs).queue();

            }catch (Exception e)
                {
                    e.printStackTrace();
                }
        }else
            {
                event.getTextChannel().sendMessage("Bitte gib eine Anzahl an Nachrichten an, die du löschen möchtest! (z.B.: .clear 5)").queue();
            }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
