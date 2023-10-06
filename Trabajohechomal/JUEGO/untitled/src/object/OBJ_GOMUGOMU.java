package object;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_GOMUGOMU extends SuperObject{
    public OBJ_GOMUGOMU(){
        name="GomuGomu";
        try{
            image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\Objects\\GomuGomu .png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision=true;
    }
}
