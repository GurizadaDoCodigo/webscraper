package com.gdcode.api.scrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.gdcode.api.scrapper.config.ScrapperProperties;

@Component
public class PageLoader {
    private final ScrapperProperties properties;

    public PageLoader(ScrapperProperties properties) {
        this.properties = properties;
    }

    public Document getPage(String pageUrl) throws IOException {
        return Jsoup.connect(pageUrl)
            .userAgent(properties.getAgent())
            .header("Accept-Language", properties.getLanguage())
            .get();
    }

    public Elements getItemsByCSSQuery(Document doc, String cssQuery) {
        return doc.body().select(cssQuery);
    }
}
