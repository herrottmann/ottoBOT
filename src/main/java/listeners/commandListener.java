package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATICS;
import core.*;

public class commandListener extends ListenerAdapter
{
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if(event.getMessage().getContent().startsWith(STATICS.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId())
        {
            commandHandler.handleCommand(commandHandler.parse.parser(event.getMessage().getContent(), event));
        }
    }
}
