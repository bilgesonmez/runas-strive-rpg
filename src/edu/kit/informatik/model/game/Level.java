package edu.kit.informatik.model.game;

/**
 * An enumeration of the levels of the game.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public enum Level {
    /**
     * The first {@link Level level}.
     */
    FIRST_LEVEL(1),
    /**
     * The second {@link Level level}.
     */
    SECOND_LEVEL(2);
    private final int level;

    /**
     * Constructs the level.
     *
     * @param level the level of the game
     */
    Level(int level) {
        this.level = level;
    }

    /**
     * Getter for level.
     *
     * @return level of the game
     */
    public int getLevel() {
        return this.level;
    }

}


