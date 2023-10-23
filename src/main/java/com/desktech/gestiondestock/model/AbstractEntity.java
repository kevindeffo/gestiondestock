package com.desktech.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "creationDate", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "lastModifiedDate", nullable = false)
    private Instant lastModifiedDate;
}

