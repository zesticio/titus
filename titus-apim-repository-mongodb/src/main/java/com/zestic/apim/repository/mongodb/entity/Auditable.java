package com.zestic.apim.repository.mongodb.entity;

import lombok.Data;

import java.util.Date;

@Data
abstract class Auditable {

    private Date createdAt;
    private Date updatedAt;
}
