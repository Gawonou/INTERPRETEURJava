package INTERPRETEUR;

public abstract class Mot implements Expression {
	
	private char _mot;
	private int	_ligne;
	private int	_colonne;
	
	public Mot(char _mot, int _ligne, int _colonne) {
		this._mot = _mot;
		this._ligne = _ligne;
		this._colonne = _colonne;
	}

	protected char get_mot() {
		return _mot;
	}

	protected void set_mot(char _mot) {
		this._mot = _mot;
	}

	protected int get_ligne() {
		return _ligne;
	}

	protected void set_ligne(int _ligne) {
		this._ligne = _ligne;
	}

	protected int get_colonne() {
		return _colonne;
	}

	protected void set_colonne(int _colonne) {
		this._colonne = _colonne;
	}


	/**
	 * méthode qui verifie si une lettre
	 * est un mot 
	 * 
	 * @param  lettre à verifier
	 * @return vrai si la lettre peut etre un mot.
	 */	
	public static boolean estMot( char lettre ) {
				
		return estMotSansValeur(lettre) || Motv.estMotAvecValeur(lettre );
	    }

	
	/**
	 * méthode qui verifie si la lettre
	 * est un mot qui n'acepte pas de valeur opt
	* 
	* @param  lettre à verifier
	* @return vrai si la lettre peut etre un mot.
	*/	
	public static boolean estMotSansValeur( char lettre ) {
				
		return lettre == 'e' || lettre == 'f' || lettre == 'g';
	    }

	/**
	 * méthode qui cree un Mot
	 * sans valeur optionnelle
	 *
	 * @param   lettre	  du mot à créer
	 * @param	noLigne	  ou le mot est situé
	 * @param	noColonne ou le mot est situé
	 * @return	mot	crée
	 */	
	public static Mot creerMot( char lettre, int noLigne, int noColonne ) {
		Mot mot = null;
		switch ( lettre) {
			case 'a': mot = new MotA(noLigne, noColonne);
						break;	
			case 'b': mot = new MotB(noLigne, noColonne); 
						break;	
			case 'c': mot = new MotC(noLigne, noColonne);
						break;	
			case 'd': mot = new MotD(noLigne, noColonne);
						break;	
			case 'e': mot = new MotE(noLigne, noColonne); 
						break;	
			case 'f': mot = new MotF(noLigne, noColonne); 
						break;	
			case 'g': mot = new MotG(noLigne, noColonne); 
						break;	
			default: System.err.printf(Principale.MSG_ERR_SYNTAXE, noLigne, noColonne);
			  		  System.exit(-1);
		   }
		return mot;
	    }
	
	

}
