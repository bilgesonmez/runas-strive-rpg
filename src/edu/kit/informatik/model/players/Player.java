package edu.kit.informatik.model.players;

/**
 * Represents a player of the game.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class Player {

    private final String name;
    private int health;
    private int focusPoints;
    private boolean hasRolledTheDice;

    /**
     * Constructs a new player. A player has a name, health points, focus points and cards.
     *
     * @param name               the name
     * @param initialHealth      the initial health points
     * @param initialFocusPoints the initial focus points
     */
    public Player(String name, int initialHealth, int initialFocusPoints) {
        this.name = name;
        this.health = initialHealth;
        this.focusPoints = initialFocusPoints;
        this.hasRolledTheDice = false;
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
        this.focusPoints += focusPoints;
    }

    /**
     * Removes the specified tokens from this players token count.
     *
     * @param focusPoints the focus points
     * @throws IllegalArgumentException if {@code focus points} is negative
     */
    public void removeFocusPoints(int focusPoints) {
        if (focusPoints >= this.focusPoints) {
            setFocusPoints(1);
        } else {
            this.focusPoints -= focusPoints;
        }
    }

    /**
     * Returns {@code true} if this player has rolled the dice.
     *
     * @return {@code true} if this player has rolled the dice
     */
    public boolean hasRolledTheDice() {
        return this.hasRolledTheDice;
    }

    /**
     * Returns {@code true} if this player has selected a god favor, i.e. the god favor is set and not empty.
     *
     * @return {@code true} if this player has selected a god favor
     */
    public boolean hasDrawnCard() {
        return false;
    }

}
