package edu.kit.informatik.model.players.monsters.firstLevel;

import edu.kit.informatik.model.skills.MonsterSkills;
import edu.kit.informatik.model.players.PlayerMonster;

import java.util.List;

/**
 * Represents the monster Frog.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class Frog extends PlayerMonster {
    /**
     * Constructs a new player. A player has a name, health points, focus points and cards.
     *
     * @param name          the name
     * @param initialHealth the initial health points
     * @param skills        skills of the monster
     */
    public Frog(String name, int initialHealth, List<MonsterSkills> skills) {
        super(name, initialHealth, skills);
    }

}
