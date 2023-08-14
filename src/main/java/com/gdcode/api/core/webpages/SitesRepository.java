package com.gdcode.api.core.webpages;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SitesRepository extends ReactiveCrudRepository<Site, String> {}
