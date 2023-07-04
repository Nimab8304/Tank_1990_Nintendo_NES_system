package ir.ac.kntu.addItems;

import ir.ac.kntu.Main;
import ir.ac.kntu.tank.*;
import ir.ac.kntu.wall.ColumnWall;
import ir.ac.kntu.wall.IronWall;
import ir.ac.kntu.wall.RegularWall;
import ir.ac.kntu.wall.RowWall;


import java.io.Serializable;

public class Level1 implements Serializable {

    private static final long serialVersionUID = 42L;

    public static void addObjects() {
        IronWall ironWall = new IronWall(275, 300);
        IronWall ironWall1 = new IronWall(325, 300);
        IronWall ironWall2 = new IronWall(225, 300);
        IronWall ironWall3 = new IronWall(375, 300);
        RowWall rowWall = new RowWall(275, 580);
        RowWall rowWall1 = new RowWall(325, 580);
        RegularWall regularWall = new RegularWall(225, 250);
        RegularWall regularWall1 = new RegularWall(225, 200);
        RegularWall regularWall2 = new RegularWall(375, 250);
        RegularWall regularWall3 = new RegularWall(375, 200);
        RegularWall regularWall4 = new RegularWall(225, 350);
        RegularWall regularWall5 = new RegularWall(225, 400);
        RegularWall regularWall6 = new RegularWall(375, 350);
        RegularWall regularWall7 = new RegularWall(375, 400);
        ColumnWall columnWall = new ColumnWall(275, 600);
        ColumnWall columnWall1 = new ColumnWall(355, 600);
        Main.gameObjects.add(regularWall);
        Main.gameObjects.add(regularWall1);
        Main.gameObjects.add(regularWall2);
        Main.gameObjects.add(regularWall3);
        Main.gameObjects.add(regularWall4);
        Main.gameObjects.add(regularWall5);
        Main.gameObjects.add(regularWall6);
        Main.gameObjects.add(regularWall7);
        Main.gameObjects.add(rowWall);
        Main.gameObjects.add(rowWall1);
        Main.gameObjects.add(columnWall1);
        Main.gameObjects.add(columnWall);
        Main.gameObjects.add(ironWall1);
        Main.gameObjects.add(ironWall2);
        Main.gameObjects.add(ironWall3);
        Main.gameObjects.add(ironWall);
        ArmoredTank armoredTank = new ArmoredTank(0, 0);
        ArmoredTank armoredTank1 = new ArmoredTank(600, 0);

        RegularTank regularTank = new RegularTank(200, 0);
        RegularTank regularTank1 = new RegularTank(400, 0);
        RandomTank randomTank = new RandomTank(600, 0);
        RegularTank regularTank2 = new RegularTank(400, 0);
        Main.tanks.add(randomTank);
        Main.tanks.add(regularTank);
        Main.tanks.add(regularTank1);
        Main.tanks.add(armoredTank);
        Main.tanks.add(armoredTank1);
        Main.tanks.add(regularTank2);
        //saveGameObjectInfos(Main.gameObjects);
    }
}
