import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */    
public class Map extends World {
    
    public static final int NB_ROW = 13;
    public static final int CELL_SIZE = 45;
    
    // Apparition proba (/100)
    public static final int PROBA_CAR = 10;
    public static final int PROBA_TREE = 10;   

    /**
     * Constructor for objects of class Map.
     */

    public Map() {    
        // Create a new world
        super(NB_ROW, NB_ROW, CELL_SIZE); 
        
        setPaintOrder(Mover.class,Background.class);
        
        int nb = Greenfoot.getRandomNumber(3);
        
        // On commence par une plaine sans arbre en bas
        for(int i=0; i<NB_ROW ; i++) {
            addObject(new Plain(CELL_SIZE),i,NB_ROW-1);            
        }
        
        // On remplit aléatoirement le reste
        for(int i=NB_ROW-2; i >= 0 ; i--) {
            nb = Greenfoot.getRandomNumber(4);
            this.loadGround(nb,i);
        }        
        
        // Ajout Player 
        addObject(new Player(CELL_SIZE),NB_ROW/2,NB_ROW - 1);
    }
    
   /* Cette fonction place un objet Ground sur la carte 
    * selon l'entier passé en paramètre sur la ligne y.
    * 0 <= y < NB_ROW
    * 
    * 0 => water
    * 1 => plain
    * 2 => road
    * 3 => rail
    */
   public void loadGround(int nb, int y) {  
       // Water
       if(nb == 0) {
           for(int i=0; i<NB_ROW ; i++) {
               addObject(new Water(CELL_SIZE),i,y);
            }
       }
       
       // Plain
       if(nb == 1) {
           for(int i=0; i<NB_ROW ; i++) {
               Plain pl = new Plain(CELL_SIZE);
               addObject(pl,i,y);       
               
               // Tree ?
               int isTree = Greenfoot.getRandomNumber(100);
               if(isTree < PROBA_TREE) {
                   pl.addTree(CELL_SIZE);
               }               
           }
       }
       
       // Road
       if(nb == 2) {
           String direction;
           if(Greenfoot.getRandomNumber(2)==0) {
                direction = "toLeft";
           }
           else {
                direction = "toRight";
           }  
           
           for(int i=0; i<NB_ROW ; i++) {
               Road road = new Road(CELL_SIZE,direction);
               addObject(road,i,y);               
               
               // Car ?
               int isCar = Greenfoot.getRandomNumber(100);
               if(isCar < PROBA_CAR) {
                   road.addCar(CELL_SIZE);
                }
            }
       }
       
       // Rail
       if(nb == 3) {
           for(int i=0; i<NB_ROW ; i++) {
               addObject(new Rail(CELL_SIZE),i,y);
            }
       }         
     
   }
}
