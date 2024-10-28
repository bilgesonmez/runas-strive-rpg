package edu.kit.informatik.core;

import edu.kit.informatik.core.stage.FirstStage;
import edu.kit.informatik.model.game.Game;
import edu.kit.informatik.model.players.FirstLevelMonster;
import edu.kit.informatik.model.players.PlayerMonster;
import edu.kit.informatik.model.players.SecondLevelMonster;
import edu.kit.informatik.model.resources.Commands;
import edu.kit.informatik.model.resources.Errors;
import edu.kit.informatik.model.resources.Messages;

import java.util.*;

/**
 * Represents the interactive class to manage the commands.
 *
 * @version 1.1
 */
public class RunasStriveUI {
    private static boolean isOver = false;
    private final Game game;

    public RunasStriveUI(Game game) {
        this.game = game;
    }

    public static void setIsOver(boolean isOver) {
        RunasStriveUI.isOver = isOver;
    }

    public void interactive() {
        Scanner input = new Scanner(System.in);
        List<PlayerMonster> monsterCards = initializeMonsters();
        while (!isOver) {
            if (!processInput(input, monsterCards)) break;
        }
        input.close();
    }

    private List<PlayerMonster> initializeMonsters() {
        return game.getLevel() == 1
                ? new FirstLevelMonster().createDeck()
                : new SecondLevelMonster().createDeck();
    }

    private boolean processInput(Scanner input, List<PlayerMonster> monsterCards) {
        System.out.println(Messages.ENTER_SEED);
        String seeds = input.nextLine();

        if (Commands.COMMAND_QUIT.equals(seeds)) {
            setIsOver(true);
            return false;
        }

        String[] seedArray = seeds.split(",");
        if (!validateAndParseSeeds(seeds, seedArray)) return true;

        shuffleCards(monsterCards, Integer.parseInt(seedArray[0]), Integer.parseInt(seedArray[1]));
        if (nextStage(monsterCards)) setIsOver(true);

        return !isOver;
    }

    private boolean validateAndParseSeeds(String seeds, String[] seedArray) {
        if (isOver) {
            System.err.println(Errors.GAME_OVER);
            return false;
        }
        if (seedArray.length != 2) return false;

        try {
            Integer.parseInt(seedArray[0]);
            Integer.parseInt(seedArray[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean nextStage(List<PlayerMonster> monsterCards) {
        System.out.println("Runa enters Stage " + game.getStage() + " of Level " + game.getLevel());
        boolean isFinalStage = new FirstStage().firstStage(monsterCards, game, 0, "null");

        if (isFinalStage) {
            System.out.println("Congratulations! You've completed the final stage.");
            setIsOver(true);
        }
        return isFinalStage;
    }

    public void shuffleCards(List<PlayerMonster> monsterCards, int firstSeed, int secondSeed) {
        Collections.shuffle(game.getSkillCards(), new Random(firstSeed));
        Collections.shuffle(monsterCards, new Random(secondSeed));
        game.setMonsterCards(monsterCards);
    }
}
