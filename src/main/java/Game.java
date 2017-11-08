import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Game{
  private String mWord;
  private static String mFilled;
  private static String[] compReplacedArray;
  public Game(String word){
    mWord = word;
    compReplacedArray=new String[mWord.split("").length];
  }

  public String getWord(){
    return mWord;

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
      // if (letter.toLowerCase().equals(splitWordArray[z])) {
      //
      //   compReplacedArray.set(z, letter.toLowerCase());
      // }

    }
    mFilled = String.join("",Arrays.asList(compReplacedArray) );
    return Arrays.asList(compReplacedArray);
  }



}
