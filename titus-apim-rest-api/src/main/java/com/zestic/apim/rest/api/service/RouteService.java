package com.zestic.apim.rest.api.service;

import com.zestic.apim.repository.mongodb.entity.Route;
import com.zestic.apim.repository.mongodb.repository.RouteRepository;
import com.zestic.apim.repository.mongodb.service.SequenceGeneratorService;
import com.zestic.apim.rest.api.Application;
import com.zestic.common.entity.Result;
import com.zestic.common.utils.HTTPErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Application.class);

    private final String id = "API_ROUTES";
    private final RouteRepository repository;
    private final SequenceGeneratorService service;

    @Autowired
    public RouteService(RouteRepository repository, SequenceGeneratorService service) {
        this.repository = repository;
        this.service = service;
    }

    public Result findAll() {
        Result<List<Route>> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), HTTPErrorCodes.SUCCESS.getMessage());
        List<Route> routes = repository.findAll();
        result.setData(routes);
        return result;
    }

    public Result create(Route param) {
        Result<Route> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), HTTPErrorCodes.SUCCESS.getMessage());
        if (!repository.existsByName(param.getName())) {
            param.setId(service.generateSequence(id));
            Route route = repository.save(param);
            result.setData(route);
            result.setCode(HTTPErrorCodes.CREATED.getCode());
        } else {
            result.setCode(HTTPErrorCodes.DUPLICATE.getCode());
            result.setMessage(HTTPErrorCodes.DUPLICATE.getMessage());
        }
        return result;
    }

    public Result update(Long id, Route param) {
        Result<Route> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), HTTPErrorCodes.SUCCESS.getMessage());
        if (repository.existsById(id)) {
            Route route = repository.save(param);
            result.setData(route);
            result.setCode(HTTPErrorCodes.CREATED.getCode());
        } else {
            result.setCode(HTTPErrorCodes.NOT_FOUND.getCode());
            result.setMessage(HTTPErrorCodes.NOT_FOUND.getMessage());
        }
        return result;
    }

    public Result findById(Long id) {
        Result<Route> result = new Result(HTTPErrorCodes.SUCCESS.getCode(), HTTPErrorCodes.SUCCESS.getMessage());
        if (!repository.existsById(id)) {
            result.setData(repository.findById(id).get());
        } else {
            result.setCode(HTTPErrorCodes.NOT_FOUND.getCode());
            result.setMessage(HTTPErrorCodes.NOT_FOUND.getMessage());
        }
        return result;
    }
}
