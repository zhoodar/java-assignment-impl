package kg.zhoodar.base.yandex.api.business;

import kg.zhoodar.base.yandex.api.model.YaItem;
import kg.zhoodar.base.yandex.api.model.YaPage;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.CharArrayWriter;

/**
 * Handler for Yandex.XML's response parsing
 */
public class YaHandler extends DefaultHandler {

    private static final String IGNORE_TAG = "hlword";

    private final CharArrayWriter buffer = new CharArrayWriter();
    private YaItem currentItem;
    private YaPage yaPage;

    /**
     * Constructor
     * @param yaPage yandex page that will be filled with SERP items
     */
    public YaHandler(final YaPage yaPage) {
        this.yaPage = yaPage;
    }

    @Override
    public void startElement(
            final String uri,
            final String localName,
            final String qName,
            final Attributes attr
    ) throws SAXException {
        super.startElement(uri, localName, qName, attr);
        if (!IGNORE_TAG.equals(qName)) {
            buffer.reset();
        }
    }

    @Override
    public void endElement(
            final String uri,
            final String localName,
            final String qName
    ) throws SAXException {

        super.endElement(uri, localName, qName);
        if ("error".equals(qName)) {
            throw new IllegalArgumentException("Bad request: " + buffer.toString());
        } else if ("url".equals(qName)) {
            currentItem = new YaItem(buffer.toString());
        } else if ("domain".equals(qName) && currentItem != null) {
            currentItem.setDomain(buffer.toString());
        } else if ("title".equals(qName) && currentItem != null) {
            currentItem.setTitle(clearFromTags(buffer.toString()));
        } else if ("headline".equals(qName) && currentItem != null) {
            currentItem.setDescription(clearFromTags(buffer.toString()));
        } else if ("passage".equals(qName) && currentItem != null) {
            currentItem.addPassage(clearFromTags(buffer.toString()));
        } else if ("group".equals(qName) && currentItem != null) {
            yaPage.addYaItem(currentItem);
        }
    }

    @Override
    public void characters(final char[] chars, final int start, final int length)
            throws SAXException {
        super.characters(chars, start, length);
        buffer.write(chars, start, length);
    }

    /**
     * Clear text from unwanted tags
     * @param text text to clear
     * @return cleared text
     */
    private String clearFromTags(final String text) {
        return text.replaceAll("<" + IGNORE_TAG +">", "")
                .replaceAll("</" + IGNORE_TAG + ">", "");
    }
}
