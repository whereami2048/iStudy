package iStudy.managementservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MeetingController {

    @GetMapping("/meetings")
    public String goMeetings() {
        return "admin/meetings";
    }
}
