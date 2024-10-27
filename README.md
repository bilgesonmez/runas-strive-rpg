# Monster Hunter - Runa’s Strive Game

Monster Hunter - Runa’s Strive Game is an engaging, turn-based RPG designed to deliver a challenging and strategic gameplay experience. Developed as a school project, this game puts players in control of Runa, a determined hero journeying through progressively difficult stages filled with fierce monsters, strategic skill choices, and unique rewards. Whether you're a Warrior, Mage, or Paladin, each decision matters as you balance your health, skill management, and the threat of new adversaries.

## 🎮 Game Overview

Runa’s Strive combines classic RPG elements with a command-line interface, creating an immersive, interactive experience that’s accessible and strategic. Players are tasked with advancing through levels populated by increasingly challenging monsters, each equipped with unique skills. Success depends on choosing the right class, using skills wisely, and adapting to various enemy types. As Runa, players must navigate the perils of each stage, deciding when to discard skills for healing, selecting rewards to strengthen their deck, and staying alert as new monster abilities emerge.

### Key Gameplay Mechanics
- **Character Classes**: Each class—Warrior, Mage, and Paladin—comes with a unique deck of skills. Choose a class that matches your preferred combat style and adapt your strategy accordingly.
- **Strategic Combat**: Engage in battles where each skill card plays a role in either offense, defense, or strategic advantage.
- **Dynamic Skill Management**: Runa’s skills are not unlimited; players must manage skill cards, heal by discarding, and gain new abilities as they progress.
- **Stage Progression**: As players advance, each stage introduces tougher foes, culminating in climactic boss battles that test skill and strategy.
- **Reward and Healing System**: After each successful encounter, players earn rewards and choose between strengthening Runa’s deck or healing to prepare for the next fight.

## 🧩 Project Structure

The game’s structure is designed with modularity in mind, allowing for smooth extension and easy maintenance. Here’s an overview of the core packages and classes:

1. **Application**
   - `Application.java`: The main entry point that sets up the game. Players select a character class, initialize the game, and start their journey. The game loop is defined here, alongside input validation and the transition to the interactive UI.

2. **model.game**
   - `Game.java`: Manages the overall state, levels, and progression of the game, from start to finish.
   - `Level` and `Stage` Enumerations: Define the game's progression system, tracking stages and level-specific details to progressively increase difficulty.

3. **model.players**
   - **Player Classes**: Centralizes player management, with `PlayerRuna` for Runa’s character and `PlayerMonster` to represent different monsters.
   - **Monster Packages**:
      The `first level` and `second level` packages define the types of monsters encountered in each stage. Each monster, such as a `Spider`, `Goblin`, or `MegaSaurus`, has unique skills that challenge the player with different combat scenarios.

4. **model.resources**
   - `Commands`: Defines core commands such as "quit."
   - `Errors` and `Messages`: Standardizes error and feedback messages to ensure consistent communication with players.

5. **model.skills**
   - `RunasSkills`: Defines Runa’s skill cards, categorized by type and level. Includes both physical and magic offensive skills, as well as defensive options to counter monsters’ attacks.
   - `MonsterSkills`: An enumeration of monster-specific skills, ranging from elemental attacks to physical strikes, increasing in complexity with game progression.
   - **Skill Groups**: The `FirstLevelMonsterSkills` and `SecondLevelMonsterSkills` classes organize skill sets by stage, ensuring smooth skill allocation for each monster.

6. **utilities**
   - `Heal`: Provides Runa with a means to heal by discarding cards, adding a layer of strategy around skill management and resource allocation.
   - `Reward`: Manages the reward system, enabling players to acquire new skills after winning battles. Tailored to encourage deck expansion and adaptability.

## 📜 Gameplay Flow

**Begin the Journey**

Players select Runa’s class—Warrior, Mage, or Paladin—and are equipped with a corresponding skill set. Each class influences Runa’s abilities, and the choice determines your starting deck and overall strategy.

**Battle Mechanics**

Runa advances through a sequence of battles, each stage presenting unique monsters with progressively challenging abilities. Combat is turn-based, where players choose from available skills to strike, defend, or apply effects to survive and conquer.

**Skill and Health Management**

Health is crucial in survival, and Runa can heal by discarding skill cards through the `Heal` utility. Players must weigh the pros and cons of discarding useful skills to regain health, adding a tactical element to each encounter.

**Rewards and Advancement**

Upon defeating monsters, players can select new skill cards as rewards. Depending on the stage, the number of loot options varies, allowing players to strengthen Runa’s deck and prepare for tougher enemies. These rewards enhance replayability by introducing customization.

**Climactic Boss Battles**

Each stage culminates in a boss fight where players encounter the most powerful foes, such as `Spider King` or `MegaSaurus`. These encounters push the player's tactical knowledge and resource management to the limit, serving as a capstone to each level.

## 📈 How to Run

To set up and play the game locally:

1. Clone the Repository:
   ```bash
   git clone https://github.com/yourusername/Monster-Hunter-Runas-Strive.git
   cd Monster-Hunter-Runas-Strive
Compile and Run:
javac Application.java
java Application


## 💡 Highlights and Innovations
**Strategic Depth:** With health management, skill discarding, and a diverse reward system, players must constantly adapt their strategy to succeed.
**Class and Skill Diversity:** Each character class provides a distinct gameplay experience, from high-damage Warriors to magic-wielding Mages, with unique skills that affect both offense and defense.
**Progressive Difficulty and Replayability:** Levels and monsters evolve, providing an increasing challenge that encourages players to replay and try new approaches.
**Rich Command-Line Interface:** Designed to be engaging and responsive, the CLI delivers an intuitive way to navigate the game’s mechanics and interact with Runa’s journey.

Monster Hunter - Runa’s Strive Game offers a captivating experience that balances challenging gameplay with an interactive command-line setup. Prepare to make each decision count, and may you lead Runa to victory against all odds! :)
