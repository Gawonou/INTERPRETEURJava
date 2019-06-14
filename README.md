
# INTERPRÉTEUR

```Intro

Un logiciel qui lit une phrase.  Cette phrase sera interprétée selon un de trois interpréteurs.

``` 

## DESCRIPTION 


Ce logiciel doit interpréter une phrase.  Cette phrase sera lue dans un fichier texte.  Elle est constituée d’une séquence de mots.  Votre logiciel doit valider la syntaxe de la phrase.  Ensuite, le logiciel demande à l’utilisateur de choisir l’interpréteur qui sera utilisé.  Les interpréteurs doivent signaler out problème lors de l’interprétation.  Ensuite, il offre la possibilité d’utiliser une autre interprétation.  Finalement, le logiciel afficher l’état final de l’interpréteur. 

## ENTRÉES 

Au lancement, votre logiciel doit demander à l’utilisateur d’entrer le nom du fichier qui contiendra la phrase à interpréter.  S’il y a des problèmes à ouvrir le fichier, alors le logiciel doit afficher un message d’erreur.  Lorsque le fichier est ouvert, le logiciel doit lire et mémoriser la phrase contenue dans le fichier.  Cette phrase utilise la syntaxe suivante : 

*Phrase :: séquence de Mot:* 

Une phrase est une suite de 0 ou plus Mot.  Chaque Mot de la phrase peut être entouré d’espace `‘ ‘`, de tabulation `‘\t’` et de fin de ligne `‘\n’`. 

*Mot:*
un mot est une lettre minuscule.  Les lettres de `‘a’` à `‘g’` sont utilisées.  Les mots de `‘a’` à `‘d’` peuvent être suivi, optionnellement, par une valeur entière entre parenthèses.  Il peut y avoir des espaces, tabulation et fin de ligne de chaque côté des parenthèses. 

*fichier1*
```exemple1

a(2)eeeeeabcd

```
*fichier*
```exemple2

a(  16  )     b (   8)





           c(4)



d	(

				2

				


)
```

*fichier3*
```exemple3

ea(100)c(90)a(100)d(90)a(100)
fb(100)c(90)b(100)d(90)b(100)
g

```


S’il y a une erreur de syntaxe dans la phrase, votre logiciel doit afficher un message d’erreur contenant le numéro de colonne et de ligne du caractère qui à une erreur.  Le logiciel doit conserver l’information sur le numéro de ligne et de colonne pour chaque Mot.  Ainsi, les erreurs lors de l’interprétation pourront aussi utiliser cette information. 
Finalement, votre logiciel doit demander à l’utilisateur lequel des trois interpréteurs il doit utiliser.  Pour cela, affichez un menu numérotant les trois interpréteurs.  Aussi, placez un quatrième choix afin de terminer le logiciel

Entrez le nom du fichier : *test1.txt*

```entr

1- Calculatrice.
2- Profil.
3- Mystère.
4- Fin du logiciel. 

```

```choix

Entrez votre choix : 2 

```


## TRAITEMENT 

Chaque interprétation contient une description de l’état interne de l’interpréteur (une liste de variable interne) et les sept actions associés à chaque Mot (partie spécifique).  Aussi, tous les interpréteurs utilisent le même code pour l’interprétation d’une Phrase (partie générique).  Voici la description de chaque interpréteur. 


### PREMIER INTERPRÉTEUR : CALCULATRICE 

État interne : 

• Accumulateur : un entier. 
• Pile : une pile d’entiers. 

Actions : 

```ActionCal

• a :  
	1. Lire 2 valeurs sur la pile (pop). 
	2. Additionner les deux valeurs.
	3. Placer le résultat sur la pile (push).
• a( v ) : ajouter la valeur v au contenu de l’accumulateur.
 
• b : 
  	1. Lire 2 valeurs sur la pile (pop).
  	2. Soustraire la première valeur à la deuxième.
  	3. Placer le résultat sur la pile (push).

 • b( v ) : soustraire la valeur v au contenu de l’accumulateur.

• c : 
  	1. Lire 2 valeurs sur la pile (pop).
 	2. Multiplier les deux valeurs.
  	3. Placer le résultat sur la pile (push).

• a( v ) : multiplier la valeur v avec contenu de l’accumulateur et placer le résultat dans l’accumulateur.

• d : 
  	1. Lire 2 valeurs sur la pile (pop).
  	2. Diviser la première valeur par la deuxième.
  	3. Placer le résultat sur la pile (push). 

 • a( v ) : diviser l’accumulateur par v et placer le résultat dans l’accumulateur. 

 • e : Placer le contenu de l’accumulateur sur la pile (push).

 • f : Lire une valeur sur la pile (pop) et la place dans l’accumulateur.

 • g : Placer l’accumulateur à 0. 

 ```


### DEUXIÈME INTERPRÉTEUR : PROFIL 

État interne : 

• Nombre d’opérations(no) : un entier.
• Nombre d’accès à la pile(np) : un entier. 
• Nombre d’accès à l’accumulateur(na) : en entier. 

Actions : 

```Pro

• a, b, c, d : 
	 - np = np + 3
	 - no = no + 1

• a(v), b(v), c(v), d(v) : 
     - na = na + 2
     - no = no + 1

• e, f :
	- np = np + 1
	- na = na + 1

 • g : 
 	- na = na + 1 

```


### TROISIÈME INTERPRÉTEUR : TORTUE 

Pour le troisième interpréteur, les mots de la phrase vont représenter les mouvements d’une tortue.  Cette tortue peut avancer, reculer, tourner en sens horaire et antihoraire, et se téléporter à une ancienne position.

Vous aurez donc besoin de construire une classe Tortue qui représente la position d’une tortue.  Cette classe va contenir les coordonnées x et y (double) représentant la position de la tortue et un angle (double) représentant la direction où elle regarde.  Cette classe devra contenir un constructeur vide qui initialise toutes les valeurs à 0.0.  Aussi, vous devrez avoir un constructeur qui accepte une Tortue en argument et construit une nouvelle Tortue qui soit une copie de celle en argument. 

Pour l’état interne de votre interpréteur, vous devrez avoir une variable de type Tortue.  Aussi, certaines actions vont permettre de mémoriser la position de la tortue afin qu’elle puisse revenir sur ces pas (se téléporter).  Pour cela, vous aurez besoin d’une variable qui sera une pile de Tortue.  Finalement, nous voulons enregistrer le chemin que la tortue aura parcouru.  Pour cela, il y a une classe Java du nom de Path2D.Double (c’est la sousclasse ‘Double’ de la classe ‘Path2D’). 


État interne : 
• tortue :: Tortue 
• pile :: Stack<Tortue> 
• chemin :: Path2D.Double 

Actions : 

```Tortue

• a :  (avance la tortue)
	1. tortue.x = tortue.x + cos( tortue.angle ) 
	2. tortue.y = tortue.y + sin( tortue.angle ) 
	3. chemin.lineTo( tortue.x, tortue.y ) 

• a( v ) :
	1. tortue.x = tortue.x + v * cos( tortue.angle )
	2. tortue.y = tortue.y + v * sin( tortue.angle )
	3. chemin.lineTo( tortue.x, tortue.y ) 

• b : (recule la tortue) 
	1. tortue.x = tortue.x - cos( tortue.angle ) 
	2. tortue.y = tortue.y - sin( tortue.angle ) 
	3. chemin.lineTo( tortue.x, tortue.y ) 

• b( v ) : 
	1. tortue.x = tortue.x - v * cos( tortue.angle )
	2. tortue.y = tortue.y - v * sin( tortue.angle ) 
	3. chemin.lineTo( tortue.x, tortue.y ) 

• c : tourne antihoraire 
	1. tortue.angle = tortue.angle + Math.PI 

• c( v ) : 
	1. tortue.angle = tortue.angle + Math.toRadians( v ) 
 
• d : tourne horaire 
	1. tortue.angle = tortue.angle - Math.PI 

• d( v ) : 
	1. tortue.angle = tortue.angle - Math.toRadians( v ) 

• e : mémoriser position 
	1. pile.push( tortue ) 
	2. tortue = new Tortue( tortue ) 

• f : téléporter à une ancienne position
 	1. tortue = pile.pop() 
 	2. chemin.moveTo( tortue.x, tortue.y ) 

• g : téléporter à l’origine 
	1. tortue = new Tortue() 
	2. chemin.moveTo( tortue.x, tortue.y ) 

```

Finalement, quand l’interpréteur a terminé, vous devez afficher l’état final.  Pour cela, vous devez afficher le contenu de la classe Tortue et le contenu de la pile.

Pour le chemin parcouru, il serait plus intéressant de le dessiner.  Pour cela, je vous donne deux classes déjà prêtes qui permettent de dessiner un Path2D.Double : Dessin et Fenetre.  Vous n’avez qu’à les ajouter dans votre projet.  La ligne suivante va faire apparaître le dessin : Fenetre.afficherChemin( chemin ); 
 


## CONSTRUCTION 

Pour la construction du logiciel, vous allons suivre une hiérarchie de classe spécifique.  Cette hiérarchie permet une bonne représentation d’un interpréteur et va nous donner une bonne flexibilité pour adapter différents contextes pour l’interprétation. 

REPRÉSENTATION DE L’INTERPRÉTEUR 

Pour représenter les éléments interprétables (partie générale), nous allons utiliser une interface ‘Expression’.  Les interpréteurs (partie spécialisée) vont utiliser l’interface ‘ContexteInterpretation’.  L’interface pour les expressions va définir une méthode : 
Cette méthode va contenir le code générique pour l’interprétation.  C’est ce code qui va faire appel au code spécialisé de l’interpréteur, défini par le contexte. 
Ensuite vous devez définir une classe abstraite pour les mots du langage.  Cette classe aura le nom ‘Mot’ et implémentera la classe Expression.  Chacun des 7 mots du langage sera représenté par une sous classe de ‘Mot’ : MotA, MotB, MotC, MotD, MotE, MotF et MotG.  Chacune de ces classes doit hériter de la classe Mot.  Elles vont donc automatiquement implémenter l’interface ‘Expression’.  Finalement, la classe ‘Phrase’ va aussi implémenter l’interface Expression.  Puisqu’elle contient une séquence de Mot, elle doit hériter d’un ‘List ( Mot)', ce qui lui donnera toutes les méthodes d’un ArrayList. 

## CONTEXTE POUR L’INTERPRÉTATION 

Afin de rendre l’interprétation facile à modifier, vous allez construire l’interface ContexteInterpretation. 
C’est cette interface qui sera implémentée par chaque interpréteur que vous voulez ajouter. 

LIEN AVEC LE CODE 

La méthode interprete dans les Expression de type Mot va simplement appeler les méthodes définies par le contexte d’interprétation reçu en argument.  Pour la classe Phrase, la méthode interprete doit appeler l’interprétation sur chaque Mot, un après l’autre, en utilisant le même contexte d’interprétation pour chacune. 

Comme dans le cas de JAVA:

void interprete( ContexteInterpretation contexte )

Ensuite, il vous reste à construire une classe implémentant le ContexteInterpretation pour chaque interpréteur.  Cette classe va contenir les variables d’instance représentant l’état et va implémenter les méthodes pour chacune des actions. 

Comme dans le cas de JAVA:

```Java

public interface ContexteInterpretation { 
	void a( MotA motA );
	void b( MotB motB );
	void c( MotC motC ); 
	void d( MotD motD );
	void e( MotE motE );  
	void f( MotF motF ); 
	void g( MotG motG ); 

}

```
Finalement, pour appeler votre interpréteur, il suffit de construire une instance de Phrase contenant des instances des Mots représentant les mots lu dans le fichier.  Vous construisez aussi une instance de la classe de contexte d’interprétation choisi par l’utilisateur.  Finalement, il reste à démarrer l’interprétation en appelant la méthode interprete sur l’instance de Phrase avec le contexte d’interprétation en argument. 
Il ne reste qu’à afficher le contenu de l’état final (définir un toString sur vos classes de contexte d’interprétation). 


## TRAITEMENT DES ERREURS 

Lors de l’exécution, il peut y avoir des erreurs : 

- Un pop sur une pile vide.
- Une division par zéro. 

Si une de ces erreurs arrive, il faut afficher un message contenant le nom du mot qui a causé l’erreur avec le numéro de ligne et de colonne où il se trouvait dans le code original. 

Toutes les erreurs dans le logiciel doivent être affichées sur le canal d’erreur (*print()*) et être suivies d’un appel à *exit*