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
    // myRandomizer.randomWord();

    Randomizer.addHint("Mediator", "peace maker");
    Game myGame= new Game(myRandomizer.getWord());

    // Randomizer myRandomizer = new Randomizer();
    // myRandomizer.randomWord();

    get("/", (request, response)-> {
      Map<String, Object> model = new HashMap<String, Object>();
        model.put("score", myGame.getScore());
        model.put("hint", myRandomizer.getHint(myGame.getWord()));
        model.put("answer", myGame.getWord());
        model.put("word", Game.getFilled());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/", (request, response)-> {
      Map<String, Object> model = new HashMap<String, Object>();
      String letter = request.queryParams("letter");
      String correct="";


      model.put("randomWords", myRandomizer.getWordArray());
      if (Game.getChosen().contains(letter.toLowerCase())) {
        correct = "You already chose this";

      }else if(!myGame.getWord().contains(letter.toLowerCase())){
        correct = "OOPS! TRY AGAIN";
        myGame.lessScore();

      }else if(myGame.getWord().contains(letter.toLowerCase())){
          correct = "CORRECT";
            myGame.addScore();
      }
      Game.addChosen(letter);
      myGame.dashFiller(letter);
      model.put("score", myGame.getScore());
      model.put("correct", correct);
      model.put("hint", myRandomizer.getHint(myGame.getWord()));
      model.put("answer", myGame.getWord());
      model.put("word", Game.getFilled());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/getnewword", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      myGame.changeWord();

      response.redirect("/");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/newgame", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      myGame.newGame();
      
      response.redirect("/");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/reduce", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      myGame.hintReducer();
      response.redirect("/");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
