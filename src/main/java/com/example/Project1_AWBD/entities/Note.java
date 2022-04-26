package com.example.Project1_AWBD.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob //Allows for more than 256 characters in the notes field as hibernate always limits the String field to 256 characters.
    private String notes;
}
