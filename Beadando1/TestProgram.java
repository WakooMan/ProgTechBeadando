
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestProgram {
    final static File inputFolder = new File("Inputs");
    final static File outputFolder = new File("Outputs");

    public static void main(String[] args) {

        boolean shouldExit = false;
        String[] menu = new String[] { "Start Game", "Exit" };
        while(!shouldExit)
        {

            for(int i = 0; i < menu.length; i++)
            {
                System.out.println(i + 1 + ". " + menu[i]);
            }
            Integer idx1 = readInt("Choose a menu option: ", 1, menu.length);
            if(idx1 == 1)
            {
                File[] inputFiles = inputFolder.listFiles();
                for(int i = 0; i < inputFiles.length; i++)
                {
                    System.out.println(i + 1 + ". " + inputFiles[i].getName());
                }
                Integer idx2 = readInt("Choose an input file to test: ", 1, inputFiles.length);
                
                // File[] outputFiles = outputFolder.listFiles();
                // for(int i = 0; i < outputFiles.length; i++)
                // {
                //     System.out.println(i + 1 + ". " + outputFiles[i].getName());
                // }
                // Integer idx3 = readInt("Choose an output file to compare: ", 1, outputFiles.length);
                List<String> arguments = new ArrayList<String>();
                arguments.add("Inputs/" + inputFiles[idx2 - 1].getName());
                try{
                    Process capitalyProcess = exec(arguments);
                    try(BufferedReader input = new BufferedReader(new InputStreamReader(capitalyProcess.getInputStream()))) {
                        String line;

                        while ((line = input.readLine()) != null) {
                            System.out.println(line);
                        }
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            else
            {
                shouldExit = true;
            }
        }
    }

    private static Integer readInt(String message, Integer min, Integer max)
    {
        Integer result = null;
        Console cnsl = System.console();
        while(result == null)
        {
            try
            {
                System.out.print(message);
                result = Integer.parseInt(cnsl.readLine());
                if(min > result || result > max)
                {
                    throw new NumberFormatException();
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("The given string is not a number or is not between " + min + " and " + max + ".");
                result = null;
            }
        }
        return result;
    }

    private static Process exec(List<String> args) throws IOException,
                                               InterruptedException {

        List<String> command = new LinkedList<String>();
        command.add("java");
        command.add("-cp");
        command.add("bin");
        command.add("capitaly.Program");
        if (args != null) {
            command.addAll(args);
        }

        ProcessBuilder builder = new ProcessBuilder(command);

        Process process = builder.inheritIO().start();
        process.waitFor();
        return process;
    }
}
