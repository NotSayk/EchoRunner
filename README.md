# 🌀 Echo Runner

> _“Et si vous pouviez collaborer avec votre propre passé ?”_

**Echo Runner** est un jeu de plateforme 2D développé en **Java** avec le framework **LibGDX**.  
Le joueur contrôle un personnage capable d’enregistrer ses actions pendant quelques secondes — ces actions sont ensuite rejouées en boucle par un **écho temporel**, un clone fantomatique qui répète fidèlement les mouvements du passé.  
Le joueur doit utiliser ces échos pour résoudre des puzzles, activer des interrupteurs et atteindre la sortie de chaque niveau.

---

## 🎯 Objectif du jeu

Chaque niveau est un puzzle à résoudre grâce à la synchronisation entre le joueur et ses clones :
- Enregistrez vos actions au bon moment.  
- Utilisez vos échos pour activer des mécanismes.  
- Franchissez des zones inaccessibles seul.  
- Terminez les niveaux en un minimum de temps et de tentatives !

---

## 🧩 Fonctionnalités principales

- 🕹️ **Gameplay original** : mécanique d’enregistrement et de reproduction des actions.  
- 👻 **Échos temporels** : jusqu’à 3 clones simultanés.  
- 🧱 **Physique 2D** : collisions, plateformes, gravité.  
- 🚪 **Puzzles variés** : interrupteurs, portes, pics, blocs.  
- 💾 **Chargement dynamique** des niveaux via JSON.  
- 🎨 **Pixel art minimaliste** et **musique d’ambiance**.  

---

## 🧱 Structure du projet

echo-runner/
├── core/
│ ├── src/com/echorunner/
│ │ ├── EchoRunnerGame.java
│ │ ├── screens/
│ │ ├── entities/
│ │ ├── world/
│ │ ├── input/
│ │ ├── utils/
│ │ ├── audio/
│ │ └── ui/
│ └── assets/
│ ├── levels/
│ ├── images/
│ ├── sounds/
│ └── music/
└── desktop/
└── src/com/echorunner/desktop/DesktopLauncher.java


---

## ⚙️ Installation et exécution

### 🔧 Prérequis
- Java 17 ou supérieur  
- Gradle ou IDE compatible (IntelliJ IDEA, Eclipse, VS Code)  
- LibGDX (inclus via Gradle)

### 🖥️ Cloner et exécuter le projet

```bash
# Cloner le dépôt
git clone https://github.com/<ton-utilisateur>/echo-runner.git
cd echo-runner

# Lancer le jeu (avec Gradle)
./gradlew desktop:run

    💡 Si tu es sous Windows : gradlew.bat desktop:run

🧠 Concept technique

Chaque “écho” enregistre la position et les actions du joueur à chaque frame, sous forme d’une liste d’objets ActionFrame.
Lorsqu’un écho est créé, il rejoue cette liste avec le même timing, ce qui permet de créer des puzzles temporels nécessitant coordination et anticipation.
🧩 Classes principales
Classe	Rôle
EchoRunnerGame	Point d’entrée du jeu
Player	Gère les mouvements, l’enregistrement et la création d’échos
Echo	Clone qui rejoue les actions enregistrées
Level	Représente un niveau (plateformes, portes, interrupteurs)
ActionFrame	Stocke les actions enregistrées du joueur
GameScreen	Boucle de jeu principale
Assets	Gestion des textures, sons et musiques
🎨 Ressources graphiques et audio

    Graphismes : pixel art simple (créés sous Aseprite / Piskel)

    Sons : générés via sfxr.me

Musique : boucles libres de droits (par exemple de opengameart.org

    )

🚀 Améliorations futures

    🧱 Éditeur de niveaux intégré

    ⏳ Nouveaux types d’échos (miroir, inversé, décalé)

    🌍 Système de progression avec sauvegarde

    🏆 Classement des temps (leaderboard local)

👨‍💻 Auteur

👋 Samuel Ampeau
Étudiant en 2ᵉ année de BUT Informatique – IUT du Havre
Passionné par la création de jeux et le développement logiciel.
📜 Licence

Ce projet est distribué sous la licence MIT.
Tu peux l’utiliser, le modifier et le redistribuer librement, à condition de citer l’auteur original.
💬 Citation du projet

    “Vous ne jouez pas seul… vous jouez avec votre propre passé.”

🌀 Echo Runner — Un jeu Java 2D où le temps devient votre coéquipier.


---
