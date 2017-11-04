package listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceSuppressEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATICS;

import static util.STATICS.voicelogChannelname;

public class voiceListener extends ListenerAdapter
{
     //Nachricht wird in ausgewähltem Channe ausgegeben
     public void onGuildVoiceJoin(GuildVoiceJoinEvent event)
     {
         event.getGuild().getTextChannelsByName(voicelogChannelname, true).get(0).sendMessage(
                 "**[+] " + event.getVoiceState().getMember().getEffectiveName() + "** ist dem Voicechannel **" + event.getChannelJoined().getName() + "** beigetreten."
         ).queue();
     }

     public void onGuildVoiceLeave(GuildVoiceLeaveEvent event)
     {
         event.getGuild().getTextChannelsByName(voicelogChannelname, true).get(0).sendMessage(
                 "**[-] " + event.getVoiceState().getMember().getEffectiveName() + "** hat den Voicechannel **" + event.getChannelLeft().getName() + "** verlassen."
         ).queue();
     }

    public void onGuildVoiceMove(GuildVoiceMoveEvent event)
    {
        event.getGuild().getTextChannelsByName(voicelogChannelname, true).get(0).sendMessage(
                 "**[>] " + event.getVoiceState().getMember().getEffectiveName() + "** ist von dem Voicechannel **" + event.getChannelLeft().getName() + "** in **" + event.getChannelJoined().getName() + "** gegangen."
        ).queue();
    }
}
