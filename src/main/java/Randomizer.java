import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Randomizer{
  private String randomWord=" ";
  private static int mIndex = 0;
  private String[]  mWords= {"witnesses", "finisher", "race", "author", "shame", "exhortation", "partakers", "flesh", "father", "righteousness","bitterness","zion", "kingdom","fire"};
  private static Map<String, String> mHints = new HashMap<String, String>();
  private List<String> mRandomList = new ArrayList<String>();


  public String[] getWordArray(){
    return mWords;
  }

  // public void randomWord(){
  //      randomWord= getWordArray()[mIndex];
  // }

  public static int returnIndex(){
    return mIndex;
  }

  public static void nextWord(){
    mIndex++;
  }

  public String getWord(){
    randomWord= getWordArray()[mIndex];
    return randomWord;
  }

  public static Map<String, String> getMap(){
    return mHints;
  }

  public List<String> getRandomWordsList(){
    return mRandomList;
  }

  public void addRandomWordsList(){
    mRandomList.add(randomWord);
  }

  public static void addHint(String key, String hint){
    mHints.put("witnesses","I was there");
    mHints.put("finisher","mortal kombat");
    mHints.put("race","Usain Bolt");
    mHints.put("author","Pastor Favour");
    mHints.put("shame","nursery school punishment");
    mHints.put("exhortation","praise someone");
    mHints.put("partakers","we are ___ with christ");
    mHints.put("flesh","meat");
    mHints.put("father","God");
    mHints.put("righteousness","our nature");
    mHints.put("bitterness","not sweet");
    mHints.put("zion","our dwelling as Christians");
    mHints.put("kingdom","it suffers violence");
    mHints.put("fire","Elijah's transportation");
    mHints.put(key, hint);
  }

  public String getHint(String word){
    String hint = null;
    if (mHints.containsKey(word)) {
      hint = mHints.get(word);
    }
    return hint;
  }


  public void removePrev(String randomWord){
    List<String> list = new ArrayList<String>(Arrays.asList(mWords));
list.remove(randomWord);
mWords= list.toArray(new String[0]);
  }
}
