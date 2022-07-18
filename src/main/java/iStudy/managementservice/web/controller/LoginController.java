package iStudy.managementservice.web.controller;

import iStudy.managementservice.domain.service.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    private final MemberServiceImpl memberService;

    private LoginController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    /*
    원생이 비밀번호 입력 후 전송 클릭 시 ajax로 입력한 비밀번호를 매핑된 url로 전송
    *************여기서 부터 미완성**************
    이후 컨트롤러 호출 후 컨트롤러에서 서비스 호출하여 비밀번호 일치 여부 판정
    맞으면 2xx 응답, 틀리면 4xx 응답
     */

    @PostMapping("/check-member")
    public String checkMember(@RequestBody String param) {
        System.out.println(param);

        return "join/login";
    }

    /*
        딘순 로그인 화면으로 이동
    */
    @GetMapping("/join/login")
    public String goLogin() {
//        System.out.println("요청 들어옴")
        return "/join/login";
    }

    /*
        로그인 시도 시
    */
    @PostMapping("/join/login")
    public String login(@RequestParam(required = false) String isAdmin, @RequestParam String id, @RequestParam String pw) {
        System.out.println(isAdmin);

        if (memberService.login(isAdmin, id, pw)) {   //아이디 비밀번호 매칭 성공 시
            System.out.println("환영합니다");
            if (isAdmin != null) {
                if (isAdmin.equals("on"))
                    return "redirect:/home/admin";
                else return "redirect:/home/normal";
            } else return "redirect:/home/normal";
        }else {
            System.out.println("아이디 혹은 비밀번호가 틀립니다.");
            return "/join/login";
        }
    }
}
