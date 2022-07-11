package iStudy.managementservice.domain.model.repository;

import iStudy.managementservice.domain.model.Member;

import java.util.List;

public interface Repository {
    public Member create(String id, String pw, String name, Long age, String grade, String gender,
                         String tell, String address, String rgDate, String pwString);
    public Member update(Member member);
    public Member delete(Member member);
    public Member findOne(String id);
    public List<Member> findAll();
    public void clear();
}
