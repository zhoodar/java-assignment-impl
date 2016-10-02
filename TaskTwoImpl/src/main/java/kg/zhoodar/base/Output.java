package kg.zhoodar.base;

import java.util.List;

/**
 * The interface provides one method to search for a specified patterns.
 * @author Zhoodar
 * @since 01.10.2016.
 */
public interface Output {

    /**
     * Returns list of given inputs string, where the given list of inputs
     * contain a match from specified patterns
     * @param inputs given list inputs
     * @param patterns specified patterns
     * @return list of strings
     */
    List<String> searchPattern(List<Input> inputs, List<Pattern> patterns);
}
