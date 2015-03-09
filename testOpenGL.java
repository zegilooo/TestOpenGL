import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class testOpenGL {
	public static void main(String[] args) {    
		GLCanvas glcanvas = new GLCanvas();
	    glcanvas.addGLEventListener( new Renderer());
	
	    final JFrame jframe = new JFrame( "Cube" ); 
	    jframe.addWindowListener( new WindowAdapter() {
	        public void windowClosing( WindowEvent windowevent ) {
	            jframe.dispose();
	            System.exit( 0 );
	        }
	    });
	    jframe.getContentPane().add( glcanvas, BorderLayout.CENTER );
	    jframe.setSize( 640, 480 );
	    jframe.setVisible( true );
	    while(true){
	    	glcanvas.display();
	    }
	}
}
