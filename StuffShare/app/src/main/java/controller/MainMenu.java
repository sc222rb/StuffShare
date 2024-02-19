package controller;

import java.util.Optional;

import model.Contract;
import model.Item;
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
    Member selectedMember = null;
    while (running) {
      try {
        if (selectedMember != null) {
          if (!doMemberMenu(selectedMember)) {
            selectedMember = null;
          }
        } else {
          Optional<MainMenuView.MainMenuEvent> action = mainMenuView.showMainMenu();

          if (!action.isPresent()) {
            mainMenuView.errorMessage("Unknown Command");
            continue;
          }

          switch (action.get()) {
            case AddMember:
              createNewMember();
              break;
            case SelectMember:
              selectedMember = memberView.getSelectedMember(lendingModel.getMembers());
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
        }
      } catch (Exception e) {
        // show the error and reset the application state
        mainMenuView.errorMessage(e.getMessage());
        selectedMember = null;
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

  private boolean doMemberMenu(Member selectedMember) {
    Item selectedItem = null;
    MemberView.Event action = memberView.showMemberMenu(selectedMember);
    switch (action) {
      default:
      case AddItem:
        createNewItem(selectedMember);
        break;
      case View:
        selectedItem = memberView.getSelectedItem(selectedMember.getItems());
        memberView.printItem(selectedItem);
        break;
      case Delete:
        selectedItem = memberView.getSelectedItem(selectedMember.getItems());
        selectedMember.deleteItem(selectedItem);
        break;
      case Edit:
        selectedItem = memberView.getSelectedItem(selectedMember.getItems());
        memberView.printItem(selectedItem);
        Item editedItem = memberView.editItem(selectedItem);
        selectedMember.replaceItem(selectedItem, editedItem);
        break;
      case RentItem:
        Member renter = selectedMember;
        Member owner = memberView.getSelectedMember(lendingModel.getMembers());
        selectedItem = memberView.getSelectedItem(owner.getItems());
        memberView.printItem(selectedItem);
        Contract newContract = memberView.rentItem(renter, selectedItem);
        if (selectedItem.checkCredits(newContract)
            && selectedItem.checkAvailability(newContract)) {
          selectedItem.addContract(newContract);
        } else {
          mainMenuView.errorMessage("Can't add contract.");
        }
        break;
      case Back:
        return false;
    }

    return true;
  }

  private void createNewItem(Member selectedMember) {
    model.Item newItem = memberView.createNewItem();
    selectedMember.addItem(newItem);
  }

}
