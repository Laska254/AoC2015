package com.adventofcode.day11;

import com.adventofcode.day11.rule.BannedLetters;
import com.adventofcode.day11.rule.IncreasingStraightOfThreeLetters;
import com.adventofcode.day11.rule.PasswordRule;
import com.adventofcode.day11.rule.TwoDifferentPairs;

import java.util.Set;

public class Validator {

    private final Set<PasswordRule> rules = Set.of(
            new BannedLetters(),
            new IncreasingStraightOfThreeLetters(),
            new TwoDifferentPairs()
    );

    public boolean isValid(final Password password) {
        return rules.stream().allMatch(rule -> rule.isSatisfiedBy(password));
    }

}
