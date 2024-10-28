package edu.kit.informatik.core.fight;

import edu.kit.informatik.utilities.Heal;
import edu.kit.informatik.utilities.Reward;
import edu.kit.informatik.model.game.Game;
import edu.kit.informatik.model.game.Level;
import edu.kit.informatik.model.game.Stage;
import edu.kit.informatik.model.players.PlayerMonster;
import edu.kit.informatik.model.players.PlayerRuna;
import edu.kit.informatik.model.resources.Messages;

import java.util.Scanner;

/**
 * This class contains methods for Runa fighting a single monster.
 *
 * @version 1.0
 */
public class OneMonsterFight {

    /**
     * Starts a 1-1 fight between Runa and a specific monster.
     *
     * @param monster        the monster
     * @param game           the game
     * @param skillIndex     index of skill of monster
     * @param monsterMessage the message of the monster that affects Runa
     * @return true if quit
     */
    public boolean oneMonsterFight(PlayerMonster monster, Game game, int skillIndex, String monsterMessage) {
        PlayerRuna runa = game.getRuna();
        Fight fight = new Fight();
        Scanner scanner = new Scanner(System.in);

        displayFightStatus(runa, game, monster, skillIndex);

        String message = fight.monsterVsRuna(game, monster, monsterMessage, skillIndex);
        if (message.equals("quit")) return true;

        skillIndex = cycleSkillIndex(monster, skillIndex);

        if (message.equals("Monster is dead.")) {
            handleMonsterDeath(game, monster);
            if (game.getStage() != Stage.FOURTH_STAGE.getStage()) {
                handlePostBattle(game, runa, scanner);
            }
        } else {
            return oneMonsterFight(monster, game, skillIndex, message); // recursive call for ongoing battle
        }

        return false;
    }

    /**
     * Displays the current fight status.
     */
    private void displayFightStatus(PlayerRuna runa, Game game, PlayerMonster monster, int skillIndex) {
        System.out.println(Messages.LINE + "Runa (" + runa.getHealth() + "/50 HP, " + runa.getFocusPoints() + "/"
                + game.getDieFace().getValue() + " FP)\nvs.\n" + monster.getName() + " (" + monster.getHealth()
                + " HP, " + monster.getFocusPoints() + " FP): attempts " + monster.getSkills().get(skillIndex).getName()
                + " next\n" + Messages.SELECT);
    }

    /**
     * Handles the post-battle rewards and healing process after a monster is defeated.
     */
    private void handlePostBattle(Game game, PlayerRuna runa, Scanner scanner) {
        if (promptForRewardChoice(scanner)) {
            if (Reward.rewardCard(game)) return;
        } else {
            game.upgradeDie();
            System.out.println("Runa upgrades her die to a " + game.getDieFace().getFace());
        }

        if (runa.getHealth() < 50 && runa.getSkillCards().size() > 1) {
            if (Heal.heal(runa, runa.getSkillCards())) return;
        }
        game.upgradeStage();
        System.out.println("Runa enters Stage " + game.getStage() + " of Level " + game.getLevel());
    }

    /**
     * Prompts the player to choose a reward.
     *
     * @return true if the player chose to receive new ability cards
     */
    private boolean promptForRewardChoice(Scanner scanner) {
        String decision;
        do {
            System.out.println("Choose Runa's reward:\n1) new ability cards\n2) next player dice\nEnter number [1--2]:");
            decision = scanner.nextLine();
            if (decision.equals("quit")) return false;
        } while (!decision.equals("1") && !decision.equals("2"));
        return decision.equals("1");
    }

    /**
     * Handles necessary updates and checks after a monster is defeated.
     */
    private void handleMonsterDeath(Game game, PlayerMonster monster) {
        System.out.println(monster.getName() + " dies");
        if (game.getStage() == Stage.FOURTH_STAGE.getStage()) {
            game.setCurrentLevel(Level.SECOND_LEVEL);
            game.upgradeStage();
        }
    }

    /**
     * Cycles the skill index for the monster's skills.
     *
     * @param monster the monster
     * @param index   the current skill index
     * @return the next skill index
     */
    private int cycleSkillIndex(PlayerMonster monster, int index) {
        return (index + 1) % monster.getSkills().size();
    }
}
