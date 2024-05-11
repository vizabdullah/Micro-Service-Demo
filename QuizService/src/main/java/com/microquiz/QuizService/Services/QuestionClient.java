package com.microquiz.QuizService.Services;

import com.microquiz.QuizService.Entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8083/api/question",value = "Question-Client")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient
{
    @GetMapping("/api/question/quiz/{id}")
    List<Question> getQuestionsOfQuiz(@PathVariable long id);
}
