package ir.ac.kntu.grass;

import ir.ac.kntu.gameObjects.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Grass extends GameObject {

    public Image image;

    public Grass(int x, int y) {
        super(x, y);
        setHealth(1);
        image = new Image("file:images\\Grass.png");
    }

    public Image getImage() {
        return image;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(this.getImage(), this.getX(), this.getY(), 50, 50);
    }
}
