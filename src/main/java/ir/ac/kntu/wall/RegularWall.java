package ir.ac.kntu.wall;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.Serializable;

public class RegularWall extends Wall implements Serializable {

    public static Image image;

    public RegularWall(int x, int y) {
        super(x, y);
        setHealth(4);
    }

    public Image getImage() {
        return image;
    }

    public void draw(GraphicsContext gc) {
        if (this.getHealth()==4){
            image=new Image("file:images\\RegularWall\\Hp4.png");
        }else if (this.getHealth()==3){
            image=new Image("file:images\\RegularWall\\Hp3.png");
        }else if (this.getHealth()==2){
            image=new Image("file:images\\RegularWall\\Hp2.png");
        }else if (this.getHealth()==1){
            image=new Image("file:images\\RegularWall\\Hp1.png");
        }

        gc.drawImage(this.getImage(),this.getX(),this.getY(),50,50);
    }
}
