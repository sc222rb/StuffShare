package controller;

import java.util.Optional;
import model.LendingModel;
import model.Member;
import view.MainMenuView;
import view.MemberView;

public class MainMenu {
  private final view.MainMenuView mainMenuView;
  private final view.MemberView memberView;
  private final model.LendingModel lendingModel;

  public MainMenu(MainMenuView mainMenuView, view.MemberView mv, LendingModel lendingModel) {
    this.mainMenuView = mainMenuView;
    this.memberView = mv;
    this.lendingModel = new model.LendingModel();
  }

  /**
   * Starts the application.
   */
  public void doMainMenu() {
    boolean running = true;
    while (running) {
      try {
        Optional<MainMenuView.MainMenuEvent> action = mainMenuView.showMainMenu();

        switch (action.get()) {
          case AddMember:
            createNewMember();
            break;
          case EditMember:
            editMember();
            break;
          case DeleteMember:
            deleteMember();
            break;
          case ListMembers:
            listMembers();
            break;
          case Quit:
            running = false;
            break;
          default:
            memberView.printMembers(lendingModel.getMembers());
            break;
        }
      } catch (Exception e) {
        // show the error and reset the application state
        mainMenuView.errorMessage(e.getMessage());
      }
    }
  }

  private void listMembers() {
    memberView.printMembers(lendingModel.getMembers());
  }

  private void deleteMember() {
    model.Member deleteMember = memberView.getSelectedMember(lendingModel.getMembers());
    lendingModel.deleteMember(deleteMember);
  }

  private void editMember() {
    model.Member editMember = memberView.getSelectedMember(lendingModel.getMembers());
    model.Member editedMember = memberView.editMember(editMember);
    lendingModel.editMember(editedMember);
    memberView.printMember(editedMember);
  }

  private void createNewMember() {
    model.Member newMember = memberView.createNewMember();
    model.Member createdmember = lendingModel.addNewMember(newMember);
    memberView.printMember(createdmember);
  }

}
