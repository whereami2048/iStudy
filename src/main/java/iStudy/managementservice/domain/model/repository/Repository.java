package iStudy.managementservice.domain.model.repository;

import iStudy.managementservice.domain.model.Calendar;
import iStudy.managementservice.domain.model.Member;

import java.util.List;

public interface Repository {
    public Member create(String isAdmin, String id, String pw, String name, Long age, String grade, String school, String gender,
                         String tell, String address, String rgDate, String pwString, Calendar calendar);
    public Member update(Member member);
    public Member delete(Member member);
    public Member findOne(String id);
    public List<Member> findAll();
    public void clear();
}
