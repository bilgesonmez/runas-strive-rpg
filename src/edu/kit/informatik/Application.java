package edu.kit.informatik;

import edu.kit.informatik.core.RunasStriveUI;
import edu.kit.informatik.model.skills.RunasSkills;
import edu.kit.informatik.model.game.Game;
import edu.kit.informatik.model.resources.Messages;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * This is the main class for starting the Runa's Strive game.
 *
 * @version 1.1
 */
public final class Application {
    private Application() {
        // Utility class with private constructor
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Messages.WELCOME_MESSAGE);

        Integer characterClass = selectCharacterClass(scanner);
        Game game = initializeGame(characterClass);
        new RunasStriveUI(game).interactive();
        scanner.close();
    }

    /**
     * Prompts user to select a character class and validates input.
     *
     * @param scanner the scanner for reading input
     * @return selected character class or null if invalid input
     */
    private static Integer selectCharacterClass(Scanner scanner) {
        while (true) {
            System.out.println("Enter character class number [1-3]:");
            String input = scanner.nextLine();
            try {
                int characterClass = Integer.parseInt(input);
                if (characterClass >= 1 && characterClass <= 3) return characterClass;
            } catch (NumberFormatException ignored) {
            }
            System.err.println("Invalid input. Please enter a number from 1 to 3.");
        }
    }

    /**
     * Initializes the game by setting up Runa's class and skill cards.
     *
     * @param characterClass the chosen character class
     * @return a Game instance configured with initial settings
     */
    private static Game initializeGame(int characterClass) {
        Game game = new Game();
        List<RunasSkills> skillCards = RunasSkills.createFirstLevelDeck();
        Map<Integer, List<RunasSkills>> skillMap = Map.of(
                1, Arrays.asList(RunasSkills.THRUST, RunasSkills.PARRY),
                2, Arrays.asList(RunasSkills.FOCUS, RunasSkills.WATER),
                3, Arrays.asList(RunasSkills.SLASH, RunasSkills.REFLECT)
        );

        List<RunasSkills> chosenSkills = skillMap.get(characterClass);
        skillCards.removeAll(chosenSkills);
        game.setSkillCards(skillCards);
        game.setFirstChosenCard(chosenSkills.get(0));
        game.getRuna().setSkillCards(chosenSkills);

        return game;
    }
}
