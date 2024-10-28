package edu.kit.informatik.model.skills;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates the lists of second level monsters skills and returns the lists.
 *
 * @author bilgesonmez
 * @version 1.0
 */
public class SecondLevelMonsterSkills {

    /**
     * Creates the list of skills of the monster Mega Saurus.
     *
     * @return the list of skills of the monster Mega Saurus.
     */
    public List<MonsterSkills> getMegaSaurus() {
        List<MonsterSkills> megaSaurus = new ArrayList<>();
        megaSaurus.add(MonsterSkills.BITE2);
        megaSaurus.add(MonsterSkills.BLOCK2);
        megaSaurus.add(MonsterSkills.FOCUS2);
        megaSaurus.add(MonsterSkills.FIRE);
        megaSaurus.add(MonsterSkills.LIGHTNING);

        return megaSaurus;
    }

    /**
     * Creates the list of skills of the monster Snake.
     *
     * @return the list of skills of the monster Snake.
     */
    public List<MonsterSkills> getSnake() {
        List<MonsterSkills> snake = new ArrayList<>();
        snake.add(MonsterSkills.BITE2);
        snake.add(MonsterSkills.FOCUS2);
        snake.add(MonsterSkills.ICE2);
        return snake;
    }

    /**
     * Creates the list of skills of the monster Dark Elf.
     *
     * @return the list of skills of the monster Dark ELf.
     */
    public List<MonsterSkills> getDarkElf() {
        List<MonsterSkills> darkElf = new ArrayList<>();
        darkElf.add(MonsterSkills.FOCUS2);
        darkElf.add(MonsterSkills.WATER);
        darkElf.add(MonsterSkills.LIGHTNING);
        return darkElf;
    }

    /**
     * Creates the list of skills of the monster Shadow Blade.
     *
     * @return the list of skills of the monster Shadow Blade.
     */
    public List<MonsterSkills> getShadowBlade() {
        List<MonsterSkills> shadowBlade = new ArrayList<>();
        shadowBlade.add(MonsterSkills.SCRATCH2);
        shadowBlade.add(MonsterSkills.FOCUS2);
        shadowBlade.add(MonsterSkills.LIGHTNING2);
        return shadowBlade;
    }

    /**
     * Creates the list of skills of the monster Hornet.
     *
     * @return the list of skills of the monster Hornet.
     */
    public List<MonsterSkills> getHornet() {
        List<MonsterSkills> hornet = new ArrayList<>();
        hornet.add(MonsterSkills.SCRATCH2);
        hornet.add(MonsterSkills.FOCUS2);
        hornet.add(MonsterSkills.FIRE);
        hornet.add(MonsterSkills.FIRE2);

        return hornet;
    }

    /**
     * Creates the list of skills of the monster Tarantula.
     *
     * @return the list of skills of the monster Tarantula.
     */
    public List<MonsterSkills> getTarantula() {
        List<MonsterSkills> tarantula = new ArrayList<>();
        tarantula.add(MonsterSkills.BITE2);
        tarantula.add(MonsterSkills.BLOCK2);
        tarantula.add(MonsterSkills.SCRATCH2);
        return tarantula;
    }

    /**
     * Creates the list of skills of the monster Bear.
     *
     * @return the list of skills of the monster Bear.
     */
    public List<MonsterSkills> getBear() {
        List<MonsterSkills> bear = new ArrayList<>();
        bear.add(MonsterSkills.CLAW2);
        bear.add(MonsterSkills.DEFLECT2);
        bear.add(MonsterSkills.BLOCK2);
        return bear;
    }

    /**
     * Creates the list of skills of the monster Mushroomlon.
     *
     * @return the list of skills of the monster M.
     */
    public List<MonsterSkills> getMushroomlon() {
        List<MonsterSkills> mushroomlon = new ArrayList<>();
        mushroomlon.add(MonsterSkills.DEFLECT2);
        mushroomlon.add(MonsterSkills.SCRATCH2);
        mushroomlon.add(MonsterSkills.BLOCK2);
        return mushroomlon;
    }

    /**
     * Creates the list of skills of the monster Wild Boar.
     *
     * @return the list of skills of the monster Wild Boar.
     */
    public List<MonsterSkills> getWildBoar() {
        List<MonsterSkills> wildBoar = new ArrayList<>();
        wildBoar.add(MonsterSkills.DEFLECT);
        wildBoar.add(MonsterSkills.SCRATCH);
        return wildBoar;
    }
}

