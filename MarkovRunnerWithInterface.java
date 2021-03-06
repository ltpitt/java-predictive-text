
/**
 * This class is used to run a program to generate random text.
 * 
 * @author Davide Nastri
 * @version 5/16/2018
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {

    public void runModel(IMarkovModel markov, String text, int size, int seed) {

    	markov.setTraining(text);
        System.out.println("running with " + markov);

        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}

    }
    
    public void runMarkov() {

        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		int seed = 30;
		
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size, seed);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size, seed);

        MarkovTwo mTwo = new MarkovTwo();
        runModel(mTwo, st, size, seed);

        //MarkovModel mThree = new MarkovModel(3);
        //mThree.setRandom(seed);
        //runModel(mThree, st, size, seed);
        
        MarkovFour mFour = new MarkovFour();
        mFour.setRandom(seed);
        runModel(mFour, st, size, seed);

    }

	private void printOut(String s){

		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");

		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
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

		MarkovRunnerWithInterface mr = new MarkovRunnerWithInterface();
		mr.runMarkov();

	}

}
