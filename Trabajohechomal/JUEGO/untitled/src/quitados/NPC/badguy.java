package NPC;
import main.GamePanel;
import main.KeyHandler;
import object.OBJ_Door;
//llama a otras carpetas
import javax.imageio.ImageIO;
import entity.Player;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class badguy {
    private int x, y; // Posición del jugador
    private int width, height; // Tamaño del jugador
    private BufferedImage sprite; // Imagen del jugador
private int vida;

    badguy(int x, int y, int width, int height,int vida){
        this.x=x;
        this.y=y;
this.width=width;
this.height=height;
this.vida=vida;

    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    public int getVida() {
        return vida;
    }

    // Constructor, getters y setters para el jugador
}



