package com.gdcode.api.core.products;

import java.math.BigDecimal;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import com.gdcode.api.core.webpages.Config;
import com.gdcode.api.scrapper.config.ScrapperProperties;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductMapper {
    private final ScrapperProperties scrapperProperties;

    public Product fromElement(Element element, Config siteConfig) {
        String title = element.selectFirst(siteConfig.titleField()).wholeText();
        String priceText = element.selectFirst(siteConfig.priceField()).wholeText()
            .replace(scrapperProperties.getCurrency(), "");
        String urlField = siteConfig.slugField()
            .orElse(siteConfig.urlField().get());
        String url = element.selectFirst(urlField).attr("href");
        BigDecimal price = new BigDecimal(priceText);
        return new Product(title, price, url, null);
    }
}
