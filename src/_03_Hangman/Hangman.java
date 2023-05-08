package _03_Hangman;

import java.lang.reflect.Array;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
	public static void main(String[] args) {
		Boolean game = false;
		
		JLabel jl = new JLabel();
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		jp.add(jl);
		jf.add(jp);
		jf.setSize(500, 500);
		Stack<String> words = new Stack<String>();
		int num = Integer.parseInt(JOptionPane.showInputDialog("How many words would you like to guess?"));
		for (int i = 0; i < num; i++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));

			if (words.contains(words.push(Utilities.readRandomLineFromFile("dictionary.txt")))) {
				words.pop();
				
			
			}
			
			game = true;
		}
		String guessword = words.pop();
		
		if (game == true) {
			int lives = guessword.length();
			
			jf.setVisible(true);
			String jltext = "";
			for (int i = 0; i < guessword.length(); i++) {
				jltext = jltext + "_";
				jl.setText(jltext);
			}
			while(lives>0) {
			String guessedletter = JOptionPane.showInputDialog("Guess a letter").toString();
			System.out.println(lives);
			if (guessedletter.length() == 1) {
				char[] guesschar = guessedletter.toCharArray();
				for (int i = 0; i < guessword.length(); i++) {
					if (guessword.charAt(i) == guesschar[0]) {
						char[] jltextar = jltext.toCharArray();
						jltextar[i]=guesschar[0];
						
						jltext="";
					for (int j = 0; j < jltextar.length; j++) {
						
						jltext = jltext+jltextar[j];
						
					}
						
						jl.setText(jltext);
					}
					
				}
				if (guessword.contains(guessedletter)==false) {
					lives = lives-1;
				}
			}

			else {
				
				guessedletter = JOptionPane.showInputDialog("Guess another letter (ONE LETTER)").toString();
			}
			if (lives==0) {
				
				int reply =JOptionPane.showConfirmDialog(null, "Do you want to coninue playing?");
				 if (reply == JOptionPane.YES_OPTION)
	                {
	                    jltext ="";
	                    jl.setText(jltext);
	                    if (words.size()>0) {
							guessword=words.pop();
							 lives=guessword.length();
							 for (int i = 0; i < guessword.length(); i++) {
									jltext = jltext + "_";
									jl.setText(jltext);
								}
							 
						}
	                    else {
	                    	words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
	                    	guessword=words.pop();
	                    	lives=guessword.length();
	                    	for (int i = 0; i < guessword.length(); i++) {
	            				jltext = jltext + "_";
	            				jl.setText(jltext);
	            				
	            			}
	                    	
	                    }
	                   
	                   
	                }
				 if (reply == JOptionPane.NO_OPTION||reply==JOptionPane.CANCEL_OPTION)
	                {
					 System.exit(0);
	                }
	                
			
			}
		
			}
		}
	}
}
