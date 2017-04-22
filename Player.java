import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
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
        super(CELL_SIZE);
        this.getImage().scale(IMAGE_SIZE,IMAGE_SIZE);
        setRotation(270);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {     
        checkMove();    
       
        // Si on est sur de l'eau et qu'il n'y a pas de Platform, gameOver.
        // Si il y a une plateforme, on met le joueur dessus 
        Actor wat = getOneIntersectingObject(Water.class);
        if(wat != null){
            Actor plat = getOneIntersectingObject(Platform.class);
            if(plat == null) {
                killPlayer();
            }
            else { 
                setLocation(plat.getX(),plat.getY());
            }
        }
        
        // Si on est sur un véhicule, gameOver
        Actor intersectVehicle = getOneIntersectingObject(Vehicle.class);
        if(intersectVehicle != null) {
            killPlayer();
        } 
        
        // Si on est hors du champs le joueur meurt
        int y = this.getY();
        if (y > (SIZE_MAP + CELL_SIZE/2)){
            killPlayer();
        }
        
        // Si le Player rencontre un item, le prend
        Coin coin = (Coin)getOneIntersectingObject(Coin.class);
        if(coin != null){ 
            coin.taken();
            ((Map)getWorld()).score.increment(5);          
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
    
    
    // Ré-implémentation des fonctions de déplacement (cas des plateformes qui ne laisse pas le joueur nécessairement en face d'une cellule)
    public boolean moveLeft() {
        boolean itMoved = super.moveLeft();
        if(itMoved) {
            Platform plat = (Platform) getOneObjectAtOffset(0,0,Platform.class);
            if(plat != null) {
                setLocation(plat.getX(),plat.getY());
            }
            else {
                Background bg = (Background) getOneObjectAtOffset(0,0,Background.class);
                setLocation(bg.getX(),bg.getY());
            }
        }
        return itMoved;    
    }
    
    // 0° pour aller vers la droite
    public boolean moveRight() {
        boolean itMoved = super.moveRight();
        if(itMoved) {
            Platform plat = (Platform) getOneObjectAtOffset(0,0,Platform.class);
            if(plat != null) {
                setLocation(plat.getX(),plat.getY());
            }
            else {
                Background bg = (Background) getOneObjectAtOffset(0,0,Background.class);
                setLocation(bg.getX(),bg.getY());
            }
        }
       
        return itMoved;         
    }
    
    // 270° pour aller vers le haut
    public boolean moveUp() {
        boolean itMoved = super.moveUp();
        if(itMoved) {
            Platform plat = (Platform) getOneObjectAtOffset(0,0,Platform.class);
            if(plat != null) {
                setLocation(plat.getX(),plat.getY());
            }
            else {
                Background bg = (Background) getOneObjectAtOffset(0,0,Background.class);
                setLocation(bg.getX(),bg.getY());
            }            
        }
        return itMoved;     
    }
    
    public boolean moveDown() {
        return false;
    }
    // 90° pour aller vers le bas (seulement pour les tests)
    /* public boolean moveDown() {
        boolean itMoved = super.moveDown();
        if(itMoved) {
            Platform plat = (Platform) getOneObjectAtOffset(0,0,Platform.class);
            if(plat != null) {
                setLocation(plat.getX(),plat.getY());
            }
            else {
                Background bg = (Background) getOneObjectAtOffset(0,0,Background.class);
                setLocation(bg.getX(),bg.getY());
            }
       }
        return itMoved; 
   }
   */
    
    public void killPlayer() {        
        // Apparition d'un crane
        this.setRotation(0);
        this.setImage("skull.png");
        this.getImage().scale(IMAGE_SIZE,IMAGE_SIZE);
        
        getWorld().repaint();
        ((Map)getWorld()).gameOver();
    }
}
