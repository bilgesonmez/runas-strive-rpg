package edu.kit.informatik.utilities;

import edu.kit.informatik.model.players.PlayerRuna;
import edu.kit.informatik.model.skills.RunasSkills;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class allows Runa to heal herself by discarding skill cards.
 *
 * @version 1.0
 */
public final class Heal {
    private Heal() {
        // This is a utility class with a private constructor.
    }

    /**
     * Heals Runa if the conditions are right.
     *
     * @param runa  the player Runa
     * @param cards Runa's skill cards deck
     * @return true if quit
     */
    public static boolean heal(PlayerRuna runa, List<RunasSkills> cards) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Runa (" + runa.getHealth() + "/50 HP) can discard ability cards for healing (or none)");

        displayCards(cards);

        String input;
        String[] selectedCards;
        do {
            System.out.print("Enter card numbers [1-" + cards.size() + "] separated by commas, or 'quit' to exit: ");
            input = scanner.nextLine();

            if (input.equals("quit")) return true;
            if (input.isEmpty()) return false;

            selectedCards = input.split(",");
        } while (!isValidSelection(selectedCards, cards.size()));

        discardSelectedCards(selectedCards, cards);
        int totalHeal = calculateHealAmount(selectedCards.length);
        runa.heal(totalHeal);

        System.out.println("Runa gains " + totalHeal + " health");
        return false;
    }

    /**
     * Displays available skill cards with their indexes.
     */
    private static void displayCards(List<RunasSkills> cards) {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println((i + 1) + ") " + cards.get(i).getName());
        }
    }

    /**
     * Checks if the selected cards are valid based on the size of the deck.
     */
    private static boolean isValidSelection(String[] selectedCards, int deckSize) {
        try {
            for (String card : selectedCards) {
                int cardIndex = Integer.parseInt(card.trim());
                if (cardIndex < 1 || cardIndex > deckSize) {
                    System.out.println("Invalid selection. Please try again.");
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numbers separated by commas.");
            return false;
        }
        return true;
    }

    /**
     * Removes the selected cards from Runa's skill deck.
     */
    private static void discardSelectedCards(String[] selectedCards, List<RunasSkills> cards) {
        // Sort in descending order to avoid index shifting when removing
        int[] sortedIndexes = sortDescending(selectedCards);
        for (int index : sortedIndexes) {
            cards.remove(index - 1);
        }
    }

    /**
     * Sorts the array of selected card indexes in descending order.
     */
    private static int[] sortDescending(String[] selectedCards) {
        int[] indexes = new int[selectedCards.length];
        for (int i = 0; i < selectedCards.length; i++) {
            indexes[i] = Integer.parseInt(selectedCards[i].trim());
        }
        Arrays.sort(indexes);
        // Reverse array to descending order
        for (int i = 0; i < indexes.length / 2; i++) {
            int temp = indexes[i];
            indexes[i] = indexes[indexes.length - 1 - i];
            indexes[indexes.length - 1 - i] = temp;
        }
        return indexes;
    }

    /**
     * Calculates the total amount of health Runa gains from discarded cards.
     */
    private static int calculateHealAmount(int numCardsDiscarded) {
        return numCardsDiscarded * 10;
    }
}
