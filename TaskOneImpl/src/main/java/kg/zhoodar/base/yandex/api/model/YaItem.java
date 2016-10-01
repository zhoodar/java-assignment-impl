package kg.zhoodar.base.yandex.api.model;


/**
 * Representation of one item in Yandex SERP
 */
public class YaItem {

    private int position;
    private String url;
    private String domain;
    private String title;
    private String description = "";
    private String passages = "";

    /**
     * Constructor
     * @param url url of current item
     */
    public YaItem(final String url) {
        this.url = url;
    }

    /* Тут набор getter-ов для приватных полей класса... */

    public void setPosition(final int position) {
        this.position = position;
    }

    public void setDomain(final String domain) {
        this.domain = domain;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void addPassage(final String passage) {
        passages += passage;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "YaItem{" +
                "position=" + position +
                ", url='" + url + '\'' +
                ", domain='" + domain + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", passages='" + passages + '\'' +
                '}';
    }
}