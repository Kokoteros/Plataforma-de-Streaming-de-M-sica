package com.info.streamingmusic.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@NoArgsConstructor
@Getter @Setter
public class ErrorDto {
    private String apiPath;
    private HttpStatus httpStatus;
    private String errorMessage;
    private LocalDateTime errorTime;
}
