import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */
public class Car extends Vehicle
{  
    public Car(int cell_size, String direction) {
        super(cell_size, direction);
    }
    
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(getDirection() == "toLeft") {
            moveLeft();
        }
        if(getDirection() == "toRight") {
            moveRight();
        }
    }
}
