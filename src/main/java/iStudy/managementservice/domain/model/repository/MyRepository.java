package iStudy.managementservice.domain.model.repository;

import iStudy.managementservice.domain.model.Calendar;
import iStudy.managementservice.domain.model.Member;
import org.springframework.lang.NonNull;

import java.util.*;

@org.springframework.stereotype.Repository
class MyRepository implements Repository {

    private final Map<String, Member> members;  //Id, Member 키,밸류 구조
    private Long sequence;

    private MyRepository() {
        this.members = new HashMap<>();
        members.put("123", new Member("false", "123", "123", "김용현", 23L, "e-1", "진성고", "man", "123", "123", "2022-01-01", "1234", null));
        members.get("123").setIsAdmin("true");
        this.sequence = 0L;
    }
    @Override
    public Member create(String isAdmin, String id, String pw, String name, Long age, String grade, String school, String gender,
                         String tell, String address, String rgDate, String pwString, Calendar calendar) {

        Member newMember = new Member(isAdmin, id, pw, name, age, grade, school, gender, tell, address, rgDate, pwString, calendar);
        members.put(newMember.getId(), newMember);
        this.sequence++;
        return newMember;
    }

    @Override
    public Member update(Member member) {
        return null;
    }

    @Override
    public Member delete(Member member) {
        Member deleteMember = members.remove(member.getTell());
        if(sequence>0)
            sequence--;
        return deleteMember;
    }

    @Override
    public Member findOne(String id) {
        return members.get(id);
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList<>(members.values());
    }

    @Override
    public void clear() {
        members.clear();
    }
}
