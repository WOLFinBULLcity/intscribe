package com.intscribe;

import static com.intscribe.Constants.MAX_NUMBER_FOR_CONVERSION;
import static com.intscribe.Constants.MIN_NUMBER_FOR_CONVERSION;
import static com.intscribe.Constants.NEGATIVE;
import static com.intscribe.Constants.THOUSAND;
import static com.intscribe.Constants.ZERO;

/**
 * This is the strategy we use for converting an integer up to 6 digits
 */
public class ConvertAllDigits implements ConversionStrategy {

  private int number;
  private String sign;

  ConvertAllDigits(int number) {
    // Validate the number
    if (number < MIN_NUMBER_FOR_CONVERSION || number > MAX_NUMBER_FOR_CONVERSION) {
      throw new IllegalArgumentException("Number not in range [-999999..999999]: " + number);
    }

    this.sign = "";
    if (number < 0) {
      this.sign += (NEGATIVE + " ");
      number = Math.abs(number);
    }
    this.number = number;
  }

  /**
   * Converts the given number to a String representation of that number in English.
   * @return String - The word for the number in English.
   */
  @Override
  public String convertNumber() {
    if (this.number == 0) {
      return ZERO;
    }

    String thousandsWords = "";
    String hundredsWords = "";

    // Divide by 1000 to see if we have any thousands digits to convert.
    int thousandsDigits = this.number / 1000;

    if (thousandsDigits > 0) {
      // We have more than 3 digits, convert the thousands digits.
      thousandsWords += new ConvertThreeDigits(thousandsDigits).convertNumber();
      thousandsWords += (" " + THOUSAND + " ");
    }

    // Mod by 1000 to see if we have an hundreds digits to convert.
    int hundredsDigits = this.number % 1000;

    if (hundredsDigits > 0) {
      hundredsWords += new ConvertThreeDigits(hundredsDigits).convertNumber();
    }

    String result = sign + thousandsWords + hundredsWords;

    // Trim any trailing whitespace that can occur for certain numbers.
    return result.trim();
  }
}
