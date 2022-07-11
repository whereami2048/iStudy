package iStudy.managementservice.web.controller;

import iStudy.managementservice.domain.service.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/normal")
public class NormalController {
    MemberServiceImpl memberService;

    public NormalController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/attendance")
    public String goAttendance() {
        return "/normal/attendance";
    }
}
