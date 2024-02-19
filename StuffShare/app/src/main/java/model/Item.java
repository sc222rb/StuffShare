package model;

import java.util.ArrayList;

/**
 * Represents a item.
 */
public class Item {

  /**
   * Represents the category.
   */
  public enum Category {
    Tool,
    Vehicle,
    Game,
    Toy,
    Sport,
    Other
  }

  private Category category;
  private String name;
  private String description;
  private int cost;
  private int dayOfCreation;
  protected ArrayList<Contract> contracts;

  /**
   * Initializing constructor.
   *
   * @param name the name of the item.  
   * @param description the description of the item.
   * @param dayOfCreation the day of creation of the item.
   * @param cost the cost per day of the item.
   */
  public Item(Category category, String name, String description, int cost, int dayOfCreation) {
    this.category = category;
    setNameProt(name);
    this.description = description;
    this.cost = cost;
    this.dayOfCreation = dayOfCreation;
    this.contracts = new ArrayList<>();
  }

  /**
   * Copy constructor.
   *
   * @param item the item to copy.
   */
  public Item(Item item) {
    category = item.category;
    name = item.name;
    description = item.description;
    cost = item.cost;
    dayOfCreation = item.dayOfCreation;
    contracts = new ArrayList<>(item.contracts.size());

    for (Contract c : item.contracts) {
      contracts.add(new Contract(c));
    }
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category newCategory) {
    category = newCategory;
  }

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    name = newName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String newDescription) {
    description = newDescription;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int newCost) {
    cost = newCost;
  }

  public int getDayOfCreation() {
    return dayOfCreation;
  }

  public void setDayOfCreation(int newDayOfCreation) {
    dayOfCreation = newDayOfCreation;
  }

  public Iterable<Contract> getContracts() {
    return new ArrayList<>(contracts);
  }

  public void addContract(Contract contract) {
    contracts.add(new Contract(contract));
  }

  /**
   * Checks if a new contract can be added without overlapping with any existing contracts.
   *
   * @param newContract the new contract to be checked
   * @return true if the new contract does not overlap with any existing contracts, false otherwise
   */
  public boolean checkAvailability(Contract newContract) {
    for (Contract contract : contracts) {
      if (contract.overlaps(newContract)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if a renter has enough credits to cover the cost of a new contract.
   *
   * @param newContract the new contract to be checked
   * @return true if the renter has enough credits to cover the cost, false otherwise
   */
  public boolean checkCredits(Contract newContract) {
    Member renter = newContract.getRenter();
    int renterCredits = renter.getCredits();
    int totalCost = newContract.calculateCost();
    if (renterCredits < totalCost) {
      return false;
    }
    return true;
  }


  protected void setNameProt(String newName) {
    model.validation.Str strv = new model.validation.Str();
    strv.checkNull(newName, "Name Cannot be null");
    strv.checkMinLength(newName, "Name cannot be too short");
    strv.checkIsCharacters(newName, "Must be characters");
    name = newName;
  }

  public boolean overlaps(Item other) {
    return this.getName().equals(other.getName());
  }
}
