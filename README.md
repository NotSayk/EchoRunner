# 🌀 Echo Runner

> _"Et si vous pouviez collaborer avec votre propre passé ?"_

**Echo Runner** est un jeu de plateforme 2D innovant développé en **Java 17** avec le framework **LibGDX 1.14.0**.  
Contrôlez un personnage capable d'enregistrer ses actions pendant quelques secondes — ces actions sont ensuite rejouées en boucle par un **écho temporel**, un clone fantomatique qui répète fidèlement vos mouvements passés.  
Utilisez ces échos pour résoudre des puzzles complexes, activer des interrupteurs et atteindre la sortie de chaque niveau.

**📚 Projet académique** — BUT Informatique, 2ᵉ année — IUT du Havre  
**🗓️ Année universitaire** — 2024-2025

---

## 🎯 Objectif du jeu

Chaque niveau est un puzzle temporel à résoudre grâce à la synchronisation entre le joueur et ses clones :
- 🎬 Enregistrez vos actions au bon moment
- ⚙️ Utilisez vos échos pour activer plusieurs mécanismes simultanément
- 🚶‍♂️ Franchissez des zones inaccessibles en solo
- ⏱️ Terminez les niveaux en un minimum de temps et de tentatives

---

## 🧩 Fonctionnalités principales

- 🕹️ **Gameplay original** : mécanique unique d'enregistrement et de reproduction des actions
- 👻 **Échos temporels** : jusqu'à 3 clones simultanés pour des puzzles complexes
- 🧱 **Physique 2D réaliste** : collisions, plateformes mobiles, gravité
- 🚪 **Puzzles variés** : interrupteurs, portes, pièges, blocs mobiles
- 💾 **Chargement dynamique** des niveaux via fichiers JSON
- 🎨 **Style pixel art minimaliste** avec musique d'ambiance immersive

---

## 🧱 Structure du projet

```
EchoRunner/
├── core/                             # Module principal du jeu
│   ├── src/com/echorunner/
│   │   ├── EchoRunnerGame.java       # Point d'entrée principal (extends Game)
│   │   ├── screens/                  # Écrans de jeu
│   │   │   ├── MainMenuScreen.java   # Menu principal
│   │   │   ├── GameScreen.java       # Écran de gameplay
│   │   │   └── LevelSelectScreen.java # Sélection de niveau
│   │   ├── entities/                 # Entités du jeu
│   │   │   ├── Entity.java           # Classe abstraite de base
│   │   │   ├── Player.java           # Joueur contrôlable
│   │   │   └── Echo.java             # Clone temporel / Onde sonore
│   │   ├── world/                    # Gestion du monde
│   │   │   ├── Level.java            # Niveau de jeu
│   │   │   ├── LevelLoader.java      # Chargement des niveaux
│   │   │   ├── Tile.java             # Tuiles/Blocs
│   │   │   ├── Door.java             # Portes
│   │   │   └── Switch.java           # Interrupteurs
│   │   ├── input/                    # Gestion des contrôles
│   │   │   └── InputHandler.java     # Entrées clavier/souris
│   │   ├── audio/                    # Système audio
│   │   │   ├── Assets.java           # Gestionnaire d'assets
│   │   │   └── SoundManager.java     # Sons et musique
│   │   ├── ui/                       # Interface utilisateur
│   │   │   └── HUD.java              # Affichage tête haute
│   │   └── utils/                    # Utilitaires
│   │       ├── Constants.java        # Constantes du jeu
│   │       └── ActionFrame.java      # Gestion des animations
│   └── build.gradle                  # Configuration Gradle du module
│
├── lwjgl3/                           # Backend LWJGL3 (desktop moderne)
│   ├── src/main/java/github/NotSayk/EchoRunner/lwjgl3/
│   │   ├── Lwjgl3Launcher.java       # Lanceur principal
│   │   └── StartupHelper.java        # Helper de démarrage
│   └── build.gradle                  # Configuration du launcher
│
├── assets/                           # Ressources du jeu
│   ├── levels/                       # (à créer) Niveaux JSON
│   ├── images/                       # (à créer) Textures et sprites
│   ├── sounds/                       # (à créer) Effets sonores
│   └── music/                        # (à créer) Musiques de fond
│
├── build.gradle                      # Configuration Gradle racine
├── settings.gradle                   # Modules Gradle (core, lwjgl3)
├── gradle.properties                 # Propriétés du projet
└── start.sh                          # Script de lancement rapide
```

---

## ⚙️ Installation et exécution

### 🔧 Prérequis
- **Java 17** (JDK 17 minimum requis)
- **Gradle 8.x** (inclus via wrapper, aucune installation requise)
- **LibGDX 1.14.0** (géré automatiquement par Gradle)
- **LWJGL3** pour le rendu OpenGL
- IDE recommandé : **IntelliJ IDEA**, Eclipse ou VS Code

### 🖥️ Cloner et exécuter le projet

```bash
# Cloner le dépôt
git clone https://github.com/NotSayk/EchoRunner.git
cd EchoRunner

# Lancer le jeu avec Gradle (LWJGL3)
./gradlew lwjgl3:run

# Alternative : utiliser le script de lancement
chmod +x start.sh
./start.sh

# Compiler le projet
./gradlew build
```

💡 **Windows** : Utilisez `gradlew.bat lwjgl3:run`

### 🎮 Configuration de lancement
Le jeu démarre avec une fenêtre de **640x480 pixels** par défaut.  
Configuration modifiable dans `Lwjgl3Launcher.java` :
- Résolution d'écran
- VSync et limitation FPS
- Icône de fenêtre

---

## 🧠 Concept technique

Le système d'échos repose sur l'enregistrement frame par frame des actions du joueur :

- Chaque action (position, saut, direction) est stockée dans un objet `ActionFrame`
- Lorsqu'un écho est créé, il rejoue cette séquence avec un timing précis
- Plusieurs échos peuvent coexister, créant des puzzles nécessitant coordination et anticipation

### 🧩 Classes principales

| Classe | Rôle |
|--------|------|
| `EchoRunnerGame` | Point d'entrée et gestionnaire principal du jeu |
| `Lwjgl3Launcher` | Lanceur LWJGL3 avec configuration de la fenêtre |
| `Player` | Gère les mouvements, l'enregistrement et la création d'échos |
| `Echo` | Clone qui rejoue fidèlement les actions enregistrées |
| `Entity` | Classe de base pour toutes les entités du jeu |
| `Level` | Représente un niveau (plateformes, portes, interrupteurs) |
| `LevelLoader` | Charge les niveaux depuis les fichiers JSON |
| `Tile` | Gestion des tuiles et de la grille de jeu |
| `Door` | Portes activables par les switches |
| `Switch` | Interrupteurs à activer pour résoudre les puzzles |
| `ActionFrame` | Stocke les données d'une frame enregistrée |
| `GameScreen` | Boucle de jeu principale avec rendu et logique |
| `MainMenuScreen` | Menu principal du jeu |
| `LevelSelectScreen` | Écran de sélection des niveaux |
| `InputHandler` | Gestion centralisée des contrôles clavier |
| `SoundManager` | Gestion des effets sonores et musiques |
| `Assets` | Chargement centralisé des ressources |
| `HUD` | Affichage de l'interface utilisateur en jeu |
| `Constants` | Constantes globales du jeu |

---

## 🎨 Ressources graphiques et audio

- **Graphismes** : Pixel art minimaliste (créés avec Aseprite / Piskel)
- **Sons** : Effets sonores générés via [sfxr.me](https://sfxr.me)
- **Musique** : Boucles libres de droits depuis [OpenGameArt.org](https://opengameart.org)

---

## 🚀 Roadmap et améliorations futures

### Version 1.0 (Actuelle)
- ✅ Moteur de jeu fonctionnel avec LibGDX
- ✅ Système d'échos temporels
- ✅ 3 niveaux de base
- ✅ Menu principal et sélection de niveaux
- ✅ Gestion audio (sons et musique)
- ✅ Système de collision et physique

### Version 1.1 (Prévue)
- � **Éditeur de niveaux** intégré dans le jeu
- 🎨 **Assets graphiques personnalisés** (sprites, animations)
- 📊 **Système de statistiques** (temps, tentatives, échos utilisés)
- 💾 **Sauvegarde de progression** persistante

### Version 2.0 (Future)
- ⏳ **Nouveaux types d'échos** (miroir, inversé, décalé temporellement)
- 🏆 **Classement des temps** (leaderboard local et en ligne)
- 🎮 **Support manette** (gamepad Xbox/PlayStation)
- 🌐 **Mode multijoueur coopératif** en ligne
- 🎵 **Bande-son originale** complète

---

## � Équipe de développement

Ce projet a été développé par une équipe de 4 étudiants en 2ᵉ année de BUT Informatique à l'IUT du Havre :

| Membre | Rôle |
|--------|------|
| **Samuel Ampeau** | Développeur | 
| **Nichita Gutu** | Développeur | 
| **Laurent Descourtis** | Développeur | 
| **Matéo Cheveau** | Développeur  |

📧 **Contact** : [Voir le dépôt GitHub](https://github.com/NotSayk/EchoRunner)  
🔗 **GitHub du projet** : [github.com/NotSayk/EchoRunner](https://github.com/NotSayk/EchoRunner)

---

## �️ Technologies utilisées

| Technologie | Version | Usage |
|-------------|---------|-------|
| **Java** | 17 | Langage principal |
| **LibGDX** | 1.14.0 | Framework de jeu 2D/3D |
| **LWJGL3** | 3.x | Backend OpenGL natif |
| **Gradle** | 8.x | Build automation |
| **JSON** | - | Format des niveaux |

### Dépendances principales
- `com.badlogicgames.gdx:gdx` - Core LibGDX
- `com.badlogicgames.gdx:gdx-backend-lwjgl3` - Backend desktop
- `com.badlogicgames.gdx:gdx-platform` - Natives multiplateformes

---


## �📜 Licence

Ce projet est distribué sous la **licence MIT**.  
Vous pouvez l'utiliser, le modifier et le redistribuer librement, à condition de citer les auteurs originaux.

Voir le fichier [LICENSE](LICENSE) pour plus de détails.

---

## 💬 Citation du projet

> _"Vous ne jouez pas seul… vous jouez avec votre propre passé."_

🌀 **Echo Runner** — Un jeu Java 2D où le temps devient votre coéquipier.

---



**⭐ Si ce projet vous plaît, n'hésitez pas à lui donner une étoile sur GitHub !**

**📝 Contributions** : Les pull requests sont les bienvenues pour améliorer le jeu !
