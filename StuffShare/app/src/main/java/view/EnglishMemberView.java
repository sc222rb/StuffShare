package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.Contract;
import model.Item;
import model.Item.Category;
import model.Member;
import model.Member.Email;
import model.Member.PhoneNumber;

/**
 * Implements a English Member view.
 */
public class EnglishMemberView implements MemberView {
  public Scanner input;

  public EnglishMemberView(Scanner input) {
    this.input = input;
  }

  @Override
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

  @Override
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

  @Override
  public void printMember(Member m) {
    System.out.println("Name: " + m.getName() + " Email: " + m.getEmail().emailStr());
    System.out.println("Credits: " + m.getCredits() + " Number of owned items: " + m.getItemCount());
  }

  @Override
  public void printMembers(Iterable<? extends Member> members) {
    ArrayList<Member> memberList = new ArrayList<>();
    members.forEach(memberList::add); // Copy elements to a new ArrayList
    sortByName(memberList); // Sort the new ArrayList
    for (Member m : memberList) {
      printMember(m);
    }
  }

  @Override
  public void printMemberVerbose(Member m) {
    System.out.println("Name : " + m.getName() + " Email: " + m.getEmail().emailStr());
    System.out.println("Info of all owned items: ");
    for (Item ownedItem : m.getItems()) {
      printItem(ownedItem);
    }
  }

  @Override
  public void printMembersVerbose(Iterable<? extends Member> members) {
    for (Member m : members) {
      printMemberVerbose(m);
    }
  }

  @Override
  public void printItem(Item item) {
    System.out.println(
        "Category: " + item.getCategory() + " name : " + item.getName() + ": " + item.getCost() + " Contracts: ");
    for (Contract contract : item.getContracts()) {
      System.out.println("Renter: " + contract.getRenter().getName());
      System.out.println("From day: " + contract.getStartingDay() + " To day: " + contract.getEndingDay());
    }
  }

  @Override
  public void printItems(Iterable<? extends Item> items) {
    for (Item item : items) {
      printItem(item);
    }
  }

  @Override
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

  @Override
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

  @Override
  public void errorMessage(String message) {
    System.out.println("\n=== Error! ===");
    System.out.println(message + "\n");
  }

  @Override
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

  @Override
  public Item editItem(Item selectedItem) {
    System.out.println("Category: Tool, Vehicle, Game, Toy, Sport or Other: ");
    final String categoryStr = input.nextLine();
    final Category category = Category.valueOf(categoryStr); // convert to enum
    System.out.println("Item's name: ");
    final String name = input.nextLine();
    System.out.println("Item's descriotion: ");
    String description = input.nextLine();
    System.out.println("Item's cost: ");
    int cost = Integer.parseInt(input.nextLine());
    System.out.println("Day of creation: ");
    int dayOfCreation = Integer.parseInt(input.nextLine());

    return new Item(category, name, description, cost, dayOfCreation);
  }

  @Override
  public <T extends Item> T getSelectedItem(Iterable<T> items) {
    int ix = 0;
    System.out.println("");
    for (Item item : items) {
      System.out.println("" + ix + " " + item.getName());
      ix++;
    }

    System.out.print("Enter item index to select: ");
    final int selected = Integer.parseInt(input.nextLine());

    ix = 0;
    for (T item : items) {
      if (ix == selected) {
        return item;
      }
      ix++;
    }

    return null;
  }

  @Override
  public Contract rentItem(Member renter, Item selectedItem) {
    System.out.println("Enter the starting day: ");
    int startingDay = Integer.parseInt(input.nextLine());
    System.out.println("Enter the ending day: ");
    int endingDay = Integer.parseInt(input.nextLine());

    return new Contract(renter, selectedItem, startingDay, endingDay);
  }

  /**
   * Sorts members by name.
   */
  public ArrayList<Member> sortByName(ArrayList<Member> members) {
    Collections.sort(members, Comparator.comparing(Member::getName));
    return members;
  }

}