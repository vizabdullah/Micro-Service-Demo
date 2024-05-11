package com.microquestion.QuestionService.Services;

import com.microquestion.QuestionService.Entities.Question;

import java.util.List;

public interface QuestionService
{
    Question create(Question question);
    List<Question> get();
    Question get(long id);

    List<Question> getQuestionOfQuiz(long id);
}
