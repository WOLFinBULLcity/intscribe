package com.intscribe;

import java.util.Arrays;
import java.util.Optional;

/**
 * Enum for numbers that can also serve as prefixes.
 */
public enum WordsForNumberPrefixes {
  EMPTY(0),
  TEN(1),
  TWENTY(2),
  THIRTY(3),
  FORTY(4),
  FIFTY(5),
  SIXTY(6),
  SEVENTY(7),
  EIGHTY(8),
  NINETY(9);

  private final int value;

  WordsForNumberPrefixes(int value) {
    this.value = value;
  }

  public static Optional<WordsForNumberPrefixes> valueOf(int value) {
    return Arrays.stream(values())
        .filter((WordsForNumberPrefixes -> WordsForNumberPrefixes.value == value))
        .findFirst();
  }

  public String getName() {
    if (this.ordinal() == 0) {
      return "";
    }
    return name().toLowerCase();
  }
}
