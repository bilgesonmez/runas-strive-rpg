package edu.kit.informatik.model.game;

/**
 * An enumeration of the die faces.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public enum Die {
    /**
     * The four-faced {@link Die die}.
     */
    FOUR_FACES("d4", 4),
    /**
     * The six-faced {@link Die die}.
     */
    SIX_FACES("d6", 6),
    /**
     * The eight-faced {@link Die die}.
     */
    EIGHT_FACES("d8", 8),
    /**
     * The ten-faced {@link Die die}.
     */
    TEN_FACES("d10", 10),
    /**
     * The ten-faced {@link Die die}.
     */
    TWELVE_FACES("d12", 12);


    private final String face;
    private final int value;

    /**
     * Constructs the die.
     *
     * @param face  the symbol starts with d and die's face
     * @param value the valu of the die faces
     */
    Die(String face, int value) {
        this.face = face;
        this.value = value;
    }

    /**
     * Getter for faces.
     *
     * @return faces of die
     */
    public String getFace() {
        return this.face;
    }

    /**
     * Getter for value of die.
     *
     * @return die's face number
     */
    public int getValue() {
        return this.value;
    }

}


