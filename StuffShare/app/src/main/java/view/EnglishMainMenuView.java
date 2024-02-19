package view;

import java.util.Optional;
import java.util.Scanner;

/**
 * Implements a English Main Menu view.
 */
public class EnglishMainMenuView implements MainMenuView {
  public Scanner input;

  public EnglishMainMenuView(Scanner input) {
    this.input = input;
  }

  @Override
  public Optional<MainMenuEvent> showMainMenu() {
    final String quitString = "quit";
    final String addString = "add";
    final String selectString = "select";
    final String deleteString = "delete";
    final String listString = "list";
    final String editString = "edit";
    final String progressDaysString = "progressDays";

    System.out.println(" == Main Menu ==");
    System.out.println(" " + addString + " - Add New Member");
    System.out.println(" " + listString + " - List Members");
    System.out.println(" " + selectString + " - Select a Member");
    System.out.println(" " + editString + " - Edit a member");
    System.out.println(" " + deleteString + " - Delete a Member");
    System.out.println(" " + progressDaysString + " - Edit Progress days");
    System.out.println(" " + quitString + " - Quit");

    String choice = input.nextLine(); 

    switch (choice) {
      case quitString:
        return Optional.of(MainMenuEvent.Quit);
      case addString:
        return Optional.of(MainMenuEvent.AddMember);
      case selectString:
        return Optional.of(MainMenuEvent.SelectMember);
      case editString:
        return Optional.of(MainMenuEvent.EditMember);
      case deleteString:
        return Optional.of(MainMenuEvent.DeleteMember);
      case listString:
        return Optional.of(MainMenuEvent.ListMembers);
      case progressDaysString:
        return Optional.of(MainMenuEvent.ProgressDays);
      default:
        return Optional.empty();
    }
  }

  @Override
  public void errorMessage(String message) {
    System.out.println("\n=== Error! ===");
    System.out.println(message + "\n");
  }
}