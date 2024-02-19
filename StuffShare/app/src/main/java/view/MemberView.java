package view;

import model.Contract;
import model.Item;
import model.Member;

/**
 * Represents the console ui for members.
 */
public interface MemberView {

  /**
   * Represents the member menu actions.
   */
  public static enum Event {
    AddItem,
    View,
    Delete,
    Edit,
    RentItem,
    Back
  }

  /**
   * Prompts the user to input data for a new member.
   *
   * @return the member data as a member object.
   */
  public Member createNewMember();

  /**
   * Prompts the user to input data for a member.
   *
   * @return the member data as a member object.
   */
  public Member editMember(Member selectedMember);

  public void printMember(model.Member m);

  /**
   * Prints all the members.

   * @param members the members to print.
   */
  public void printMembers(Iterable<? extends Member> members);

  public void printMemberVerbose(model.Member m);

  /**
   * Prints all the members.
   *
   * @param members the members to print.
   */
  public void printMembersVerbose(Iterable<? extends Member> members);

  /**
   * Prints the item.
   *
   * @param item the item to print.
   */
  public void printItem(model.Item item);

  /**
   * Prints all the items for the specific member.

   * @param items the members to print.
   */
  public void printItems(Iterable<? extends Item> items);

  /**
   * Shows the member submenu.
   *
   * @param selectedMember member that the menu applies for.
   *
   * @return the sub menu action.
   */
  public Event showMemberMenu(Member selectedMember);

  /**
   * UI for selecting a specific member out of a collection.
   *
   * @param members collection of members
   * @return the selected member or null if none is selected.
   */
  public <T extends Member> T getSelectedMember(Iterable<T> members);

  public void errorMessage(String message);

  /**
   * Prompts the user to input data for a new item.
   *
   * @return the item data as a item object.
   */
  public Item createNewItem();

  /**
   * Edits the user to input data for a selected item.
   *
   * @return the item data as a item object.
   */
  public Item editItem(Item selectedItem);

  /**
   * UI for selecting a specific item out of a collection.
   *
   * @param items collection of items
   * @return the selected item or null if none is selected.
   */
  public <T extends Item> T getSelectedItem(Iterable<T> items);

  /**
   * Prompts the user to input data for creating new contract.
   *
   * @return the contract date.
   */
  public Contract rentItem(Member renter, Item selectedItem);

}
