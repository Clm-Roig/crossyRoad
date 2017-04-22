import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1.0
 */
public class RailWithSignal extends Rail {
    private final int DELAY_TRAIN = 350;
    private final int SIGNAL_SIZE = 25;
    private final int PLACE_OVAL_SIGNAL = 12;
    private final int DISTANCE_OVAL_SIGNAL = 13;
    private final int DISTANCE_ORANGE_SIGNAL = 1000;
    private final int DISTANCE_RED_SIGNAL = 700;
    
    private int positionTrain;    
    private int delayTrainCounter;
    private int delaySignalCounter; 
    private Train train;

    public RailWithSignal(String direction) {
        super(direction);
        this.delayTrainCounter = Greenfoot.getRandomNumber(200) + 150;
        
        // Si le train va à droite, on le place à -1000 du premier rail de la ligne (à -1000 du bord gauche de la map donc)
        if(direction == "toRight") {
            positionTrain = -1000;
        }
        // Sinon, on le met à 1000 du dernier rail de la ligne
        else {
            positionTrain = 1000 + ((Map)getWorld()).SIZE_MAP;
        }
        
        this.getImage().setColor(new Color(200,200,200));
        this.getImage().drawOval(PLACE_OVAL_SIGNAL,PLACE_OVAL_SIGNAL,SIGNAL_SIZE,SIGNAL_SIZE);  
        greenSignal();
    }
    
    public void act() {  
        delayTrainCounter++;
        
        // Controle pour ajout train
        if(delayTrainCounter >= DELAY_TRAIN) {
            this.train = addTrain();
            delayTrainCounter = Greenfoot.getRandomNumber(100);       
        }          
        
        if(checkForDistance(DISTANCE_ORANGE_SIGNAL)) {
            orangeSignal();
            if(checkForDistance(DISTANCE_RED_SIGNAL)) {
                redSignal();
            }
        }
        else {
            greenSignal();
        }   
        checkForDeleteTrain();
    }   
    
    /**
     * Teste si le train est plus proche de la map que la distance passée en paramètre (selon l'axe X)
     */
    public boolean checkForDistance(int distance) {
        boolean res = false;
        
        if(this.train != null) {
            
            // Si le train est à gauche, on compare dans les négatifs 
            if(this.positionTrain < 0) {
                if(this.train.getX() > -distance) {
                    res = true;
                }
                else {
                    res = false;
                }            
            }
            // Sinon, il est à droite, on compare dans les positifs
            else {
                if(this.train.getX() < ((Map)getWorld()).SIZE_MAP + distance) {
                    res = true;
                }
                else {
                    res = false;
                }        
            }
        }
        
        return res;
    }
    
    /**
     * Supprime le référencement du train dans le rail si celui-ci est déjà passé
     */    
    private void checkForDeleteTrain() {
        // Le train vient de gauche
        if(this.train != null) {
            if(this.positionTrain < 0) {
                if(this.train.getX() > ((Map)getWorld()).SIZE_MAP){
                    this.train = null;
                }
            }
            // Le train vient de droite
            else {
                if(this.train.getX() < 0) {
                    this.train = null;
                }        
            }
        }
    }
    
    /**
     * Créé et renvoie un nouveau train à positionTrain pxl de la map. 
     */
    private Train addTrain() {
        Train train = new Train(super.getDirection());
        getWorld().addObject(train,positionTrain,getY());  
        return train;
    }  
    
    /**
     * Change la couleur du signal
     */        
    private void greenSignal() {
        this.getImage().setColor(new Color(50,200,50));
        this.getImage().fillOval(PLACE_OVAL_SIGNAL,PLACE_OVAL_SIGNAL,SIGNAL_SIZE,SIGNAL_SIZE);    
    }
    
    private void orangeSignal() {
        this.getImage().setColor(new Color(200,150,20));
        this.getImage().fillOval(PLACE_OVAL_SIGNAL,PLACE_OVAL_SIGNAL,SIGNAL_SIZE,SIGNAL_SIZE);    
    }
    
    private void redSignal() {
        this.getImage().setColor(new Color(220,50,20));
        this.getImage().fillOval(PLACE_OVAL_SIGNAL,PLACE_OVAL_SIGNAL,SIGNAL_SIZE,SIGNAL_SIZE);    
    }
    
    
}
