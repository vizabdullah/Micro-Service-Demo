package com.microquiz.QuizService.Controllers;

import com.microquiz.QuizService.Entities.Quiz;
import com.microquiz.QuizService.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController
{
    @Autowired
    private QuizService quizService;

    @PostMapping("/add")
    public Quiz create(@RequestBody Quiz quiz)
    {
        return quizService.add(quiz);
    }

    @GetMapping()
    public List<Quiz> get()
    {
        return quizService.get();
    }
    @GetMapping("/{id}")
    public Quiz get(@PathVariable long id)
    {
        return quizService.get(id);
    }
}
