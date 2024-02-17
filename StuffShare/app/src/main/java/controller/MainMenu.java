package controller;

import model.LendingModel;
import view.MainMenuView;

public class MainMenu {
  private final view.MainMenuView mainMenuView;
  private final model.LendingModel lendingModel;

  public MainMenu(MainMenuView mainMenuView, LendingModel lendingModel) {
    this.mainMenuView = mainMenuView;
    this.lendingModel = new model.LendingModel();
  }

  public void doMainMenu() {
    createNewMember();
  }

  private void createNewMember() {
    model.Member newMember = mainMenuView.createNewMember();
    model.Member m = lendingModel.addNewMember(newMember);
    System.out.println(m.getName() + " has been added to the library system.");
  }

}
