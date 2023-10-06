package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Key extends SuperObject{
    public OBJ_Key(){
        name="Key";
        try{
            image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\Objects\\LlaveDoor.png"));
        }catch (IOException e){
        }
    }
}
