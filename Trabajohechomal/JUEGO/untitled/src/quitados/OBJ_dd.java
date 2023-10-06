package object;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;


public class OBJ_dd extends SuperObject{
    public OBJ_dd(){
        name="dd";
    try{        
    image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\src\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\badguys\\house.png"));
    }
    catch(IOException e){

    }
    collision=true;

}
}
