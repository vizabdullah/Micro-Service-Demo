package com.microquestion.QuestionService.Services;

import com.microquestion.QuestionService.Entities.Question;
import com.microquestion.QuestionService.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService
{
    @Autowired
    private QuestionRepository question_repo;
    @Override
    public Question create(Question question) {
        return question_repo.save(question);
    }

    @Override
    public List<Question> get() {
        return question_repo.findAll();
    }

    @Override
    public Question get(long id) {
        return question_repo.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionOfQuiz(long id) {
        return question_repo.findByQuizId(id);
    }


}
