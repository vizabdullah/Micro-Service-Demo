package com.microquestion.QuestionService.Controllers;

import com.microquestion.QuestionService.Entities.Question;
import com.microquestion.QuestionService.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController
{
    @Autowired
    QuestionService questionService;

    @PostMapping()
    public Question create(@RequestBody Question question)
    {
        return questionService.create(question);
    }

    @GetMapping()
    public List<Question> get()
    {
        return questionService.get();
    }
    @GetMapping("/{id}")
    Question get(@PathVariable long id)
    {
        return questionService.get(id);
    }

    @GetMapping("/quiz/{id}")
    public List<Question> getQuestionsOfQuiz(@PathVariable long id)
    {
        return questionService.getQuestionOfQuiz(id);
    }
}
