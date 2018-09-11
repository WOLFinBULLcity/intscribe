package com.intscribe;

import static org.junit.jupiter.api.Assertions.*;

import static com.intscribe.Constants.EMPTY;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConvertOneDigitTest {

  @ParameterizedTest
  @CsvSource({
      "1, one",
      "2, two",
      "3, three",
      "4, four",
      "5, five",
      "6, six",
      "7, seven",
      "8, eight",
      "9, nine"
  })
  void convertNumberTest_AllValues(int input, String output) {
    assertEquals(output, new ConvertOneDigit(input).convertNumber());
  }

  @Test
  void convertNumberTest_ZeroIsEmpty() {
    assertEquals(EMPTY, new ConvertOneDigit(0).convertNumber());
  }
}