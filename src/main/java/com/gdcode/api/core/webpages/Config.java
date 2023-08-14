package com.gdcode.api.core.webpages;

import java.util.Optional;

public record Config(
    /**
     * Css query for the container or the items.
     * Will be passed to a "querySelectorAll" like.
     */
    String container,
    String priceField,
    String titleField,
    Optional<String> slugField,
    /**
     * Should be defined if slug is undefined
     */
    Optional<String> urlField
) {}
