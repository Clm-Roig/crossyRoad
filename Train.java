import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Train here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */
public class Train extends Vehicle
{    
    public Train(String direction) {
        super(direction,10);     
        this.getImage().scale(getImage().getWidth(), 35);    
    }
    
    public void act() {
        if(getDirection() == "toLeft") {
            moveLeft();
            
            if(isAtEdge()) {
                
            }
        }
        
        if(getDirection() == "toRight") {
            moveRight();
            
            if(isAtEdge()) {
                
            }
        }
    }    
}
