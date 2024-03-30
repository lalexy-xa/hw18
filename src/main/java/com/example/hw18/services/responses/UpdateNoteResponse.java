package com.example.hw18.services.responses;

import com.example.hw18.data.entities.Note;
import com.example.hw18.services.dto.NoteDto;
import com.example.hw18.services.requests.UpdateNoteRequest;
import lombok.*;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class UpdateNoteResponse{
    private boolean success;
    private Error errorMessage;
    private NoteDto note;

    @Getter
    public enum Error {
        ok,
        noId,
        invalidTitle,
        invalidContent
    }

    public static UpdateNoteResponse success(NoteDto note) {
        return UpdateNoteResponse.builder()
                .success(true)
                .errorMessage(Error.ok)
                .note(note)
                .build();
    }

    public static UpdateNoteResponse failed(Error errorMessage) {
        return UpdateNoteResponse.builder().success(false).note(null).errorMessage(errorMessage).build();
    }
}
