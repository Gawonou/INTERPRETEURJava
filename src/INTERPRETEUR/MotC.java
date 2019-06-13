package INTERPRETEUR;

public class MotC  extends Mot{

	public MotC(int _ligne, int _colonne ) {
			super('c', _ligne, _colonne);		
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

