package edu.kit.informatik.model.players;

import edu.kit.informatik.model.skills.RunasSkills;

import java.util.List;
import java.util.Objects;


/**
 * Represents a player of the game.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class PlayerRuna extends Player {
    private final String name;
    private int health;
    private int focusPoints;
    private List<RunasSkills> skillCards;

    /**
     * Constructs a new player. A player has a name, health points, focus points and cards. Each player starts the game
     * with 0 focus points and 50 health points.
     *
     * @param name               the name
     * @param initialHealth      the initial health points
     * @param initialFocusPoints focus points
     * @param skillCards         skills of the monster
     */
    public PlayerRuna(String name, int initialHealth, int initialFocusPoints, List<RunasSkills> skillCards) {
        super(name, initialHealth, initialFocusPoints);
        this.name = name;
        this.focusPoints = initialFocusPoints;
        this.health = initialHealth;
        this.skillCards = skillCards;
    }

    /**
     * Sets health.
     *
     * @param health the health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Sets focus points.
     *
     * @param focusPoints focus points
     */
    public void setFocusPoints(int focusPoints) {
        if (focusPoints <= 0) {
            this.focusPoints = 1; //the focus point can never be less than 1
        } else {
            this.focusPoints = focusPoints;
        }
    }

    /**
     * Gets skill cards of Runa
     *
     * @return skill cards of Runa
     */
    public List<RunasSkills> getSkillCards() {
        return Objects.requireNonNull(this.skillCards);
    }

    /**
     * Sets skill cards of Runa
     *
     * @param skillCards skill cards of Runa
     */
    public void setSkillCards(List<RunasSkills> skillCards) {
        this.skillCards = skillCards;
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
     */
    public void heal(int amount) {
        if (amount >= 0) {
            this.health += amount;
            if (health >= 50) {
                setHealth(50);
            }
        }
    }

    /**
     * Damages this player by the given amount.
     *
     * @param amount the amount
     */
    public void damage(int amount) {
        if (amount > 0) {
            this.health = amount <= this.health ? this.health - amount : 0;
        }
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
     */
    public void addFocusPoints(int focusPoints) {
        if (focusPoints < 0) {
            return;
        }
        this.focusPoints += focusPoints;
    }

    /**
     * Removes the specified focus point from these players focus point. If the focus point is 1, it does not reduce
     * and stay the same.
     *
     * @param focusPoints the focus points
     */
    public void removeFocusPoints(int focusPoints) {
        if (this.focusPoints > 1) {
            this.focusPoints -= focusPoints;
        }


    }
}
