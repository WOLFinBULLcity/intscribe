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

    String prefix = "";
    if (firstDigit > 0) {
      prefix += (new ConvertOneDigit(firstDigit).convertNumber() + " " + HUNDRED);
    }

    String moreDigits = new ConvertTwoDigits(lastDigits).convertNumber();

    boolean spaceRequired = !EMPTY.equals(prefix) && !EMPTY.equals(moreDigits);
    String spaceIfNeeded = spaceRequired ? " " : "";

    return prefix + spaceIfNeeded + moreDigits;
  }
}
