package view;

import java.util.Scanner;

/**
 * Represents the console ui for the system.
 */
public class SystemView {
  public Scanner input;

  public SystemView(Scanner scanner) {
    input = scanner;
  }

  /**
   * Prompts the user to enter the number of days.
   *
   * @return the number of days entered by the user as an integer
   * @throws NumberFormatException if the input cannot be parsed as an integer
   */
  public int getProgressDays() throws NumberFormatException {
    System.out.println("How many days do you want to add?");
    int days = Integer.parseInt(input.nextLine());
    return days;
  }
}
