package INTERPRETEUR;

import java.util.Stack;

public class Calculatrice implements ContexteInterpretation {

	int accumulateur;
	Stack<Integer> Pile = new Stack<Integer>();
	
	protected Calculatrice() {
		super();
		this.accumulateur = 0;
	}
	@Override
	public void a(MotA motA) {
		
		if (!Pile.isEmpty()) {
			int val1 = Pile.pop();
			int val2 = Pile.pop();
			Pile.push(val1+val2);
		}	else {
				System.err.printf(Principale.MSG_ERR_PILE, motA.get_mot(),
									motA.get_ligne(), motA.get_colonne());
				System.exit(-1);
		}		
	}

	@Override
	public void b(MotB motB) {
		if (!Pile.isEmpty()) {
			int val1 = Pile.pop();
			int val2 = Pile.pop();
			Pile.push(val2-val1);
		}	else {
			System.err.printf(Principale.MSG_ERR_PILE, motB.get_mot(),
							motB.get_ligne(), motB.get_colonne());
			System.exit(-1);
			}	
	}

	@Override
	public void c(MotC motC) {
		if (!Pile.isEmpty()) {
			int val1 = Pile.pop();
			int val2 = Pile.pop();
			Pile.push(val1*val2);
		}	else {
			System.err.printf(Principale.MSG_ERR_PILE, motC.get_mot(),
							motC.get_ligne(), motC.get_colonne());
			System.exit(-1);
		}	

	}

	@Override
	public void d(MotD motD) {
		if (!Pile.isEmpty()) {
			int val1 = Pile.pop();
			int val2 = Pile.pop();
			if (val2 != 0) {
				Pile.push(val1 / val2);
			}	else {
				System.err.printf(Principale.MSG_ERR_ZERO, motD.get_mot(),
								motD.get_ligne(), motD.get_colonne());
				System.exit(-1);
				}
		}	else {
			System.err.printf(Principale.MSG_ERR_PILE, motD.get_mot(),
							motD.get_ligne(), motD.get_colonne());
			System.exit(-1);
		}	

	}

	@Override
	public void e(MotE motE) {
		Pile.push(this.accumulateur);
	}

	@Override
	public void f(MotF motF) {
		if (!Pile.isEmpty()) {
		this.accumulateur = Pile.pop();
		}	else {
			System.err.printf(Principale.MSG_ERR_PILE, motF.get_mot(),
							motF.get_ligne(), motF.get_colonne());
			System.exit(-1);
		}	

	}

	@Override
	public void g(MotG motG) {
		this.accumulateur = 0;

	}
	@Override
	public void a(MotAv motAv) {
		this.accumulateur += motAv.get_valeur();
		
	}
	@Override
	public void b(MotBv motBv) {
		this.accumulateur = this.accumulateur - motBv.get_valeur();
			
	}
	@Override
	public void c(MotCv motCv) {
		this.accumulateur = this.accumulateur * motCv.get_valeur();
			
	}
	@Override
	public void d(MotDv motDv) {
		if (motDv.get_valeur() != 0) {
			this.accumulateur = this.accumulateur / motDv.get_valeur();
		}	else {
			System.err.printf(Principale.MSG_ERR_ZERO, motDv.get_mot(),
							motDv.get_ligne(), motDv.get_colonne());
			System.exit(-1);
			}	
	}

	public String toString() { 
        return ("\ncalculatrice : \n\taccumulateur = " + accumulateur +
        		"\n\tpile = " + Pile +"\n");
     } 
}
