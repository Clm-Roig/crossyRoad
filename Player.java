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
    
    private final int IMAGE_SIZE = 40;
    private final int WALKING_DELAY = 15;
    private int walkingDelayCounter = 0;
    private int speed = 50;
    
    public Player() {
        this.getImage().scale(IMAGE_SIZE,IMAGE_SIZE);
        setRotation(270);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {     
        checkMove();
       
        // Si on est sur un objet en mouvement, gameOver
        Actor intersectMov = getOneIntersectingObject(Mover.class);
        if(intersectMov != null) {
            this.killPlayer();
        } 
       
        // Si on est sur de l'eau et qu'il n'y a pas de Rock, gameOver
        List<Water> listWat = getObjectsAtOffset(0,0,Water.class);
        if(!listWat.isEmpty()){
            List<Rock> listRock = getObjectsAtOffset(0,0,Rock.class);
            if(listRock.isEmpty()) {
                killPlayer();
            }
        }
        
        walkingDelayCounter++;
    }  
    
    public void checkMove() {
        if(walkingDelayCounter >= WALKING_DELAY) {
            
            if(Greenfoot.isKeyDown("up")) {
                if(getY() - this.speed > 0) {
                    moveUp(this.speed);
                    walkingDelayCounter = 0;
                }
            }
            
            if(Greenfoot.isKeyDown("right")) {
                if(getX() + this.speed < ((Map)getWorld()).SIZE_MAP) {
                    moveRight(this.speed);
                    walkingDelayCounter = 0;
                }
            }
            
            if(Greenfoot.isKeyDown("left")){
                if(getX() - this.speed > 0) {
                    moveLeft(this.speed);  
                    walkingDelayCounter = 0;
                }
            }
           
            // Juste pour les tests, on autorise le déplacement vers le bas
            if(Greenfoot.isKeyDown("down")){
                if(getY() + this.speed < ((Map)getWorld()).SIZE_MAP) {
                    moveDown(this.speed);  
                    walkingDelayCounter = 0;
                }
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
