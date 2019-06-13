package INTERPRETEUR;

import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final double TAILLE_MAX = 972.0;
	private static final int HAUTEUR_ENTETE_WINDOW = 40;
	private static final int DEVIATION_X = 17;
	private static final int BORDURE = 20;
	
	public Fenetre( Path2D.Double chemin ) {
		super();
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Rectangle2D frontiere = chemin.getBounds2D();
		double hauteurDessin = frontiere.getHeight();
		double largeurDessin = frontiere.getWidth();
		
		double agrandissement = TAILLE_MAX / Math.max( largeurDessin, hauteurDessin );
		
		setSize( DEVIATION_X + 2 * BORDURE + (int)(agrandissement * largeurDessin), 2 * BORDURE + HAUTEUR_ENTETE_WINDOW + (int)(agrandissement * hauteurDessin ) );


		chemin.transform( AffineTransform.getScaleInstance( agrandissement, - agrandissement ) );

		Rectangle2D nouvelleFrontiere = chemin.getBounds2D();
		double positionX = nouvelleFrontiere.getX();
		double positionY = nouvelleFrontiere.getY();

		chemin.transform( AffineTransform.getTranslateInstance( BORDURE - positionX, BORDURE - positionY ));		

		Dessin dessin = new Dessin( chemin );
		
		add( dessin );
		
		setVisible( true );
	}
	
	public static void afficherChemin( Path2D.Double chemin ) {
		SwingUtilities.invokeLater( () -> new Fenetre( chemin ) );
	}
}
