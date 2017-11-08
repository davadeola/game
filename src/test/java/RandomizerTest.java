import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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
    assertTrue(Arrays.asList(randomizerTest.getWordArray()).contains(randomizerTest.getWord()));
  }
}
