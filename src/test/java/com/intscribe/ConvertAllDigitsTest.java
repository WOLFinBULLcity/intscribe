package com.intscribe;

import static com.intscribe.Constants.ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConvertAllDigitsTest {

  @ParameterizedTest
  @CsvSource({
      "7, seven",
      "10, ten",
      "15, fifteen",
      "21, twenty one",
      "37, thirty seven",
      "60, sixty",
      "99, ninety nine",
      "100, one hundred",
      "101, one hundred one",
      "111, one hundred eleven",
      "330, three hundred thirty",
      "999, nine hundred ninety nine",
      "1000, one thousand",
      "1100, one thousand one hundred",
      "1001, one thousand one",
      "1101, one thousand one hundred one",
      "44101, forty four thousand one hundred one",
      "12345, twelve thousand three hundred forty five",
      "80008, eighty thousand eight",
      "123456, one hundred twenty three thousand four hundred fifty six",
      "-1, negative one",
      "0, zero",
      "-11, negative eleven",
      "-1000, negative one thousand",
      "-99999, negative ninety nine thousand nine hundred ninety nine",
      "999999, nine hundred ninety nine thousand nine hundred ninety nine",
      "-999999, negative nine hundred ninety nine thousand nine hundred ninety nine"
  })
  void convertNumberTest_SeveralValues(int input, String output) {
    assertEquals(output, new ConvertAllDigits(input).convertNumber());
  }

  @Test
  void convertNumberTest_ZeroIsEmpty() {
    assertEquals(ZERO, new ConvertAllDigits(0).convertNumber());
  }
}