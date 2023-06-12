package _00_IntroToStacks;

import java.util.Random;

import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		Stack<Double> stack = new Stack<Double>();
		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int i = 0; i < 99; i++) {
			Random rand = new Random();
			Double doub = rand.nextDouble() * 100;
			stack.push(doub);

		}
		JOptionPane.showMessageDialog(null, "Please enter two numbers:");

		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter a number between 0 and 100"));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter a number between 0 and 100"));
		int top = 0;
		int bottom = 0;
		if (num1 > num2) {
			top = num1;
			bottom = num2;
		}
		if (num2 > num1) {
			top = num2;
			bottom = num1;
		}
		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		for (int i = 0; i < 99; i++) {

			if (bottom < stack.peek() && stack.peek() < top) {

				System.out.println(stack.pop());
			} else {
				stack.pop();
			}
		}
		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.

		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}
}
