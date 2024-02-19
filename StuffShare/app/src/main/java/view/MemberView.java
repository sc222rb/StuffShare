package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;
import model.Item;
import model.Item.Category;
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

  public Member editMember(Member selectedMember) {
    System.out.println("Enter the name: ");
    final String name = input.nextLine();
    System.out.println("email: ");
    String emailStr = input.nextLine();
    System.out.println("phone number: ");
    String phoneNumberStr = input.nextLine();
    System.out.println("credits: ");
    int credits = Integer.parseInt(input.nextLine());
    int dayOfCreation = selectedMember.getDayOfCreation();
    Collection<Item> items = selectedMember.getItems();
    String id = selectedMember.getId();
    Email email = new Email(emailStr);
    PhoneNumber phoneNumber = new PhoneNumber(phoneNumberStr);

    return new Member(id, name, email, phoneNumber, credits, dayOfCreation, items);
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

  public Event showMemberMenu(Member selectedMember) {
    printMember(selectedMember);

    final String addString = "add";
    final String viewString = "view";
    final String deleteString = "delete";
    final String editString = "edit";
    final String rentItemString = "rent";
    final String backString = "b";

    System.out.println(" == Member Menu ==");
    System.out.println(" " + addString + " - Add an item");
    System.out.println(" " + deleteString + " - Delete an item");
    System.out.println(" " + viewString + " - View details");
    System.out.println(" " + editString + " - Edit an Item");
    System.out.println(" " + rentItemString + " - Rent an item");
    System.out.println(" " + backString + " - back");

    String choice = input.nextLine();

    if (choice.equals(backString)) {
      return Event.Back;
    } else if (choice.equals(addString)) {
      return Event.AddItem;
    } else if (choice.equals(viewString)) {
      return Event.View;
    } else if (choice.equals(editString)) {
      return Event.Edit;
    } else if (choice.equals(rentItemString)) {
      return Event.RentItem;
    } else {
      return Event.Delete;
    }
  }

  public Item createNewItem() {
    System.out.println("Category: Tool, Vehicle, Game, Toy, Sport or Other: ");
    final String categoryStr = input.nextLine();
    final Category category = Category.valueOf(categoryStr); // convert to enum
    System.out.println("New item's name: ");
    String name = input.nextLine();
    System.out.println("New item's descriotion: ");
    String description = input.nextLine();
    System.out.println("New item's cost: ");
    int cost = Integer.parseInt(input.nextLine());
    int dayOfCreation = 0;

    return new Item(category, name, description, cost, dayOfCreation);
  }

}
