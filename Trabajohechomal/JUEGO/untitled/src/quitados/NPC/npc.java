package NPC;
public class npc{
    private int x, y; // Posición del NPC
    private int width, height; // Tamaño del NPC
  //  private BufferedImage sprite; // Imagen del NPC

    // Constructor, getters y setters para el NPC

    // Método para que el NPC persiga al jugador
    public void chasePlayer(badguy mean) {
        // Calcula la dirección hacia la que moverse para alcanzar al jugador
        int playerX = mean.getX();
        int playerY = mean.getY();

        // Implementa la lógica de seguimiento aquí, por ejemplo, actualiza las coordenadas x e y del NPC para moverlo hacia el jugador
    }

   
    public void attackPlayer(badguy mean) {
        
    }
}