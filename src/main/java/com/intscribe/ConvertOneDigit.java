package com.intscribe;

/**
 * This is the strategy we use for converting a single numerical digit.
 */
public class ConvertOneDigit implements ConversionStrategy {

  private int number;

  ConvertOneDigit(int number) {
    this.number = number;
  }

  /**
   * Converts the given number to a String representation of that number in English.
   * @return String - The word for the number in English.
   */
  @Override
  public String convertNumber() {
    if (WordsForNumbers.valueOf(this.number).isPresent()) {
      return WordsForNumbers.valueOf(this.number).get().getName();
    }
    return "";
  }
}
