package edu.kit.informatik.model.players;

import edu.kit.informatik.model.skills.FirstLevelMonsterSkills;
import edu.kit.informatik.model.players.monsters.firstLevel.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the deck of first-level monsters, including the Big Boss.
 *
 * @version 1.0
 */
public class FirstLevelMonster {
    private final FirstLevelMonsterSkills skills = new FirstLevelMonsterSkills();

    // First-level monsters with their names, health, and specific skills
    private final SpiderKing spiderKing = new SpiderKing("Spider King", 50, skills.getSpiderKing());
    private final Frog frog = new Frog("Frog", 16, skills.getFrog());
    private final Ghost ghost = new Ghost("Ghost", 15, skills.getGhost());
    private final Gorgon gorgon = new Gorgon("Gorgon", 13, skills.getGorgon());
    private final Skeleton skeleton = new Skeleton("Skeleton", 14, skills.getSkeleton());
    private final Spider spider = new Spider("Spider", 15, skills.getSpider());
    private final Goblin goblin = new Goblin("Goblin", 12, skills.getGoblin());
    private final Rat rat = new Rat("Rat", 14, skills.getRat());
    private final Mushroomlin mushroomlin = new Mushroomlin("Mushroomlin", 20, skills.getMushoomlin());

    /**
     * Returns a list containing only the Big Boss monster, Spider King.
     *
     * @return a list with the Big Boss monster
     */
    public List<PlayerMonster> getBigBossMonster() {
        List<PlayerMonster> bigBoss = new ArrayList<>();
        bigBoss.add(spiderKing);
        return bigBoss;
    }

    /**
     * Creates and returns a list of first-level monsters for the deck.
     *
     * @return a list of first-level monsters excluding the Big Boss
     */
    public List<PlayerMonster> createDeck() {
        List<PlayerMonster> monsters = new ArrayList<>();
        monsters.add(frog);
        monsters.add(ghost);
        monsters.add(gorgon);
        monsters.add(skeleton);
        monsters.add(spider);
        monsters.add(goblin);
        monsters.add(rat);
        monsters.add(mushroomlin);
        return monsters;
    }
}
