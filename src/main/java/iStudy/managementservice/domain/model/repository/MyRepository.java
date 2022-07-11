package iStudy.managementservice.domain.model.repository;

import iStudy.managementservice.domain.model.Member;

import java.util.*;

@org.springframework.stereotype.Repository
class MyRepository implements Repository {

    private final Map<String, Member> members;  //Id, Member 키,밸류 구조
    private Long sequence;

    private MyRepository() {
        this.members = new HashMap<>();
        members.put("123", new Member("123", "123", "김용현", 20L, "e-1", "man", "123",
                     "123", "2022-01-01", "1234"));
        members.get("123").setIsAdmin("true");
        this.sequence = 0L;
    }

    @Override
    public Member create(String id, String pw, String name, Long age, String grade, String gender,
                         String tell, String address, String rgDate, String pwString) {

        Member newMember = new Member(id, pw, name, age, grade, gender, tell, address, rgDate, pwString);
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
