package com.example.hw18.services.validation;

import com.example.hw18.services.requests.CreateNoteRequest;
import com.example.hw18.services.requests.UpdateNoteRequest;
import com.example.hw18.services.responses.CreateNoteResponse;
import com.example.hw18.services.responses.UpdateNoteResponse;

import java.util.Optional;

public class NoteFieldsValidationService {

    private static final int MAX_TITLE_LENGTH = 30;
    private static final int MIN_TITLE_LENGTH = 1;
    private static final int MAX_CONTENT_LENGTH = 1000;
    private static final int MIN_CONTENT_LENGTH = 2;

    public static Optional<UpdateNoteResponse.Error> validateUpdateFields(UpdateNoteRequest request) {
        if (!isTitileValid(request.getTitle())) {
            return Optional.of(UpdateNoteResponse.Error.invalidTitle);
        }

        if (!isContentValid(request.getContent())) {
            return Optional.of(UpdateNoteResponse.Error.invalidContent);
        }

        return Optional.empty();
    }

    public static Optional<CreateNoteResponse.Error> validateCreateFields(CreateNoteRequest request) {
        if (!isTitileValid(request.getTitle())) {
            return Optional.of(CreateNoteResponse.Error.invalidTitle);
        }

        if (!isContentValid(request.getContent())) {
            return Optional.of(CreateNoteResponse.Error.invalidContent);
        }

        return Optional.empty();
    }

    private static boolean isTitileValid(String title){
        int titleLength = title.trim().length();
        if (titleLength < MIN_TITLE_LENGTH || titleLength > MAX_TITLE_LENGTH) {
            return false;
        }
        return true;
    }

    private static boolean isContentValid(String content){
        int contentLength = content.trim().length();
        if (contentLength < MIN_CONTENT_LENGTH || contentLength > MAX_CONTENT_LENGTH) {
            return false;
        }
        return true;
    }
}
