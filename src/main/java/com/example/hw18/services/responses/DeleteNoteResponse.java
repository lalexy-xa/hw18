package com.example.hw18.services.responses;

import lombok.*;

import java.util.UUID;
@Builder
@Data
public class DeleteNoteResponse {
    private boolean success;
    private Error errorMessage;
    private UUID id;

    @Getter
    public enum Error {
        ok,
        noId
    }

    public static DeleteNoteResponse success(UUID id) {
        return DeleteNoteResponse.builder().success(true).errorMessage(Error.ok).id(id).build();
    }

    public static DeleteNoteResponse failed(Error errorMessage) {
        return DeleteNoteResponse.builder().success(false).id(null).errorMessage(errorMessage).build();
    }
}
