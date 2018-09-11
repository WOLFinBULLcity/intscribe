package com.intscribe;

import static com.intscribe.Constants.EMPTY;
import static com.intscribe.Constants.HUNDRED;

/**
 * This is the strategy we use for converting a three digit number.
 */
public class ConvertThreeDigits implements ConversionStrategy {

  private int number;

  ConvertThreeDigits(int number) {
    this.number = number;
  }

  /**
   * Converts the given number to a String representation of that number in English.
   * @return String - The word for the number in English.
   */
  @Override
  public String convertNumber() {

    int firstDigit = this.number / 100;
    int lastDigits = this.number % 100;

    // Check if we have a prefix word for this number.
    String prefix = "";
    if (firstDigit > 0) {
      prefix += (new ConvertOneDigit(firstDigit).convertNumber() + " " + HUNDRED);
    }

    // Get the words for the remaining digits.
    String moreDigits = new ConvertTwoDigits(lastDigits).convertNumber();

    // Check if we have both prefix and digit words. If so, we'll need to insert a space.
    boolean spaceRequired = !EMPTY.equals(prefix) && !EMPTY.equals(moreDigits);
    String spaceIfNeeded = spaceRequired ? " " : "";

    // Piece together the prefix with the remaining digits.
    return prefix + spaceIfNeeded + moreDigits;
  }
}
