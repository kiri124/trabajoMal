package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class Sound {
    Clip clip;
    String soundURL[]=new String[30];
    public Sound(){
        soundURL[0]="C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\sound\\xd.wav";
        soundURL[1]="C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\sound\\prueba2.wav";
    }

    public void setFile(int i){
        try {
            AudioInputStream ais= AudioSystem.getAudioInputStream(new File(soundURL[i]).getAbsoluteFile());
            clip=AudioSystem.getClip();
            clip.open(ais);
        }catch (Exception e){

        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
