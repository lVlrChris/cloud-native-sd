package com.chrisboer.restassignment.controllers;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AccountDTO {
    @NonNull
    private Long id;
    @NotNull @NotBlank
    private String iBAN;
    private double balance;
    private boolean isBlocked;

    protected AccountDTO() {}
}
