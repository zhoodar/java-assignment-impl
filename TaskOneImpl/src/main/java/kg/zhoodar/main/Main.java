package kg.zhoodar.main;

import com.google.api.services.customsearch.model.Result;
import kg.zhoodar.base.WebSearchEngine;
import kg.zhoodar.base.yandex.api.model.YaItem;
import kg.zhoodar.business.WebSearchEngineImplByGoogle;
import kg.zhoodar.business.WebSearchEngineImplByYandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Zhoodar
 * @since 01.10.2016.
 */
public class Main {

    public static void main(String[] args) {

        WebSearchEngine google = new WebSearchEngineImplByGoogle();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String query = null;
        try {
            while(true) {
                System.out.println("Please enter text to search:");
                query = reader.readLine();
                if(!query.trim().isEmpty())
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Result> googleResults = google.doSearch(query);
        System.out.println("The 1th result from the web search engine Google:");
        System.out.println("Title: " + googleResults.get(0).getTitle() +
                            "\nURL: " + googleResults.get(0).getLink());

        /*
          To run this part of code needed to submit the public IP address of the PC
          which is running this app on Yandex.XML API service. The service is limited.

        WebSearchEngine yandex = new WebSearchEngineImplByYandex();

        List<YaItem> yandexResults = yandex.doSearch(query);
        System.out.println("The 1th result from the web search engine Yandex:");
        System.out.println("Title: " + yandexResults.get(0).getTitle() +
                            "\nURL: " + yandexResults.get(0).getUrl());*/
    }
}
