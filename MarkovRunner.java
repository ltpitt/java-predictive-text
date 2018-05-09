
/**
 * Write a description of class MarkovRunner here.
 *
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

import java.util.ArrayList;

public class MarkovRunner {

    public void testGetFollows() {
        MarkovOne markov = new MarkovOne();
        markov.setTraining("this is a test yes this is a test.");
        ArrayList<String> follows = markov.getFollows(".");
        System.out.println("follows size:\n" + follows.size());
        System.out.println("follows content:");
        System.out.println(follows);

    }

    public void testGetFollowsWithFile() {
        //MarkovZero markov = new MarkovZero();
        //MarkovOne markov = new MarkovOne();
        //MarkovTwo markov = new MarkovTwo();
        //MarkovFour markov = new MarkovFour();
        MarkovModel markov = new MarkovModel(8);
        markov.setRandom(365);
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        markov.setTraining(st);
        String generatedText = markov.getRandomText(100);
        System.out.println(generatedText);
        //ArrayList<String> follows = markov.getFollows("th");
        //System.out.println("follows size:\n" + follows.size());
        //System.out.println("follows content:");
        //System.out.println(follows);

    }

    public void runMarkovZero() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //MarkovZero markov = new MarkovZero();
        MarkovOne markov = new MarkovOne();
        //MarkovTwo markov = new MarkovTwo();
        markov.setTraining(st);
        for (int k = 0; k < 3; k++) {
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }

    private void printOut(String s) {
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for (int k = 0; k < words.length; k++) {
            System.out.print(words[k] + " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        MarkovRunner mr = new MarkovRunner();
        //mr.runMarkovZero();
        //mr.testGetFollows();
        mr.testGetFollowsWithFile();
    }


}
