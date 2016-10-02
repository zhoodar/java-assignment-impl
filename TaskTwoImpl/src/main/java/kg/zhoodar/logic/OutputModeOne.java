package kg.zhoodar.logic;

import kg.zhoodar.base.Input;
import kg.zhoodar.base.Output;
import kg.zhoodar.base.Pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the <tt>Output</tt> interface for mode one
 * @author Zhoodar
 * @since 01.10.2016.
 */
public class OutputModeOne implements Output{

    @Override
    public List<String> searchPattern(List<Input> inputs, List<Pattern> patterns) {
        List<String> stringList = new ArrayList<>();

        for(Pattern pattern : patterns){
            for(Input input: inputs){
                if(pattern.getLine().equals(input.getLine()))
                    stringList.add(input.getLine());
            }
        }
        return stringList;
    }
}
