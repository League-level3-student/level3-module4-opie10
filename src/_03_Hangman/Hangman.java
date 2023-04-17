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
		jf.add(jl);
		jp.add(jf);
		jp.setSize(100, 100);
		Stack<String> words = new Stack<String>();
		int num = Integer.parseInt(JOptionPane.showInputDialog("How many words would you like to guess?"));
		for (int i = 0; i < num; i++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));

			if (words.contains(words.get(i))) {
				words.pop();
				i = i - 1;
			}
			game = true;
		}
		String guessword = words.pop();
		while (game = true) {
			jp.setVisible(true);
			String jltext = "";
			for (int i = 0; i < guessword.length(); i++) {
				jltext = jl + "_";
				jl.setText(jltext);
			}
			String guessedletter = JOptionPane.showInputDialog("Guess a letter").toString();
			if (guessedletter.length() < 1) {
				char[] guesschar = guessedletter.toCharArray();
				for (int i = 0; i < guessword.length(); i++) {
					if (guessword.charAt(i) == guesschar[0]) {
				
						
jl.setText(jltext);
					}
				}
			}

			else {
				guessedletter = JOptionPane.showInputDialog("Guess another letter (ONE LETTER)").toString();
			}
		}
	}
}
