package ir.ac.kntu.wall;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.Serializable;

public class ColumnWall extends Wall implements Serializable {
    public static Image image;

    public ColumnWall(int x, int y) {
        super(x, y);
        setHealth(2);
        image=new Image("file:images\\MiniWall\\miniup.png");
    }

    public Image getImage() {
        return image;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(this.getImage(),this.getX(),this.getY(),20,50);
    }
}
