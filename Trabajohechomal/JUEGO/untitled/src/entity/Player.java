package entity;
import main.GamePanel;
import main.KeyHandler;
import object.OBJ_Door;
//llama a otras carpetas
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//llama librerias
public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public int hasKey=0;
    public int keyChest=0;
    int speed;

    public Player(GamePanel gp,KeyHandler keyH){
        this.gp=gp;
        this.keyH=keyH;
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);

        solidArea=new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.height=32;
        solidArea.width=32;

        setDefaultValues();
        getPlayerImg();
    }

    public void setDefaultValues(){
        worldx=gp.screenWidth/2;
        worldy=gp.screenHeight/2;
        speed=5;
        direction="down";
    }
    public void getPlayerImg(){
        try{
            up1= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\player\\luffygoingdown1.png"));
            up2= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\player\\luffygoingdown2.png"));
            down1= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\player\\luffygoingup1.png"));
            down2= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\player\\luffygoingup2.png"));
            left1= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\player\\luffystanding.png"));
            left2= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\player\\luffywalking.png"));
            right1= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\player\\luffywalkingright.png"));
            right2= ImageIO.read(new File("C:\\Users\\USUARIO\\Desktop\\JuegoFinal\\TrabajoFinalPOOII\\JUEGO\\untitled\\res\\src\\player\\standingright.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyH.upPressed==true||keyH.downPressed==true||keyH.leftPressed==true||keyH.rightPressed==true){
            if(keyH.upPressed==true){
                direction="up";
            }
            if (keyH.downPressed==true){
                direction="down";
            }
            if (keyH.leftPressed==true){
                direction="left";
            }
            if(keyH.rightPressed==true){
                direction="right";
            }
            if(keyH.rightPressed==true && keyH.upPressed==true ){
                direction="up-right";
            }
            if(keyH.leftPressed==true && keyH.upPressed==true ){
                direction="up-left";
            }
            if(keyH.leftPressed==true && keyH.downPressed==true ){
                direction="down-left";
            }
            if(keyH.rightPressed==true && keyH.downPressed==true ){
                direction="down-right";
            }

            //Chech collision
            collisionOn=false;
            gp.cChercker.checkTile(this);

            //Check obj collision
            int objIndex=gp.cChercker.checkObject(this,true);
            pickUpObject(objIndex);
            //if collision is false, player can move
            if(collisionOn==false){
                switch (direction){
                    case"up":
                        worldy-=speed;
                        break;
                    case "down":
                        worldy+=speed;
                        break;
                    case "left":
                        worldx-=speed;
                        break;
                    case "right":
                        worldx+=speed;
                        break;
                    case "up-right":
                        worldy-=(speed-1);
                        worldx+=(speed-1);
                        break;
                    case "up-left":
                        worldy-=(speed-1);
                        worldx-=(speed-1);
                        break;
                    case "down-left":
                        worldy+=(speed-1);
                        worldx-=(speed-1);
                        break;
                    case "down-right":
                        worldy+=(speed-1);
                        worldx+=(speed-1);
                        break;
                }
            }
            spriteCounter++;
            if(spriteCounter>15){
                if(spriteNum==1){
                    spriteNum=2;
                } else if (spriteNum==2) {
                    spriteNum=1;
                }
                spriteCounter=0;
            };
        }
    }



    public void pickUpObject(int i){
        if(i!=999){
            String objectName=gp.obj[i].name;
            switch (objectName){
                case "Key":
                    hasKey++;
                    gp.obj[i]=null;
                    gp.ui.showMessage("You got a key");
                    break;
                case "GomuGomu":
                    gp.obj[i]=null;
                    gp.ui.showMessage("Demon fruit?");
                    break;
                case "Door":
                    if(hasKey>0){
                        gp.obj[i]=null;
                        hasKey--;
                    }
                    else{
                        gp.ui.showMessage("You need a key");
                    }
                    break;
                case "Chest":
                    if(keyChest>0){
                        gp.ui.showMessage("Treasure");
                        keyChest--;
                    }
                    else{
                        gp.ui.showMessage("You need a key");
                    }
                    break;
                case "Boots":
                    speed+=2;
                    gp.playSE(1);
                    gp.obj[i]=null;
                    break;
            }
        }
    }


    
    public int getSpeed(){
        return speed;
    }
    public void draw(Graphics2D g2){
        BufferedImage image=null;
        switch (direction){
            case "up":
                if(spriteNum==1){
                    image=up1;
                }
                if(spriteNum==2){
                    image=up2;
                }
                break;
            case "down":
                if(spriteNum==1){
                    image=down1;
                }
                if(spriteNum==2){
                    image=down2;
                }
                break;
            case "left":
            //,"up-left","down-left"
                if(spriteNum==1){
                    image=left1;
                }
                if(spriteNum==2){
                    image=left2;
                }
                break;

                case "down-left":
                if(spriteNum==1){
                    image=left1;
                }
                if(spriteNum==2){
                    image=left2;
                }
                break;


            case "right":
            //,"up-right","down-right"
                if(spriteNum==1){
                    image=right1;
                }
                if(spriteNum==2){
                    image=right2;
                }
                break;


                case"down-right":
                if(spriteNum==1){
                    image=right1;
                }
                if(spriteNum==2){
                    image=right2;
                }
                break;
        }
        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
    }

}
