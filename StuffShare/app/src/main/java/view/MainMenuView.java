package view;

import java.util.Optional;
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

  /**
   * Represents the main menu actions.
   */
  public static enum MainMenuEvent {
    AddMember
  }

  public Optional<MainMenuEvent> showMainMenu(){
    final String addString = "add";

    System.out.println(" == Main Menu ==");
    System.out.println(" " + addString + " - Add New Member");
    String choice = input.nextLine(); 

    switch (choice) {
      case addString:
        return Optional.of(MainMenuEvent.AddMember);
      default:
        return Optional.empty();
    }
  }
}