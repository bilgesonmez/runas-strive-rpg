package edu.kit.informatik.model.skills;

import java.util.ArrayList;
import java.util.List;


/**
 * This class creates the lists of monsters skills and returns the lists.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class FirstLevelMonsterSkills {
    /**
     * Creates the list of skills of the monster Frog.
     *
     * @return the list of skills of the monster Frog.
     */
    public List<MonsterSkills> getFrog() {
        List<MonsterSkills> frog = new ArrayList<>();
        frog.add(MonsterSkills.FOCUS);
        frog.add(MonsterSkills.WATER);
        return frog;
    }

    /**
     * Creates the list of skills of the monster Spider King.
     *
     * @return the list of skills of the monster Spider King.
     */
    public List<MonsterSkills> getSpiderKing() {
        List<MonsterSkills> spiderKing = new ArrayList<>();
        spiderKing.add(MonsterSkills.BITE);
        spiderKing.add(MonsterSkills.BLOCK);
        spiderKing.add(MonsterSkills.FOCUS);
        spiderKing.add(MonsterSkills.LIGHTNING);
        return spiderKing;
    }

    /**
     * Creates the list of skills of the monster Ghost.
     *
     * @return the list of skills of the monster Ghost.
     */
    public List<MonsterSkills> getGhost() {
        List<MonsterSkills> ghost = new ArrayList<>();
        ghost.add(MonsterSkills.FOCUS);
        ghost.add(MonsterSkills.ICE);
        return ghost;
    }

    /**
     * Creates the list of skills of the monster Gorgon.
     *
     * @return the list of skills of the monster Gorgon.
     */
    public List<MonsterSkills> getGorgon() {
        List<MonsterSkills> gorgon = new ArrayList<>();
        gorgon.add(MonsterSkills.FOCUS);
        gorgon.add(MonsterSkills.FIRE);
        return gorgon;
    }

    /**
     * Creates the list of skills of the monster Skeleton.
     *
     * @return the list of skills of the monster Skeleton.
     */
    public List<MonsterSkills> getSkeleton() {
        List<MonsterSkills> skeleton = new ArrayList<>();
        skeleton.add(MonsterSkills.FOCUS);
        skeleton.add(MonsterSkills.LIGHTNING);
        return skeleton;
    }

    /**
     * Creates the list of skills of the monster Spider.
     *
     * @return the list of skills of the monster Spider.
     */
    public List<MonsterSkills> getSpider() {
        List<MonsterSkills> spider = new ArrayList<>();
        spider.add(MonsterSkills.BITE);
        spider.add(MonsterSkills.BLOCK);
        return spider;
    }

    /**
     * Creates the list of skills of the monster Goblin.
     *
     * @return the list of skills of the monster Goblin.
     */
    public List<MonsterSkills> getGoblin() {
        List<MonsterSkills> goblin = new ArrayList<>();
        goblin.add(MonsterSkills.SMASH);
        goblin.add(MonsterSkills.DEFLECT);
        return goblin;
    }

    /**
     * Creates the list of skills of the monster Rat.
     *
     * @return the list of skills of the monster Rat.
     */
    public List<MonsterSkills> getRat() {
        List<MonsterSkills> rat = new ArrayList<>();
        rat.add(MonsterSkills.BLOCK);
        rat.add(MonsterSkills.CLAW);
        return rat;
    }

    /**
     * Creates the list of skills of the monster Mushroomlin.
     *
     * @return the list of skills of the monster Mushroomlin.
     */
    public List<MonsterSkills> getMushoomlin() {
        List<MonsterSkills> mushroomlin = new ArrayList<>();
        mushroomlin.add(MonsterSkills.DEFLECT);
        mushroomlin.add(MonsterSkills.SCRATCH);
        return mushroomlin;
    }
}
