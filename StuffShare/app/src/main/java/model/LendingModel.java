package model;

import model.Member.Email;
import model.Member.PhoneNumber;

public class LendingModel {
  public LendingModel() {

  }

  /**
   * Adds a new member to the system with the provided Name, Email, PhoneNumber,
   * if a member with the same Email address does not already exist in the system.
   *
   * @param name        The Name of the new member.
   * @param email       The Email address of the new member.
   * @param phoneNumber The PhoneNumber of the new member.
   * @return The new Member object if the member was successfully added.
   */
  public Member addNewMember(String id, String name, Email email, PhoneNumber phoneNumber) {
    Member m = new Member(id, name, email, phoneNumber);
    return m;
  }

  /**
   * Adds a new member to the registry.
   *
   * @param m The member data to use.
   * @return the new added member.
   */
  public Member addNewMember(Member member) {
    return addNewMember(member.generateMemberId(), member.getName(), member.getEmail(), member.getPhoneNumber());
  }
}
