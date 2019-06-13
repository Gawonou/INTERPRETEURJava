package INTERPRETEUR;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *  Classe qui interpréte une phrase
 * 
 * @author N'TSOUAGLO Kokou Gawonou
 * 
 * Courriel: gawonou01@gmail.com
 * 
 *
 * @version 11 Juin 2019
 */
public class Principale {

	public final static String MSG_SOL_FICHIER = "Entrez le nom de fichier : ";
	public final static String MSG_ERR_NON_TROUVE = "\nLe fichier n'a pas été trouvé.";
	public final static String MSG_ERR_NON_LU = "\nErreur de lecture du fichier.";
	public final static String MSG_ERR_SYNTAXE = "\nErreur de syntaxe à la ligne %d colonne %d.";
	public final static String MSG_ERR_PILE = "\nErreur! La pile est vide. \n\tMot: '%s' ligne: %d colonne: %d.";
	public final static String MSG_ERR_ZERO = "\nErreur! division par zéro. Mot: '%s' ligne: %d colonne: %d.";
	public final static String CHOIX_MAL_ENTRE = "\nLe choix mal entré";
	public final static String FIN_LOGICIEL = "\n Fin du logiciel";
	public final static String MENU = "\n\t\t1 - Calculatrice." 
									+ "\n\t\t2 - Profil."
									+ "\n\t\t3 - Mistere." 
									+ "\n\t\t4 - Fin du logiciel."
									+ "\nEntrez votre choix : ";
	private static Scanner sc;
	private static Scanner sc2;

	public static void main(String[] args) {

		String nomFichierEntree;
		BufferedReader fichierLu = null;
		ArrayList<String> lignesLues = new ArrayList<String>();
		Phrase phrase = new Phrase();
		int choix = 0;
		

		nomFichierEntree = lireNomdeFichier(MSG_SOL_FICHIER);

		try {
			fichierLu = LireFichier(nomFichierEntree);
				} catch (FileNotFoundException e) {
					System.err.println(MSG_ERR_NON_TROUVE);
					System.exit(-1); }
		
		try {
			lignesLues = LireLignes(fichierLu);
				} catch (IOException e) {
					System.err.println(MSG_ERR_NON_LU);
					System.exit(-1); }
		
		Phrase.validerLignes(lignesLues);
		phrase = Phrase.LirePhrase(lignesLues);
		
	  try {
		boolean sortir = false;
		while (!sortir) {
			choix=ChoixInterpretteur(MENU);
			switch ( choix) {
				case 1: Calculatrice choix1 = new Calculatrice();
						phrase.interprete(choix1);
						System.out.print(choix1);
						break;
				case 2: Profil choix2 = new Profil();
						phrase.interprete(choix2);
						System.out.print(choix2);
						break;
				case 3: Tortue choix3 = new Tortue();
						phrase.interprete(choix3);
						System.out.print(choix3);
						choix3.afficher();
				break;
				case 4 : 
					System.out.print(FIN_LOGICIEL);
					sortir = true; 
			}
		} 
		

//			sc.close();
//			sc2.close();
		}
	  
	  catch (Exception e) {
	         System.err.println(CHOIX_MAL_ENTRE);
	         System.exit(-1); 
	      }
	}

	/**
	 * méthode pour choisir l'interpreteur 
	 * 		-affiche menu 
	 * 		-lit le choix de l'utilisateur
	 * 
	 * @param menu montrant les choix disponibles
	 * @return choix de l'utilisateur
	 */
	public static int ChoixInterpretteur(String menu) {
		sc2 = new Scanner(System.in);
		int selection = 0;
		boolean erreur = false;
		do {
		if (erreur) 
				System.err.println("choix invalide!");
		
		System.out.print(menu);
		String lecture = sc2.nextLine();
		
		selection = Integer.valueOf(lecture);
		if (selection < 1 || selection > 4 )
			erreur = true;
		} while (selection < 1 || selection > 4);
//		sc.close();
		return selection;
	}

	/**
	 * méthode pour lire le fichier en entrée
	 * 
	 * @param nomFichier
	 * @return fichier en BufferedReader
	 */
	public static BufferedReader LireFichier(String nomFichier) throws FileNotFoundException {
		BufferedReader fichier = new BufferedReader(new FileReader(nomFichier));
		return fichier;

	}

	/**
	 * méthode qui lit les lignes dans la phrase
	 * 
	 * @param fichier lu
	 *            
	 * @return Lignes Lues
	 * @throws IOException 
	 * 
	 */
	public static ArrayList<String> LireLignes(BufferedReader fichier) throws IOException{
		ArrayList<String> lesLignes = new ArrayList<String>();
		String ligneTemp = "";
		while((ligneTemp=fichier.readLine())!=null){	
			
			lesLignes.add(ligneTemp);
			ligneTemp = "";
		}
		return lesLignes;
	}

	/**
	 * méthode qui lit le nom du fichier
	 * 
	 * @param question demandant le nom du fichier
	 * @return nomDuFichier
	 */
	public static String lireNomdeFichier(String question) {
		sc = new Scanner(System.in);

		System.out.print(question);
		String nomDuFichier = sc.nextLine();

		return nomDuFichier;
	}
}
