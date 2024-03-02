
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class TestProgram {
    final static File inputFolder = new File("Inputs");
    final static File outputFolder = new File("Outputs");
    final static Hashtable<String, String> testFiles = new Hashtable<String, String>() {{
       for(int i = 1; i <= 14; i++)
       {
            put("input"+ i + ".txt", "Output" + i + ".txt");
       }
    }};

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
                System.out.println(inputFiles.length + 1 + ". All test files");
                Integer idx2 = readInt("Choose an input file to test: ", 1, inputFiles.length + 1);
                
                if(idx2 == inputFiles.length + 1)
                {
                    for(String inputFile :  testFiles.keySet())
                    {
                        runTest(inputFile, false);
                    }
                }
                else
                {
                    runTest(inputFiles[idx2 - 1].getName(), true);
                }
            }
            else
            {
                shouldExit = true;
            }
        }
    }

    private static void runTest(String test, boolean writeOutput)
    {
        List<String> arguments = new ArrayList<String>();
        arguments.add("Inputs/" + test);
        try{
            exec(arguments);
            String[] programOutput = readFile("tmp.txt", writeOutput);

            if(testFiles.containsKey(test))
            {
                String outputFile = "Outputs/" + testFiles.get(test);
                String[] expectedOutput = readFile(outputFile, false);
                if(Arrays.equals(programOutput, expectedOutput))
                {
                    System.out.println("Test passed! The program output is the same as in the output file.");
                }
                else
                {
                    System.out.println("Test failed! The program output is not the same as in the output file.");
                }
                File tmp = new File("tmp.txt");
                tmp.delete();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private static String[] readFile(String file, boolean writeOutput) throws FileNotFoundException, IOException
    {
        List<String> result = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                if(writeOutput)
                {
                    System.out.println(line);
                }
                result.add(line.trim());
            }
        }
        String[] finalResult = new String[result.size()];
        return result.toArray(finalResult);
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
        command.add("RunCapitaly.bat");
        if (args != null) {
            command.addAll(args);
        }

        ProcessBuilder builder = new ProcessBuilder(command);

        Process process = builder.inheritIO().start();
        process.waitFor();
        return process;
    }
}
