package edu.kit.informatik.model.game;

import edu.kit.informatik.model.players.PlayerMonster;
import edu.kit.informatik.model.players.PlayerRuna;
import edu.kit.informatik.model.skills.RunasSkills;

import java.util.Arrays;
import java.util.List;

/**
 * Represents the Runa's Strive Game.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class Game {
    private RunasSkills firstChosenCard;
    private Die dieFace = Die.FOUR_FACES;
    private Stage currentStage;
    private List<PlayerMonster> monsterCards;
    private List<RunasSkills> skillCards = Arrays.asList(RunasSkills.values());
    private Level currentLevel;
    private final PlayerRuna runa = new PlayerRuna("Runa", 50, 1, null);


    /**
     * Constructs the Runa's Strive Game. A Runa's Strive game has two players, three stages and 4 levels:
     * The game starts with the first stage.
     */
    public Game() {
        this.currentStage = Stage.FIRST_STAGE;
        this.currentLevel = Level.FIRST_LEVEL;
    }

    /**
     * Getter for Runa.
     *
     * @return gets the player Runa
     */
    public PlayerRuna getRuna() {
        return runa;
    }

    /**
     * Getter for level.
     *
     * @return the current level as an Integer
     */
    public int getLevel() {
        return currentLevel.getLevel();
    }

    /**
     * Upgrades the die face.
     */
    public void upgradeDie() {
        if (dieFace == Die.FOUR_FACES) {
            setDieFace(Die.SIX_FACES);
        } else if (dieFace == Die.SIX_FACES) {
            setDieFace(Die.EIGHT_FACES);
        } else if (dieFace == Die.EIGHT_FACES) {
            setDieFace(Die.TEN_FACES);
        } else if (dieFace == Die.TEN_FACES) {
            setDieFace(Die.TWELVE_FACES);
        }
    }

    /**
     * Upgrades the stage.
     */
    public void upgradeStage() {
        if (getStage() == Stage.FIRST_STAGE.getStage()) {
            setStage(Stage.SECOND_STAGE);
        } else if (getStage() == Stage.SECOND_STAGE.getStage()) {
            setStage(Stage.THIRD_STAGE);
        } else if (getStage() == Stage.THIRD_STAGE.getStage()) {
            setStage(Stage.FOURTH_STAGE);
        } else if (getStage() == Stage.FOURTH_STAGE.getStage()) {
            setStage(Stage.FIRST_STAGE);
        }
    }

    /**
     * Gets the current stage.
     *
     * @return the current stage
     */
    public int getStage() {
        return currentStage.getStage();
    }

    /**
     * Sets the current stage.
     *
     * @param stage current stage
     */
    public void setStage(Stage stage) {
        this.currentStage = stage;
    }

    /**
     * Gets the die faces.
     *
     * @return the die faces
     */
    public Die getDieFace() {
        return dieFace;
    }

    /**
     * Setter for chosen card.
     *
     * @param firstChosenCard chosen card
     */
    public void setFirstChosenCard(RunasSkills firstChosenCard) {
        this.firstChosenCard = firstChosenCard;
    }

    /**
     * Getter for chosen card.
     *
     * @return chosen card
     */
    public RunasSkills getFirstChosenCard() {
        return firstChosenCard;
    }

    /**
     * Sets the die faces.
     *
     * @param dieFace the die faces
     */
    public void setDieFace(Die dieFace) {
        this.dieFace = dieFace;
    }


    /**
     * Sets the monster cards.
     *
     * @param monsterCards monster cards
     */
    public void setMonsterCards(List<PlayerMonster> monsterCards) {
        this.monsterCards = monsterCards;
    }

    /**
     * Gets the skill cards of Runa
     *
     * @return the skill cards of Runa
     */
    public List<RunasSkills> getSkillCards() {
        return skillCards;
    }

    /**
     * Sets the skill cards of Runa
     *
     * @param skillCards the skill cards of Runa
     */
    public void setSkillCards(List<RunasSkills> skillCards) {
        this.skillCards = skillCards;
    }

    /**
     * Sets the current level.
     *
     * @param currentLevel the current level
     */
    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }


}

