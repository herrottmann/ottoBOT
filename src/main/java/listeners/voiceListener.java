package listeners;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class voiceListener extends ListenerAdapter
{
     public void onGuildVoiceJoin(GuildVoiceJoinEvent event)
     {
         event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(
                 "**" + event.getVoiceState().getMember().getEffectiveName() + "** ist dem Voicechannel **" + event.getChannelJoined().getName() + "** beigetreten."
         ).queue();
     }

     public void onGuildVoiceLeave(GuildVoiceLeaveEvent event)
     {
         event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(
                 "**" + event.getVoiceState().getMember().getEffectiveName() + "** hat den Voicechannel **" + event.getChannelLeft().getName() + "** verlassen."
         ).queue();
     }
}
