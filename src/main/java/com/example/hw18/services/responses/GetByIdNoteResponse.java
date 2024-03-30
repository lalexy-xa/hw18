package com.example.hw18.services.responses;

import com.example.hw18.data.entities.Note;
import com.example.hw18.services.dto.NoteDto;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdNoteResponse {
    private boolean success;
    private Error errorMessage;
    private NoteDto note;

    @Getter
    public enum Error {
        ok,
        noId
    }

    public static GetByIdNoteResponse success(NoteDto note) {
        return GetByIdNoteResponse.builder()
                .success(true)
                .errorMessage(Error.ok)
                .note(note)
                .build();
    }

    public static GetByIdNoteResponse failed(Error errorMessage) {
        return GetByIdNoteResponse.builder().success(false).note(null).errorMessage(errorMessage).build();
    }
}
