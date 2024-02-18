package model;

import model.Member.Email;
import model.Member.PhoneNumber;

public class LendingModel {
  public LendingModel() {
    // some hard coded members for now
    Email email0 = new Email("allan@turing.com");
    PhoneNumber phoneNumber0 = new PhoneNumber("0731234567");
    Member member0 = new Member("123456", "Allan", email0,
        phoneNumber0);
    addNewMember(member0);

    Email email1 = new Email("Hamilton@lnu.se");
    PhoneNumber phoneNumber1 = new PhoneNumber("069283456");
    Member member1 = new Member("234567", "Margaret",
        email1, phoneNumber1);
    addNewMember(member1);

    Email email2 = new Email("Ben@gmail.com");
    PhoneNumber phoneNumber2 = new PhoneNumber("098234856");
    Member member2 = new Member("345678", "Ben", email2,
        phoneNumber2);
    addNewMember(member2);
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
