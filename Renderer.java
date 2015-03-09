import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;


public class Renderer implements GLEventListener {
	
	private float Rotate = 0.0f;
	
	private void square(GL2 gl, float r, float g, float b) {
		gl.glColor3f(r,g,b);          // The color for the square.
		gl.glTranslatef(0,0,0.5f);    // Move square 0.5 units forward.
		gl.glNormal3f(0,0,1);         // Normal vector to square (this is actually the default).
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		gl.glVertex2f(-0.5f,-0.5f);    // Draw the square (before the
		gl.glVertex2f(0.5f,-0.5f);     //   the translation is applied)
		gl.glVertex2f(0.5f,0.5f);      //   on the xy-plane, with its
		gl.glVertex2f(-0.5f,0.5f);     //   at (0,0,0).
		gl.glEnd();
	}

	private void cube(GL2 gl) {

		gl.glPushMatrix();
		square(gl,1,0,0);        // front face is red
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(180,0,1,0); // rotate square to back face
		square(gl,0,1,1);        // back face is cyan
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(-90,0,1,0); // rotate square to left face
		square(gl,0,1,0);        // left face is green
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(90,0,1,0); // rotate square to right face
		square(gl,1,0,1);       // right face is magenta
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(-90,1,0,0); // rotate square to top face
		square(gl,0,0,1);        // top face is blue
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glRotatef(90,1,0,0);  // rotate square to bottom face
		square(gl,1,1,0);        // bottom face is yellow
		gl.glPopMatrix();

	}
	
	@Override
    public void reshape(GLAutoDrawable glDrawable, int x, int y, int width, int height) {
		
    }

	@Override
    public void init(GLAutoDrawable glDrawable) {
		   // called when the panel is created
		GL2 gl = glDrawable.getGL().getGL2();
		gl.glClearColor(0.8F, 0.8F, 0.8F, 1.0F);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glEnable(GL2.GL_LIGHTING);
		gl.glEnable(GL2.GL_LIGHT0);
		gl.glEnable(GL2.GL_COLOR_MATERIAL);
    }

	@Override
    public void dispose(GLAutoDrawable glDrawable) {

    }

	@Override
    public void display(GLAutoDrawable glDrawable) {
       		
		GL2 gl = glDrawable.getGL().getGL2();
		gl.glClearColor(0,0,0,0);
		gl.glClear( GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT );

		gl.glMatrixMode(GL2.GL_PROJECTION);  // Set up the projection.
		gl.glLoadIdentity();
		gl.glOrtho(-1,1,-1,1,-2,2);
		gl.glMatrixMode(GL2.GL_MODELVIEW);

		gl.glLoadIdentity();             // Set up modelview transform. 
		gl.glRotatef(Rotate++,0,0,1);
		gl.glRotatef(Rotate++,0,1,0);
		gl.glRotatef(Rotate++,1,0,0);
		cube(gl);
    }
	
	
}