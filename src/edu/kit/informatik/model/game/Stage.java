package edu.kit.informatik.model.game;

/**
 * An enumeration of the stages of the game. Each level of the game contains 4 stages.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public enum Stage {
    /**
     * The first {@link Stage stage} with RUna and a monster.
     */
    FIRST_STAGE(1),
    /**
     * The second {@link Stage stage} with Runa and two monsters.
     */
    SECOND_STAGE(2),
    /**
     * The third {@link Stage stage} with Runa and two monsters.
     */
    THIRD_STAGE(3),
    /**
     * The fourth {@link Stage stage} Big Boss Monster Stage, which Runa and a big boss monster fights.
     */
    FOURTH_STAGE(4);

    private final int stage;

    /**
     * Constructs a stage.
     *
     * @param stage the stage of the game.
     */
    Stage(int stage) {
        this.stage = stage;
    }

    /**
     * Getter for stage
     *
     * @return the stage of the game.
     */
    public int getStage() {
        return (this.stage);
    }
}
