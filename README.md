# Monster Hunter - Runa’s Strive Game

**Monster Hunter—Runa’s Strive Game** is a command-line RPG in which players take on the role of Runa, a courageous hero battling through monster-filled stages. Developed as an educational project, this game focuses on strategic skill management, character progression, and immersive turn-based combat.

## 🎮 Game Overview
In **Runa’s Strive**, players guide Runa through progressively challenging stages, selecting from three distinct character classes—Warrior, Mage, or Paladin. Each class offers unique abilities and strategies, requiring players to carefully choose skills, health management, and rewards after battles.

### Key Features
- **Character Class Selection**: Choose from three character classes, each with a tailored set of skills.
- **Turn-Based Combat**: Engage in strategic, skill-based combat against various monsters.
- **Skill Management**: Use skill cards carefully; discard them to heal or enhance your deck by choosing rewards.
- **Stage Progression**: Face increasingly difficult monsters and climactic bosses as you progress.

## 📂 Project Structure

- **`model.game`**: Contains classes for the game’s structure, levels, and stages.
- **`model.players`**: Manages player entities, with `PlayerRuna` for Runa and various monster types.
- **`model.resources`**: Defines commands, error messages, and messages for consistent in-game communication.
- **`model.skills`**: Organizes skills for Runa and monsters, creating diverse combat scenarios.
- **`utilities`**: Provides utility classes like `Heal` and `Reward`, adding depth to gameplay by managing health and rewards.

## 📜 How to Play

1. **Select Runa's Class**  
   Choose between Warrior, Mage, or Paladin, each with unique abilities and skill cards.

2. **Fight Through Stages**  
   Battle a variety of monsters with distinct skills. Plan your moves, manage health, and adapt to new challenges.

3. **Skill and Health Management**  
   Use the `Heal` utility to discard skills for health, and the `Reward` system to strengthen Runa’s deck as you progress.

4. **Defeat Bosses**  
   Each level culminates in a boss fight, where strategic skill use and timing are essential.

## 📈 How to Run

To set up and play the game locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Monster-Hunter-Runas-Strive.git
   cd Monster-Hunter-Runas-Strive
Compile and run the game:
bash
javac Application.java
java Application
