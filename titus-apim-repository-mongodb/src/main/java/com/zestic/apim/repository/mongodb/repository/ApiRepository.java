package com.zestic.apim.repository.mongodb.repository;

import com.zestic.apim.repository.mongodb.entity.Api;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ApiRepository  extends ReactiveMongoRepository<Api,Long> {

    Flux<Api> findByMethod(String method);
}
