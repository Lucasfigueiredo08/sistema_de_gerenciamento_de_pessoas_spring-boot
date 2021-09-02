package com.digitalinnovation.one.PersonAPI_bootcamp.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

    private String message;
}
