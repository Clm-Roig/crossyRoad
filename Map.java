import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */    
public class Map extends World {
    // SIZE_MAP doit etre un multiple de CELL_SIZE pour bien remplir tout l'écran
    public static final int SIZE_MAP = 550;
    public static final int CELL_SIZE = 50;
    
    // Apparition proba (/100)
    public static final int PROBA_CAR = 10;
    public static final int PROBA_TREE = 10;   
    public static final int PROBA_ROCK = 50; 

    /**
     * Constructor for objects of class Map.
     */
    
    public ScoreBoard score;

    public Map() {    
        // Create a new world and setPaintOrder
        super(SIZE_MAP, SIZE_MAP, 1);
        setPaintOrder(ScoreBoard.class,Mover.class,Rock.class,Obstacle.class,Background.class);
        
        // On commence par une plaine sans arbre en bas
        for(int i=CELL_SIZE/2; i<SIZE_MAP ; i = i+CELL_SIZE) {
            addObject(new Plain(),i,SIZE_MAP - (CELL_SIZE/2));            
        }
        
        int typeGround;
        // On remplit aléatoirement le reste
        for(int i=SIZE_MAP - (CELL_SIZE*3)/2 ; i > 0 ; i = i-CELL_SIZE) {
            typeGround= Greenfoot.getRandomNumber(4);
            this.loadGround(typeGround,i);
        }        
        
        // Ajout Player et score
        addObject(new Player(),SIZE_MAP/2,SIZE_MAP - CELL_SIZE/2);
        
        this.score = new ScoreBoard("Score : ");
        addObject(this.score,150,CELL_SIZE/2);
        
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
   public void loadGround(int typeGround, int y) {  
       // Water
       if(typeGround == 0) {
           for(int i=CELL_SIZE/2; i<SIZE_MAP ; i = i+CELL_SIZE) {
               Water wat = new Water();
               addObject(wat,i,y);           
            
               // Rock ?
               int isRock = Greenfoot.getRandomNumber(100);
               if(isRock < PROBA_ROCK) {
                   wat.addRock(CELL_SIZE);
               } 
           }
       }
       
       // Plain
       if(typeGround == 1) {
           for(int i=CELL_SIZE/2; i<SIZE_MAP ; i = i+CELL_SIZE) {
               Plain pl = new Plain();
               addObject(pl,i,y);       
               
               // Tree ?
               int isTree = Greenfoot.getRandomNumber(100);
               if(isTree < PROBA_TREE) {
                   pl.addTree();
               }               
           }
       }
       
       // Road
       if(typeGround == 2) {
           String direction;
           if(Greenfoot.getRandomNumber(2)==0) {
                direction = "toLeft";
           }
           else {
                direction = "toRight";
           }  
           
           // Which color of Car for this road ?
           int colorCar = Greenfoot.getRandomNumber(3);
           
           for(int i=CELL_SIZE/2; i<SIZE_MAP ; i = i+CELL_SIZE) {
               Road road = new Road(direction);
               addObject(road,i,y);               
               
               // Car ?
               int isCar = Greenfoot.getRandomNumber(100);
               if(isCar < PROBA_CAR) {
                   if(colorCar == 0) road.addRedCar();
                   if(colorCar == 1) road.addGreenCar();
                   if(colorCar == 2) road.addBlueCar();
                }
            }
       }
       
       // Rail
       if(typeGround == 3) {
           for(int i=CELL_SIZE/2; i<SIZE_MAP ; i = i+CELL_SIZE) {
               addObject(new Rail(),i,y);
            }
       }         
     
   }
   
   public void gameOver() {
       Greenfoot.stop();
   }
}
