package view;

import java.util.Optional;

/**
 * Represents a console/terminal driven user interface.
 */
public interface MainMenuView {
  
  /**
   * Represents the main menu actions.
   */
  public static enum MainMenuEvent {
    AddMember,
    ListMembers,
    Quit,
    SelectMember,
    DeleteMember,
    EditMember,
    ProgressDays
  }

  /**
   * Shows the main menu.

   * @return the users selected action.
   */
  public Optional<MainMenuEvent> showMainMenu();

  public void errorMessage(String message);
}