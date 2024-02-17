package model;

import model.Member.Email;
import model.Member.PhoneNumber;

public class LendingModel {
  public LendingModel() {

  }

  public Member addNewMember(String name, Email email, PhoneNumber phoneNumber) {
    Member m = new Member(name, email, phoneNumber);
    return m;
  }

  public Member addNewMember(Member member) {
    return addNewMember(member.getName(), member.getEmail(), member.getPhoneNumber());
  }
}
