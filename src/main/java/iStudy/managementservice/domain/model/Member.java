package iStudy.managementservice.domain.model;

import lombok.*;

@Data
public class Member {

    private String isAdmin = "false";
    private String id;
    private String pw;

    private String name;
    private Long age;
    private String grade;
    private String school;
    private String gender;
    private String tell;
    private String address;
    private String rgDate;
    private String pwString;

    private Calendar myCalendar;

    public Member(String isAdmin, String id, String pw, String name, Long age, String grade, String school, String gender, String tell,
                  String address, String rgDate, String pwString, Calendar calendar) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
        this.gender = gender;
        this.tell = tell;
        this.address = address;
        this.rgDate = rgDate;
        this.pwString = pwString;
        this.myCalendar = calendar;
    }


}
