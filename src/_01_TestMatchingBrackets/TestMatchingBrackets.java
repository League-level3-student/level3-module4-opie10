package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {
		if (b.charAt(b.length() - 1) == '{' || b.charAt(0) == '}') {
			return false;
		}
		int isgood = 0;
		boolean check = false;
		Stack<Character> charst = new Stack<Character>();

		for (int i = 0; i < b.length(); i++) {
			charst.push(b.charAt(i));

		}

		for (int i = 0; i <= charst.size(); i++) {
			if (charst.peek() == '{') {

				isgood = isgood + 1;
			}
			if (charst.peek() == '}') {

				isgood = isgood - 1;

			}
			charst.pop();
			i = 0;
		}

		if (isgood == 0) {
			check = true;

		} else {
			check = false;

		}
		return check;
	}
}