package kg.zhoodar.base;

import java.util.List;

/**
 * Interface provides one method to make web search
 * @author Zhoodar
 * @since 01.10.2016.
 */
public interface WebSearchEngine {

    /**
     * Method returns list of result from a web search with the specified query
     * @param query specified query
     * @return list of result from search
     */
    List doSearch(String query);
}
