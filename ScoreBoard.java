 import greenfoot.*;

/**
 * ScoreBoard that displays some taxt and a number.
 * 
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1.0
 */
public class ScoreBoard extends Actor {
    private int value = 0;
    private int fontSize = 20;
    private String text;

    /**
     * Create a ScoreBoard without a text prefix, initialized to zero.
     */
    public ScoreBoard() {
        this("");
    }

    /**
     * Create a ScoreBoard with a given text prefix, initialized to zero.
     */
    public ScoreBoard(String prefix) {
        this.text = prefix;
        
        boolean bold = true;
        boolean italic = false;
        int imageWidth = (text.length() + 2) * 30;
        
        setImage(new GreenfootImage(imageWidth,this.fontSize*2));        
        
        Font font = new Font(bold,italic,this.fontSize);
        getImage().setFont(font);
        getImage().setColor(new Color(255,255,255));
        updateImage();
    }

    /**
     * Increment the counter value by the value given.
     */
    public void increment(int inc) {
        value += inc;
        updateImage();
    }

    /**
     * Show the current text and count on this actor's image.
     */
    private void updateImage() {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, this.fontSize);
    }
}