package com.intscribe;

import static com.intscribe.Constants.EMPTY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConvertTwoDigitsTest {

  @ParameterizedTest
  @CsvSource({
      "1, one",
      "3, three",
      "7, seven",
      "8, eight",
      "9, nine",
      "10, ten",
      "11, eleven",
      "15, fifteen",
      "21, twenty one",
      "37, thirty seven",
      "60, sixty",
      "99, ninety nine"
  })
  void convertNumberTest_SeveralValues(int input, String output) {
    assertEquals(output, new ConvertTwoDigits(input).convertNumber());
  }

  @Test
  void convertNumberTest_ZeroIsEmpty() {
    assertEquals(EMPTY, new ConvertTwoDigits(0).convertNumber());
  }
}