package edu.kit.informatik.core.stage;

import edu.kit.informatik.core.fight.Fight;
import edu.kit.informatik.model.game.Game;
import edu.kit.informatik.model.players.Player;
import edu.kit.informatik.model.players.PlayerMonster;
import edu.kit.informatik.model.resources.Messages;

import java.util.List;

/**
 * Represents the second stage of the game.
 *
 * @version 1.0
 */
public class SecondStage {

    /**
     * Starts the fight at the second stage.
     *
     * @param monsters              the monster cards
     * @param game                  the game
     * @param indexFirstMonster     the index of the skill of the first monster
     * @param indexSecondMonster    the index of the skill of the second monster
     * @param firstMonstersMessage  the message of the first monster, which affects Runa
     * @param secondMonstersMessage the message of the second monster, which affects Runa
     * @return true if quit
     */
    public boolean secondStage(List<PlayerMonster> monsters, Game game, int indexFirstMonster, int indexSecondMonster,
                               String firstMonstersMessage, String secondMonstersMessage) {
        Fight fight = new Fight();
        ThirdStage thirdStage = new ThirdStage();
        PlayerMonster firstMonster = monsters.get(1);
        PlayerMonster secondMonster = monsters.get(2);

        displayFightStatus(game, firstMonster, secondMonster, indexFirstMonster, indexSecondMonster);

        String monsterMessages = fight.fightWithTwoMonsters(game, firstMonster, secondMonster,
                firstMonstersMessage, secondMonstersMessage, indexFirstMonster, indexSecondMonster);

        if (monsterMessages == null) {
            return thirdStage.thirdStage(monsters, game, 0, 0, "null", "null");
        } else if (monsterMessages.equals("quit")) {
            return true;
        }

        String[] messages = monsterMessages.split(",");
        int newIndexFirstMonster = cycleSkillIndex(firstMonster, indexFirstMonster);
        int newIndexSecondMonster = cycleSkillIndex(secondMonster, indexSecondMonster);

        return secondStage(monsters, game, newIndexFirstMonster, newIndexSecondMonster, messages[0], messages[1]);
    }

    /**
     * Displays the current fight status between Runa and the two monsters.
     */
    private void displayFightStatus(Game game, PlayerMonster firstMonster, PlayerMonster secondMonster,
                                    int indexFirstMonster, int indexSecondMonster) {
        Player runa = game.getRuna();
        System.out.println(Messages.LINE + "Runa (" + runa.getHealth() + "/50 HP, " + runa.getFocusPoints() + "/"
                + game.getDieFace().getValue() + " FP)\nvs.\n" + firstMonster.getName()
                + " (" + firstMonster.getHealth() + " HP, " + firstMonster.getFocusPoints() + " FP): attempts "
                + firstMonster.getSkills().get(indexFirstMonster).getName() + " next\n" + secondMonster.getName()
                + " (" + secondMonster.getHealth() + " HP, " + secondMonster.getFocusPoints() + " FP): attempts "
                + secondMonster.getSkills().get(indexSecondMonster).getName() + " next\n" + Messages.SELECT);
    }

    /**
     * Cycles the skill index for a monster's skills.
     *
     * @param monster the monster
     * @param index   the current skill index
     * @return the next skill index
     */
    private int cycleSkillIndex(PlayerMonster monster, int index) {
        return (index + 1) % monster.getSkills().size();
    }
}
