import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Game{
  private String mWord=" ";
  private static String mFilled= "";
  private static String[] compReplacedArray;
  private int mScore;
  private static List<String> chosen = new ArrayList<String>();


  public Game(String word){
    mWord = word;
    compReplacedArray=new String[mWord.split("").length];
    mScore = 20;
  }

  public String getWord(){
      return mWord;

  }
  public int getScore(){
    return mScore;
  }

  public void addScore(){
     mScore++;
  }

  public void lessScore(){
     mScore--;
  }

  public void hintReducer(){
    mScore = mScore -5;
  }

  public int newGame(){
    this.chosen=new ArrayList<String>();
    Randomizer myRandomizer = new Randomizer();
    myRandomizer.nextWord();
    // myRandomizer.randomWord();
    this.mWord = myRandomizer.getWord();
    this.compReplacedArray=new String[mWord.split("").length];
    this.chosen = new ArrayList<String>();
    dashFiller(this.mWord);
    return mScore = 20;
  }

  public static String[] getList(){
    return compReplacedArray;
  }

  public List<String> dashReplacer(){
    List<String> splitWordArray = Arrays.asList(mWord.split(""));
    // List<String> dashReplacedArray = new ArrayList<String>();
    for (int i=0; i<splitWordArray.size();i++ ) {
      if (compReplacedArray[i] == null) {
          Arrays.asList(compReplacedArray).set(i, " _ ");
      }
    }
      return Arrays.asList(compReplacedArray);
  }

  public static String getFilled(){

      return mFilled;

  }

  public List<String> dashFiller(String letter){
    String[] splitWordArray = mWord.split("");
    List<String> dashReplaced = dashReplacer();
    for (int i = 0; i<splitWordArray.length ; i++ ) {
      if (letter.toLowerCase().equals(splitWordArray[i])) {
        dashReplaced.set(i, letter.toLowerCase());
      }
    }
    for (int z = 0; z<splitWordArray.length ;z++ ) {
      if (dashReplaced.get(z) != " _ ") {
        Arrays.asList(compReplacedArray).set(z,dashReplaced.get(z));
      }
    }
    mFilled = String.join("",Arrays.asList(compReplacedArray) );
    return Arrays.asList(compReplacedArray);
  }

  public static List<String> getChosen(){
    return chosen;
  }
  public static void addChosen(String letter){
    chosen.add(letter);
  }



  public void changeWord(){
      Randomizer myRandomizer = new Randomizer();
      myRandomizer.nextWord();
      // myRandomizer.randomWord();
      this.mWord = myRandomizer.getWord();
      this.compReplacedArray=new String[mWord.split("").length];
      this.chosen = new ArrayList<String>();
      dashFiller(this.mWord);
    }

}
