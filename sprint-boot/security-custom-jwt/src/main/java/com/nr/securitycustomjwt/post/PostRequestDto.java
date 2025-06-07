package com.nr.securitycustomjwt.post;

import jakarta.validation.constraints.NotBlank;

public record PostRequestDto(
        @NotBlank
        String title,
        @NotBlank
        String content
) {
}
