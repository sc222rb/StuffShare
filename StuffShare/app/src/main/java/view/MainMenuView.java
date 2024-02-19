package view;

import java.util.Optional;
import java.util.Scanner;

public class MainMenuView {
  public Scanner input;

  public MainMenuView(Scanner input) {
    this.input = input;
  }

  /**
   * Represents the main menu actions.
   */
  public static enum MainMenuEvent {
    AddMember,
    ListMembers,
    Quit,
    DeleteMember
  }

  public Optional<MainMenuEvent> showMainMenu() {
    final String quitString = "quit";
    final String addString = "add";
    final String deleteString = "delete";
    final String listString = "list";

    System.out.println(" == Main Menu ==");
    System.out.println(" " + addString + " - Add New Member");
    System.out.println(" " + listString + " - List Members");
    System.out.println(" " + deleteString + " - Delete a Member");
    System.out.println(" " + quitString + " - Quit");
    System.out.println(" ==============");

    String choice = input.nextLine();

    switch (choice) {
      case quitString:
        return Optional.of(MainMenuEvent.Quit);
      case addString:
        return Optional.of(MainMenuEvent.AddMember);
      case deleteString:
        return Optional.of(MainMenuEvent.DeleteMember);
      case listString:
        return Optional.of(MainMenuEvent.ListMembers);
      default:
        return Optional.empty();
    }
  }

  public void errorMessage(String message) {
    System.out.println("\n=== Error! ===");
    System.out.println(message + "\n");
  }
}