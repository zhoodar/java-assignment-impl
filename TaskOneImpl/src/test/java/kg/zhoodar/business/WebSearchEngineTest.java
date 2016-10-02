package kg.zhoodar.business;

import kg.zhoodar.base.WebSearchEngine;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhoodar
 * @since 02.10.2016.
 */
public class WebSearchEngineTest {

    @Test
    public void testGoogleEngine(){
        WebSearchEngine google = new WebSearchEngineImplByGoogle();
        assertNotNull(google.doSearch("I am a programmer"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGoogleEngineThrowsException(){
        WebSearchEngine google = new WebSearchEngineImplByGoogle();
        google.doSearch(null);
    }

    @Test
    public void testYandexEngine(){
        WebSearchEngine yandex = new WebSearchEngineImplByYandex();
        assertNotNull(yandex.doSearch("I am a programmer"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testYandexEngineThrowsException(){
        WebSearchEngine yandex = new WebSearchEngineImplByYandex();
        yandex.doSearch(null);
    }


}