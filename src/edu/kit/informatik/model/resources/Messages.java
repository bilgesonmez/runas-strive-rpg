package edu.kit.informatik.model.resources;

/**
 * This class provides resources and throws messages.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public final class Messages {

    /**
     * The command not found message.
     */
    public static final String COMMAND_NOT_FOUND = "Command not found";
    /**
     * s
     */
    public static final String ENTER_SEED = "To shuffle ability cards and monsters, enter two seeds\n"
            + "Enter seeds [1--2147483647] separated by comma:";
    /**
     * s
     */
    public static final String WELCOME_MESSAGE = "Welcome to Runa's Strive\n" + "Select Runa's character class\n"
            + "1) Warrior\n" + "2) Mage" + '\n' + "3) Paladin";
    /**
     * s
     */
    public static final String SELECT = "----------------------------------------\n" + "Select card to play";
    /**
     * s
     */
    public static final String LINE = "----------------------------------------\n";

    private Messages() {
        // This is a utility class so has a private constructor.
    }

}
