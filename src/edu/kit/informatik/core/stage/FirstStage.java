package edu.kit.informatik.core.stage;

import edu.kit.informatik.core.fight.OneMonsterFight;
import edu.kit.informatik.model.game.Game;
import edu.kit.informatik.model.players.PlayerMonster;

import java.util.List;

/**
 * Represents the first stage of the game.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class FirstStage {

    /**
     * Starts the fight at the first stage
     *
     * @param monsters       the monster cards
     * @param game           the game
     * @param skillIndex     the index of the skill of the monster
     * @param monsterMessage the message of monster, which affects Runa
     * @return true if quit
     */
    public boolean firstStage(List<PlayerMonster> monsters, Game game, int skillIndex,
                              String monsterMessage) {
        SecondStage secondStage = new SecondStage();
        OneMonsterFight oneMonsterFight = new OneMonsterFight();
        if (oneMonsterFight.oneMonsterFight(monsters.get(0), game, skillIndex, monsterMessage)) {
            return true;
        }
        return secondStage.secondStage(monsters, game, 0, 0, "null",
                "null");
    }

}




