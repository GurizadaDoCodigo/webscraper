package com.gdcode.api.core.products;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestProductRepository
    extends ReactiveCrudRepository<InterestProduct, Long> {
}
