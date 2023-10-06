package main;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //SCREEN SETTINGS
    final int originalTileSize=16; //In most 2d games the mobs are 16 x 16 px, but we can scale it
    final int scale=7;

    final public int tileSize=originalTileSize*scale; //48*48
    public final int maxScreenCol=14;
    public final int getMaxScreenRow=8;
    public final int screenWidth=tileSize*maxScreenCol;//768 px
    public final int screenHeight=tileSize*getMaxScreenRow;//576 px

    //World settings
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int worldWidth=tileSize*maxWorldCol;
    public final int worldHeight=tileSize*maxWorldRow;
    //FPS
    int FPS=60;
    //tilemanager
    TileManager tileM=new TileManager(this);

    KeyHandler keyH=new KeyHandler();
    Sound music=new Sound();
    Sound se=new Sound();
    public UI ui=new UI(this);


    
    //Start the clock of the game
    Thread gameThread;
    public CollisionChecker cChercker=new CollisionChecker(this);
    public AssetSetter aSetter=new AssetSetter(this);

/* el thread es el hilo que para actualizando cuando juegas
 * y eso permite que juegues 
 * 
 */
    public Player player=new Player(this,keyH);
    public SuperObject obj[]=new SuperObject[10];
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame(){
        aSetter.setObject();
        playMusic(0);
    }
    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    public void run(){
        double drawInterval=1000000000/FPS;//0.01666seconds;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount=0;

        while(gameThread!=null){
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            timer+=(currentTime-lastTime);
            lastTime=currentTime;
            if (delta>=1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer>=1000000000){
                System.out.println("FPS:"+drawCount);
                drawCount=0;
                timer=0;
            }
        }
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;
        //tile
        tileM.draw(g2);
        //Object
        for(int i=0;i<obj.length;i++){
            if(obj[i]!=null){
                obj[i].draw(g2,this);
            }
        }
        //player
        player.draw(g2);
        ui.draw(g2);
        g2.dispose();
    }
    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int i){
        se.setFile(i);
        se.play();
    }
    
}
