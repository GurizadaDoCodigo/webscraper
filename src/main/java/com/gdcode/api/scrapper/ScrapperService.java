package com.gdcode.api.scrapper;

import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.springframework.stereotype.Service;

import com.gdcode.api.core.webpages.SitesRepository;
import com.gdcode.api.core.products.InterestProduct;
import com.gdcode.api.core.products.ProductMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScrapperService {
    private final PageLoader loader;
    private final ProductMapper mapper;
    private final SitesRepository sitesRepository;

    public void searchForProduct(InterestProduct interestProducts) {
        String encoded = URLEncoder.encode(
            interestProducts.query(), Charset.forName("UTF-8"));
        sitesRepository.findAll()
            .map(site -> {
                String url = site.domain() + encoded;
                try {
                    loader.getItemsByCSSQuery(
                        loader.getPage(url),
                        site.config().container()
                    ).stream()
                        .map(element -> mapper.fromElement(element, site.config()));
                    return null;
                } catch(Exception e) {
                    return null;
                }
            });
    }
}
