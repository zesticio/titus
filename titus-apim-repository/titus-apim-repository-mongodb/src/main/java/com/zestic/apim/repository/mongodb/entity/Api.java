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
package com.zestic.apim.repository.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "api_routes")
public class Api extends Auditable {

    @Id
    private Long id;

    private String path;
    private String method;
    private String uri;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Api{");
        sb.append("id='").append(id).append('\'');
        sb.append(", path='").append(path).append('\'');
        sb.append(", method='").append(method).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
