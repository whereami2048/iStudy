package iStudy.managementservice.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
public class Member {

    private String isAdmin = "false";
    private String id;
    private String pw;

    private String name;
    private Long age;
    private String grade;
    private String gender;
    private String tell;
    private String address;
    private String rgDate;
    private String pwString;
    private Calendar myCalendar;

    public Member(String id, String pw, String name, Long age, String grade, String gender, String tell,
                  String address, String rgDate, String pwString, Calendar calendar) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.gender = gender;
        this.tell = tell;
        this.address = address;
        this.rgDate = rgDate;
        this.pwString = pwString;
        this.myCalendar = calendar;
    }


}
