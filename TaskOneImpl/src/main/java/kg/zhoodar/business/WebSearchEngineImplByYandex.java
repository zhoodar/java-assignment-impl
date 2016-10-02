package kg.zhoodar.business;

import kg.zhoodar.base.WebSearchEngine;
import kg.zhoodar.base.yandex.api.model.YaItem;
import kg.zhoodar.base.yandex.api.model.YaPage;
import kg.zhoodar.base.yandex.api.business.YaSearcher;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhoodar
 * @since 01.10.2016.
 */
public class WebSearchEngineImplByYandex implements WebSearchEngine {

    private static final String API_KEY = "03.420413770:88e77d3c23ee4d377fb7bf5aaf01ef5a";
    private static final String login ="azhoodar";
    private static final int DEFAULT_PAGE = 0;

    @Override
    public List doSearch(String query) {
        if (query == null ) {
            throw new IllegalArgumentException(
                    "Error: Invalid arguments.");
        }
        String searchQuery = query.replaceAll(" ", "+");
        final YaSearcher searcher = new YaSearcher(login, API_KEY);
        List<YaItem> items = new ArrayList<>();
        System.out.println("Yandex is searching...");
        final YaPage result;
        try {
            result = searcher.loadYaPage(searchQuery, DEFAULT_PAGE);
            items.addAll(result.getYaItems());
            System.out.println("Searching is completed!");
        } catch (IOException | SAXException e) {
            System.err.println("Occurred an error during the search: "
                    + e.getMessage());
        }
        return items;
    }
}
