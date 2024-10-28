package com.poi.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trail {
    @NotNull
    private Long fid;

    private Boolean restrooms;

    private Boolean picnic;

    private Boolean fishing;

    private String aka;

    private String accessType;

    private String accessId;

    private String clazz;

    @NotEmpty
    private String address;

    private Boolean fee;

    private Boolean bikerack;

    private Boolean biketrail;

    @Min(value = 0)
    private Integer dogTube;

    private Boolean grills;

    @Min(value = 0)
    private Integer trashcans;

    @Min(value = 0)
    private Integer parkSpaces;

    private String adaSurface;

    private Boolean adaToilet;

    private Boolean adaFishing;

    private Boolean adaCamping;

    private Boolean adaPicnic;

    private String adaTrail;

    private Boolean adaParking;

    private Boolean adaFacilit;

    private String adaFacName;

    private String horseTrail;

    private String dateFrom;

    private String dateTo;

    private Boolean recycleBin;

    private Boolean dogCompost;

    private String accessName;

    private Boolean thLeash;

}
