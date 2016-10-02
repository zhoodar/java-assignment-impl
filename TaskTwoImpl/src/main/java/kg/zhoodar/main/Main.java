package kg.zhoodar.main;

import kg.zhoodar.base.Input;
import kg.zhoodar.base.Output;
import kg.zhoodar.base.Pattern;
import kg.zhoodar.logic.OutputModeOne;
import kg.zhoodar.logic.OutputModeThree;
import kg.zhoodar.logic.OutputModeTwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhoodar
 * @since 01.10.2016.
 */
public class Main {

    public static void main(String[] args) {
        List<Input> inputs = new ArrayList<>();
        List<Pattern> patterns = new ArrayList<>();
        Output outputModeOne = new OutputModeOne();
        Output outputModeTwo = new OutputModeTwo();
        Output outputModeThree = new OutputModeThree();

        try(BufferedReader inputR = new BufferedReader(new FileReader(new File("input.txt")));
            BufferedReader patternsR = new BufferedReader(new FileReader(new File("patterns.txt")))
        ){
            String line;
            while((line=inputR.readLine())!= null){
                inputs.add(new Input(line));
            }
            while((line=patternsR.readLine())!= null){
                patterns.add(new Pattern(line));
            }

            List<String>  modeOne = outputModeOne.searchPattern(inputs,patterns);
            List<String>  modeTwo = outputModeTwo.searchPattern(inputs,patterns);
            List<String>  modeThree = outputModeThree.searchPattern(inputs,patterns);

            System.out.println("Mode 1 outputs: ");
            modeOne.forEach(System.out::println);

            System.out.println("Mode 2 outputs: ");
            modeTwo.forEach(System.out::println);

            System.out.println("Mode 3 outputs: ");
            modeThree.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
