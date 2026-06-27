---
name: connecter-sqlite
description: "Use when: connecting a SQLite database, creating a local DB connection, configuring JDBC or sqlite3, testing a SQLite connection."
---

# Connecter une base SQLite

## Quand l'utiliser
Utiliser cette compétence pour connecter une application à une base SQLite locale ou embarquée, vérifier l'accès et exécuter un premier test de requête.

## Workflow
1. Identifier le langage et l'environnement
   - Java/Maven : utiliser JDBC avec une dépendance SQLite
   - Python : utiliser le module standard sqlite3
   - Node.js : utiliser better-sqlite3 ou sqlite3

2. Vérifier le chemin de la base et les permissions
   - Choisir un chemin stable pour le fichier de base
   - Créer le dossier parent si nécessaire
   - Vérifier que l'application peut écrire dans ce dossier

3. Ajouter la dépendance ou le module adapté
   - Maven : ajouter la dépendance SQLite JDBC
   - Python : utiliser sqlite3 sans installation supplémentaire
   - Node : installer le driver SQLite adapté

4. Établir la connexion
   - Java : ouvrir une connexion via JDBC avec un URL du type jdbc:sqlite:./data/app.db
   - Python : utiliser sqlite3.connect("data/app.db")
   - Node : ouvrir une connexion via le driver SQLite choisi

5. Valider la connexion
   - Exécuter une requête simple comme SELECT 1 ou PRAGMA user_version
   - Vérifier les erreurs et lire les messages d'exception

6. Structurer le code proprement
   - Centraliser la connexion dans une classe, un service ou un helper
   - Fermer les connexions et les curseurs après usage
   - Utiliser des transactions pour les écritures

7. Tester le flux complet
   - Créer une table
   - Insérer une ligne
   - Lire la ligne
   - Vérifier que le fichier de base est bien créé

## Checklist de fin
- La connexion s'ouvre sans erreur
- Une première requête fonctionne
- Le fichier de base existe au bon endroit
- Le code gère les erreurs et les fermetures
- Un test minimal a été exécuté

## Exemples de prompts
- "Connecte cette application Java à une base SQLite"
- "Ajoute la configuration pour une base SQLite locale"
- "Vérifie pourquoi la connexion SQLite échoue"
