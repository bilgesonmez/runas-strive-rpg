package edu.kit.informatik.utilities;

import edu.kit.informatik.model.game.Game;
import edu.kit.informatik.model.game.Stage;
import edu.kit.informatik.model.skills.RunasSkills;

import java.util.List;
import java.util.Scanner;

/**
 * This class provides the reward function, allowing Runa to pick skill cards as loot
 * based on the current game stage.
 *
 * @version 1.0
 */
public class Reward {

    /**
     * Offers a loot reward to Runa based on the game stage, allowing her to select new skill cards.
     *
     * @param game the current game instance
     * @return true if the player quits during the reward selection process
     */
    public static boolean rewardCard(Game game) {
        Scanner scanner = new Scanner(System.in);
        List<RunasSkills> runasSkills = game.getRuna().getSkillCards();
        int lootCount = getLootCount(game.getStage());
        displayLootOptions(game, lootCount);

        String selectionPrompt = game.getStage() == Stage.FIRST_STAGE.getStage()
                ? "Enter number [1--2]:"
                : "Enter numbers [1--4] separated by comma:";
        System.out.println(selectionPrompt);

        String numbers = scanner.nextLine();
        if (numbers.equals("quit")) return true;

        addSelectedSkills(game, runasSkills, numbers.split(","));
        clearLootedCards(game, lootCount);

        return false;
    }

    /**
     * Determines the number of cards to offer as loot based on the stage.
     *
     * @param stage the current game stage
     * @return the number of cards to be offered as loot
     */
    private static int getLootCount(int stage) {
        return stage == Stage.FIRST_STAGE.getStage() ? 2 : 4;
    }

    /**
     * Displays the available loot options based on the current stage.
     *
     * @param game      the current game instance
     * @param lootCount the number of cards to display as loot
     */
    private static void displayLootOptions(Game game, int lootCount) {
        System.out.println("Pick " + (lootCount / 2) + " card(s) as loot");
        for (int i = 0; i < lootCount; i++) {
            System.out.println((i + 1) + ") " + game.getSkillCards().get(i).getName());
        }
    }

    /**
     * Adds selected skill cards to Runa's deck based on player input.
     *
     * @param game          the current game instance
     * @param runasSkills   Runa's skill deck
     * @param numbersArray  array of selected card indices
     */
    private static void addSelectedSkills(Game game, List<RunasSkills> runasSkills, String[] numbersArray) {
        for (String s : numbersArray) {
            int index = Integer.parseInt(s) - 1;
            RunasSkills selectedSkill = game.getSkillCards().get(index);
            System.out.println("Runa gets " + selectedSkill.getName());
            runasSkills.add(selectedSkill);
        }
    }

    /**
     * Removes looted cards from the main skill deck.
     *
     * @param game      the current game instance
     * @param lootCount the number of cards that were looted
     */
    private static void clearLootedCards(Game game, int lootCount) {
        game.getSkillCards().subList(0, lootCount).clear();
    }
}
