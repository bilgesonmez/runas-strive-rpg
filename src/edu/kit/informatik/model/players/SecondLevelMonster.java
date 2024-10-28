package edu.kit.informatik.model.players;

import edu.kit.informatik.model.players.monsters.secondLevel.*;
import edu.kit.informatik.model.skills.SecondLevelMonsterSkills;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the deck of second-level monsters, including the Big Boss.
 *
 * @version 1.0
 */
public class SecondLevelMonster {

    private final SecondLevelMonsterSkills skills = new SecondLevelMonsterSkills();

    // Define second-level monsters with their names, health, and specific skills
    private final MegaSaurus megaSaurus = new MegaSaurus("Mega Saurus", 100, skills.getMegaSaurus());
    private final Snake snake = new Snake("Snake", 31, skills.getSnake());
    private final DarkElf darkElf = new DarkElf("Dark Elf", 34, skills.getDarkElf());
    private final ShadowBlade shadowBlade = new ShadowBlade("Shadow Blade", 27, skills.getShadowBlade());
    private final Hornet hornet = new Hornet("Hornet", 32, skills.getHornet());
    private final Tarantula tarantula = new Tarantula("Tarantula", 33, skills.getTarantula());
    private final Bear bear = new Bear("Bear", 40, skills.getBear());
    private final Mushroomlon mushroomlon = new Mushroomlon("Mushroomlon", 50, skills.getMushroomlon());
    private final WildBoar wildBoar = new WildBoar("Wild Boar", 27, skills.getWildBoar());

    /**
     * Returns a list containing only the Big Boss monster, Mega Saurus.
     *
     * @return a list with the Big Boss monster
     */
    public List<PlayerMonster> getBigBossMonster() {
        List<PlayerMonster> bigBoss = new ArrayList<>();
        bigBoss.add(megaSaurus);
        return bigBoss;
    }

    /**
     * Creates and returns a list of second-level monsters for the deck.
     *
     * @return a list of second-level monsters excluding the Big Boss
     */
    public List<PlayerMonster> createDeck() {
        List<PlayerMonster> monsters = new ArrayList<>();
        monsters.add(snake);
        monsters.add(darkElf);
        monsters.add(shadowBlade);
        monsters.add(hornet);
        monsters.add(tarantula);
        monsters.add(bear);
        monsters.add(mushroomlon);
        monsters.add(wildBoar);
        return monsters;
    }
}
