package com.prana.stock.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
