package com.nr.securitycustomjwt.post;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectPostId extends Throwable {
    public IncorrectPostId(String format) {
        super(format);
    }
}
