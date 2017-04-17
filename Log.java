import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Log here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Log extends Platform {
    private final int IMAGE_SIZE = 50;
    
    public Log(String direction,int speed) {
        super(speed,direction);
        
        // TODO : à arranger (nouvelle image ?) surtout le + 10
        float ratioHW = (float) getImage().getHeight()/getImage().getWidth();
        float newHeight = IMAGE_SIZE * ratioHW + 10;
        this.getImage().scale(IMAGE_SIZE,(int)newHeight);      
        
        if(direction == "toRight") {
            setRotation(0);
        }
        else {
            setRotation(180);
        }
    }
    
    /**
     * Act - do whatever the Log wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
