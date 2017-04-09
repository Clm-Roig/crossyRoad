import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map here.
 * 
 * @author (Jade HENNEBERT & Clément ROIG) 
 * @version (1,0)
 */    
public class Map extends World
{
    
    public static final int NB_ROW = 10;
    public static final int CELL_SIZE = 50;

    /**
     * Constructor for objects of class Map.
     */

    public Map() {    
        // Create a new world with 600*600 cells with a cell size of 60*60 pixels.
        super(NB_ROW, NB_ROW, CELL_SIZE); 
        
        int nb = Greenfoot.getRandomNumber(3);
        
        // On commence par une plaine en bas
        loadGround(1,NB_ROW-1);
        
        // On remplit aléatoirement le reste
        for(int i=NB_ROW-2; i >= 0 ; i--) {
            nb = Greenfoot.getRandomNumber(3);
            this.loadGround(nb,i);
        }        
        
        // Ajout Player 
        addObject(new Player(),NB_ROW/2,NB_ROW - 1);
    }
    
   /* Cette fonction place un objet Ground sur la carte 
    * selon l'entier passé en paramètre sur la ligne y.
    * 0 <= y < NB_ROW
    * 
    * 0 => water
    * 1 => plain
    * 2 => road
    */
   public void loadGround(int nb, int y) {
       for(int i=0; i<NB_ROW ; i++) {
           
           if(nb == 0) {
               addObject(new Water(CELL_SIZE),i,y);
           }
           
           if(nb == 1) {
               addObject(new Plain(CELL_SIZE),i,y);
           }
           
           if(nb == 2) {
               addObject(new Road(CELL_SIZE),i,y);
           }
           
        }
   }
}
