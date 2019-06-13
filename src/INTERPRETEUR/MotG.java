package INTERPRETEUR;

	public class MotG extends Mot{

		public MotG(int _ligne, int _colonne ) {
			super('g', _ligne, _colonne);		
		}

		@Override
		public void interprete(ContexteInterpretation contexte) {
			if (contexte instanceof Calculatrice) 
				contexte.g(this);
			if (contexte instanceof Profil) 
				contexte.g(this);
			if (contexte instanceof Tortue) 
				contexte.g(this);
			
		}

	}
