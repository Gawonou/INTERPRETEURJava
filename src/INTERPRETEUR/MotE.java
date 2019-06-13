package INTERPRETEUR;

	public class MotE extends Mot{

		public MotE(int _ligne, int _colonne ) {
			super('e', _ligne, _colonne);		
		}

		@Override
		public void interprete(ContexteInterpretation contexte) {
			if (contexte instanceof Calculatrice) 
				contexte.e(this);
			if (contexte instanceof Profil) 
				contexte.e(this);
			if (contexte instanceof Tortue) 
				contexte.e(this);
			
		}

	}
