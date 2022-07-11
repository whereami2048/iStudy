package iStudy.managementservice.domain.service;
import iStudy.managementservice.domain.model.Member;

import iStudy.managementservice.domain.model.repository.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MemberServiceImpl {
    private final Repository repository;

    @Autowired
    private MemberServiceImpl(Repository repository) {
        this.repository = repository;
    }

    public Member join(Member member) {
        System.out.println("멤버에 추가되었습니다.");
        repository.create(member.getId(), member.getPw(), member.getName(), member.getAge(), member.getGrade(),
                member.getGender(), member.getTell(), member.getAddress(), member.getRgDate(), member.getPwString());
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
}
