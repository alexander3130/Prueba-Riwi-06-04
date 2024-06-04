package com.riwi.riwi.domain.entities;

import java.util.List;

import com.riwi.riwi.util.enums.TypeQuestion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Entity(name = "question")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 255, nullable = false)
    private String text;
    @Enumerated(EnumType.STRING)
    private TypeQuestion type;
    @Column(nullable = false)
    private boolean active;

    /* RELACIONES */

    //Muchas preguntas
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id", referencedColumnName = "id")
    private SurveyEntity survey; 

    //Una pregunta puede tener muchas opciones de respuesta
    @OneToMany(mappedBy = "question_id", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = false)
    private List<OptionQuestionEntity> optionquestion;
    

}
