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
import com.zestic.apim.repository.mongodb.entity.Api;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.BooleanSpec;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class RouteLocatorImpl implements RouteLocator {

    private final RouteService apiRouteService;
    private final RouteLocatorBuilder routeLocatorBuilder;

    @Override
    public Flux<Route> getRoutes() {
        RouteLocatorBuilder.Builder builder = routeLocatorBuilder.routes();
        return apiRouteService.findRoutes()
                .map(apiRoute -> builder.route(String.valueOf(apiRoute.getId()),
                        predicateSpec -> setPredicateSpec(apiRoute, predicateSpec)))
                .collectList()
                .flatMapMany(builders -> builder.build()
                        .getRoutes());
    }

    private Buildable<Route> setPredicateSpec(Api apiRoute, PredicateSpec predicateSpec) {
        BooleanSpec booleanSpec = predicateSpec.path(apiRoute.getPath());
        if (!StringUtils.isEmpty(apiRoute.getMethod())) {
            booleanSpec.and()
                    .method(apiRoute.getMethod());
        }
        return booleanSpec.uri(apiRoute.getUri());
    }
}
