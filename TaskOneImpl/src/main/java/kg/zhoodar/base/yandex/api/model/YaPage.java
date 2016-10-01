package kg.zhoodar.base.yandex.api.model;

import kg.zhoodar.base.yandex.api.model.YaItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of Yandex SERP page
 */
public class YaPage {

    public static final int ITEMS_PER_PAGE = 10;

    private String keyword;
    private int pageNumber;
    private List<YaItem> yaItems = new ArrayList<YaItem>();

    /**
     * Constructor
     * @param keyword keyword for searching
     * @param pageNumber number of page
     */
    public YaPage(final String keyword, final int pageNumber) {
        this.keyword = keyword;
        this.pageNumber = pageNumber;
    }

    public List<YaItem> getYaItems() {
        return yaItems;
    }

    /**
     * Add one SERP item to collection (page)
     * @param item one SERP item
     */
    public void addYaItem(final YaItem item) {

        final int position = (pageNumber * ITEMS_PER_PAGE) + yaItems.size() + 1;
        item.setPosition(position);
        yaItems.add(item);
    }
}