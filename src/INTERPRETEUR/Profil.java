package INTERPRETEUR;

public class Profil implements ContexteInterpretation {

	int nbOperations;
	int nbAccesPile;
	int nbAccesAccumulateur;		
	
	protected Profil() {
		super();
		this.nbOperations = 0;
		this.nbAccesPile = 0;
		this.nbAccesAccumulateur = 0;
	}

	@Override
	public void a(MotA motA) {
		this.nbAccesPile += 3;
		this.nbOperations += 1;
	}

	@Override
	public void a(MotAv motAv) {
		this.nbAccesAccumulateur += 2;
		this.nbOperations += 1;
	}

	@Override
	public void b(MotB motB) {
		this.nbAccesPile += 3;
		this.nbOperations += 1;
	}

	@Override
	public void b(MotBv motBv) {
		this.nbAccesAccumulateur += 2;
		this.nbOperations += 1;
	}

	@Override
	public void c(MotC motC) {
		this.nbAccesPile += 3;
		this.nbOperations += 1;
	}

	@Override
	public void c(MotCv motCv) {
		this.nbAccesAccumulateur += 2;
		this.nbOperations += 1;
	}

	@Override
	public void d(MotD motD) {
		this.nbAccesPile += 3;
		this.nbOperations += 1;
	}

	@Override
	public void d(MotDv motDv) {
		this.nbAccesAccumulateur += 2;
		this.nbOperations += 1;
	}

	@Override
	public void e(MotE motE) {
		this.nbAccesPile += 1;
		this.nbAccesAccumulateur += 1;
	}

	@Override
	public void f(MotF motF) {
		this.nbAccesPile += 1;
		this.nbAccesAccumulateur += 1;
	}

	@Override
	public void g(MotG motG) {
		this.nbAccesAccumulateur += 1;
	}
	public String toString() { 
        return ("\nprofil : "
        		+ "\n\tno = " + this.nbOperations
        		+ "\n\tnp = " + this.nbAccesPile
        		+ "\n\tna = " + this.nbAccesAccumulateur
        		+"\n");
	}

}
