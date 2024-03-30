package com.example.hw18.data.reprository;


import com.example.hw18.data.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface NoteRepository extends JpaRepository<Note, UUID> {


}
