package com.zestic.apim.gateway.service.impl;

import com.zestic.apim.gateway.service.RouteService;
import com.zestic.apim.gateway.service.GatewayRouteService;
import com.zestic.apim.repository.mongodb.entity.Api;
import com.zestic.apim.repository.mongodb.repository.ApiRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RouteServiceImpl implements RouteService {

    private ApiRepository repository;
    private GatewayRouteService service;

    public RouteServiceImpl(GatewayRouteService service, ApiRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @Override
    public Flux<Api> findRoutes() {
        return repository.findAll();
    }

    @Override
    public Mono<Api> findRouteById(Long id) {
        return findAndValidateApiRoute(id);
    }

    private Mono<Api> findAndValidateApiRoute(Long id) {
        return repository.findById(id)
                .switchIfEmpty(
                        Mono.error(
                                new RuntimeException(String.format("Api route with id %d not found", id)
                                )
                        )
                );
    }
}
