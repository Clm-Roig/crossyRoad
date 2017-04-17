import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
    private int PROBA_CAR = 15;
    private int PROBA_TREE = 10;   
    private int PROBA_LOG = 30; 
    private int PROBA_TRAIN = 100;
    private int PROBA_COIN = 5;
    
    /* Les probas de sol sont cumulatives et sont traités dans l'ordre suivant : 
     * water => plain => road => rail
     * EXEMPLE
     * public int PROBA_WATER = 15;     => probaWat = 15-0 = 15%
     * public int PROBA_PLAIN = 75;     => probaPla = 75-15 = 60%
     * public int PROBA_ROAD = 85;      => probaWat = 85 - 75 = 10%
     * public int PROBA_RAIL = 100;     => probaWat = 100 - 85 = 15%%
     */    
    private int PROBA_WATER = 20;
    private int PROBA_PLAIN = 60;
    private int PROBA_ROAD = 80;
    private int PROBA_RAIL = 100;      
    
    // Misc
    public final int TRAIN_LIMIT_X = 2000; 
    public final int INIT_POSITION_PLAYER_X = SIZE_MAP/2;
    public final int INIT_POSITION_PLAYER_Y = SIZE_MAP - (3*CELL_SIZE/2);
    
    private boolean aBougé = false;

    /**
     * Constructor for objects of class Map.
     */
    
    public ScoreBoard score;
    public Player joueur;

    public Map() {    
        // Create a new world and setPaintOrder
        super(SIZE_MAP, SIZE_MAP, 1,false);
        setPaintOrder(ScoreBoard.class,Item.class,Player.class,Mover.class,Rock.class,Obstacle.class,Background.class);
        
        // On commence par deux plaines sans arbre en bas
        for(int i=CELL_SIZE/2; i<SIZE_MAP ; i = i+CELL_SIZE) {
            addObject(new Plain(),i,SIZE_MAP - (CELL_SIZE/2));
            addObject(new Plain(),i,SIZE_MAP - (3*CELL_SIZE/2));
        }
        

        // On remplit aléatoirement le reste
        for(int i=SIZE_MAP - (CELL_SIZE*5)/2 ; i > 0 ; i = i-CELL_SIZE) {
            this.loadRandomGround(i);
        }        
        
        // Ajout Player et score        
        this.joueur = new Player();
        addObject(joueur,INIT_POSITION_PLAYER_X,INIT_POSITION_PLAYER_Y);
        
        this.score = new ScoreBoard("Score : ");
        addObject(this.score,150,CELL_SIZE/2); 
              
    }
    
    public void act() {
        cleanTrainsOut();
        
        // On n'active pas le défilement tant que le joueur n'a pas bougé de sa position initiale
        if(this.joueur.getY() != INIT_POSITION_PLAYER_Y || this.joueur.getX() != INIT_POSITION_PLAYER_X && !this.aBougé) {
            this.aBougé = true;
        }  
        
        if(this.aBougé) {
            defile();       
        }
    }
    
    /**
     * Supprime les trains qui sont "loin" en dehors de la map pour éviter de surcharger la mémoire indéfiniment.
     */
    public void cleanTrainsOut() {
        List<Train> listT = getObjects(Train.class); 
        for(Train tr : listT) {
            if(tr.getX() > TRAIN_LIMIT_X || tr.getX() < -TRAIN_LIMIT_X ) {
                removeObject(tr);
            }
        }
    }
    
    // Les differéntes méthodes de chargement de background        
    public void loadWater(int y){
        String direction;
        if(Greenfoot.getRandomNumber(2)==0) {
            direction = "toLeft";
        }
        else {
            direction = "toRight";
        }  
        
        // Speed sur l'eau (entre 1 et 3)
        int speed = Greenfoot.getRandomNumber(3) + 1;
        
        for(int i=CELL_SIZE/2; i<SIZE_MAP ; i = i+CELL_SIZE) {
            Water wat = new Water(direction,speed);
            addObject(wat,i,y);           
                
            // Log ?
            int isLog = Greenfoot.getRandomNumber(100);
                if(isLog < PROBA_LOG) {
                   Platform log = wat.addLog(CELL_SIZE);
                   int isCoin = Greenfoot.getRandomNumber(100);
                   if(isCoin < PROBA_COIN){
                       wat.addCoinOnPlatform(log);
                    }
                }
            }
    }    
    
    public void loadPlain(int y){
         for(int i=CELL_SIZE/2; i<SIZE_MAP ; i = i+CELL_SIZE) {
               Plain pl = new Plain();
               addObject(pl,i,y);       
               
               // Tree or Coin ?
               int isTree = Greenfoot.getRandomNumber(100);
               int isCoin = Greenfoot.getRandomNumber(100);
               if(isTree < PROBA_TREE) {
                   pl.addTree();
               }
               else if(isCoin < PROBA_COIN){
                   pl.addCoin();
               }
        }
    }
    
    public void loadRoad(int y){
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
           
           // Coin ? 
           int isCoin = Greenfoot.getRandomNumber(100);
           if(isCoin < PROBA_COIN){
               road.addCoin();
            }
        }
        
    }
    
    public void loadRail(int y){
           // Direction
           String direction;
           if(Greenfoot.getRandomNumber(2)==0) {
                direction = "toLeft";
                
                // On place le railWithSignal à droite
                Rail railWS = new RailWithSignal(direction);   
                addObject(railWS,SIZE_MAP - CELL_SIZE/2,y);         
                
                // On complète la ligne entière           
                for(int i=CELL_SIZE/2; i<SIZE_MAP - CELL_SIZE/2 ; i = i+CELL_SIZE) { 
                    Rail rail = new Rail(direction);
                    addObject(rail,i,y); 
                    
                    // Coin ? 
                    int isCoin = Greenfoot.getRandomNumber(100);
                    if(isCoin < PROBA_COIN){
                        rail.addCoin();
                    }
                } 
           }
           else {
                direction = "toRight";
                
                // On place le railWithSignal à gauche
                Rail railWS = new RailWithSignal(direction);   
                addObject(railWS,CELL_SIZE/2,y);
                
                // On complète la ligne entière           
                for(int i=(CELL_SIZE*3)/2; i<SIZE_MAP ; i = i+CELL_SIZE) { 
                    Rail rail = new Rail(direction);
                    addObject(rail,i,y);    
                    
                    // Coin ? 
                    int isCoin = Greenfoot.getRandomNumber(100);
                    if(isCoin < PROBA_COIN){
                        rail.addCoin();
                    }
                } 
           }               
       }
    
    /** 
     * Place un objet Background sur la carte selon l'entier passé en paramètre sur la ligne y.
     */
    public void loadRandomGround(int y) {  
       int randGround = Greenfoot.getRandomNumber(100);
       
       // Water
       if(randGround < PROBA_WATER) {
           loadWater(y);
       }
       
       // Plain
       if(PROBA_WATER <= randGround && randGround < PROBA_PLAIN) {
           loadPlain(y);
       }
       
       // Road
       if(PROBA_PLAIN <= randGround && randGround < PROBA_ROAD) {
           loadRoad(y);
       }
       
       // Rail
       if(PROBA_ROAD <= randGround && randGround < PROBA_RAIL) {
           loadRail(y); 
       }
    }
   
    // Fin de partie
    public void gameOver() {
        // Image grise sur toute la map
        setPaintOrder(Player.class,EndScreen.class);
        addObject(new EndScreen(),SIZE_MAP/2,SIZE_MAP/2);
        
        // Texte
        showText("GAME OVER",SIZE_MAP/2,SIZE_MAP/2 - 40);
        String scoreFinal = "Votre Score : " + this.score.getValue();
        showText(scoreFinal,SIZE_MAP/2,SIZE_MAP/2);
        showText("Appuyez sur Entrée pour recommencer.",SIZE_MAP/2,SIZE_MAP/2 + 40);
        
        repaint();
        // Restart ? 
        while(!Greenfoot.isKeyDown("Enter")) {}
        this.removeObjects(getObjects(Coin.class));        
        Greenfoot.setWorld(new Map());
        Greenfoot.start();       
    }
    
    // Défilage Map
    public void defile (){
        List <Actor> listActeurs = getObjects(Actor.class);
        int i=0;
        for(Actor act : listActeurs){
            int y = act.getY();
            int x = act.getX();
            if (!(act instanceof ScoreBoard)){
                act.setLocation(x, y+1);
            }
           
            // si on trouve un objet encore au dessus de la MAP 
            if (y < CELL_SIZE/2){
                i = i+1;
            }
            //si l'objet sort de la MAP
            if (y > SIZE_MAP + CELL_SIZE/2){
                this.removeObject(act);
            }
        }
        // si on a pas trouvé d'objet au dessus de la MAP : regénérer une ligne 
        if (i==0){
            loadRandomGround(-(CELL_SIZE/2)+1);
        }
       
    }
}
