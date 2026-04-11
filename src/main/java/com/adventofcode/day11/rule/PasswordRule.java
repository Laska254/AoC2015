package com.adventofcode.day11.rule;

import com.adventofcode.day11.Password;

public sealed interface PasswordRule
        permits BannedLetters, IncreasingStraightOfThreeLetters, TwoDifferentPairs {

    boolean isSatisfiedBy(Password password);

}
