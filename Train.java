import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */
public class Train extends Vehicle {
    public Train(String direction) {
        super(direction,12);     
        this.getImage().scale(getImage().getWidth(), 35);    
    }
    
    public void act() {
        if(getDirection() == "toLeft") {
            moveLeft();
        }
        
        if(getDirection() == "toRight") {
            moveRight();            
        }
    }    
}
