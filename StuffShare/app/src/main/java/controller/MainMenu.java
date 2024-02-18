package controller;

import model.LendingModel;
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

  public void doMainMenu() {
    createNewMember();
  }

  private void createNewMember() {
    model.Member newMember = memberView.createNewMember();
    model.Member createdmember = lendingModel.addNewMember(newMember);
    memberView.printMember(createdmember);
  }

}
