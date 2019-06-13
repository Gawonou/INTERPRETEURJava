package INTERPRETEUR;

public class MotCv extends Motv {

	public MotCv(int _valeur, int _ligne, int _colonne) {
		super('c', _valeur, _ligne, _colonne);
	}

	@Override
	public void interprete(ContexteInterpretation contexte) {
		if (contexte instanceof Calculatrice) 
			contexte.c(this);
		if (contexte instanceof Profil) 
			contexte.c(this);
		if (contexte instanceof Tortue) 
			contexte.c(this);
		
	}

}
