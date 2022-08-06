package iStudy.managementservice.web.controller;

import iStudy.managementservice.domain.service.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final MemberServiceImpl memberService;

    private HomeController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/home/admin")
    public String goAdmin() {
        return "/admin/index";
    }

    @GetMapping("/home/normal")
    public String goNormal() {
        return "/home/normal";
    }
}
