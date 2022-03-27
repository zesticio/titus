package com.zestic.apim.gateway.service;

import com.zestic.apim.repository.mongodb.entity.Api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RouteService {

    Flux<Api> findRoutes();
    Mono<Api> findRouteById(Long id);
}
