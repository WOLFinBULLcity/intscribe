package com.intscribe;

import static com.intscribe.Constants.MAX_NUMBER_FOR_CONVERSION;
import static com.intscribe.Constants.MIN_NUMBER_FOR_CONVERSION;

public class IntscribeMain {

  public static void main(String[] args) {
    int numberToConvert = Integer.parseInt(args[0]);

    // Make sure the number is in the valid range.
    if (numberToConvert < MIN_NUMBER_FOR_CONVERSION ||
        numberToConvert > MAX_NUMBER_FOR_CONVERSION) {
      System.out.println("Number not in range [-999999..999999]: " + numberToConvert);
      System.exit(0);
    }

    System.out.println(new ConvertAllDigits(numberToConvert).convertNumber());
  }
}
