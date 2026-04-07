package com.adventofcode.day21;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class Day21 {

    private static final int BOSS_HIT_POINTS = 109;
    private static final int BOSS_DAMAGE = 8;
    private static final int BOSS_ARMOR = 2;
    private static final int PLAYER_HIT_POINTS = 100;

    private final ItemShop itemShop = new ItemShop();

    public int calculateMinimalGoldToWin() {
        var minCost = Integer.MAX_VALUE;
        for (var weapon : itemShop.getWeapons()) {
            for (var armor : itemShop.getArmors()) {
                for (var rings : generateRingsCombinations()) {
                    final var totalCost = calculateTotalCost(weapon, armor, rings);
                    final var totalDamage = calculateTotalDamage(weapon, rings);
                    final var totalArmor = calculateTotalArmor(armor, rings);
                    if (simulateFight(totalDamage, totalArmor)) {
                        minCost = Math.min(minCost, totalCost);
                    }
                }
            }
        }
        return minCost;
    }

    private boolean simulateFight(final int playerDamage, final int playerDefense) {
        final var player = new LivingEntity(PLAYER_HIT_POINTS, playerDamage, playerDefense);
        final var boss = new LivingEntity(BOSS_HIT_POINTS, BOSS_DAMAGE, BOSS_ARMOR);
        while (true) {
            boss.takeDamage(
                    Math.max(1, player.getDamage() - boss.getDefense()));
            if (!boss.isAlive()) {
                return true;
            }
            player.takeDamage(
                    Math.max(1, boss.getDamage() - player.getDefense()));
            if (!player.isAlive()) {
                return false;
            }
        }
    }

    private List<List<Ring>> generateRingsCombinations() {
        final List<List<Ring>> combinations = new ArrayList<>();
        // no rings
        combinations.add(List.of());
        // only one ring
        itemShop.getRings().stream()
                .map(List::of)
                .forEach(combinations::add);
        // two rings
        final var pairOfRings = new ArrayList<>(itemShop.getRings());
        range(0, pairOfRings.size()).forEach(
                i -> range(i + 1, pairOfRings.size()).forEach(
                        j -> combinations.add(
                                List.of(
                                        pairOfRings.get(i),
                                        pairOfRings.get(j)))
                )
        );
        return combinations;
    }

    private static int calculateTotalArmor(final Armor armor, final List<Ring> ringCombo) {
        return armor.getDefense()
                + ringCombo.stream().mapToInt(Ring::getDefense).sum();
    }

    private static int calculateTotalDamage(final Weapon weapon, final List<Ring> ringCombo) {
        return weapon.getDamage()
                + ringCombo.stream()
                .mapToInt(Ring::getDamage)
                .sum();
    }

    private static int calculateTotalCost(final Weapon weapon, final Armor armor, final List<Ring> ringCombo) {
        return weapon.getCost()
                + armor.getCost()
                + ringCombo.stream().mapToInt(ShopItem::getCost).sum();
    }

}
