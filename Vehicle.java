import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vehicle here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */
public abstract class Vehicle extends Mover
{
    private final int IMAGE_SIZE = 45;
    private String direction;    
    
    public Vehicle(String direction, int s) { 
        super();
        super.setSpeed(s);
        
        float ratioHW = (float) getImage().getHeight()/getImage().getWidth();
        float newHeight = IMAGE_SIZE * ratioHW;
        this.getImage().scale(IMAGE_SIZE,(int)newHeight);    
        
        this.direction = direction;
        if(direction == "toRight") {
            setRotation(0);
        }
        else {
            setRotation(180);
        }
    } 
    
    // GET / SET
    public String getDirection() {return this.direction;}
 
    /**
     * Act - do whatever the Vehicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        
    }    
}
