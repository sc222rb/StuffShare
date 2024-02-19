package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Item.Category;
import model.Member.Email;
import model.Member.PhoneNumber;

public class LendingModel {

  private List<Member> registeredMembers = new ArrayList<Member>();

  public LendingModel() {
    // some hard coded members for now
    ArrayList<Item> items0 = new ArrayList<Item>();
    Email email0 = new Email("allan@turing.com");
    PhoneNumber phoneNumber0 = new PhoneNumber("0731234567");
    items0.add(new Item(Category.Tool, "hammar", "hammering", 20, 0));
    Member member0 = new Member("123456", "Allan", email0,
        phoneNumber0, 20, 0, items0);
    addNewMember(member0);

    ArrayList<Item> items1 = new ArrayList<Item>();
    Email email1 = new Email("Hamilton@lnu.se");
    PhoneNumber phoneNumber1 = new PhoneNumber("069283456");
    items1.add(new Item(Category.Vehicle, "car", "yellow", 30, 0));
    Member member1 = new Member("234567", "Margaret",
        email1, phoneNumber1, 30, 0, items1);
    addNewMember(member1);

    ArrayList<Item> items2 = new ArrayList<Item>();
    Email email2 = new Email("Ben@gmail.com");
    PhoneNumber phoneNumber2 = new PhoneNumber("098234856");
    items2.add(new Item(Category.Game, "switch", "tv-game", 200, 3));
    Member member2 = new Member("345678", "Ben", email2,
        phoneNumber2, 20, 0, items2);
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
   * @param credits       The initial credit balance for the new member.
   * @param dayOfCreation The day when the member was created.
   * @param ownedItems    The collection of items owned by the new member.
   * @return The newly added Member object if it was successfully added, or null
   *         if a member with the same Email address already exists in the system.
   */
  public Member addNewMember(String id, String name, Email email, PhoneNumber phoneNumber, int credits,
  int dayOfCreation,
  Collection<Item> ownedItems) {
    for (Member member : registeredMembers) {
      if (member.getEmail().equals(email)) {
        throw new IllegalArgumentException("Email is already registered");
      }
      if (member.getPhoneNumber().equals(phoneNumber)) {
        throw new IllegalArgumentException("Phone Number is already registered");
      }
    }
    Member m = new Member(id, name, email, phoneNumber, credits, dayOfCreation, ownedItems);
    registeredMembers.add(m);
    return m;
  }

  /**
   * Adds a new member to the registry.
   *
   * @param m The member data to use.
   * @return the new added member.
   */
  public Member addNewMember(Member m) {
    return addNewMember(m.generateMemberId(), m.getName(), m.getEmail(), m.getPhoneNumber(), m.getCredits(), m.getDayOfCreation(), m.getItems());
  }

  /**
   * Deletes a member from the registry.
   *
   * @param member The member data to use.
   */
  public void deleteMember(Member member) {
    registeredMembers.remove(member);
  }

  /**
   * Edits a member from the registry.
   *
   * @param editedMember The member data to use.
   */
  public void editMember(Member editedMember) {
    String id = editedMember.getId();
    Email email = editedMember.getEmail();
    PhoneNumber phoneNumber = editedMember.getPhoneNumber();
    for (Member member : registeredMembers) {
      if (!id.equals(member.getId())) {
        if (member.getEmail().equals(email)) {
          throw new IllegalArgumentException("Email is already registered");
        }
        if (member.getPhoneNumber().equals(phoneNumber)) {
          throw new IllegalArgumentException("Phone Number is already registered");
        }
      }
    }
    for (int i = 0; i < registeredMembers.size(); i++) {
      Member m = registeredMembers.get(i);
      if (m != null && id.equals(m.getId())) {
        // Replace the existing member with the edited member
        registeredMembers.set(i, editedMember);
        return; // Exit the loop once the member is updated
      }
    }
    return;
  }
}
