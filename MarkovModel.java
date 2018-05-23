/**
 * Write a description of class MarkovZero here.
 *
 * @author Duke Software
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovModel implements IMarkovModel {

    private String myText;
    private Random myRandom;
    private int myOrder;

    public MarkovModel(int order) {
        myRandom = new Random();
        myOrder = order;
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setOrder(int order) {
        myOrder = order;
    }

    public void setTraining(String s) {
        myText = s.trim();
    }

    public ArrayList<String> getFollows(String key) {

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

    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - myOrder);
        String key = myText.substring(index, index + myOrder);
        sb.append(key);

        for (int k = 0; k < numChars - myOrder; k++) {
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }

        return sb.toString();
    }

}