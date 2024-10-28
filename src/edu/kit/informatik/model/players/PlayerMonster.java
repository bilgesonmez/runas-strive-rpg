package edu.kit.informatik.model.players;

import edu.kit.informatik.model.skills.MonsterSkills;

import java.util.List;


/**
 * Represents a player of the game.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class PlayerMonster extends Player {
    private final String name;
    private int health;
    private int focusPoints;
    private List<MonsterSkills> skills;
    private boolean hasRolledTheDice;
    private boolean hasDrawnCard;

    /**
     * Constructs a new player. A player has a name, health points, focus points and cards. Each player starts the game
     * with 0 focus points and 50 health points.
     *
     * @param name          the name
     * @param initialHealth the initial health points
     * @param skills        skills of the monster
     */
    public PlayerMonster(String name, int initialHealth, List<MonsterSkills> skills) {
        super(name, initialHealth, 0);
        this.name = name;
        this.health = initialHealth;
        this.hasRolledTheDice = false;
        this.hasDrawnCard = false;
        this.skills = skills;
    }

    /**
     * s
     *
     * @param health s
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * s
     *
     * @param focusPoints s
     */
    public void setFocusPoints(int focusPoints) {
        this.focusPoints = focusPoints;
    }

    /**
     * s
     *
     * @return s
     */
    public List<MonsterSkills> getSkills() {
        return skills;
    }

    /**
     * s
     *
     * @param skills s
     */
    public void setSkills(List<MonsterSkills> skills) {
        this.skills = skills;
    }


    /**
     * Returns the name of this player.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the current health points of this player.
     *
     * @return the current health points
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Heals this player by the given amount.
     *
     * @param amount the amount
     * @throws IllegalArgumentException if the amount is negative
     */
    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
        this.health += amount;
    }

    /**
     * Damages this player by the given amount.
     *
     * @param amount the amount
     * @throws IllegalArgumentException if the amount is negative
     */
    public void damage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }

        this.health = amount <= this.health ? this.health - amount : 0;
    }


    /**
     * Returns {@code true} if this player is dead, i.e. the health points are zero.
     *
     * @return {@code true} if this player is dead, {@code false} otherwise
     */
    public boolean isDead() {
        return (this.health <= 0);
    }

    /**
     * Returns the current focus points of this player.
     *
     * @return the current focus points
     */
    public int getFocusPoints() {
        return this.focusPoints;
    }

    /**
     * Adds focus points to this players focus points.
     *
     * @param focusPoints the focus points
     * @throws IllegalArgumentException if {@code focus points} is negative
     */
    public void addFocusPoints(int focusPoints) {
        if (focusPoints < 0) {
            throw new IllegalArgumentException();
        }
        this.focusPoints += focusPoints;
    }

    /**
     * Removes the specified tokens from this players token count.
     *
     * @param focusPoints the focus points
     * @throws IllegalArgumentException if {@code focus points} is negative
     */
    public void removeFocusPoints(int focusPoints) {
        if (focusPoints < 0 || focusPoints > this.focusPoints) {
            throw new IllegalArgumentException();
        }
        this.focusPoints -= focusPoints;
    }

    /**
     * Returns {@code true} if this player has rolled the dice.
     *
     * @return {@code true} if this player has rolled the dice
     */
    public boolean hasRolledTheDice() {
        return this.hasRolledTheDice;
    }

}
