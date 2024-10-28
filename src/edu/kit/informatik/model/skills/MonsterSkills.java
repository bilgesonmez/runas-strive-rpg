package edu.kit.informatik.model.skills;

/**
 * An enumeration representing the various skills available to monsters in the game.
 * Each skill has a name and a level, which indicates its strength or stage of use.
 * Skills can be offensive, defensive, or supportive, allowing monsters to challenge Runa in different ways.
 *
 * @version 1.0
 */
public enum MonsterSkills {

    // Basic offensive skills
    /**
     * A basic scratch attack (level 1).
     */
    SCRATCH("Scratch(1)", 1),

    /**
     * A basic claw attack (level 1).
     */
    CLAW("Claw(1)", 1),

    /**
     * A basic smash attack (level 1).
     */
    SMASH("Smash(1)", 1),

    /**
     * A basic bite attack (level 1).
     */
    BITE("Bite(1)", 1),

    // Focus and defensive skills
    /**
     * Focus skill allowing the monster to increase focus points (level 1).
     */
    FOCUS("Focus(1)", 1),

    /**
     * A defensive block skill that reduces incoming damage (level 1).
     */
    BLOCK("Block(1)", 1),

    /**
     * A deflect skill that can reflect certain attacks (level 1).
     */
    DEFLECT("Deflect(1)", 1),

    // Elemental magic skills
    /**
     * Water-based magical skill for dealing damage or effects (level 1).
     */
    WATER("Water(1)", 1),

    /**
     * Ice-based magical skill that may slow or damage the opponent (level 1).
     */
    ICE("Ice(1)", 1),

    /**
     * Fire-based magical skill that inflicts burn or damage (level 1).
     */
    FIRE("Fire(1)", 1),

    /**
     * Lightning-based magical skill for high-impact damage (level 1).
     */
    LIGHTNING("Lightning(1)", 1),

    // Level 2 upgraded skills for stronger effect
    /**
     * An upgraded scratch attack (level 2).
     */
    SCRATCH2("Scratch(2)", 1),

    /**
     * An upgraded claw attack (level 2).
     */
    CLAW2("Claw(2)", 1),

    /**
     * An upgraded smash attack (level 2).
     */
    SMASH2("Smash(2)", 1),

    /**
     * An upgraded bite attack (level 2).
     */
    BITE2("Bite(2)", 1),

    /**
     * An upgraded focus skill allowing higher focus point accumulation (level 2).
     */
    FOCUS2("Focus(2)", 1),

    /**
     * An upgraded block skill with enhanced defensive capabilities (level 2).
     */
    BLOCK2("Block(2)", 1),

    /**
     * An upgraded deflect skill with greater reflection ability (level 2).
     */
    DEFLECT2("Deflect(2)", 1),

    /**
     * A level 2 water-based magical skill for increased damage or effects.
     */
    WATER2("Water(2)", 1),

    /**
     * A level 2 ice-based magical skill with more powerful effects.
     */
    ICE2("Ice(2)", 1),

    /**
     * A level 2 fire-based magical skill for stronger burn or damage.
     */
    FIRE2("Fire(2)", 1),

    /**
     * A level 2 lightning-based magical skill for intensified impact.
     */
    LIGHTNING2("Lightning(2)", 1);

    private final String nameOfSkill;
    private final int level;

    /**
     * Constructs a monster skill with a specified name and level.
     *
     * @param nameOfSkill the name of the skill
     * @param level       the level of the skill, indicating strength or stage
     */
    MonsterSkills(String nameOfSkill, int level) {
        this.nameOfSkill = nameOfSkill;
        this.level = level;
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
     * Gets the level of the skill.
     *
     * @return the level of the skill
     */
    public int getLevel() {
        return level;
    }
}
