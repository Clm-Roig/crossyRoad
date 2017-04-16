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
    public static final int SIZE_MAP = 550;
    public static final int CELL_SIZE = 50;
    
    private final int IMAGE_SIZE = 40;
    private final int WALKING_DELAY = 10;
    private int walkingDelayCounter = 0;
    
    public Player() {
        super();
        super.setSpeed(((Map)getWorld()).CELL_SIZE);
        this.getImage().scale(IMAGE_SIZE,IMAGE_SIZE);
        setRotation(270);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {     
        checkMove();
       
        // Si on est sur un véhicule, gameOver
        Actor intersectVehicle = getOneIntersectingObject(Vehicle.class);
        if(intersectVehicle != null) {
            this.killPlayer();
        } 
       
        // Si on est sur de l'eau et qu'il n'y a pas de Platform, gameOver
        List<Water> listWat = getObjectsAtOffset(0,0,Water.class);
        if(!listWat.isEmpty()){
            List<Platform> listPlatform = getObjectsAtOffset(0,0,Platform.class);
            if(listPlatform.isEmpty()) {
                killPlayer();
            }
        }
        // Si le Player rencontre un item, le prend
        List<Reward> listReward = getObjectsAtOffset(0,0,Reward.class);
        if(!listReward.isEmpty()){
            for (Reward rew : listReward){
                rew.taken();
                ((Map)getWorld()).score.increment(5);
                ((Map)getWorld()).removeObject(rew);
            }
        }
        // Si on est hors du champs le joueur meurt
        int y = this.getY();
        if (y > (SIZE_MAP + CELL_SIZE/2)){
            killPlayer();
        }
   
        
        walkingDelayCounter++;
    }  
    
    public void checkMove() {
        if(walkingDelayCounter >= WALKING_DELAY) {
            boolean heMoved = false;
            
            if(Greenfoot.isKeyDown("up")) {
                if(getY() - this.speed > 0) {
                    moveUp();
                    heMoved = true;
                    ((Map)getWorld()).score.increment(1);
                }
            }
            
            if(Greenfoot.isKeyDown("right")) {
                if(getX() + this.speed < ((Map)getWorld()).SIZE_MAP) {
                    moveRight();
                    heMoved = true;
                }
            }
            
            if(Greenfoot.isKeyDown("left")){
                if(getX() - this.speed > 0) {
                    moveLeft();  
                    heMoved = true;
                }
            }
           
            // Juste pour les tests, on autorise le déplacement vers le bas
            if(Greenfoot.isKeyDown("down")){
                if(getY() + this.speed < ((Map)getWorld()).SIZE_MAP) {
                    moveDown();  
                    heMoved = true;
                }
            }
            
            // En cas de mouvement, on réinitialise le compteur
            if(heMoved) {
                walkingDelayCounter = 0;
            }
            
        }
    }
    
    public void killPlayer() {        
        // Apparition d'un crane
        this.setRotation(0);
        this.setImage("skull.png");
        this.getImage().scale(IMAGE_SIZE,IMAGE_SIZE);

        ((Map)getWorld()).gameOver();
    }
}
