import java.util.Arrays;

public class Randomizer{
  private String randomWord;
  private String[]  mWords= {"author", "company","exhortation", "chastening", "assembly", "innumerable", "heavenly", "mediator"};

  public String[] getWordArray(){
    return mWords;
  }

  public void randomWord(){
     randomWord = getWordArray()[(int)(Math.random() * getWordArray().length)];
  }

  public String getWord(){
    return randomWord;
  }
}
