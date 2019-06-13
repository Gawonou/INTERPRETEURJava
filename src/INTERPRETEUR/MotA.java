package INTERPRETEUR;

public class MotA  extends Mot{

	public MotA(int _ligne, int _colonne ) {
		super('a', _ligne, _colonne);		
	}

	@Override
	public void interprete(ContexteInterpretation contexte) {
		if (contexte instanceof Calculatrice) {
			contexte.a(this);
		}
		if (contexte instanceof Profil) {
			contexte.a(this);
		}
		if (contexte instanceof Tortue) {
			contexte.a(this);
		}
		
	}

}

