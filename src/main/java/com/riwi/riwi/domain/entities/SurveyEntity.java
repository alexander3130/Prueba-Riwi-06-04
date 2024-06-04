package com.riwi.riwi.domain.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "survey")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class SurveyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 255, nullable = false)
    private String title;
    @Column(length = 100, nullable = false)
    private String description;
    @Column( nullable = false)
    private LocalDateTime creation_date;
    @Column(nullable = false)
    private Long active;

    /* RELACIONES */

    //Muchas encuestas pueden tener un usuario
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private UserEntity user; 
    
    // Una encuesta puede tener muchas preguntas
    @OneToMany(mappedBy = "survey", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = false)
    private List<QuestionEntity> question;
}
