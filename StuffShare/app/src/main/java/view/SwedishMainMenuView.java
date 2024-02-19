package view;

import java.util.Optional;
import java.util.Scanner;

/**
 * Implements a Swedish Main Menu view.
 */
public class SwedishMainMenuView implements MainMenuView {
  public Scanner input;

  public SwedishMainMenuView(Scanner input) {
    this.input = input;
  }

  @Override
  public Optional<MainMenuEvent> showMainMenu() {
    final int quitInt = 1;
    final int addInt = 2;
    final int selectInt = 3;
    final int deleteInt = 4;
    final int listInt = 5;
    final int editInt = 6;
    final int progressDaysInt = 7;

    System.out.println(" == Huvudmeny ==");
    System.out.println(" " + quitInt + " - Avsluta");
    System.out.println(" " + addInt + " - Lägg till ny medlem");
    System.out.println(" " + selectInt + " - Välj en medlem");
    System.out.println(" " + deleteInt + " - Radera en medlem");
    System.out.println(" " + listInt + " - Lista medlemmar");
    System.out.println(" " + editInt + " - Redigera en medlem");
    System.out.println(" " + progressDaysInt + " - Redigera framstegsdagar");

    int choice = Integer.parseInt(input.nextLine()); 

    switch (choice) {
      case 1:
        return Optional.of(MainMenuEvent.Quit);
      case 2:
        return Optional.of(MainMenuEvent.AddMember);
      case 3:
        return Optional.of(MainMenuEvent.SelectMember);
      case 4:
        return Optional.of(MainMenuEvent.DeleteMember);
      case 5:
        return Optional.of(MainMenuEvent.ListMembers);
      case 6:
        return Optional.of(MainMenuEvent.EditMember);
      case 7:
        return Optional.of(MainMenuEvent.ProgressDays);
      default:
        return Optional.empty();
    }
  }

  @Override
  public void errorMessage(String message) {
    System.out.println("\n=== Fel! ===");
    System.out.println(message + "\n");
  }
}
