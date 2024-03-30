package com.example.hw18.services;

import com.example.hw18.data.entities.Note;
import com.example.hw18.data.reprository.NoteRepository;
import com.example.hw18.services.dto.NoteDto;
import com.example.hw18.services.mapper.MapperNotes;
import com.example.hw18.services.requests.CreateNoteRequest;
import com.example.hw18.services.requests.UpdateNoteRequest;
import com.example.hw18.services.responses.CreateNoteResponse;
import com.example.hw18.services.responses.DeleteNoteResponse;
import com.example.hw18.services.responses.GetByIdNoteResponse;
import com.example.hw18.services.responses.UpdateNoteResponse;
import com.example.hw18.services.validation.NoteFieldsValidationService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository repository;
    private final MapperNotes mapperNotes;

    public List<NoteDto> findAll(){
        return mapperNotes.toNoteDtoList(repository.findAll());
    }

    public CreateNoteResponse create( CreateNoteRequest request) {
        Optional<CreateNoteResponse.Error> validationError = NoteFieldsValidationService.validateCreateFields(request);
        if (validationError.isPresent()) {
            return CreateNoteResponse.failed(validationError.get());
        }

        Note createdNote = repository.save(Note.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());

        return CreateNoteResponse.success(createdNote.getId());
    }

    public UpdateNoteResponse update(UUID id, UpdateNoteRequest request) throws Exception {
        Optional<UpdateNoteResponse.Error> validationError = NoteFieldsValidationService.validateUpdateFields(request);
        if(!repository.existsById(id)){
            return UpdateNoteResponse.failed(UpdateNoteResponse.Error.noId);
        }
        if (validationError.isPresent()){
            return UpdateNoteResponse.failed(validationError.get());
        }
        Note note = new Note(id, request.getTitle(), request.getContent());
        repository.save(note);
        return UpdateNoteResponse.success(mapperNotes.toNoteDto(note));
    }

    public DeleteNoteResponse delete(UUID id){
        if(!repository.existsById(id)){
            return DeleteNoteResponse.failed(DeleteNoteResponse.Error.noId);
        }
        repository.deleteById(id);
        return DeleteNoteResponse.success(id);
    }

    public GetByIdNoteResponse getById(UUID id){
        if(!repository.existsById(id)){
            return GetByIdNoteResponse.failed(GetByIdNoteResponse.Error.noId);
        }
        NoteDto note = mapperNotes.toNoteDto(repository.getById(id));
        return GetByIdNoteResponse.success(note);
    }

}
