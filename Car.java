import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Car follows the direction of his road. 
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */
public class Car extends Vehicle { 
    private final int IMAGE_SIZE = 45;
    
    public Car(String direction, int s) {
        super(direction,s);
        float ratioHW = (float) getImage().getHeight()/getImage().getWidth();
        float newHeight = IMAGE_SIZE * ratioHW;
        this.getImage().scale(IMAGE_SIZE,(int)newHeight);    
        
        if(direction == "toRight") {
            setRotation(0);
        }
        else {
            setRotation(180);
        }
    }
    
    public void act() {
        if(getDirection() == "toLeft") {
            moveLeft();            
            if(isAtEdge()) {
                setLocation(this.getWorld().getWidth()-1,getY());
            }
        }
        
        if(getDirection() == "toRight") {
            moveRight();            
            if(isAtEdge()) {
                setLocation(1,getY());
            }
        }
    }
}
