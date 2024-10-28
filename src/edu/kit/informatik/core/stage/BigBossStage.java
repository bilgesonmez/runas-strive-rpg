package edu.kit.informatik.core.stage;

import edu.kit.informatik.utilities.Heal;
import edu.kit.informatik.core.fight.OneMonsterFight;
import edu.kit.informatik.core.RunasStriveUI;
import edu.kit.informatik.model.game.Game;
import edu.kit.informatik.model.players.FirstLevelMonster;
import edu.kit.informatik.model.players.PlayerMonster;
import edu.kit.informatik.model.skills.RunasSkills;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Big Boss Stage, which is the fourth and last stage of a level.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class BigBossStage {

    /**
     * Starts the fight with the big boss monster.
     *
     * @param game the game
     * @return true if quit
     */
    public boolean fightWithBigBoss(Game game) {
        OneMonsterFight oneMonsterFight = new OneMonsterFight();
        PlayerMonster bigBossMonster = new FirstLevelMonster().getBigBossMonster().get(0);

        if (oneMonsterFight.oneMonsterFight(bigBossMonster, game, 0, "null")) return true;

        System.out.println(bigBossMonster.getName() + " dies");

        List<RunasSkills> skillCards = RunasSkills.createSecondLevelDeck();
        List<RunasSkills> newSkills = determineUpgradedSkills(game);

        updateSkillDeck(game, skillCards, newSkills);
        announceNewSkills(newSkills);

        if (Heal.heal(game.getRuna(), game.getRuna().getSkillCards())) return true;

        new RunasStriveUI(game).interactive();
        return false;
    }

    /**
     * Determines Runa's upgraded skills based on her first chosen card.
     *
     * @param game the game instance
     * @return a list of upgraded skills for Runa
     */
    private List<RunasSkills> determineUpgradedSkills(Game game) {
        List<RunasSkills> upgradedSkills = new ArrayList<>();

        switch (game.getFirstChosenCard()) {
            case THRUST -> {
                upgradedSkills.add(RunasSkills.THRUST2);
                upgradedSkills.add(RunasSkills.PARRY2);
            }
            case FOCUS -> {
                upgradedSkills.add(RunasSkills.FOCUS2);
                upgradedSkills.add(RunasSkills.WATER2);
            }
            default -> {
                upgradedSkills.add(RunasSkills.SLASH2);
                upgradedSkills.add(RunasSkills.REFLECT2);
            }
        }
        return upgradedSkills;
    }

    /**
     * Updates the skill deck to include Runa's new skills and removes them from the general deck.
     *
     * @param game      the game instance
     * @param skillDeck the main skill deck
     * @param newSkills the new skills to add to Runa's deck
     */
    private void updateSkillDeck(Game game, List<RunasSkills> skillDeck, List<RunasSkills> newSkills) {
        skillDeck.removeAll(newSkills);
        game.setSkillCards(skillDeck);
        game.getRuna().getSkillCards().addAll(newSkills);
    }

    /**
     * Announces Runa's newly acquired skills to the player.
     *
     * @param newSkills the new skills Runa receives
     */
    private void announceNewSkills(List<RunasSkills> newSkills) {
        newSkills.forEach(skill -> System.out.println("Runa gets " + skill.getName()));
    }
}
