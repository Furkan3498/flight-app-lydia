package com.lydiatechnology.flightticket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor

@SuperBuilder
public class BaseEntity {
    @CreatedDate
    private Date creationDate;

    @LastModifiedDate
    private Date LastModificationDate;

    @Builder.Default
    private boolean deleted=false;

}