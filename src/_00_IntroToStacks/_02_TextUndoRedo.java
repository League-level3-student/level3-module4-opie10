package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JLabel jl = new JLabel();
	Stack<Character> chars = new Stack<>();

	void start() {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	
		
	


jp.add(jl);
jf.add(jp);
jf.setSize(500,500);
jf.setVisible(true);
jf.addKeyListener(this);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()!=e.VK_BACK_SPACE||e.getKeyCode()==e.VK_BACK_SLASH) {
	String olds = jl.getText();
	char adds = e.getKeyChar();
	String news = olds+adds; 
	
	System.out.println(jl.getText().length());
		
		// TODO Auto-generated method stub
		jl.setText(news);
		}
		if (e.getKeyCode()==e.VK_BACK_SPACE) {
			
		char del=	jl.getText().charAt(jl.getText().length()-2);
	String str=	jl.getText().substring(0,jl.getText().length()-1);
		jl.setText(str);
		
		chars.push(del);
		
		}
		if (e.getKeyCode()==e.VK_BACK_SLASH) {
			String stri=	jl.getText().substring(0,jl.getText().length()-1);
			jl.setText(stri+chars.pop());
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}
}
