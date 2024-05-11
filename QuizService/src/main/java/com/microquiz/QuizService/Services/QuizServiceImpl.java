package com.microquiz.QuizService.Services;

import com.microquiz.QuizService.Entities.Quiz;
import com.microquiz.QuizService.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService
{
    @Autowired
    private QuizRepository quiz_repo;
    @Autowired
    private QuestionClient questionClient;
    @Override
    public Quiz add(Quiz quiz) {
        return quiz_repo.save(quiz);
    }

    @Override
    public List<Quiz> get() {

        List<Quiz> quizzes =quiz_repo.findAll();
        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

        return newQuizList;
    }

    @Override
    public Quiz get(long id) {

        Quiz quiz = quiz_repo.findById(id).orElseThrow(()-> new RuntimeException("Quiz Not Found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;

    }
}
