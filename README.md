# RawGE
A Java game library based on Majoolwip's YouTube tutorials - https://www.youtube.com/watch?v=4iPEjFUZNsw&list=PL7dwpoQd3a8j6C9p5LqHzYFSkii6iWPZF

## Getting started
### Add RawGE to your project (Eclipse).
1. Head to Project > Properties > Java Build Path > Libraries > Add external JAR and select rawGE.jar
2. Require the package in module-info.java `requires rawGE;`. You may also need java.desktop.

### Opening a window
Create a class (E.g. GameController) that has the `public static void main()` entry point method and make the class implement the Controller interface.

    import com.albionbrown.rawge.Controller;

    public class GameController implements Controller {

   	public static GameContainer gc;

  	  public static void main(String[] args) {
	    
      }
    }

This class will be the class for initialising and controlling rawGE. Inside your `main()` method, create an instance of GameController and get an instance of the RawGE `GameContainer`.

    public static void main(String[] args) {
      GameController gamecontroller = new GameController();

      // Creates a window with title "Example Game", with dimensions of 1280 by 960 pixels. The instance of 
      gc = new GameContainer("Example Game", 1280, 960, gamecontroller);

      // Creates a thread and starts the game loop
      gc.start();
    }

When the `start()` method in the `Game Container` class is called, the game loop begins. But before this happens, 2 new methods must be implemented in the `GameController` class.

    public void update(GameContainer gc);
	public void render(Renderer r);

The `update()` method will be called first, followed by `render()`. Your window will open to see a black screen.

