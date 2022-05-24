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

package com.zestic.apim.rest.api.controller;

import com.zestic.apim.repository.mongodb.entity.Route;
import com.zestic.apim.rest.api.Constants;
import com.zestic.apim.rest.api.service.RouteService;
import com.zestic.apim.rest.api.validation.CreateRouteValidator;
import com.zestic.common.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "" + Constants.END_POINT_V1_0 + "/routes", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "", description = "", tags = {"Routes"})
public class RouteController {

    private RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    /**
     * list all users
     *
     * @return
     */
    @GetMapping(path = "")
    @ApiOperation(value = "Returns all routes configured", notes = "Pagination also supported using limit and page")
    public ResponseEntity<Result> find(@RequestParam Optional<Integer> limit,
                                       @RequestParam Optional<Integer> page) {
        Result response = service.findAll();
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Create a new user
     *
     * @return
     */
    @PostMapping(path = "")
    @ApiOperation(value = "Create a new route", notes = "")
    public ResponseEntity<Result> create(@RequestBody
                                         @ApiParam(name = "Create route", value = "Create route value", required = true)
                                         @CreateRouteValidator Route route) {
        Result response = service.create(route);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Update user
     *
     * @param id
     * @return
     */
    @PutMapping(path = "/{id}")
    @ApiOperation(value = "", notes = "")
    public ResponseEntity<Result> update(@PathVariable(value = "id") Long id, @RequestBody @CreateRouteValidator Route route) {
        Result response = service.update(id, route);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * Get user by id
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    @ApiOperation(value = "", notes = "")
    public ResponseEntity<Result> findById(@PathVariable(value = "id") Long id) {
        Result response = service.findById(id);
        return new ResponseEntity<Result>(response, HttpStatus.valueOf(response.getCode()));
    }
}
