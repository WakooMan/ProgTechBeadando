package capitaly;

public class Program {
    
    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.start("test.txt");
    }

}
