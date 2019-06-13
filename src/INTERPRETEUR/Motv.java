package INTERPRETEUR;

public abstract class Motv extends Mot {

	private int _valeur;

	protected Motv(char _mot, int _valeur, int _ligne, int _colonne) {
		super(_mot, _ligne, _colonne);
		this._valeur = _valeur;
	}

	public int get_valeur() {
		return _valeur;
	}

	public void set_valeur(int _valeur) {
		this._valeur = _valeur;
	}

	/**
	 * méthode qui calcule le mot
	 *
	 * @param motTemp
	 *            à calculer
	 * 
	 * @return valeur calculée ou message d'erreur le cas écheant
	 */
	protected static char calculerMot(String motTemp, int noLigne, int noColonne) {
		boolean erreur = false;
		char valeur = 0;
		int position = 0;
		boolean trouve = false;
	
		while (motTemp != null && !erreur && position < motTemp.length() && motTemp.charAt(position) != '(') {
			if (estMotAvecValeur(motTemp.charAt(position))) {
				valeur = motTemp.charAt(position);
				trouve = true;
			} else {
				
				if (motTemp.charAt(position) == ')' || motTemp.charAt(position) == '-'
						|| motTemp.charAt(position) == '+' || Character.isDigit(motTemp.charAt(position)))
					erreur = true;
			}
			position++;
		}
		if (!trouve || erreur) {
			System.err.printf(Principale.MSG_ERR_SYNTAXE, noLigne, noColonne + position - 1);
			System.exit(-1);
		}

		return valeur;
	}

	/**
	 * méthode qui calcule la valeur optionnelle
	 * 
	 * @param noLigne
	 * @param noColonne
	 *
	 * @param motTemp
	 *            à calculer
	 * 
	 * @return valeur calculée
	 */
	protected static int calculerValeur(String mot, int noLigne, int noColonne) {
		int valeur = 0;
		int debut = mot.indexOf('(');
		int fin = mot.indexOf(')');
		if (debut >= 0 && fin > debut) {
			try {
				
				mot = mot.substring(debut + 1, fin);
				valeur = Integer.parseInt(mot);

			} catch (Exception e) {
				System.err.printf(Principale.MSG_ERR_SYNTAXE, noLigne, noColonne + debut + 1);
				System.exit(-1);
			}
		} else {
			System.err.printf(Principale.MSG_ERR_SYNTAXE, noLigne, noColonne + 2);
			System.exit(-1);
		}
		return valeur;
	}

	/**
	 * méthode qui cree un Mot avec valeur suplementaire
	 * 
	 * @param lettre
	 *            du mot à créer
	 * @param valeur
	 *            optionelle du mot
	 * @param noLigne
	 *            ou le mot est situé
	 * @param noColonne
	 *            ou le mot est situé
	 * @return mot crée
	 */
	public static Mot creerMot(String motTemp, int noLigne, int noColonne) {
		Mot mot = null;

		if (!aIgnorerM(motTemp)) {
			char lettre = calculerMot(motTemp, noLigne, noColonne);
			
			int valeur = calculerValeur(motTemp, noLigne, noColonne);

			switch (lettre) {
			case 'a':
				mot = new MotAv(valeur, noLigne, noColonne);
				break;
			case 'b':
				mot = new MotBv(valeur, noLigne, noColonne);
				break;
			case 'c':
				mot = new MotCv(valeur, noLigne, noColonne);
				break;
			case 'd':
				mot = new MotDv(valeur, noLigne, noColonne);
				break;
			default:
				System.err.printf(Principale.MSG_ERR_SYNTAXE, noLigne, noColonne);
				System.exit(-1);
			}
		}
		return mot;
	}

	private static boolean aIgnorerM(String motTemp) {
		boolean vide = true;
		for (int position = 0; position < motTemp.length(); position++) {
			if (!Phrase.estaIgnorer(motTemp.charAt(position)))
				vide = false;
		}
		return vide;
	}

	/**
	 * méthode qui verifie si la lettre est un mot qui accepte une valeur opt
	 * 
	 * @param lettre
	 *            à verifier
	 * 
	 * @return vraie si la lettre peut etre un mot+val
	 */
	public static boolean estMotAvecValeur(char lettre) {

		return lettre == 'a' || lettre == 'b' || lettre == 'c' || lettre == 'd';
	}

}
