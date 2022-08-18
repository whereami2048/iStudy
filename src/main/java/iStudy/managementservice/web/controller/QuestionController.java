package iStudy.managementservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class QuestionController {

    @GetMapping("/questions")
    public String goQuestions() {
        return "admin/questions";
    }
}
