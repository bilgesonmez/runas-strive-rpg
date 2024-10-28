package edu.kit.informatik.model.players.monsters.secondLevel;

import edu.kit.informatik.model.players.PlayerMonster;
import edu.kit.informatik.model.skills.MonsterSkills;

import java.util.List;

/**
 * Represents the monster Mushroomlon.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class Mushroomlon extends PlayerMonster {
    /**
     * Constructs a new player. A player has a name, health points, focus points and cards.
     *
     * @param name          the name
     * @param initialHealth the initial health points
     * @param skills        skills of the monster
     */
    public Mushroomlon(String name, int initialHealth, List<MonsterSkills> skills) {
        super(name, initialHealth, skills);
    }
}
