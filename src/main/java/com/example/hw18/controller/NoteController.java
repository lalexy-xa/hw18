package com.example.hw18.controller;


import com.example.hw18.services.NoteService;
import com.example.hw18.services.dto.NoteDto;
import com.example.hw18.services.requests.CreateNoteRequest;
import com.example.hw18.services.requests.UpdateNoteRequest;
import com.example.hw18.services.responses.CreateNoteResponse;
import com.example.hw18.services.responses.DeleteNoteResponse;
import com.example.hw18.services.responses.GetByIdNoteResponse;
import com.example.hw18.services.responses.UpdateNoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping(value = "/list")
    public List<NoteDto> listOfNotes() {
        return noteService.findAll();
    }

    @PostMapping(value = "")
    public CreateNoteResponse addNote(@RequestBody CreateNoteRequest note) {
        return noteService.create(note);
    }

    @PutMapping(value = "/{id}")
    public UpdateNoteResponse updateNote(@PathVariable ("id") UUID id, @RequestBody UpdateNoteRequest note) throws Exception {
        return noteService.update(id, note);
    }

    @DeleteMapping(value = "/{id}")
    public DeleteNoteResponse delete(@PathVariable ("id") UUID id){
        return noteService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public GetByIdNoteResponse getById(@PathVariable ("id") UUID id){
        return noteService.getById(id);
    }
}
