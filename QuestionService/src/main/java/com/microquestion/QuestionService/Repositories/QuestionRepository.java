package com.microquestion.QuestionService.Repositories;

import com.microquestion.QuestionService.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long>
{
    List<Question> findByQuizId(long id);
}
