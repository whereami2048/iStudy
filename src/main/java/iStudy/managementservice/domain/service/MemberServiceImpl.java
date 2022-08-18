package iStudy.managementservice.domain.service;
import iStudy.managementservice.domain.model.Calendar;
import iStudy.managementservice.domain.model.Member;

import iStudy.managementservice.domain.model.repository.Repository;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class MemberServiceImpl {
    private final Repository repository;

    @Autowired
    private MemberServiceImpl(Repository repository) {
        this.repository = repository;
    }

    public Member join(Member member) {
        System.out.println("멤버에 추가되었습니다.");
        repository.create(member.getIsAdmin(), member.getId(), member.getPw(), member.getName(), member.getAge(), member.getGrade(), member.getSchool(),
                member.getGender(), member.getTell(), member.getAddress(), member.getRgDate(), member.getPwString(), new Calendar());
        System.out.println(repository.findOne(member.getId()));
        return member;
    }

    /*
    로그인 시도 시 호출한다.
    id,pw,isAdmin 값을 인자로 넘겨받아 repository에서 해당 아이디와 비번을 가진 멤버가 있는지 조회 후
    있으면 true 없으면 false를 반환한다.
     */

    public boolean login(String isAdmin, String id, String pw) {
        if (repository.findOne(id) != null) {   //멤버가 있는 경우
            Member guest = repository.findOne(id);
            if (guest.getPw().equals(pw)) {  //비밀번호도 일치하는 경우
                if (isAdmin != null) {  //관리자 로그인인 경우
                    if (isAdmin.equals("on")) {
                        if (guest.getIsAdmin().equals("true")) { //해당 아이디가 관리자인 경우
                            System.out.println("로그인 성공" + id + ", " + pw);
                            return true;
                        }else return false;
                    }else return false;
                }else{  //일반 사용자인 경우
                    System.out.println("로그인 성공" + id + ", " + pw);
                    return true;
                }
            } else{
                System.out.println("비밀번호가 일치하지 않습니다.");
                return false;
            }
        } else {
            System.out.println("해당 아이디가 존재하지 않습니다.");
            return false;
        }
    }

    public boolean checkMember(String pwString) {
        return false;
    }

    /* 회원가입 시 입력한 이름과 연락처를 입력하면 아이디를 반환한다.
    */
    public String findId(String name, String tell) {
        List<Member> members = repository.findAll();
        for (Member member : members) {
            if (member.getName().equals(name)) {
                if (member.getTell().equals(tell)) {
                    return member.getId();
                }
            }
        }
        return "존재하지 않습니다.";
    }

    /* 회원가입 시 입력한 아이디를 입력하면 해당 아이디 존재 여부 확인후
       존재할 시 해당하는 아이디의 비밀번호를 반환한다.
     */
    public String findPw(String id) {
        Member findMember = repository.findOne(id);
        if(findMember != null)
            return findMember.getPw();
        else return "존재하지 않습니다.";
    }

    public Member findByName(String name) {
        List<Member> members = repository.findAll();
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public Member findById(String id) {
        List<Member> members = repository.findAll();
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    /* repository에 저장돼 있는 모든 원생 정보를 List 형태로 불러온다
    *  리스트 반환 전 학년과 성별 정보를 한글로 변환한 뒤 return 한다
    *  변환 형태는 ex) 학년 -> 초 1, 성별 -> 남 or 여
    */
    public List findAll() {
        List<Member> members = cloneMemberList(repository.findAll());

        for (Member member: members) {
            if (member.getGender().equals("man")) {
                member.setGender("남");
            }else {
                member.setGender("여");
            }

            StringTokenizer st = new StringTokenizer(member.getGrade(), "-");
            String grade = st.nextToken();
            String gradeNumber = st.nextToken();

            switch (grade) {
                case "e":
                    member.setGrade("초등 " + Integer.parseInt(gradeNumber));
                case "m":
                    member.setGrade("중등 " + Integer.parseInt(gradeNumber));
                case "h":
                    member.setGrade("고등 " + Integer.parseInt(gradeNumber));
            }
        }
        return members;
    }

    public List<Member> cloneMemberList(List<Member> originList) {
        List<Member> copyList = new ArrayList<>();
        for (Member member: originList) {
            copyList.add(new Member(member.getIsAdmin(), member.getId(), member.getPw(), member.getName(), member.getAge(),
                        member.getGrade(), member.getSchool(), member.getGender(), member.getTell(), member.getAddress(),
                        member.getRgDate(), member.getPwString(), member.getMyCalendar()));
        }
        return copyList;
    }
}
