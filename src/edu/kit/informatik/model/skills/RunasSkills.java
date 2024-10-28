package edu.kit.informatik.model.skills;

import java.util.ArrayList;
import java.util.List;

/**
 * Enumeration of Runa's skill cards, each categorized by type and level.
 * Skills are organized as:
 * - Defensive (type -1)
 * - Physical offensive (type 1)
 * - Magic offensive (type 2)
 * - Other skills (type 0)
 * Each skill has a name, type, and level, indicating its power and usage context.
 *
 * @version 1.0
 */
public enum RunasSkills {

    // First-level physical offensive skills
    /**
     * Physical offensive skill "Slash" (level 1).
     */
    SLASH("Slash(1)", 1, 1),
    /**
     * Physical offensive skill "Swing" (level 1).
     */
    SWING("Swing(1)", 1, 1),
    /**
     * Physical offensive skill "Thrust" (level 1).
     */
    THRUST("Thrust(1)", 1, 1),
    /**
     * Physical offensive skill "Pierce" (level 1).
     */
    PIERCE("Pierce(1)", 1, 1),

    // First-level defensive and focus skills
    /**
     * Defensive skill "Parry" (level 1), reduces incoming physical damage.
     */
    PARRY("Parry(1)", -1, 1),
    /**
     * Focus skill "Focus" (level 1), accumulates focus points.
     */
    FOCUS("Focus(1)", 0, 1),
    /**
     * Defensive skill "Reflect" (level 1), reflects certain attacks.
     */
    REFLECT("Reflect(1)", -1, 1),

    // First-level magic offensive skills
    /**
     * Water-based magic offensive skill "Water" (level 1).
     */
    WATER("Water(1)", 2, 1),
    /**
     * Ice-based magic offensive skill "Ice" (level 1).
     */
    ICE("Ice(1)", 2, 1),
    /**
     * Fire-based magic offensive skill "Fire" (level 1).
     */
    FIRE("Fire(1)", 2, 1),
    /**
     * Lightning-based magic offensive skill "Lightning" (level 1).
     */
    LIGHTNING("Lightning(1)", 2, 1),

    // Second-level upgraded skills
    /**
     * Upgraded physical offensive skill "Slash" (level 2).
     */
    SLASH2("Slash(2)", 1, 2),
    /**
     * Upgraded physical offensive skill "Swing" (level 2).
     */
    SWING2("Swing(2)", 1, 2),
    /**
     * Upgraded physical offensive skill "Thrust" (level 2).
     */
    THRUST2("Thrust(2)", 1, 2),
    /**
     * Upgraded physical offensive skill "Pierce" (level 2).
     */
    PIERCE2("Pierce(2)", 1, 2),

    // Second-level defensive and focus skills
    /**
     * Upgraded defensive skill "Parry" (level 2).
     */
    PARRY2("Parry(2)", -1, 2),
    /**
     * Upgraded focus skill "Focus" (level 2).
     */
    FOCUS2("Focus(2)", 0, 2),
    /**
     * Upgraded defensive skill "Reflect" (level 2).
     */
    REFLECT2("Reflect(2)", -1, 2),

    // Second-level magic offensive skills
    /**
     * Upgraded water-based magic offensive skill "Water" (level 2).
     */
    WATER2("Water(2)", 2, 2),
    /**
     * Upgraded ice-based magic offensive skill "Ice" (level 2).
     */
    ICE2("Ice(2)", 2, 2),
    /**
     * Upgraded fire-based magic offensive skill "Fire" (level 2).
     */
    FIRE2("Fire(2)", 2, 2),
    /**
     * Upgraded lightning-based magic offensive skill "Lightning" (level 2).
     */
    LIGHTNING2("Lightning(2)", 2, 2),

    /**
     * Quit command to exit the game.
     */
    QUIT("", 1, 1);

    private final String nameOfSkill;
    private final int type;
    private final int level;

    /**
     * Constructs a Runa skill with a specific name, type, and level.
     *
     * @param nameOfSkill the name of the skill
     * @param type        the type of skill (-1 for defensive, 1 for physical offensive, 2 for magic offensive, 0 for other)
     * @param level       the level of skill, indicating its power stage
     */
    RunasSkills(String nameOfSkill, int type, int level) {
        this.nameOfSkill = nameOfSkill;
        this.type = type;
        this.level = level;
    }

    /**
     * Creates and returns the deck of first-level skills.
     *
     * @return the list of first-level skills
     */
    public static List<RunasSkills> createFirstLevelDeck() {
        List<RunasSkills> skills = new ArrayList<>();
        skills.add(SLASH);
        skills.add(SWING);
        skills.add(THRUST);
        skills.add(PIERCE);
        skills.add(PARRY);
        skills.add(FOCUS);
        skills.add(REFLECT);
        skills.add(WATER);
        skills.add(ICE);
        skills.add(FIRE);
        skills.add(LIGHTNING);
        return skills;
    }

    /**
     * Creates and returns the deck of second-level skills.
     *
     * @return the list of second-level skills
     */
    public static List<RunasSkills> createSecondLevelDeck() {
        List<RunasSkills> skills = new ArrayList<>();
        skills.add(SLASH2);
        skills.add(SWING2);
        skills.add(THRUST2);
        skills.add(PIERCE2);
        skills.add(PARRY2);
        skills.add(FOCUS2);
        skills.add(REFLECT2);
        skills.add(WATER2);
        skills.add(ICE2);
        skills.add(FIRE2);
        skills.add(LIGHTNING2);
        return skills;
    }

    /**
     * Gets the name of the skill.
     *
     * @return the name of the skill
     */
    public String getName() {
        return nameOfSkill;
    }

    /**
     * Gets the type of the skill.
     *
     * @return the type of the skill (-1 for defensive, 1 for physical, 2 for magic, 0 for other)
     */
    public int getType() {
        return type;
    }

    /**
     * Gets the level of the skill.
     *
     * @return the level of the skill
     */
    public int getLevel() {
        return level;
    }
}
