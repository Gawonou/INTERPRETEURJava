package INTERPRETEUR;

	public class MotD  extends Mot{

		public MotD(int _ligne, int _colonne ) {
			super('d', _ligne, _colonne);		
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

