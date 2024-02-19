package model;

import java.util.ArrayList;
import java.util.List;
import model.Member.Email;
import model.Member.PhoneNumber;

public class LendingModel {

  private List<Member> registeredMembers = new ArrayList<Member>();

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

  public Iterable<Member> getMembers() {
    return new ArrayList<>(registeredMembers);
  }

  /**
   * Adds a new member to the system with the provided Name, Email, PhoneNumber,
   * if a member with the same Email address does not already exist in the system.
   *
   * @param name        The Name of the new member.
   * @param email       The Email address of the new member.
   * @param phoneNumber The PhoneNumber of the new member.
   * @return The newly added Member object if it was successfully added, or null
   *         if a member with the same Email address already exists in the system.
   */
  public Member addNewMember(String id, String name, Email email, PhoneNumber phoneNumber) {
    for (Member member : registeredMembers) {
      if (member.getEmail().equals(email)) {
        throw new IllegalArgumentException("Email is already registered");
      }
      if (member.getPhoneNumber().equals(phoneNumber)) {
        throw new IllegalArgumentException("Phone Number is already registered");
      }
    }
    Member m = new Member(id, name, email, phoneNumber);
    registeredMembers.add(m);
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

  /**
   * Deletes a member from the registry.
   *
   * @param member The member data to use.
   */
  public void deleteMember(Member member) {
    registeredMembers.remove(member);
  }

}
