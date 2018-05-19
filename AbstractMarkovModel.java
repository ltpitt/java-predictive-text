
/**
 * Abstract class AbstractMarkovModel, implements MarkovModel
 * 
 * @author Davide Nastri
 * @version 5/16/2018
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);


    protected ArrayList<String> getFollows(String key) {

        ArrayList<String> follows = new ArrayList<String>();

        for (int i = 0; i < myText.length() - key.length(); i++) {

            if (key.equals(myText.substring(i, i + key.length()))){
                //System.out.println("Current key:\n" + key);
                //System.out.println("Current substring:\n" + myText.substring(i + key.length(), i + key.length() + 1));
                follows.add(myText.substring(i + key.length(), i + key.length() + 1));
            }
        }

        return follows;

    }


}
