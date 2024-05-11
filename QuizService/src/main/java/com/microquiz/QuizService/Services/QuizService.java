package com.microquiz.QuizService.Services;

import com.microquiz.QuizService.Entities.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService
{
    Quiz add(Quiz quiz);

    List<Quiz> get();
    Quiz get(long id);
}
