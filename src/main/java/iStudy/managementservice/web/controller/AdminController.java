package iStudy.managementservice.web.controller;

import iStudy.managementservice.domain.service.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @GetMapping("/updateclasses")
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
}
