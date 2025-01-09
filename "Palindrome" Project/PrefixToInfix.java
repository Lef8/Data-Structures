/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
	Name: Anna-Lefkothea Papavasileiou
	Student Number: 6190101
*/

import java.util.Scanner;

public class PrefixToInfix {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome!");
		System.out.println("This program reads a numeric expression in prefix form"
						 + " and prints the corresponding infix form.");
		
		boolean invalidExpression = true;
		
		System.out.print("Please enter the prefix expression that you would like"
						 + " to convert to its infix expression: ");
		String prefix = in.nextLine();
		
		char[] a = prefix.toCharArray();
		
		do { //Checks if the given prefix expression is valid.
			
			if (a.length < 3) { // The length of the prefix expression is less than 3
				System.out.println("The prefix expression that you entered (" + prefix 
	 		 		 	 		 + ") is not valid. "
	 		 		 	 		 + "A prefix expression should have at least 3 length.");
				System.out.print("Please enter a valid prefix expression, that you would like"
		 		 	   	   + " to convert to its infix expression: ");
				prefix = in.nextLine();
				a = prefix.toCharArray();
			} else {
			// Line 33 checks if the first element of the prefix expression is an operator and the last is an operand between and including 0 and 9
				if ((a[0] == '+' || a[0] == '-' || a[0] == '*' || a[0] == '/') && ('0' <= a[a.length - 1] && a[a.length - 1] <= '9')) {
					Boolean valid = false;
					for (int i = 1; i < a.length; i++) { // Checks if all the elements of the prefix expression are 
						if ((a[i] < '0' || '9' < a[i]) && (a[i] != '+' && a[i] != '-' && a[i] != '*' && a[i] != '/')) {
							System.out.println("The prefix expression that you entered (" + prefix 
						 		 		 	 + ") is not valid. "
						 		 		 	 + "A prefix expression should only have numbers between 0 and 9 and the operands +, -, * and /.");
							System.out.print("Please enter a valid prefix expression, that you would like"
						 		 	   	   + " to convert to its infix expression: ");
							prefix = in.nextLine();
							a = prefix.toCharArray();
							break;
						}
					
						if (i == (a.length-1)) {
							valid = true;
						}
						
					}
					
					if (valid == true) {
						//invalidExpression = false;
						int operands = 0, operators = 0;
						int operandsWithoutLastTwo = 0, operatorsWithoutLastTwo = 0;
						for (int i = 0; i < a.length; i++) {
							if (a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/') {
								operators++;
								if (i < (a.length - 2)) {
									operatorsWithoutLastTwo++;
								}
							} else {
								operands++;
								if (i < (a.length - 2)) {
									operandsWithoutLastTwo++;
								}
							}
						}
						if ((operators + 1) == operands) { // The total number of operands, is one more than the total number of operators
							if (operandsWithoutLastTwo <= operatorsWithoutLastTwo) { // No less operators than operands, excluding the last two symbols
								
								
								char[] reversed = new char[a.length];
								
								int startingIndex = a.length - 1;
								
								for (int i = (startingIndex); i >= 0; i--) { 
									reversed[startingIndex - i] = a[i];
								}
								
								int counter = 0;
								boolean validExpression  = true;

								for (int i = 0; i < reversed.length; i++) {
								    if (Character.isDigit(reversed[i])) {
								        counter++;
								    } else if (reversed[i] == '+' || reversed[i] == '-' || reversed[i] == '*' || reversed[i] == '/') {
								        if (counter < 2) {
								            validExpression = false;
								            break;
								        }
								        counter -= 2;
								        counter++;
								    }
								}

								
								// Outside the loop, check if the counter is 1 and never went below 0
								if (counter == 1 && validExpression) {
								    invalidExpression = false;  // // Valid prefix expression!!!
								} else {
								    System.out.println("The prefix expression that you entered (" + prefix 
		 		 		 	 		 		 		 + ") is not valid and causes an underflow. "
		 		 		 	 		 		 		 + "A prefix expression should not contain less operators than operands, excluding the last two symbols.");
								    System.out.print("Please enter a valid prefix expression, that you would like"
			 		 	   	   	   		   		   + " to convert to its infix expression: ");
								    prefix = in.nextLine();
								    a = prefix.toCharArray();
								}
								
								
								
							} else { // Change the message in line 76!!!
								System.out.println("The prefix expression that you entered (" + prefix 
			 		 		 	 		 		 + ") is not valid. "
			 		 		 	 		 		 + "A prefix expression should not contain less operators than operands, excluding the last two symbols.");
								System.out.print("Please enter a valid prefix expression, that you would like"
				 		 	   	   	   		   + " to convert to its infix expression: ");
								prefix = in.nextLine();
								a = prefix.toCharArray();
							}
							
						} else {
							System.out.println("The prefix expression that you entered (" + prefix 
				 		 		 	 		 + ") is not valid. "
				 		 		 	 		 + "A prefix expression should always have exactly one more operand than operators.");
							System.out.print("Please enter a valid prefix expression, that you would like"
					 		 	   	   	   + " to convert to its infix expression: ");
							prefix = in.nextLine();
							a = prefix.toCharArray();
						}
						
					}
					
				} else {
					if (!(a[0] == '+' || a[0] == '-' || a[0] == '*' || a[0] == '/')) {
						System.out.println("The prefix expression that you entered (" + prefix 
						 		 	 	 + ") is not valid. "
						 		 	 	 + "A prefix expression should start with an operator.");
						System.out.print("Please enter a valid prefix expression, that you would like"
						 	   	   	   + " to convert to its infix expression: ");
						prefix = in.nextLine();
						a = prefix.toCharArray();
					} else {
						System.out.println("The prefix expression that you entered (" + prefix 
				 		 	 	 		 + ") is not valid. "
				 		 	 	 		 + "A prefix expression should end with an operand.");
						System.out.print("Please enter a valid prefix expression, that you would like"
				 	   	   	   		   + " to convert to its infix expression: ");
						prefix = in.nextLine();
						a = prefix.toCharArray();
					}
				}
				
			}
			
		} while(invalidExpression);
		
		char[] reversed = new char[a.length];
		
		int startingIndex = a.length - 1;
		
		for (int i = (startingIndex); i >= 0; i--) { 
			reversed[startingIndex - i] = a[i];
		}
		
		StringDoubleEndedQueueImpl<String> stackQueue = new StringDoubleEndedQueueImpl<String>();
		
		for (int i = 0; i < reversed.length; i++) {
			if (reversed[i] == '+' || reversed[i] == '-' || reversed[i] == '*' || reversed[i] == '/') {
				String operandA = stackQueue.removeFirst();
				String operandB = stackQueue.removeFirst();
				String result = "(" + operandA + " " + reversed[i] + " " + operandB + ")";
				stackQueue.addFirst(result);
			} else {
				stackQueue.addFirst(String.valueOf(reversed[i]));
			}
		}
		
		System.out.print("The corresponding infix expression, of the given prefix expression is: ");
		stackQueue.printQueue(System.out);
		
		in.close();

	}

}
