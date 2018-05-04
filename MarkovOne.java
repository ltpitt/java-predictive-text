
/**
 * Write a description of class MarkovZero here.
 *
 * @author Duke Software
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovOne {
    private String myText;
    private Random myRandom;

    public MarkovOne() {
        myRandom = new Random();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String s) {
        myText = s.trim();
    }

    public ArrayList<String> getFollows(String key) {

        ArrayList<String> follows = new ArrayList<String>();

        for (int i = 0; i < myText.length() - key.length(); i++) {

            if (key.equals(myText.substring(i, i + key.length()))){
                System.out.println("Current key:\n" + key);
                System.out.println("Current substring:\n" + myText.substring(i + key.length(), i + key.length() + 1));
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
        int index = myRandom.nextInt(myText.length() - 1);
        String key = myText.substring(index, index + 1);
        sb.append(key);

        for (int k = 0; k < numChars - 1; k++) {
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        MarkovOne mo = new MarkovOne();
        mo.setTraining("saluti da davide");
        String result = mo.getRandomText(5);
        System.out.println(result);
    }

}