package model;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a member of the library.
 */
public class Member {
  private String id;
  private String name; 
  private Email email;
  private PhoneNumber phoneNumber;


  /**
   * The Email class represents a valid email address in the format "x@y".
   * It provides methods for creating, retrieving, and comparing email addresses.
   */
  public static class Email {
    private String email;

    /**
     * Constructs an Email object with the given email address.
     *
     * @param email The email address to be validated and stored.
     * @throws IllegalArgumentException if the provided email is invalid.
     *                                  An email is considered valid if it:
     *                                  - Is not null.
     *                                  - Has a length of at least 3 characters.
     *                                  - Contains exactly one "@" symbol.
     *                                  - Both the part before and after "@" have
     *                                  lengths greater than 0.
     */
    public Email(String email) {
      var parts = email.split("@");
      if (email.length() < 3 || !email.contains("@") || parts.length != 2 || parts[0].length() < 1
          || parts[1].length() < 1) {
        throw new IllegalArgumentException("Email must be at least 3 characters and contain @ in the format x@y");
      }
      this.email = email;
    }

    /**
     * Returns the email address as a string.
     *
     * @return The email address.
     */
    public String emailStr() {
      return email;
    }

    /**
     * Compares this Email object to another object for equality.
     *
     * @param obj The object to compare to.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     *         Two Email objects are considered equal if their email addresses are
     *         the same,
     *         ignoring case differences.
     */
    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      Email other = (Email) obj;
      return email.equalsIgnoreCase(other.emailStr());
    }

    @Override
    public int hashCode() {
      return Objects.hash(email);
    }
  }

  /**
   * The PhoneNumber class represents a valid phone number.
   * It provides methods for creating, retrieving, and comparing phone numbers.
   */
  public static class PhoneNumber {
    private String phoneNumber;

    /**
     * Constructs a PhoneNumber object with the given phone number.
     *
     * @param phoneNumber The phone number to be validated and stored.
     * @throws IllegalArgumentException if the provided phone number is invalid.
     *                                  A phone number is considered valid if it is
     *                                  not null
     *                                  and has a length of at least 2 characters.
     */
    public PhoneNumber(String phoneNumber) {
      if (phoneNumber.length() < 8) {
        throw new IllegalArgumentException("Phone Number must be at least 8 numbers");
      }
      this.phoneNumber = phoneNumber;
    }

    public String phoneNumberStr() {
      return phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      PhoneNumber other = (PhoneNumber) obj;
      return phoneNumber.equalsIgnoreCase(other.phoneNumberStr());
    }

    @Override
    public int hashCode() {
      return Objects.hash(phoneNumber);
    }
  }

  /**
   * Constructs a new Member object with the provided Name, Email, and
   * PhoneNumber.
   * Initializes the member with zero credits, a creation day of 0, and an empty
   * list of owned items.
   *
   * @param name        The Name of the member.
   * @param email       The Email address of the member.
   * @param phoneNumber The PhoneNumber of the member.
   */
  public Member(String name, Email email, PhoneNumber phoneNumber) {
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public Member(String id, String name, Email email, PhoneNumber phoneNumber) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Email getEmail() {
    return email;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  protected String generateMemberId() {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      sb.append(characters.charAt(random.nextInt(characters.length())));
    }
    return sb.toString();
  }
}
