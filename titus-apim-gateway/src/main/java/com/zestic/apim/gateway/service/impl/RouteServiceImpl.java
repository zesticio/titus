/*
 * Version:  1.0.0
 *
 * Authors:  Kumar <Deebendu Kumar>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
