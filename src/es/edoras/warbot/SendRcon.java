// Made with love by Kikisito <3
package es.edoras.warbot;

import net.kronos.rkon.core.Rcon;
import net.kronos.rkon.core.ex.AuthenticationException;

import java.io.IOException;

public class SendRcon extends Main {
    public static void SendCommand(String murder, String victim) {
        try {
            Rcon rcon = new Rcon("IP", PORT, "PASSWORD".getBytes());
            String msg = "alertraw ['',{'text':'[','color':'white'},{'text':'Edoras War Bot','color':'red'},{'text':'] ','color':'white'},{'text':'" + murder + " ha matado a " + victim + "','color':'aqua'}]";
            String msg2 = "alertraw ['',{'text':'[','color':'white'},{'text':'Edoras War Bot','color':'red'},{'text':'] ','color':'white'},{'text':'[','color':'white','clickEvent':{'action':'open_url','value':'https://twitter.com/edorasminecraft'},'hoverEvent':{'action':'show_text','value':{'text':'','extra':[{'text':'Pulsa para entrar al perfil de @EdorasMinecraft','color':'aqua'}]}}},{'text':'Ver en Twitter','color':'green','clickEvent':{'action':'open_url','value':'https://twitter.com/edorasminecraft'},'hoverEvent':{'action':'show_text','value':{'text':'','extra':[{'text':'Pulsa para entrar al perfil de @EdorasMinecraft','color':'aqua'}]}}},{'text':']','color':'white','clickEvent':{'action':'open_url','value':'https://twitter.com/edorasminecraft'},'hoverEvent':{'action':'show_text','value':{'text':'','extra':[{'text':'Pulsa para entrar al perfil de @EdorasMinecraft','color':'aqua'}]}}}]";
            msg = msg.replaceAll("'", "\"");
            msg2 = msg2.replaceAll("'", "\"");
            String result = rcon.command(msg);
            String result2 = rcon.command(msg2);
            System.out.println(result);
            System.out.println(result2);
        } catch (AuthenticationException | IOException e) {
            e.printStackTrace();
        }
    }
}
