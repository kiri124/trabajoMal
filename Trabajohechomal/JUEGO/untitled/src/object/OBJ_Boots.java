package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Boots extends SuperObject{
    public OBJ_Boots(){
        name="Boots";
        try{
            image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\Objects\\Botas1.png"));
        }catch (IOException e){
        }
        collision=false;
    }
}
