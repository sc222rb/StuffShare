package controller;

import java.util.Scanner;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.
   * 
   * @param args command line arguments.
   */
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in, "UTF8");
    view.MainMenuView mainMenu = new view.MainMenuView(scanner);

    model.LendingModel lendingModel = new model.LendingModel();
    controller.MainMenu mm = new controller.MainMenu(mainMenu, lendingModel);

    mm.doMainMenu();

    scanner.close();
  }

}