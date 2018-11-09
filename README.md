# inscriptionsSportives

# inscription

1  Présentation
La gestion des inscriptions aux compétitions est encore aujourd’hui assurée par les ligues avec des tableurs, et le développement d’un logiciel davantage adapté est en cours. L’application en question permet de gérer un ensemble de compétitions, de personnes, et d’affecter des personnes à des compétitions. Il est possible que certaines compétitions soient réservées à des équipes et qu’il soit impossible à une personne seule de s’inscrire. dans le cas, tous les membres de l’équipe doivent être enregistrés.

Cette application ne sera pas accessible au grand public, seuls des employés des ligues pourront y accéder pour saisir les inscrits. Les précédents informaticiens se sont penchés sur le problème et ont déjà commencé à développer la couche métier. Les ressources suivantes sont à votre disposition :

Le code source sur Github : (https://github.com/alexandreMesle/inscriptionsSportives). Ne copiez-collez pas le projet, faites un fork.
La documentation: (http://enseignement.alexandre-mesle.com/PPE/inscriptions/javadoc/).

2  Spécification du besoin
La version proposée ne gère pas les niveaux d’accès des utilisateurs, Il serait souhaitable que cette problématique soit étudiée.
Le code fourni n’a pas été testé, il pourrait ne pas être exempt d’erreurs.
Le dialogue utilisateur est pour le moment inexistant, il serait souhaitable qu’une interface, même simple soit proposée.
Le logiciel est pour le moment mono-utilisateur, il faudrait centraliser son contenu dans une base de données relationnelle pour pouvoir se connecter à plusieurs.
Le personnel des ligues serait particulièrement intéressé par l’idée de pouvoir contacter toutes les personnes inscrites à une compétition, par exemple pour les convoquer par mail.
3  Résultats attendus à l’itération 1
Il serait souhaitable que les fonctionnalités ci-après soient mises en place. Si vous n’avez pas le temps de toutes les traiter, occupez-vous d’abord des plus importantes. S’il reste du temps, cherchez des améliorations à apporter.

3.1  Application Java
Tests unitaires.
Ajout des fonctionalités manquantes, indiquées dans le code avec des //TODO
Ajout d’exceptions dans la couche métier pour gérer les erreurs (rejet de l’inscription d’un candidat à une compétition, etc).
Etude de la bibliothèque disponible dans ce dépôt. Comme ce code est sur github et qu’il peut être mis à jour, ne le copiez-collez pas dans votre projet ! Importez-le dans votre workspace et ajoutez-le aux dépendances de votre projet.
3.2  Base de données
Modélisation de la base de données
3.3  Documentation
La documentation suivante doit être accessible depuis votre portefolio.

MCD.
Diagramme UML.
Arborescence des menus.
4  Résultats attendus à l’itération 2
Il serait souhaitable que les fonctionnalités ci-après soient mises en place. Si vous n’avez pas le temps de toutes les traiter, occupez-vous d’abord des plus importantes. S’il reste du temps, cherchez des améliorations à apporter.

4.1  Base de données
Création d’une base de données.
Installation de la base de données sur un serveur.
4.2  Application Java
Mise en place d’un dialogue utilisateur à l’aide de la bibliothèque disponible dans ce dépôt. Comme ce code est sur github et qu’il peut être mis à jour, ne le copiez-collez pas dans votre projet !
5  Résultats attendus à l’itération 3
5.1  Base de données
Connexion à la base de données avec Hibernate.
Tout le dialogue avec la base de données doit être utilisé avec Hibernate, vous n’avez pas le droit d’utiliser JDBC.

5.2  Documentation
La documentation suivante doit être accessible depuis votre portefolio.

Maquettes des fenêtres.
6  Résultats attendus à l’itération 4
6.1  Application Java
Développement d’une IHM en Java (Swing, JavaFX, ou autre).
Possibilité de contacter les candidats.
6.2  Documentation
La documentation suivante doit être accessible depuis votre portefolio.

Documentation utilisateur.
7  Contraintes
Vous devrez donc garder java pour la suite de ce projet, ne modifiez le code que :

si trouvez une erreur.
pour implémenter les //TODO
pour établir le dialogue avec la base de données.
pour mettre en place des exceptions.
N’oubliez pas de

Respecter l’architecture en couches !
Utiliser github !
Ne pas écrire de pâtés !
8  Productions
8.1  Chef de projet
Remise à la fin de la séance d’un rapport indiquant :

La répartition des tâches et le planning (il est conseillé de faire un diagramme de Gantt).
Il est conseillé d’utiliser un logiciel de gestion de tâches et de travail collaboratif (Trello, Asana, Slack, etc.)

8.2  Équipe
Présentation sur diapositives (pdf ou powerpoint) des productions par l’équipe. Le chef de projet anime la présentation, mais tous les membres de l’équipe doivent intervenir au moins une fois.
Démonstration des productions.
8.3  Individuel
Ajoutez à votre porte-folio :

Un compte-rendu d’activité détaillant le travail que vous avez effectué (extraits de code, explications, impressions d’écran, compétences du référentiel mises en oeuvre).
Le code source sur Github.
La documentation utilisateur.
La documentation développeur.
]

