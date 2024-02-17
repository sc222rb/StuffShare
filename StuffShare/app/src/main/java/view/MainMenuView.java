package view;

import java.util.Scanner;
import model.LendingModel;
import model.Member;

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

    return new Member(name, emailStr);
  }
}