
/**
 * Interface for the MarkovModel.
 * 
 * @author Davide Nastri
 * @version 5/16/2018
 */

public interface IMarkovModel {

    public void setTraining(String text);
    public void setRandom(int seed);
    public String getRandomText(int numChars);

}
