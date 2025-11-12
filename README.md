# 🌀 Echo Runner

> _"Et si vous pouviez collaborer avec votre propre passé ?"_

**Echo Runner** est un jeu de plateforme 2D innovant développé en **Java** avec le framework **LibGDX**.  
Contrôlez un personnage capable d'enregistrer ses actions pendant quelques secondes — ces actions sont ensuite rejouées en boucle par un **écho temporel**, un clone fantomatique qui répète fidèlement vos mouvements passés.  
Utilisez ces échos pour résoudre des puzzles complexes, activer des interrupteurs et atteindre la sortie de chaque niveau.

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
echo-runner/
├── core/
│   ├── src/com/echorunner/
│   │   ├── EchoRunnerGame.java      # Point d'entrée principal
│   │   ├── screens/                  # Écrans de jeu
│   │   ├── entities/                 # Player, Echo, entités
│   │   ├── world/                    # Gestion des niveaux
│   │   ├── input/                    # Contrôles clavier
│   │   ├── utils/                    # Utilitaires
│   │   ├── audio/                    # Gestion audio
│   │   └── ui/                       # Interface utilisateur
│   └── assets/
│       ├── levels/                   # Fichiers JSON des niveaux
│       ├── images/                   # Textures et sprites
│       ├── sounds/                   # Effets sonores
│       └── music/                    # Musiques de fond
└── desktop/
    └── src/com/echorunner/desktop/
        └── DesktopLauncher.java      # Lanceur desktop
```

---

## ⚙️ Installation et exécution

### 🔧 Prérequis
- **Java 17** ou supérieur
- **Gradle** (inclus via wrapper) ou IDE compatible (IntelliJ IDEA, Eclipse, VS Code)
- **LibGDX** (géré automatiquement par Gradle)

### 🖥️ Cloner et exécuter le projet

```bash
# Cloner le dépôt
git clone https://github.com/<ton-utilisateur>/echo-runner.git
cd echo-runner

# Lancer le jeu (avec Gradle)
./gradlew desktop:run
```

💡 **Windows** : Utilisez `gradlew.bat desktop:run`

---

## 🧠 Concept technique

Le système d'échos repose sur l'enregistrement frame par frame des actions du joueur :

- Chaque action (position, saut, direction) est stockée dans un objet `ActionFrame`
- Lorsqu'un écho est créé, il rejoue cette séquence avec un timing précis
- Plusieurs échos peuvent coexister, créant des puzzles nécessitant coordination et anticipation

### 🧩 Classes principales

| Classe | Rôle |
|--------|------|
| `EchoRunnerGame` | Point d'entrée et gestionnaire principal |
| `Player` | Gère les mouvements, l'enregistrement et la création d'échos |
| `Echo` | Clone qui rejoue fidèlement les actions enregistrées |
| `Level` | Représente un niveau (plateformes, portes, interrupteurs) |
| `ActionFrame` | Stocke les données d'une frame enregistrée |
| `GameScreen` | Boucle de jeu principale avec rendu et logique |
| `AssetsManager` | Gestion centralisée des textures, sons et musiques |

---

## 🎨 Ressources graphiques et audio

- **Graphismes** : Pixel art minimaliste (créés avec Aseprite / Piskel)
- **Sons** : Effets sonores générés via [sfxr.me](https://sfxr.me)
- **Musique** : Boucles libres de droits depuis [OpenGameArt.org](https://opengameart.org)

---

## 🚀 Améliorations futures

- 🛠️ **Éditeur de niveaux** intégré dans le jeu
- ⏳ **Nouveaux types d'échos** (miroir, inversé, décalé temporellement)
- 🌍 **Système de progression** avec sauvegarde persistante
- 🏆 **Classement des temps** (leaderboard local)
- 🎮 **Support manette** (gamepad)
- 🌐 **Mode multijoueur coopératif** en ligne

---

## 👨‍💻 Auteur

**👋 Samuel Ampeau**  
Étudiant en 2ᵉ année de BUT Informatique – IUT du Havre  
Passionné par la création de jeux vidéo et le développement logiciel

📧 Contact : [ton-email@exemple.com](mailto:ton-email@exemple.com)  
🔗 GitHub : [github.com/ton-utilisateur](https://github.com/ton-utilisateur)

---

## 📜 Licence

Ce projet est distribué sous la **licence MIT**.  
Vous pouvez l'utiliser, le modifier et le redistribuer librement, à condition de citer l'auteur original.

Voir le fichier [LICENSE](LICENSE) pour plus de détails.

---

## 💬 Citation du projet

> _"Vous ne jouez pas seul… vous jouez avec votre propre passé."_

🌀 **Echo Runner** — Un jeu Java 2D où le temps devient votre coéquipier.

---

**⭐ Si ce projet vous plaît, n'hésitez pas à lui donner une étoile sur GitHub !**
