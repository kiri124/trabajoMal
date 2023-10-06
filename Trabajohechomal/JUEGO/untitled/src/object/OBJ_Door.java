package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Door extends SuperObject{
    public OBJ_Door(){
        name="Door";
        try{
            image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\Objects\\DoorSunny.png"));
        }catch (IOException e){
        }
        collision=true;
    }
}
