import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class GameTest{

  @Test
  public void game_instantiatesCorrectly_true(){
    Randomizer testRandomizer = new Randomizer();
    testRandomizer.randomWord();
    Game testGame = new Game(testRandomizer.getWord());
    assertTrue(testGame instanceof Game);
  }

  @Test
  public void getWord_returnsWord_author(){
    Randomizer testRandomizer = new Randomizer();
    testRandomizer.randomWord();
    String testWord = testRandomizer.getWord();
    Game testGame = new Game(testWord);
    assertEquals(testWord, testGame.getWord());
  }

  @Test
  public void dashReplacer_returnsWordSpacesWithDashes_true(){
    Randomizer testRandomizer = new Randomizer();
    testRandomizer.randomWord();
    String testWord = testRandomizer.getWord();
    Game testGame = new Game(testWord);
    assertEquals(testWord.split("").length, testGame.dashReplacer().size());
  }

  @Test
  public void dashFiller_replacesDashWithLetter_true(){
    Game testGame = new Game("aba");
    assertEquals(true, testGame.dashFiller("a").contains("a"));
  }

  @Test
  public void dashFiller_replacesDashWithCapitalizedInput_true(){
    Game testGame = new Game("aba");
    assertEquals(true, testGame.dashFiller("A").contains("a"));
  }

  @Test
  public void getFilled_returnsProgressOfFilled_true(){
    Randomizer testRandomizer = new Randomizer();
    testRandomizer.randomWord();
    String testWord = testRandomizer.getWord();
    Game testGame = new Game("aba");
    testGame.dashFiller("b");
    assertEquals(" _ b _ ",Game.getFilled());
  }

  @Test
  public void getFilled_returnsCompletedWord_true(){
    Randomizer testRandomizer = new Randomizer();
    testRandomizer.randomWord();
    String testWord = testRandomizer.getWord();
    Game testGame = new Game("abaoop");
    testGame.dashFiller("b");
    testGame.dashFiller("o");
    testGame.dashFiller("p");
    testGame.dashFiller("a");

    assertTrue(Game.getFilled().equals("abaoop"));
  }

  @Test
  public void getScore_returnsScore_20(){
    Game testGame = new Game("abaoop");
    assertEquals(20, testGame.getScore());
  }

  @Test
  public void addScore_addsScore_24(){
    Game testGame = new Game("abaoop");
    testGame.addScore();
    testGame.addScore();
    testGame.addScore();
    testGame.addScore();
    assertEquals(24,  testGame.getScore());
  }


  @Test
  public void lessScore_addsScore_16(){
    Game testGame = new Game("abaoop");
    testGame.lessScore();
    testGame.lessScore();
    testGame.lessScore();
    testGame.lessScore();
    assertEquals(16,  testGame.getScore());
  }

}
