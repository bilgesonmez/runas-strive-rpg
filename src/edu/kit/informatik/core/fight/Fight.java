package edu.kit.informatik.core.fight;

import edu.kit.informatik.model.skills.RunasSkills;
import edu.kit.informatik.model.game.Game;
import edu.kit.informatik.model.players.PlayerMonster;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * This class contains method of Runa fighting with a monster/ two monsters.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class Fight {

    /**
     * Starts a fight between Runa and two monsters.
     *
     * @param game               the game
     * @param firstMonster       the first monster
     * @param secondMonster      the second monster
     * @param messageOne         the message of first monster, which affects Runa
     * @param messageTwo         the message of second  monster, which affects Runa
     * @param indexFirstMonster  the index of the skill of the first monster
     * @param indexSecondMonster the index of the skill of the second monster
     * @return messages of monsters as a string
     */
    public String fightWithTwoMonsters(Game game, PlayerMonster firstMonster, PlayerMonster secondMonster,
                                       String messageOne, String messageTwo, int indexFirstMonster,
                                       int indexSecondMonster) {
        OneMonsterFight oneMonsterFight = new OneMonsterFight();
        Scanner scanner = new Scanner(System.in);
        String firstMessage = messageOne;
        String secondMessage = messageTwo;
        PlayerMonster target = firstMonster;
        PlayerMonster other = secondMonster;
        int index = indexFirstMonster;
        int othersIndex = indexSecondMonster;
        RunasAffects affect = new RunasAffects();
        MonstersAffects monsterAffect = new MonstersAffects();
        RunasSkills skill = drawSkillCard(game.getRuna().getSkillCards());
        if (skill == RunasSkills.QUIT) {
            return "quit";
        }
        String message = firstMessage;
        String otherMessage = secondMessage;
        if (skill.getType() == 1 || skill.getType() == 2) { // if the card is offensive
            String targetMonster;
            do {
                System.out.println("Select Runa's target.\n1) " + firstMonster.getName() + "\n2) " + other.getName()
                        + "\nEnter number [1--2]:");
                targetMonster = scanner.nextLine();
                if (targetMonster.equals("quit")) {
                    return "quit";
                }
            } while (!(Integer.parseInt(targetMonster) == 1) && !(Integer.parseInt(targetMonster) == 2));
            if ((Integer.parseInt(targetMonster) == 2)) { // targetMonster is the second one
                target = other;
                othersIndex = indexFirstMonster;
                index = indexSecondMonster;
                other = firstMonster;
                message = secondMessage;
                otherMessage = firstMessage;
            }
            System.out.println("Runa uses " + skill.getName());
            message = affect.runasAffect(skill, game, target, message);
            if (message.equals("quit")) {
                return "quit";
            }
        } else { // if the card is defensive or neutral
            System.out.println("Runa uses " + skill.getName());
            // monster is null because there is no target monster
            message = affect.runasAffect(skill, game, null, message);
            if (message.equals("quit")) {
                return "quit";
            }
        }
        if (Objects.requireNonNull(target).isDead()) { // if one of the monsters is dead
            System.out.println(target.getName() + " dies");
            if (firstMonster.equals(target)) {
                checkFocus(secondMessage, skill, secondMonster, game);
            } else {
                checkFocus(firstMessage, skill, firstMonster, game);
            }
            System.out.println(other.getName() + " uses " + other.getSkills().get(othersIndex).getName());
            message = monsterAffect.monstersAffect(other, other.getSkills().get(othersIndex), game.getRuna(), message);
            if (target.getSkills().size() - 1 == othersIndex) {
                othersIndex = 0; // turn back to zero, because it is a cycle
            } else {
                othersIndex++;
            }
            if (oneMonsterFight.oneMonsterFight(other, game, othersIndex, message)) {
                return "quit";
            }

            return null;
        }
        checkFocus(firstMessage, skill, firstMonster, game);
        checkFocus(secondMessage, skill, secondMonster, game);
        System.out.println(firstMonster.getName() + " uses "
                + firstMonster.getSkills().get(indexFirstMonster).getName());
        firstMessage = monsterAffect.monstersAffect(firstMonster, firstMonster.getSkills().get(indexFirstMonster),
                game.getRuna(), message);
        System.out.println(secondMonster.getName() + " uses "
                + secondMonster.getSkills().get(indexSecondMonster).getName());
        secondMessage = monsterAffect.monstersAffect(secondMonster, secondMonster.getSkills().get(indexSecondMonster),
                game.getRuna(), message);
        return (firstMessage + "," + secondMessage);
    }

    /**
     * Checks focus conditions.
     *
     * @param message the message
     * @param skill   the skill
     * @param monster the monster
     * @param game    the game
     */
    public void checkFocus(String message, RunasSkills skill, PlayerMonster monster, Game game) {
        if (message.equals("Focus") && !skill.equals(RunasSkills.SLASH)
                && !skill.equals(RunasSkills.SLASH2)
                && !skill.equals(RunasSkills.SWING) && !skill.equals(RunasSkills.SWING2)) {
            monster.addFocusPoints(game.getLevel());
            System.out.println(monster.getName() + " gains " + game.getLevel() + " focus");
        }
    }

    /**
     * Starts a 1-1 fight between Runa and a specific monster.
     *
     * @param game           the game
     * @param monster        the monster
     * @param monsterMessage the message of the monster that affects Runa
     * @param skillIndex     index of skill of monster
     * @return message of Runa that affects monster
     */
    public String monsterVsRuna(Game game, PlayerMonster monster, String monsterMessage, int skillIndex) {
        RunasAffects affect = new RunasAffects();
        MonstersAffects monsterAffect = new MonstersAffects();
        RunasSkills skill = drawSkillCard(game.getRuna().getSkillCards());
        if (skill == RunasSkills.QUIT) {
            return "quit";
        }
        System.out.println("Runa uses " + Objects.requireNonNull(skill).getName());
        String message = affect.runasAffect(skill, game, monster, monsterMessage);
        if (message.equals("quit")) {
            return "quit";
        }
        if (monster.isDead()) {
            return "Monster is dead.";
        }
        System.out.println(monster.getName() + " uses " + monster.getSkills().
                get(skillIndex).getName());
        return monsterAffect.monstersAffect(monster, monster.getSkills().get(skillIndex), game.getRuna(), message);
    }


    /**
     * Provides drawing card from the given deck.
     *
     * @param skillCards the skill card deck of Runa
     * @return the drawn skill card
     */
    public RunasSkills drawSkillCard(List<RunasSkills> skillCards) {
        Scanner scanner = new Scanner(System.in);
        String chosenSkill = "";
        for (int i = 0; i < skillCards.size(); i++) {
            System.out.println(i + 1 + ") " + skillCards.get(i).getName());
        }
        do {
            System.out.println("Enter number [1--" + skillCards.size() + "]:");
            chosenSkill = scanner.nextLine();
            if (chosenSkill.equals("quit")) {
                return RunasSkills.QUIT;
            }
        }
        while (Integer.parseInt(chosenSkill) > skillCards.size() || Integer.parseInt(chosenSkill) < 1);
        return skillCards.get(Integer.parseInt(chosenSkill) - 1);
    }
}

