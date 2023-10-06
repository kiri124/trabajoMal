package NPC;

public class EnemigoFactory {
    public static badguy crearEnemigo(int x, int y) {
        // Aquí puedes personalizar las propiedades del enemigo, como la vida
        return new badguy(x, y, 32, 32, 100); // Por ejemplo, un enemigo con 100 puntos de vida
    }
    badguy enemigo1 = EnemigoFactory.crearEnemigo(100, 200);
badguy enemigo2 = EnemigoFactory.crearEnemigo(300, 400);
}
