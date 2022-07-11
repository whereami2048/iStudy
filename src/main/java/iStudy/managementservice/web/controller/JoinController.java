package iStudy.managementservice.web.controller;

import iStudy.managementservice.domain.model.Member;
import iStudy.managementservice.domain.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/join")
public class JoinController {

    private final MemberServiceImpl memberService;

    @Autowired
    private JoinController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/add")
    public String goAddform() {
        return "join/addform";
    }

    @PostMapping("/add")
    public String joinMember(@ModelAttribute Member member, RedirectAttributes redirect) {
        System.out.println(member);
        memberService.join(member);
        redirect.addAttribute("name", member.getName());
        return "redirect:/join/member-info/{name}";
    }

    @GetMapping("/findidorpwd")
    public String findIdOrPwd(@RequestParam(required = false) String name, @RequestParam(required = false) String tell,
                              @RequestParam(required = false) String id, Model model) {
        model.addAttribute("printId", memberService.findId(name, tell));
        model.addAttribute("printPw", memberService.findPw(id));

        return "join/findidorpwd";
    }


}
