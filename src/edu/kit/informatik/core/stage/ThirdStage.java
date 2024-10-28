package edu.kit.informatik.core.stage;

import edu.kit.informatik.core.fight.Fight;
import edu.kit.informatik.model.game.Game;
import edu.kit.informatik.model.players.Player;
import edu.kit.informatik.model.players.PlayerMonster;
import edu.kit.informatik.model.resources.Messages;

import java.util.List;

/**
 * Represents the third stage of the game.
 *
 * @version 1.0
 */
public class ThirdStage {

    /**
     * Starts the third stage fight.
     *
     * @param monsters             the monster cards
     * @param game                 the game
     * @param indexFirstMonster    the index of the skill of the first monster
     * @param indexSecondMonster   the index of the skill of the second monster
     * @param firstMonsterMessage  the message of the first monster, which affects Runa
     * @param secondMonsterMessage the message of the second monster, which affects Runa
     * @return true if quit
     */
    public boolean thirdStage(List<PlayerMonster> monsters, Game game, int indexFirstMonster, int indexSecondMonster,
                              String firstMonsterMessage, String secondMonsterMessage) {
        Fight fight = new Fight();
        BigBossStage bigBossStage = new BigBossStage();
        PlayerMonster firstMonster = monsters.get(3);
        PlayerMonster secondMonster = monsters.get(4);

        displayFightStatus(game, firstMonster, secondMonster, indexFirstMonster, indexSecondMonster);

        String monsterMessages = fight.fightWithTwoMonsters(game, firstMonster, secondMonster,
                firstMonsterMessage, secondMonsterMessage, indexFirstMonster, indexSecondMonster);

        if (monsterMessages == null) {
            return bigBossStage.fightWithBigBoss(game);
        }

        String[] messages = monsterMessages.split(",");
        int newIndexFirstMonster = cycleSkillIndex(firstMonster, indexFirstMonster);
        int newIndexSecondMonster = cycleSkillIndex(secondMonster, indexSecondMonster);

        return thirdStage(monsters, game, newIndexFirstMonster, newIndexSecondMonster, messages[0], messages[1]);
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
