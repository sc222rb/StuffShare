package model;

public class LendingModel {
  public LendingModel() {

  }

  public Member addNewMember(String name, String email) {
    Member m = new Member(name, email);
    return m;
  }

  public Member addNewMember(Member member) {
    return addNewMember(member.getName(), member.getEmail());
  }
}
