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

import com.zestic.apim.rest.api.common.Constants;
import com.zestic.common.entity.Result;
import com.zestic.common.utils.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "" + Constants.END_POINT_V1_0 + "/test", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TestController {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.LogManager.getLogger(TestController.class);

    @PostMapping("")
    public ResponseEntity<Result> post() {
        Result<String> result = new Result(Error.SUCCESS.getCode(), "SUCCESS");
        return new ResponseEntity<Result>(result, HttpStatus.valueOf(result.getCode()));
    }

    @GetMapping("")
    public ResponseEntity<Result> get() {
        Result<String> result = new Result(Error.SUCCESS.getCode(), "SUCCESS");
        return new ResponseEntity<Result>(result, HttpStatus.valueOf(result.getCode()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> findById() {
        Result<String> result = new Result(Error.SUCCESS.getCode(), "SUCCESS");
        return new ResponseEntity<Result>(result, HttpStatus.valueOf(result.getCode()));
    }

    @PutMapping("")
    public ResponseEntity<Result> put() {
        Result<String> result = new Result(Error.SUCCESS.getCode(), "SUCCESS");
        return new ResponseEntity<Result>(result, HttpStatus.valueOf(result.getCode()));
    }

    @DeleteMapping("")
    public ResponseEntity<Result> delete() {
        Result<String> result = new Result(Error.SUCCESS.getCode(), "SUCCESS");
        return new ResponseEntity<Result>(result, HttpStatus.valueOf(result.getCode()));
    }
}
