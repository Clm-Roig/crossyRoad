import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
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
    }
    
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(getDirection() == "toLeft") {
            moveLeft();
            
            if(isAtEdge()) {
                setLocation(this.getWorld().getWidth()+1,getY());
            }
        }
        
        if(getDirection() == "toRight") {
            moveRight();
            
            if(isAtEdge()) {
                setLocation(-1,getY());
            }
        }
    }
}
