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
    private int score = 0;
    private int speed = 3;
    
    public Player() {
        this.getImage().scale(IMAGE_SIZE,IMAGE_SIZE);
        setRotation(270);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {     
        if(Greenfoot.isKeyDown("up")) moveUp(this.speed);
        if(Greenfoot.isKeyDown("right")) moveRight(this.speed);
        if(Greenfoot.isKeyDown("left")) moveLeft(this.speed);  
       
        // Juste pour les tests, on autorise le déplacement vers le bas
        if(Greenfoot.isKeyDown("down")) moveDown(this.speed);  
       
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
    }  
    
    public void killPlayer() {
        GreenfootImage img = getImage();
        img.setColor(greenfoot.Color.RED);
        img.drawLine(0, 0, img.getWidth(), img.getHeight());
        img.drawLine(0, img.getHeight(), img.getWidth(), 0);

        ((Map)getWorld()).gameOver();
    }
}
