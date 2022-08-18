package iStudy.managementservice.web.controller;

import iStudy.managementservice.domain.service.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/normal")
public class NormalIndexController {
    MemberServiceImpl memberService;

    public NormalIndexController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/home/normal")
    public String goNormal() {
        return "/home/normal";
    }
}
