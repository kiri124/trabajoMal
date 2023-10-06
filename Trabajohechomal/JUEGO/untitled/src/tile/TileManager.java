package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp=gp;
        tile=new Tile[10];
        mapTileNum=new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\src\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\maps\\map01.txt");
    }
    public void getTileImage(){
        try{
            tile[0]=new Tile();
            tile[0].image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\tiles\\grass.png"));
            tile[1]=new Tile();
            tile[1].image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\tiles\\Woodwall-1.png"));
            tile[1].collision=true;
            tile[2]=new Tile();
            tile[2].image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\tiles\\water.png"));
            tile[2].collision=true;
            tile[3]=new Tile();
            tile[3].image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\tiles\\earth.png"));
            tile[4]=new Tile();
            tile[4].image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\tiles\\tree.png"));
            tile[4].collision=true;
            tile[5]=new Tile();
            tile[5].image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\tiles\\sand.png"));


tile[6]=new Tile();
tile[6].image= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\src\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\badguys\\house.png"));
  
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filename){
        try{
            FileReader is=new FileReader(filename);
            BufferedReader br=new BufferedReader(is);
            int col=0;
            int row=0;
            while(col<gp.maxWorldCol && row<gp.maxWorldRow){
                String line= br.readLine();
                while ((line = br.readLine())!=null && row<gp.maxWorldRow) {


                    String numbers[] = line.split(" ");

                    for (col=0;col<gp.maxWorldCol;col++) {
                        mapTileNum[col][row]=Integer.parseInt(numbers[col]);
                    }
                    row++;
                }
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        int worldcol=0;
        int worldrow=0;

        while (worldcol<gp.maxWorldCol && worldrow<gp.maxWorldRow){
            int tileNum=mapTileNum[worldcol][worldrow];
            int worldX=worldcol*gp.tileSize;
            int worldY=worldrow*gp.tileSize;
            int screenX=worldX-gp.player.worldx+gp.player.screenX;
            int screenY=worldY-gp.player.worldy+gp.player.screenY;
            if(worldX+gp.tileSize>gp.player.worldx-gp.player.screenX &&
               worldX-gp.tileSize<gp.player.worldx+gp.player.screenX &&
               worldY+gp.tileSize>gp.player.worldy-gp.player.screenY &&
               worldY-gp.tileSize<gp.player.worldy+gp.player.screenY){

                g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            }

            worldcol++;

            if(worldcol==gp.maxWorldCol){
                worldcol=0;
                worldrow++;

            }
        }
    }
}
