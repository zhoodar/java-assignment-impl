package kg.zhoodar.logic;

import kg.zhoodar.base.Input;
import kg.zhoodar.base.Output;
import kg.zhoodar.base.Pattern;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Zhoodar
 * @since 02.10.2016.
 */
public class OutputTest {

    private List<Input> inputs = new ArrayList<>();
    private List<Pattern> patterns = new ArrayList<>();

    @Before
    public void init(){
        inputs.add(new Input("Hello. This is line 1 of text"));
        inputs.add(new Input("and this is another."));
        inputs.add(new Input("line 3 here"));
        inputs.add(new Input("the end"));

        patterns.add(new Pattern("the end"));
        patterns.add(new Pattern("matches"));
        patterns.add(new Pattern("line 3"));
        patterns.add(new Pattern("and this is anoother."));

    }

    @Test
    public void testModeOne(){
        Output seeker = new OutputModeOne();
        assertEquals(1, seeker.searchPattern(inputs,patterns).size() );
        this.inputs.clear();
        this.patterns.clear();
    }

    @Test public void testModeTwo(){
        Output seeker = new OutputModeTwo();
        List<String> lists =seeker.searchPattern(inputs,patterns);
        assertEquals(2,lists.size());
        this.inputs.clear();
        this.patterns.clear();
    }

    @Test public void testModeThree(){
        Output seeker = new OutputModeThree();
        List<String> lists =seeker.searchPattern(inputs,patterns);
        assertEquals(2,lists.size());
        this.inputs.clear();
        this.patterns.clear();
    }

}