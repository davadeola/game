import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class RandomizerTest{
  @Test
  public void getWord_getsWord_true(){
    Randomizer randomizerTest = new Randomizer();
    randomizerTest.randomWord();
    assertTrue(randomizerTest.getWord() instanceof String);
  }
  @Test
  public void getWord_checksIfWordisInArray_true(){
    Randomizer randomizerTest = new Randomizer();
    randomizerTest.randomWord();
    randomizerTest.addRandomWordsList();
    randomizerTest.randomWord();
    assertTrue(Arrays.asList(randomizerTest.getWordArray()).contains(randomizerTest.getWord()));
  }

@Test
public void getMap_returnsMap_Map(){
  Randomizer randomizerTest = new Randomizer();
  randomizerTest.randomWord();
  assertTrue(Randomizer.getMap() instanceof Map);
}

  @Test
  public void addHint_addsHintToMap_true(){
    Randomizer randomizerTest = new Randomizer();
    randomizerTest.randomWord();
    Randomizer.addHint("finisher", "mortal Kombat");
    assertTrue(Randomizer.getMap().containsKey("finisher"));
    assertTrue(Randomizer.getMap().containsValue("mortal Kombat"));
  }

  @Test
  public void getHint_returnsHintOfSpecifiedKey_peacemaker(){
    Randomizer randomizerTest = new Randomizer();
    randomizerTest.randomWord();
    Randomizer.addHint("Mediator", "peace maker");
    assertEquals("peace maker", randomizerTest.getHint("Mediator"));
  }

  @Test
  public void removesPrev_removesPreviousRandomWord_less(){
    Randomizer randomizerTest = new Randomizer();
    randomizerTest.randomWord();
    int size = randomizerTest.getWordArray().length;
    String randomWord = randomizerTest.getWord();
    randomizerTest.removePrev(randomWord);
    int newSize = randomizerTest.getWordArray().length;
    assertEquals(newSize, size-1);
  }

  @Test
  public void addRandomWordsList_addsAlreadyChosenWord_true(){
    Randomizer randomizerTest = new Randomizer();
    randomizerTest.randomWord();
    String r = randomizerTest.getWord();
    randomizerTest.addRandomWordsList();
    assertTrue(randomizerTest.getRandomWordsList().contains(r));
  }

  @Test
  public void nextWord_increasesIndex_4(){
    Randomizer randomizerTest = new Randomizer();
    Randomizer.nextWord();
    Randomizer.nextWord();
    Randomizer.nextWord();
    Randomizer.nextWord();
    
    assertEquals("shame",  randomizerTest.getWord());

  }

}
