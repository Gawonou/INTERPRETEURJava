package INTERPRETEUR;

public class MotDv extends Motv {

	public MotDv(int _valeur, int _ligne, int _colonne) {
		super('d', _valeur, _ligne, _colonne);
	}

	@Override
	public void interprete(ContexteInterpretation contexte) {
		if (contexte instanceof Calculatrice) 
			contexte.d(this);
		if (contexte instanceof Profil) 
			contexte.d(this);
		if (contexte instanceof Tortue) 
			contexte.d(this);
		
	}

}
