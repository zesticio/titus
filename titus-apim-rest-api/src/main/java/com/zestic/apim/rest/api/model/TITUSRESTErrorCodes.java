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

package com.zestic.apim.rest.api.model;

import java.util.HashMap;
import java.util.Map;

/**
 * runtime error code starting from 0x200000
 */
public enum TITUSRESTErrorCodes {

    RTE_SESSION_NULL(0x100000, "Runtime exception session is null or not running"),
    RTE_UNABLE_ENABLE_MESSAGE_TIMESTAMP(0x100011, "Runtime exception, Unable to enable message timestamp");

    private static final Map<Integer, TITUSRESTErrorCodes> LOOKUP = new HashMap<>();

    static {
        for (final TITUSRESTErrorCodes enumeration : TITUSRESTErrorCodes.values()) {
            LOOKUP.put(enumeration.getCode(), enumeration);
        }
    }

    private final Integer code;
    private final String message;

    private TITUSRESTErrorCodes(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
