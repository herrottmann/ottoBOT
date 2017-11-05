package core;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATICS;

import java.util.Arrays;

public class permsCore
{
    public static boolean check(MessageReceivedEvent event)
    {
        for (Role r:event.getGuild().getMember(event.getAuthor()).getRoles())
        {
            if(Arrays.stream(STATICS.PERMS).parallel().anyMatch(r.getName()::contains))
                return false;
            else
                System.out.println("FEHLER: " + event.getAuthor().getName() + ": Fehlende Berechtigung!");
                event.getTextChannel().sendMessage(":warning: " + event.getAuthor().getAsMention() + ", du hast nicht die nötigen Berechtigungen, um diesen Befehl zu nutzen!").queue();
        }
        return true;
    }
}
