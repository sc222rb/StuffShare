package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Member;
import model.Member.Email;
import model.Member.PhoneNumber;

/**
 * Represents the console ui for members.
 */
public class MemberView {
  public Scanner input;

  public MemberView(Scanner input) {
    this.input = input;
  }

  /**
   * Represents the member menu actions.
   */
  public static enum Event {
    AddItem,
    View,
    Delete,
    Edit,
    RentItem,
    Back
  }

  public Member createNewMember() {
    System.out.println("Enter the name: ");
    String name = input.nextLine();
    System.out.println("email: ");
    String emailStr = input.nextLine();
    Email email = new Email(emailStr);
    System.out.println("phone number: ");
    String phoneNumberStr = input.nextLine();
    PhoneNumber phoneNumber = new PhoneNumber(phoneNumberStr);

    return new Member(name, email, phoneNumber);
  }

  public void printMember(Member m) {
    System.out.println("Name: " + m.getName() + " Email: " + m.getEmail().emailStr());
  }

  /**
   * Prints all the members.
   * 
   * @param members the members to print.
   */
  public void printMembers(Iterable<? extends Member> members) {
    ArrayList<Member> memberList = new ArrayList<>();
    members.forEach(memberList::add); // Copy elements to a new ArrayList
    for (Member m : memberList) {
      printMember(m);
    }
  }

  public void printMemberVerbose(Member m) {
    System.out.println("Name : " + m.getName() + " Email: " + m.getEmail().emailStr());
  }

  public void printMembersVerbose(Iterable<? extends Member> members) {
    for (Member m : members) {
      printMemberVerbose(m);
    }
  }

  public <T extends Member> T getSelectedMember(Iterable<T> members) {
    int ix = 0;
    System.out.println("");
    for (Member m : members) {
      System.out.println("" + ix + " " + m.getName() + " id: " + m.getId());
      ix++;
    }

    System.out.print("Enter member index to select: ");
    final int selected = Integer.parseInt(input.nextLine());

    ix = 0;
    for (T m : members) {
      if (ix == selected) {
        return m;
      }
      ix++;
    }

    return null;
  }

}
