package edu.kit.informatik.model.players.monsters.firstLevel;

import edu.kit.informatik.model.skills.MonsterSkills;
import edu.kit.informatik.model.players.PlayerMonster;

import java.util.List;

/**
 * Represents the monster Rat.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class Rat extends PlayerMonster {
    /**
     * Constructs a new player. A player has a name, health points, focus points and cards. Each player starts the game
     * with 0 focus points and 50 health points.
     *
     * @param name          the name
     * @param initialHealth the initial health points
     * @param skills        the skill cards of the monster
     */
    public Rat(String name, int initialHealth, List<MonsterSkills> skills) {
        super(name, initialHealth, skills);
    }
}
