package com.foodreyes.menu.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BaseEntity {

    @Column(name="created_date", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdDate = Instant.now();

    @Column(name="created_by", nullable = false, updatable = false)
    @CreatedBy
    private Integer createdBy = 1;

    @Column(name="modified_date", nullable = false)
    @LastModifiedDate
    private Instant modifiedDate = Instant.now();

    @Column(name="modified_by", nullable = false)
    @LastModifiedBy
    private Integer modifiedBy = 1;
}
