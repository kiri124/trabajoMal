package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Chest extends SuperObject {
    public OBJ_Chest(){
        name="Chest";
        try{
            image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\Objects\\Chest1.png"));
        }catch (IOException e){
        }
        collision=true;
    }
}
