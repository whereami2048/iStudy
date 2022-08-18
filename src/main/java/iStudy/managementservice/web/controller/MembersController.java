package iStudy.managementservice.web.controller;

import iStudy.managementservice.domain.model.Member;
import iStudy.managementservice.domain.service.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MembersController {

    private final MemberServiceImpl memberService;

    private MembersController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String goMembers(Model model) {
        model.addAttribute("memberList", memberService.findAll());
        return "admin/members";
    }

    @GetMapping("/join/member-info/{name}")
    public String goMember_info(@PathVariable("name") String name, Model model) {
        Member member = memberService.findByName(name);
        model.addAttribute("member", member);
        return "join/member-info";
    }



}
