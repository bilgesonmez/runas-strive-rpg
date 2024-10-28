package edu.kit.informatik.core.fight;

import edu.kit.informatik.model.skills.MonsterSkills;
import edu.kit.informatik.model.players.Player;

/**
 * This class provides the monsters' effects in battles.
 *
 * @author bilgesonmez
 * @version 1.1
 */
public class MonstersAffects {

    /**
     * Determines the effect of the monster's move on Runa.
     *
     * @param monster the monster
     * @param skill   the skill card monster uses
     * @param runa    the player Runa
     * @param message the message showing which card Runa used on her previous turn
     * @return the effect as a string, or "null" if no effect
     */
    public String monstersAffect(Player monster, MonsterSkills skill, Player runa, String message) {
        int level = skill.getLevel();
        int focus = monster.getFocusPoints();

        if (shouldIncreaseFocus(message, skill)) {
            runa.addFocusPoints(level);
            System.out.println("Runa gains " + level + " focus");
        }

        switch (skill) {
            case SCRATCH, SCRATCH2 -> {
                reduceHealth(runa, level, 5 * level, message);
                return "null";
            }
            case CLAW, CLAW2 -> {
                reduceHealth(runa, level, 6 * level, message);
                return "null";
            }
            case SMASH, SMASH2 -> {
                reduceHealth(runa, level, 8 * level, message);
                return "null";
            }
            case BITE, BITE2 -> {
                reduceHealth(runa, level, 10 * level, message);
                return "null";
            }
            case FOCUS, FOCUS2 -> {
                return "Focus";
            }
            case BLOCK, BLOCK2 -> {
                return "Block";
            }
            case DEFLECT, DEFLECT2 -> {
                return "Deflect";
            }
            case WATER, WATER2 -> {
                magicEffect(monster, level, runa, (8 * level + 2), focus, message);
                return "null";
            }
            case ICE, ICE2 -> {
                magicEffect(monster, level, runa, (10 * level + 2), focus, message);
                return "null";
            }
            case FIRE, FIRE2 -> {
                magicEffect(monster, level, runa, (12 * level + 2), focus, message);
                return "null";
            }
            case LIGHTNING, LIGHTNING2 -> {
                magicEffect(monster, level, runa, (14 * level + 2), focus, message);
                return "null";
            }
            default -> {
                return "null";
            }
        }
    }

    /**
     * Reduces Runa's health by the given amount, adjusting if she used "Parry".
     *
     * @param runa    the player Runa
     * @param level   the level of the skill card
     * @param damage  the base damage amount
     * @param message the message showing which card Runa used on her previous turn
     */
    private void reduceHealth(Player runa, int level, int damage, String message) {
        int adjustedDamage = message.equals("Parry") ? Math.max(damage - 7 * level, 0) : damage;
        runa.damage(adjustedDamage);
        System.out.println(runa.getName() + " takes " + adjustedDamage + " phy. damage");
    }

    /**
     * Checks if the monster has enough focus points to use an offensive magic card. Adjusts damage if Runa used "Reflect".
     *
     * @param monster the monster
     * @param level   the level of the skill card
     * @param runa    the player Runa
     * @param damage  the base damage amount
     * @param focus   focus points of the monster
     * @param message the message showing Runa's previous move
     */
    private void magicEffect(Player monster, int level, Player runa, int damage, int focus, String message) {
        if (focus >= level) {
            int finalDamage = message.equals("Reflect") ? Math.max(damage - 10 * level, 0) : damage;

            if (message.equals("Reflect") && damage >= 10 * level) {
                monster.damage(10 * level);
            }

            runa.damage(finalDamage);
            monster.removeFocusPoints(1);

            if (finalDamage > 0) {
                System.out.println("Runa takes " + finalDamage + " mag. damage");
            }
        }
    }

    /**
     * Checks if focus should be increased based on the skill and previous message.
     */
    private boolean shouldIncreaseFocus(String message, MonsterSkills skill) {
        return message.equals("Focus") && !isPhysicalAttack(skill);
    }

    /**
     * Determines if the skill is a physical attack.
     */
    private boolean isPhysicalAttack(MonsterSkills skill) {
        return skill == MonsterSkills.SCRATCH || skill == MonsterSkills.SCRATCH2 ||
                skill == MonsterSkills.CLAW || skill == MonsterSkills.CLAW2 ||
                skill == MonsterSkills.BITE || skill == MonsterSkills.BITE2;
    }
}
