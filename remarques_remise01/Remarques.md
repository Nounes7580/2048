# Projet Remise 1

## Divers

- Git : gitignore en ordre
- Readme :absent
- Javadoc : incomplète
- Couverture de test : couverture insuffisante

## Analyse de code

Commence par jeter un œil aux remarques générées par Intelliji dans la page index.html

Reviens-vers moi si il y a des remarques que tu ne comprends pas ou que tu ne trouves pas appropriées

## Controller

Comment sait-on si on a gagné ou perdu ?

## View

- la visibilité de l'attribut `clavier` est-elle pertinente ?'
- Variables `i` et `j` a éviter. préférer `row` et `column` par exemple (valable aussi dans la partie model ).
- les méthodes `toString` sont à éviter dans une vue. Un exemple est que si tu dois changer la langue de ton application, tu vas modifier le contenu du package vue et il y a un risque que tu oublies de vérifier le contenu du package model. En résumé les méthodes `toString` servent à debbuger pas à créer une vue propre.
- la langue à utiliser pour les classes, méthodes, variables, attributs est l'anglais

## Model

- Facade : absente
- Gestion du tableau de jeu : 
  - la visibilité `public` des méthodes est-elle nécessaire ?
  - la classe `Chiffre` a-t-elle une utilité ou un tableau d'entier est-il plus pertinent ?
  - les méthodes `moveTop` et`moveBot` contiennent du code redondant, pour t’aiguiller dans ce refactoring tu peux constater que ! 
    - une boucle décroissante est équivalent à une boucle croissante si on remarque que `i_decroissant = SIZE - i_croissant - 1`
    - on peut passer en paramètre à ces méthodes la direction
    - on peut remplacer `k +1` par  `direction.nextColumn(k)`
- Gestion du jeu, la classe `Game` : 
  - l'accesseur de `grid` doit retourner une copie

## Méthodes et paramètres d'entrées

Attention les méthodes qui utilisent directement leurs paramètres d'entrées, doivent contrôler leurs validités, elles en sont responsables. 





