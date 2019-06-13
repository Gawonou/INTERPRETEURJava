package INTERPRETEUR;

	public class MotF extends Mot{

		public MotF(int _ligne, int _colonne ) {
			super('f', _ligne, _colonne);		
		}

		@Override
		public void interprete(ContexteInterpretation contexte) {
			if (contexte instanceof Calculatrice) 
				contexte.f(this);
			if (contexte instanceof Profil) 
				contexte.f(this);
			if (contexte instanceof Tortue) 
				contexte.f(this);
			
		}

	}
