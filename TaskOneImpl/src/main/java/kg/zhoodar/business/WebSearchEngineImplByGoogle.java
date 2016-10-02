package kg.zhoodar.business;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.model.Result;
import com.google.api.services.customsearch.model.Search;
import kg.zhoodar.base.WebSearchEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhoodar
 * @since 01.10.2016.
 */
public class WebSearchEngineImplByGoogle implements WebSearchEngine {

    private static final String API_KEY = "AIzaSyDkDSoM7Z1dRXZ86TqZg9VPpD9Pv6e7ugM";
    private static final String ENGINE_ID = "015809992020060722942:g3a0ogjujcc";

    @Override
    public List doSearch(final String query) {

        if (query == null ) {
            throw new IllegalArgumentException(
                    "Error: Invalid arguments.");
        }
        String searchQuery = query.replaceAll(" ", "+");
        HttpRequestInitializer httpRequestInitializer = httpRequest -> httpRequest.setRequestMethod("GET");
        Customsearch customsearch = new Customsearch.Builder(new NetHttpTransport(),new JacksonFactory(),httpRequestInitializer)
                .setApplicationName("GoogleSearchEngine")
                .build();
        List<Result> result = new ArrayList<>();
        System.out.println("Google is searching...");

        try {
            Customsearch.Cse.List list = customsearch.cse().list(searchQuery);
            list.setKey(API_KEY);
            list.setCx(ENGINE_ID);
            Search results = list.execute();
            result.addAll(results.getItems());
            System.out.println("Searching is completed!");
        } catch (IOException e) {
            System.err.println("Occurred an error during the search: "
                    + e.getMessage());
        }
        return result;
    }
}
