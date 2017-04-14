import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0))
 */
public class Player extends Mover
{
    private int score = 0;
    
    public Player(int cell_size) {
        this.getImage().scale(cell_size,cell_size);
        setRotation(270);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {     
       if(Greenfoot.isKeyDown("up")) moveUp();
       if(Greenfoot.isKeyDown("right")) moveRight();
       if(Greenfoot.isKeyDown("left")) moveLeft();       
       
    }    
}
