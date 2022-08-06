package iStudy.managementservice.web.controller;

import iStudy.managementservice.domain.service.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    MemberServiceImpl memberService;

    public AdminController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String goMembers() {
        return "admin/members";
    }

    @GetMapping("/attendances")
    public String goAttendances() {
        return "admin/attendances";
    }

    @GetMapping("/grades")
    public String goGrades() {
        return "admin/grades";
    }

    @GetMapping("/tuitions")
    public String goTuitions() {
        return "admin/tuitions";
    }

    @GetMapping("/classes")
    public String goClasses() {
        return "admin/classes";
    }

    @GetMapping("/meetings")
    public String goMeetings() {
        return "admin/meetings";
    }

    @GetMapping("/questions")
    public String goQuestions() {
        return "admin/questions";
    }


    //멤버에 있는 캘린더 클래스 정보를 호출함
    @ResponseBody
    @GetMapping("/render-classes")
    public List updateClasses() {
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> data = new HashMap<>();
        data.put("title", "Date1");
        data.put("start", "2022-07-06");
        data.put("end", "2022-07-07");
        dataList.add(data);
        Map<String, Object> data2 = new HashMap<>();
        data2.put("title", "Date2");
        data2.put("start", "2022-07-06");
        data2.put("end", "2022-07-07");
        dataList.add(data2);
        return dataList;
    }

    @GetMapping("/page")
    public String goPage() {
        return "admin/page";
    }
    //멤버 캘린더 수정 사항 발생 시 호출
//    @ResponseBody
//    @PostMapping("/update-calendar")
//    public String updateCalendar() {
//
//    }
}
