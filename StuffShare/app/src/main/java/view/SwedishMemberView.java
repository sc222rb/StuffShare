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
 * Implements a Swedish Member view.
 */
public class SwedishMemberView implements MemberView {
  public Scanner input;

  public SwedishMemberView(Scanner input) {
    this.input = input;
  }

  @Override
  public Member createNewMember() {
    System.out.println("Ange namn: ");
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
    System.out.println("Ange namn: ");
    final String name = input.nextLine();
    System.out.println("email: ");
    String emailStr = input.nextLine();
    System.out.println("mobilnummer: ");
    String phoneNumberStr = input.nextLine();
    System.out.println("poäng: ");
    String id = selectedMember.getId();
    int credits = Integer.parseInt(input.nextLine());
    int dayOfCreation = selectedMember.getDayOfCreation();
    Collection<Item> items = selectedMember.getItems();
    Email email = new Email(emailStr);
    PhoneNumber phoneNumber = new PhoneNumber(phoneNumberStr);

    return new Member(id, name, email, phoneNumber, credits, dayOfCreation, items);
  }

  @Override
  public void printMember(Member m) {
    System.out.println("Namn: " + m.getName() + " Email: " + m.getEmail().emailStr());
    System.out.println("Poäng: " + m.getCredits() + " Antal ägda varor: " + m.getItemCount());
  }

  @Override
  public void printMembers(Iterable<? extends Member> members) {
    ArrayList<Member> memberList = new ArrayList<>();
    members.forEach(memberList::add); // Copy elements to a new ArrayList
    sortById(memberList); // Sort the new ArrayList
    for (Member m : memberList) {
      printMember(m);
    }
  }

  @Override
  public void printMemberVerbose(Member m) {
    System.out.println("Namn : " + m.getName() + "Email: " + m.getEmail().emailStr());
    System.out.println("Info om alla ägda varor: ");
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
        "Kategory: " + item.getCategory() + " namn : " + item.getName() + ": " + item.getCost() + " Kontrakt: ");
    for (Contract contract : item.getContracts()) {
      System.out.println("uthyrare: " + contract.getRenter().getName());
      System.out.println("Från dag: " + contract.getStartingDay() + " Till dag: " + contract.getEndingDay());
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

    final String addString = "1";
    final String viewString = "2";
    final String deleteString = "3";
    final String editString = "4";
    final String rentItemString = "5";
    final String backString = "0";

    System.out.println(" == Medlemsmeny ==");
    System.out.println(" " + addString + " - Lägg till ett objekt");
    System.out.println(" " + deleteString + " - Radera ett objekt");
    System.out.println(" " + viewString + " - Visa detaljer");
    System.out.println(" " + editString + " - Redigera ett objekt");
    System.out.println(" " + rentItemString + " - Hyr ett objekt");
    System.out.println(" " + backString + " - tillbaka");

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

    System.out.print("Ange medlemsindex: ");
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
    System.out.println("\n=== Fel! ===");
    System.out.println(message + "\n");
  }

  @Override
  public Item createNewItem() {
    System.out.println("Kategory: Tool, Vehicle, Game, Toy, Sport eller Other: ");
    final String categoryStr = input.nextLine();
    final Category category = Category.valueOf(categoryStr); // convert to enum
    System.out.println("Namn på nytt objekt: ");
    final String name = input.nextLine();
    System.out.println("beskrivning: ");
    String description = input.nextLine();
    System.out.println("kostnad: ");
    int cost = Integer.parseInt(input.nextLine());
    System.out.println("Skapelsedagen: ");
    int dayOfCreation = 0;

    return new Item(category, name, description, cost, dayOfCreation);
  }

  @Override
  public Item editItem(Item selectedItem) {
    System.out.println("Kategory: Tool,Vehicle,Game,Toy,Sport or Other: ");
    final String categoryStr = input.nextLine();
    final Category category = Category.valueOf(categoryStr); // convert to enum
    System.out.println("Namn på nytt objekt: ");
    final String name = input.nextLine();
    System.out.println("beskrivning: ");
    String description = input.nextLine();
    System.out.println("kostnad: ");
    int cost = Integer.parseInt(input.nextLine());
    System.out.println("Skapelsedagen: ");
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

    System.out.print("index för objekt: ");
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
    System.out.println("Ange startdagen: ");
    int startingDay = Integer.parseInt(input.nextLine());
    System.out.println("slutdagen: ");
    int endingDay = Integer.parseInt(input.nextLine());

    return new Contract(renter, selectedItem, startingDay, endingDay);
  }

  /**
   * Sorts members by id.
   */
  public ArrayList<Member> sortById(ArrayList<Member> members) {
    Collections.sort(members, Comparator.comparing(Member::getId));
    return members;
  }

}