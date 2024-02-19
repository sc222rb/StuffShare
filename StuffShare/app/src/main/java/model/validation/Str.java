package model.validation;

/**
 * compose validators.
 */
public class Str {
  /**
   * Checks if the length of the given string is at least 3 characters long.
   *
   * @param str the string to be checked for minimum length
   * @throws IllegalArgumentException if the length of the string is less than 3
   *                                  characters
   */
  public void checkMinLength(String str, String message) {
    if (str.length() < 3) {
      throw new IllegalArgumentException(message);
    }
  }

  /**
   * Checks if the given string contains only alphabetic characters.
   *
   * @param str the string to be checked for alphabetic characters
   * @throws IllegalArgumentException if the string contains non-alphabetic
   *                                  characters
   */
  public void checkIsCharacters(String str, String message) {
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isAlphabetic(str.charAt(i))) {
        throw new IllegalArgumentException(message);
      }
    }
  }

  /**
   * Checks if the given string is not null.
   *
   * @param str the string to be checked for nullity
   * @throws IllegalArgumentException if the string is null
   */
  public void checkNull(String str, String message) {
    if (str == null) {
      throw new IllegalArgumentException(message);
    }
  }

  /**
   * Validates if a given member ID is a 6 alpha-numeric character string.
   *
   * @param memberId the member ID to validate
   */
  public void validateMemberId(String memberId, String message) {
    String pattern = "^[a-zA-Z0-9]{6}$"; // regular expression pattern for 6 alpha-numeric characters
    if (!memberId.matches(pattern)) {
      throw new IllegalArgumentException(message);
    }
  }

}

