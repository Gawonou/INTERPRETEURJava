package INTERPRETEUR;

public class MotBv extends Motv {

	public MotBv(int _valeur, int _ligne, int _colonne) {
		super('b', _valeur, _ligne, _colonne);

	}

	@Override
	public void interprete(ContexteInterpretation contexte) {
		if (contexte instanceof Calculatrice) 
			contexte.b(this);
		if (contexte instanceof Profil) 
			contexte.b(this);
		if (contexte instanceof Tortue) 
			contexte.b(this);
		
	}

}
