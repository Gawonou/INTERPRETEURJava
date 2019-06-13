package INTERPRETEUR;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

import javax.swing.JPanel;

public class Dessin extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final Color pinceau = Color.BLACK;

	protected Path2D.Double _chemin;
	
	public Dessin( Path2D.Double chemin ) {
		super();
		
		_chemin = chemin;
	}
	
	@Override
	protected void paintComponent( Graphics g ) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setPaint( pinceau );
		g2.draw( _chemin );
	}
}
