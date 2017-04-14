import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
       
       // Si on est sur un objet en mouvement, gameOver
       Actor intersectMov = getOneIntersectingObject(Mover.class);
       if(intersectMov != null) {
           this.killPlayer();
       } 
       
       // Si on est sur de l'eau et qu'il n'y a pas de Rock, gameOver
       Actor intersectWat = getOneIntersectingObject(Water.class);
       if(intersectWat != null) {
           Actor intersectRoc = getOneIntersectingObject(Rock.class);
           if(intersectRoc == null) {
               this.killPlayer();
           }
      }          
    }  
    
    public void killPlayer() {
        GreenfootImage img = getImage();
        img.setColor(greenfoot.Color.RED);
        img.drawLine(0, 0, img.getWidth(), img.getHeight());
        img.drawLine(0, img.getHeight(), img.getWidth(), 0);

        ((Map)getWorld()).gameOver();
    }
}
