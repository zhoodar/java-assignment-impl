package kg.zhoodar.base;

import java.util.List;

/**
 * @author Zhoodar
 * @since 01.10.2016.
 */
public interface Output {

    List<String> searchPattern(List<Input> inputs, List<Pattern> patterns);
}
