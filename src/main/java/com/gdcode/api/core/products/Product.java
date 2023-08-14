package com.gdcode.api.core.products;

import java.math.BigDecimal;

import com.gdcode.api.core.webpages.Site;

public record Product(
    String title,
    BigDecimal price,
    String url,
    Site origin
) {}
