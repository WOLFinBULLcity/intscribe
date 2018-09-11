package com.intscribe;

import static com.intscribe.Constants.MAX_NUMBER_BEFORE_PREFIX;
import static com.intscribe.Constants.EMPTY;

/**
 * This is the strategy we use for converting a two digit numberAA.
 */
public class ConvertTwoDigits implements ConversionStrategy {

  private int number;

  ConvertTwoDigits(int number) {
    this.number = number;
  }

  /**
   * Converts the given number to a String representation of that number in English.
   * @return String - The word for the number in English.
   */
  @Override
  public String convertNumber() {
    // First check if the number is low enough to require no prefix.
    if (this.number <= MAX_NUMBER_BEFORE_PREFIX) {
      if (WordsForNumbers.valueOf(this.number).isPresent()) {
        return WordsForNumbers.valueOf(this.number).get().getName();
      }
      // If we get here something went wrong
      throw new IndexOutOfBoundsException("Unexpected number. Number outside of range: " + this.number);
    }
    int prefixDigit = this.number / 10;
    String prefix = "";

    // Check if we have a prefix word for this number.
    if (WordsForNumberPrefixes.valueOf(prefixDigit).isPresent()) {
      prefix = WordsForNumberPrefixes.valueOf(prefixDigit).get().getName();
    }

    int secondDigit = number % 10;
    String secondDigitWord = new ConvertOneDigit(secondDigit).convertNumber();

    // If we don't have a second digit, just return the prefix.
    // Otherwise, insert a space between the prefix and the second digit.
    return EMPTY.equals(secondDigitWord) ? prefix : prefix + " " + secondDigitWord;
  }
}
