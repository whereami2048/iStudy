package iStudy.managementservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClassesController {

    @GetMapping("/classes")
    public String goClasses() {
        return "admin/classes";
    }
}
