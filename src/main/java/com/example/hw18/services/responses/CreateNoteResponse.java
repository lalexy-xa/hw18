package com.example.hw18.services.responses;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoteResponse {
    private boolean success;
    private Error errorMessage;
    private UUID id;

    @Getter
    public enum Error {
        ok,
        invalidTitle,
        invalidContent
    }

    public static CreateNoteResponse success(UUID id) {
        return CreateNoteResponse.builder().success(true).errorMessage(Error.ok).id(id).build();
    }

    public static CreateNoteResponse failed(Error errorMessage) {
        return CreateNoteResponse.builder().success(false).id(null).errorMessage(errorMessage).build();
    }
}
