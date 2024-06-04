package com.riwi.riwi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.riwi.domain.entities.SurveyEntity;

@Repository

public interface SurveyRepository extends JpaRepository<SurveyEntity, Long> {

}
