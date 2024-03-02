package capitaly;

public class Program {
    public static void main(String[] args) {
        if(args.length == 1)
        {
            Game game = Game.getInstance();
            game.start(args[0]);
        }
        else
        {
            System.out.println("Capitaly program accepts only one argument, which is a file name.");
        }
    }
}
