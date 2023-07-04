package ir.ac.kntu.style;

import ir.ac.kntu.tank.ArmoredTank;
import ir.ac.kntu.tank.RandomTank;
import ir.ac.kntu.tank.RegularTank;
import ir.ac.kntu.wall.RegularWall;
import ir.ac.kntu.wall.RowWall;
import junit.framework.TestCase;

public class JunitTest extends TestCase {
    public void testHealth(){
        ArmoredTank armoredTank=new ArmoredTank(0,0);
        assertEquals(armoredTank.getHealth(),2);
    }
    public void testLocation(){
        ArmoredTank armoredTank=new ArmoredTank(0,0);
        assertEquals(armoredTank.getX(),0);
        assertEquals(armoredTank.getY(),0);
    }
    public void testRandomTank(){
        RandomTank randomTank=new RandomTank(0,0);
        if (randomTank.getTankType()==0){
            assertEquals(randomTank.getHealth(),1);
        }else {
            assertEquals(randomTank.getHealth(),2);
        }
    }
    public void testTankSpeed(){
        RegularTank regularTank=new RegularTank(50,50);
        assertEquals(regularTank.getSpeed(),1);
    }

    public void testWallHealth(){
        RegularWall  regularWall=new RegularWall(0,0);
        assertEquals(regularWall.getHealth(),4);
    }

    public void testRowWallHealth(){
        RowWall regularWall=new RowWall(0,0);
        assertEquals(regularWall.getHealth(),2);
    }

}
