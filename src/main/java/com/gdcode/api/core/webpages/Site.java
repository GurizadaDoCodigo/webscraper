package com.gdcode.api.core.webpages;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Embedded.OnEmpty;

public record Site(
    @Id String domain,
    @Embedded(onEmpty = OnEmpty.USE_NULL) Config config
) {}
