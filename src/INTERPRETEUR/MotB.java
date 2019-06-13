package INTERPRETEUR;

public class MotB  extends Mot{

	public MotB(int _ligne, int _colonne ) {
		super('b', _ligne, _colonne);		
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

