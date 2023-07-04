package ir.ac.kntu.flag;

import ir.ac.kntu.gameObjects.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Flag extends GameObject {

    public static Image image;

    public Flag(int x, int y) {
        super(x, y);
        this.setHealth(1);
        image = new Image("file:images\\flag.png");
    }

    public Image getImage() {
        return image;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(this.getImage(), this.getX(), this.getY(), 50, 50);
    }
}
