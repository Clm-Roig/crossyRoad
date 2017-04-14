import greenfoot.*;

/**
 * ScoreBoard that displays some taxt and a number.
 * 
 * @author Jade HENNEBERT & Clément ROIG
 * @version 1.0
 */
public class ScoreBoard extends Actor {
    private int value = 0;
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
        text = prefix;
        int imageWidth= (text.length() + 2) * 10;
        setImage(new GreenfootImage(imageWidth, 16));
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
        image.drawString(text + value, 1, 12);
    }
}