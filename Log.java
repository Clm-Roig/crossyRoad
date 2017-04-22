import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1,0
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
