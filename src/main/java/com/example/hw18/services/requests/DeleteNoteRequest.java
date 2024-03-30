package com.example.hw18.services.requests;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteNoteRequest {
    private UUID id;
}
