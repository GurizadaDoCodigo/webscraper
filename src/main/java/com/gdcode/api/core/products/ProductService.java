package com.gdcode.api.core.products;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class ProductService {
    private final InterestProductRepository interestProductRepository;

    public Mono<InterestProduct> registerProductInterest(String query) {
        return interestProductRepository.save(
            InterestProduct.builder().query(query).build()
        );
    }
}
