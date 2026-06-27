# ProjetIA0

## Calculateur d'empreinte carbone pour entreprises

Ce projet Java vise à fournir une solution simple et structurée pour estimer l'empreinte carbone des activités d'une entreprise. Il permet de calculer les émissions en fonction des postes de consommation énergétique, des déplacements, des achats et d'autres facteurs impactant le bilan carbone.

## Objectif

- Offrir un outil pédagogique pour comprendre et mesurer l'empreinte carbone d'une entreprise.
- Centraliser les principales sources d'émissions dans une application Java.
- Permettre la génération de résultats clairs pour aider à la prise de décision environnementale.

## Fonctionnalités attendues

- Calcul des émissions de CO2 liées à la consommation électrique.
- Prise en compte des déplacements professionnels (voiture, train, avion).
- Estimation des émissions issues de l'achat de matières premières ou de fournitures.
- Résultat global de l'empreinte carbone de l'entreprise sur une période donnée.

## Structure du projet

- `pom.xml` : configuration Maven du projet.
- `src/main/java/com/projetia0/` : code source Java principal.
  - `App.java` : point d'entrée de l'application.
  - `model/Entreprise.java` : représentation de l'entreprise.
  - `model/PosteEmission.java` : classe abstraite pour les postes d'émission.
  - `model/Energie.java` : consommation électrique.
  - `model/Transport.java` : déplacements professionnels.
  - `model/Achat.java` : achats et fournitures.
  - `service/FacteursEmission.java` : coefficients d'émission.
- `src/main/resources/facteurs-emission.properties` : données de facteurs d'émission.
- `src/test/java/com/projetia0/CalculateurEmpreinteTest.java` : test unitaire.

## Comment l'utiliser

1. Ouvrir le projet dans un environnement Java ou un terminal.
2. Compiler le projet avec Maven : `mvn compile`.
3. Exécuter le projet avec :
   `java -cp target/classes com.projetia0.App`
4. Lancer les tests unitaires avec : `mvn test`.

## Contribution

- Ajouter de nouvelles sources d'émissions (énergie, déchets, transport, achats).
- Améliorer les coefficients d'émission pour plus de précision.
- Créer une interface graphique ou une version web pour faciliter l'utilisation.

## Remarque

Ce projet est conçu comme une base de travail pour un projet Java de niveau 21. Il peut être enrichi avec des données réelles et des fonctionnalités d'analyse avancée.