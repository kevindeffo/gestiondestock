package com.desktech.gestiondestock.handlers;

import com.desktech.gestiondestock.enums.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorDto {
    private Integer httpCode;

    private ErrorCodes code;

    private String message;

    private List<String> errors = new ArrayList<>();
}
