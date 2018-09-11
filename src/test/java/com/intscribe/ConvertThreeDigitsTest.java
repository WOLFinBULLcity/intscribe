package com.intscribe;

import static com.intscribe.Constants.EMPTY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConvertThreeDigitsTest {

  @ParameterizedTest
  @CsvSource({
      "7, seven",
      "8, eight",
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
      "999, nine hundred ninety nine"

  })
  void convertNumberTest_SeveralValues(int input, String output) {
    assertEquals(output, new ConvertThreeDigits(input).convertNumber());
  }

  @Test
  void convertNumberTest_ZeroIsEmpty() {
    assertEquals(EMPTY, new ConvertThreeDigits(0).convertNumber());
  }
}