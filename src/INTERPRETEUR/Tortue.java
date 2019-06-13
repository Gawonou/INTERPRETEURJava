package INTERPRETEUR;




import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Double;
import java.util.Stack;



public class Tortue implements ContexteInterpretation {

	Stack<Tortue> pile;
	Tortue tortue;
	Path2D.Double path = new Path2D.Double();
	double angle = 0;
	double x;
	double y;
	



	protected Tortue(Stack<Tortue> pile, Tortue tortue, Double path, double angle, double x, double y) {
		super();
		this.pile = pile;
		this.tortue = tortue;
		this.path = path;
		this.angle = angle;
		this.x = x;
		this.y = y;
	}
	protected Tortue() {
		super();
		this.pile = new Stack<Tortue>();
		this.tortue = this;
		this.path.moveTo(0, 0);
		this.angle = 0;
		this.x = 0;
		this.y = 0;
	}

	protected Tortue(Tortue tortue) {
		super();
		this.pile = tortue.pile;
		this.tortue = tortue.tortue;
		this.path = tortue.path;
		this.angle = tortue.angle;
		this.x = tortue.x;
		this.y = tortue.y;
	}

	@Override
	public void a(MotA motA) { //avance
		tortue.x = tortue.x + Math.cos(tortue.angle);
		tortue.y = tortue.y + Math.sin(tortue.angle);
		path.lineTo(tortue.x, tortue.y); 
	}

	@Override
	public void a(MotAv motAv) {
		tortue.x = tortue.x + ((double)motAv.get_valeur() * Math.cos(tortue.angle));
		tortue.y = tortue.y + ((double)motAv.get_valeur()*Math.sin(tortue.angle));
		tortue.path.lineTo(tortue.x, tortue.y); 

	}

	@Override
	public void b(MotB motB) {  //recule
		tortue.x = tortue.x - Math.cos(tortue.angle);
		tortue.y = tortue.y - Math.sin(tortue.angle);
		tortue.path.lineTo(tortue.x, tortue.y);  

	}

	@Override
	public void b(MotBv motBv) {
		tortue.x = tortue.x - ((double)motBv.get_valeur()*Math.cos(tortue.angle));
		tortue.y = tortue.y - ((double)motBv.get_valeur()*Math.sin(tortue.angle));
		path.lineTo(tortue.x, tortue.y);

	}

	@Override
	public void c(MotC motC) { //tourne antihoraire
		tortue.angle = tortue.angle + (Math.PI/(double)2);


	}

	@Override
	public void c(MotCv motCv) {
		tortue.angle = tortue.angle + Math.toRadians((double)motCv.get_valeur());
	
	}

	@Override
	public void d(MotD motD) {
		tortue.angle = tortue.angle - (Math.PI/(double)2);
	
	}

	@Override
	public void d(MotDv motDv) {
		tortue.angle = tortue.angle - Math.toRadians((double)motDv.get_valeur());

	}

	@Override
	public void e(MotE motE) {

		pile.push(tortue);
		tortue = new Tortue(tortue);
		
	}

	@Override
	public void f(MotF motF) {
		if (!pile.isEmpty()) {
		tortue = pile.pop();
		tortue.path.moveTo(tortue.x, tortue.y);
		} else {
			   System.err.printf(Principale.MSG_ERR_PILE, motF.get_mot(),
				            	motF.get_ligne(), motF.get_colonne());
			   System.exit(-1);
				}	
	}

	@Override
	public void g(MotG motG) {
		tortue = new Tortue();
		path.moveTo(tortue.x, tortue.y);
	}
	
	public void afficher() { 
		Fenetre.afficherChemin(path);
        
     } 
	
	public String toString() { 
        return ("\ntortue : "
        		+ "\n\tpositionX = " + tortue.x
        		+ "\n\tpositionY = " + tortue.y
        		+ "\n\tdirection = " + tortue.angle
        		+ "\n");
	}
}
