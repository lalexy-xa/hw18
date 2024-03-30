package com.example.hw18.services.requests;


import lombok.Data;

@Data
public class CreateNoteRequest {
    private String title;
    private String content;
}
