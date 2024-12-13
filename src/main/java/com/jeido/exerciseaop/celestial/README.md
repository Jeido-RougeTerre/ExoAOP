### Exercice : Filtres Servlet

#### Objectif
Développer un système de journalisation complet pour suivre les requêtes et les réponses HTTP dans une application Spring Boot, en utilisant uniquement des filtres Servlet.

1. **Mise en place de l'API**
Avec l'augmentation de l'intérêt pour l'astronomie et l'espace, une organisation veut créer une plateforme en ligne où les amateurs d'astronomie peuvent observer des phénomènes spatiaux, enregistrer leurs observations.

  - Les endpoints doivent :
      - Lister différents objets célestes (id,nom).
      - Permettre aux utilisateurs de créer et de partager leurs observations (objet celest,dates, descriptions, position gps).
      - Rechercher des observations par objet céleste, date ou utilisateur.

2. **Créer un filtre Servlet pour journaliser les détails des requêtes**
   - Le filtre doit capturer et enregistrer les informations suivantes pour chaque requête :
     - URI demandée
     - Méthode HTTP (GET, POST, etc.)
     - Timestamp de la requête

  - recuperation du requestServelet 
  ```Java
  RequestContextHolder.getRequestAttributes()).getRequest();
  ```

3. **Créer un second filtre Servlet pour journaliser les détails exception lever lors de l'execution des requetes**
   - Le filtre doit capturer et enregistrer les informations suivantes pour chaque Exception :
    - le nom de l'exception et son message
    - Timestamp au quel l'exception c'est produit
    - la stack trace de l'exception
  
  et enregistrer tout ca dans un fichier de log


4. **Bonus Remplacer la BDD par un fichier csv**
