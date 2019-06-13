package INTERPRETEUR;

import java.util.ArrayList;

public class Phrase extends ArrayList<Mot> implements Expression {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * méthode qui cree la phrase avec les mots lus
	 * 
	 * @param lignes lues
	 *            
	 * @return Phrase lue
	 * 
	 */
	public static Phrase LirePhrase(ArrayList<String> lignes) {
		Phrase laPhrase = new Phrase();
		String motTemp = "";
		char carLu;
		int ligneTemp = 0;
		int colonneTemp = 0;

		for (int noLigne = 0; noLigne < lignes.size(); noLigne++) {
			
				for (int noColonne = 0; noColonne < lignes.get(noLigne).length(); noColonne++) {
						carLu = lignes.get(noLigne).charAt(noColonne);
						motTemp += carLu; 
						if (Mot.estMot(carLu)) {
							ligneTemp = noLigne+1;
							colonneTemp = noColonne+1;
						}
							
					    
						if  ( colonneTemp > 0
							  && (noColonne+1 == lignes.get(noLigne).length()
								 || Mot.estMot(lignes.get(noLigne).charAt(noColonne+1))
							 )) {
								laPhrase.add(creerMot(motTemp, ligneTemp, colonneTemp));
								motTemp = "";
								colonneTemp = 0;
					      } 
			} 
		} 
		
		return laPhrase;
	}

	public static Mot creerMot(String mTemp, int noLig, int noCol) {
		Mot mot = null;
		int fin = 0;

		while (mTemp != null && mTemp.length() > 0 && estaIgnorer(mTemp.charAt(0))) {
			fin = mTemp.length();
			mTemp = mTemp.substring(1, fin);
		}
 
		while (mTemp != null && mTemp.length() > 0 && estaIgnorer(mTemp.charAt(mTemp.length()-1))) {
			fin = mTemp.length()-1;
			mTemp = mTemp.substring(0, fin);
		}
		if (mTemp.length() == 1) {
			mot = Mot.creerMot(mTemp.charAt(0), noLig, noCol);
			
		} else if (mTemp.length() > 1) {
			mot = Motv.creerMot(mTemp, noLig, noCol);
		}

		return mot;
	}

	/**
	 * méthode valide que la ligne a seulement des caractères valides 
	 * Mots, chiffres, parentèses, signe ou à ignorer
	 * 
	 * @param ligne à verifier
	 *            
	 * @return valide = -1 si valide, sinon Nocolonne
	 */
	static int ligneValide(String ligne) {
		int valide = -1;

		for (int colonne = 0; colonne < ligne.length()-1; colonne++) {
			char carLu= ligne.charAt(colonne);
			char carLu2= ligne.charAt(colonne+1);
			if (colonne <= ligne.length()-1 && carLu != '\n' && !(Mot.estMot(carLu) || Character.isDigit(carLu) || carLu == '(' || carLu == ')'
					|| carLu == '+' || carLu == '-' || estaIgnorer(carLu)) || ChiffeMalposition(carLu, carLu2) ) {
				
				valide = colonne; 
			}
			else if( colonne == ligne.length() && ( Mot.estMot(carLu))) {
				valide = colonne;
				
		}
				 
			
		}
		return valide;
	}  
	
	/**
	 * méthode valide si un chiffre n est pas a la bonne position
	 * 
	 * @param car et car2 son des caracter  à verifier
	 *            
	 * @return répons : vrais si l emplacement est bon.
	 */
	static boolean ChiffeMalposition(char car, char car2) {
		boolean repons = false;

		if (Character.isDigit(car) && Mot.estMot(car2)) {
			repons = true;
		}
		return repons;
	}
	
	
	
	/**
	 * méthode valide que le caractère est valide et à ignorer 
	 * espace, tabulation,retourchariot, fin de ligne
	 * 
	 * @param car à verifier
	 *            
	 * @return réponse : vrai si valide et à ignorer
	 */
	static boolean estaIgnorer(char car) {
		boolean reponse = false;

		if (car == '\n' || car == '\t' || car == ' ' || car == '\r') {
			reponse = true;
		}
		return reponse;
	}

	/**
	 * méthode de l'interface Expression
	 *
	 * @param contexte
	 *            d'interpretation
	 * 
	 */
	@Override
	public void interprete(ContexteInterpretation contexte) {

		for (Mot mot : this) {
			mot.interprete(contexte);
		}
	}
	

	/**
	 * méthode verifie que chaque ligne a seulement des caractères valides
	 * 
	 * @param lignesLues
	 * @return message d'erreur le cas écheant
	 */
	public static void validerLignes(ArrayList<String> lignesLues) {
		for (int noLigne = 0; noLigne < lignesLues.size(); noLigne++) {
			int erreur = ligneValide(lignesLues.get(noLigne));
			if (erreur != -1) {
				System.err.printf(Principale.MSG_ERR_SYNTAXE, noLigne + 1, erreur+1);
				System.exit(-1);
			}
		}
	}
}