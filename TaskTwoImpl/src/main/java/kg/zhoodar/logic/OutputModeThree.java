package kg.zhoodar.logic;

import kg.zhoodar.base.Input;
import kg.zhoodar.base.Output;
import kg.zhoodar.base.Pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the <tt>Output</tt> interface for mode three
 * @author Zhoodar
 * @since 01.10.2016.
 */
public class OutputModeThree implements Output {

    @Override
    public List<String> searchPattern(List<Input> inputs, List<Pattern> patterns) {
        List<String> stringList = new ArrayList<>();
        int patternLength;
        int inputLength;
        int counter=0;

        for(Pattern pattern : patterns){
            for(Input input: inputs){
                patternLength = pattern.getLine().length();
                inputLength = input.getLine().length();
                if( patternLength-inputLength>=-1 && patternLength-inputLength<=1 ) {
                    for(int i=0;i<(patternLength-inputLength<1?inputLength:patternLength)-2;i++) {
                        if (input.getLine().substring(i, i + 1).equals(pattern.getLine().substring(i, i + 1)))
                            counter++;
                    }
                    if(patternLength-1<=counter)
                        stringList.add(input.getLine());
                }
            }
        }
        return stringList;
    }
}
