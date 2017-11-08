import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class App{
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    Randomizer myRandomizer = new Randomizer();
    myRandomizer.randomWord();
    Game myGame= new Game(myRandomizer.getWord());
    // Randomizer myRandomizer = new Randomizer();
    // myRandomizer.randomWord();

    get("/", (request, response)-> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/", (request, response)-> {
      Map<String, Object> model = new HashMap<String, Object>();
      String letter = request.queryParams("letter");
      myGame.dashFiller(letter);
      model.put("answer", myRandomizer.getWord());
      model.put("word", Game.getFilled());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
