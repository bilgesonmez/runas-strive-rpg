package edu.kit.informatik.core.fight;

import edu.kit.informatik.model.skills.RunasSkills;
import edu.kit.informatik.model.game.Game;
import edu.kit.informatik.model.players.Player;

import java.util.Scanner;

/**
 * This class provides the Runa's effects.
 *
 * @author bilgesonmez
 * @version 1.1
 */
public class RunasAffects {

    /**
     * With this method Runa plays his move according to the skill card she chased, this method returns then
     * a String that shows the cards affect next turn.
     *
     * @param skill   the skill card monster uses
     * @param game    the game
     * @param monster the monster
     * @param message the message
     * @return the affect, if the card affects the next turn. If Runa's skill card affects the skill card
     * that monster use on his turn, the affect is returned as a string. If Runa's skill card has no effect on
     * monsters card, then null is returned.
     */
    public String runasAffect(RunasSkills skill, Game game, Player monster, String message) {
        Scanner scanner = new Scanner(System.in);
        String rolledDice = null;
        if (skill.getType() == 1) {
            do {
                System.out.println("Enter dice roll [1--" + game.getDieFace().getValue() + "]:");
                rolledDice = scanner.nextLine();
                if (rolledDice.equals("quit")) {
                    return "quit";
                }
            } while ((Integer.parseInt(rolledDice) < 1)
                    && (Integer.parseInt(rolledDice) > game.getDieFace().getValue()));
        }
        assert rolledDice != null;

        int level = skill.getLevel();
        int focus = game.getRuna().getFocusPoints();
        switch (skill) {
            case SLASH, SLASH2 -> {
                reduceHealth(monster, level, (4 * level + Integer.parseInt(rolledDice)), message, skill);
                return "null";
            }
            case SWING, SWING2 -> {
                reduceHealth(monster, level, (5 * level + Integer.parseInt(rolledDice)), message, skill);
                return "null";
            }
            case THRUST, THRUST2 -> {
                if (Integer.parseInt(rolledDice) >= 6) {
                    reduceHealth(monster, level, (10 * level + Integer.parseInt(rolledDice)), message, skill);
                } else
                    reduceHealth(monster, level, (6 * level + Integer.parseInt(rolledDice)), message, skill);
                return "null";
            }
            case PIERCE, PIERCE2 -> {
                if (Integer.parseInt(rolledDice) >= 6) {
                    reduceHealth(monster, level, (12 * level + Integer.parseInt(rolledDice)), message, skill);
                } else
                    reduceHealth(monster, level, (7 * level + Integer.parseInt(rolledDice)), message, skill);
                return "null";
            }
            case PARRY, PARRY2 -> {
                return "Parry"; // this shows that the parry is used, and it will reduce the next affect of monster
            }
            case FOCUS, FOCUS2 -> {
                return "Focus";
            }
            case REFLECT, REFLECT2 -> {
                return "Reflect"; // sign for reflecting 10 * level magical damage from monster
            }
            case WATER, WATER2 -> {
                magicEffect(monster, skill, level, (2 * level + 4) * focus, focus, game, message);
                return "null";
            }
            case ICE, ICE2 -> {
                magicEffect(monster, skill, level, (2 * level + 4) * focus + 2, focus, game, message);
                return "null";
            }
            case FIRE, FIRE2 -> {
                magicEffect(monster, skill, level, (2 * level + 5) * focus, focus, game, message);
                return "null";
            }
            case LIGHTNING, LIGHTNING2 -> {
                magicEffect(monster, skill, level, (2 * level + 5) * focus + 2, focus, game, message);
                return "null";
            }
            default -> {
            }
        }
        return "null";
    }

    /**
     * Checks focus function.
     *
     * @param message the message
     * @param skill   the skill of monster
     * @param monster the monster
     * @param level   the level
     */
    public void checkFocus(String message, RunasSkills skill, Player monster, int level) {
        if (message.equals("Focus") && skill != RunasSkills.SLASH && skill != RunasSkills.SWING
                && skill != RunasSkills.SLASH2 && skill != RunasSkills.SWING2 && (monster != null)) {
            monster.addFocusPoints(level);
            System.out.println(monster.getName() + " gains " + level + " focus");
        }
    }

    /**
     * Reduces monster's health as the given amount. If monster used the card "Block" on her previous turn, the damage
     * reduces by 7 * level. Returns the damage amount at the end.
     *
     * @param monster      the monster
     * @param level        level of the skill card
     * @param damageAmount the damage amount
     * @param message      the message that shows which card Runa used on her previous turn
     * @param skill        skill
     */
    public void reduceHealth(Player monster, int level, int damageAmount, String message, RunasSkills skill) {
        if (message.equals("Block")) {
            if (damageAmount >= 7 * level) {
                monster.damage(damageAmount - 7 * level);
                System.out.println(monster.getName() + " takes " + (damageAmount - 7 * level) + " phy. damage");
                if (monster.getHealth() != 0) {
                    checkFocus(message, skill, monster, level);
                }
            } else {
                monster.damage(0);
            }
        } else {
            monster.damage(damageAmount);
            System.out.println(monster.getName() + " takes " + damageAmount + " phy. damage");
            if (monster.getHealth() != 0) {
                checkFocus(message, skill, monster, level);
            }
        }
    }

    /**
     * Checks if Runa has enough focus points to use an offensive magic card. If so, it checks if monster used
     * "Deflect" card on her previous turn. If she did, the monsters damage reduces by 10 * level, and reflect himself.
     * If "Reflect" card is not used, then it reduces Runa's health as the amount damage. The message is printed after
     * the attack is done.
     *
     * @param monsterPlayer the player Monster
     * @param skill         the skill card
     * @param level         the level of the skill card
     * @param damageAmount  the damage amount
     * @param focus         the focus points of Runa
     * @param game          the game
     * @param message       the message that shows which card Runa used on her previous turn
     */
    public void magicEffect(Player monsterPlayer, RunasSkills skill, int level, int damageAmount, int focus, Game game,
                            String message) {
        int damage = damageAmount;
        String monster = monsterPlayer.getName();
        if (focus >= 1) { // check if Runa has enough focus points
            // if enemy monster is a fire type monster
            if ((skill.equals(RunasSkills.WATER) || skill.equals(RunasSkills.WATER2)) && (monster.equals("Spider King")
                    || monster.equals("Skeleton") || monster.equals("Shadow Blade"))) {
                damage = damage + 2 * level;
            } // if enemy monster is a fire type monster
            if ((skill.equals(RunasSkills.ICE) || skill.equals(RunasSkills.ICE2)) && (monster.equals("Frog"))) {
                damage = damage + 2 * level;
            } // if enemy monster is an ice type monster
            if ((skill.equals(RunasSkills.FIRE) || skill.equals(RunasSkills.FIRE2)) && (monster.equals("Ghost")
                    || monster.equals("Snake"))) {
                damage = damage + 2 * level;
            } // if enemy monster is a fire type monster
            if ((skill.equals(RunasSkills.LIGHTNING) || skill.equals(RunasSkills.LIGHTNING2))
                    && (monster.equals("Gorgon") || monster.equals("Hornet"))) {
                damage = damage + 2 * level;
            }
            if (message.equals("Deflect")) {
                if (damage >= 11 * level + 2) {
                    damage = damage - (11 * level + 2);
                } else {
                    damage = 0;
                }
            }
            monsterPlayer.damage(damage);
            game.getRuna().removeFocusPoints(1);
            if (damage != 0) {
                System.out.println(monster + " takes " + damage + " mag. damage");
                checkFocus(message, skill, monsterPlayer, level);
            }
        }
    }
}



