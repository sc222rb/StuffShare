package model;

/**
 * Represents a contract in the stuff lending.
 */
public class Contract {
  private Member renter;
  private Item item;
  private int startingDay;
  private int endingDay;
  
  /**
   * Constructs a Contract object with the specified renter, item, starting day and ending day.
   *
   * @param renter the Member who is renting the Item
   * @param item the Item being rented
   * @param startingDay the starting day of the rental period (inclusive)
   * @param endingDay the ending day of the rental period (inclusive)
   */
  public Contract(Member renter, Item item, int startingDay, int endingDay) {
    this.renter = new Member(renter);
    this.item = new Item(item);
    this.startingDay = startingDay;
    this.endingDay = endingDay;
  }

  /**
   * Deep copy constructor.
   *
   * @param contract the contract to copy.
   */
  public Contract(Contract contract) {
    renter = contract.renter;
    item = contract.item;
    startingDay = contract.startingDay;
    endingDay = contract.endingDay;
  }

  public Member getRenter() {
    return new Member(renter);
  }

  public int getStartingDay() {
    return startingDay;
  }

  public int getEndingDay() {
    return endingDay;
  }

  /**
   * Calculates the cost of payment.
   */
  public int calculateCost() {
    int lendingDays = this.endingDay - this.startingDay;
    int cost = item.getCost();
    int totalCost = cost * lendingDays;
    return totalCost;
  }

  public boolean overlaps(Contract other) {
    return this.getEndingDay() >= other.getStartingDay() && other.getEndingDay() >= this.getStartingDay();
  }

}

