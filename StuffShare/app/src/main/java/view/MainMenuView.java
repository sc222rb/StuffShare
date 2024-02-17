package view;

import java.util.Scanner;
import model.LendingModel;
import model.Member;
import model.Member.Email;
import model.Member.PhoneNumber;

public class MainMenuView {
  public Scanner input;

  public MainMenuView(Scanner input) {
    this.input = input;
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
}