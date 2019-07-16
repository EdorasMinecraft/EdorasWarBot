// Desarrollador: Sergio Jiménez R.
package es.edoras.warbot;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.*;

public class Main implements ValoresPredefinidos {

    public static void main(String[] args) throws FileNotFoundException {

        //PrintWriter pw = new PrintWriter(new File("Tweets.txt"));
        String pw = "";

        Comunidad c = new Comunidad();
        rellenarComunidad(c);

        pw += "¡La guerra Edorina está a punto de empezar!\n\nNúmero de participantes: " + nombres.length + " Edorinxs\n\n#EdorasHueleASangre";
        //pw += "Participantes: "+c.listadoVivos()+"\n";

        try{
            updateStatus(getTwitterInstance(), pw);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        pw = "";

        try {
            Thread.sleep(300000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < nombres.length && nombres.length - c.getnMuertos() > 1; i++) {
            for(int j = 0; j < 12; j++) {
                pw += imprimirFecha();
                pw += c.matar(c.getVPersonas()[c.encontrarVivo()], c.getVPersonas()[c.encontrarVivo()]);
                if(nombres.length - c.getnMuertos() != 1) {
                    pw += nombres.length - c.getnMuertos() + " personas vivas.\n";
                    //pw += "Vivos: "+c.listadoVivos() + "\n";
                } else
                    pw += "GANADOR: "+c.listadoVivos() + "\n";

                pw += "\n#EdorasHueleASangre\n";

                try{
                    updateStatus(getTwitterInstance(), pw);
                } catch (TwitterException e) {
                    e.printStackTrace();
                }

                pw = "";

                try{
                    Thread.sleep(3600000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try{
                Thread.sleep(43200000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(SuicidiosActivados) pw += "Se ha/n producido "+c.getSuicidios()+" suicidio/s.";

        pw += "Fin.";
        System.out.println(pw);
    }

    private static final String CONSUMER_KEY = "";
    private static final String CONSUMER_SECRET = "";
    private static final String ACCESS_TOKEN = "";
    private static final String ACCESS_SECRET = "";

    public static Twitter getTwitterInstance(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }

    static String tweets = "";

    private static void updateStatus(Twitter twitter, String message) throws TwitterException, FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("Tweets.txt"));
        tweets += message+"\n\n";
        pw.println(tweets);
        pw.close();
        Status status = twitter.updateStatus(message);
        System.out.println(status.getText());
    }

    public static void rellenarComunidad(Comunidad c) throws FileNotFoundException {
        for(int i = 0; i < nombres.length; i++)
            c.addPersona(new Persona(nombres[i]));
    }

    static int año = AñoDeComienzo;
    static int mes = MesDeComienzo;
    public static String imprimirFecha() {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        if (mes == 13) {
            mes = 1;
            año++;
        }

        if (mes == 2)
            if(año % 4 == 0)
                return (int)(Math.random()*29+1) + " de " + meses[mes++-1] + " de " + año + "\n\n"; // Año bisiesto
            else
                return (int)(Math.random()*28+1) + " de " + meses[mes++-1] + " de " + año + "\n\n"; // Año no bisiesto
        else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
            return (int)(Math.random()*30+1) + " de " + meses[mes++-1] + " de " + año + "\n\n";
        else
            return (int)(Math.random()*31+1) + " de " + meses[mes++-1] + " de " + año + "\n\n";
    }
}