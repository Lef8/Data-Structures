/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
	Name: Anna-Lefkothea Papavasileiou
	Student Number: 6190101
*/

import java.util.Scanner;

public class DNAPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a DNA sequence: ");
        String dnaSequence = scanner.nextLine();

        try {
            boolean isPalindrome = isWatsonCrickPalindrome(dnaSequence);
            if (isPalindrome) {
                System.out.println("Yes, it is a Watson-Crick complemented palindrome.");
            } else {
                System.out.println("No, it is not a Watson-Crick complemented palindrome.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    private static boolean isWatsonCrickPalindrome(String dnaSequence) {
        StringDoubleEndedQueue<String> queue = new StringDoubleEndedQueueImpl<String>();

        // Adding elements in the queue
        for (int i = 0; i < dnaSequence.length(); i++) {
            char currentNucleotide = dnaSequence.charAt(i);
            if (isValidNucleotide(currentNucleotide)) {
                queue.addLast(Character.toString(currentNucleotide));/////////
            } else {
                throw new IllegalArgumentException("Invalid DNA sequence: " + currentNucleotide);
            }
        }
        
        if (dnaSequence == "") {
        	return true;
        }
        if (dnaSequence.length() % 2 == 1) {
        	return false;
        }
        
        // Checking if the sequence is a Watson-Crick sequence
        while (queue.size() >= 2) {
            String frontNucleotide = queue.removeFirst();
            String endNucleotide = queue.removeLast();

            if (!areComplementary(frontNucleotide.charAt(0), endNucleotide.charAt(0))) {
                return false; // 
            }
        }

        return true; // 
    }
    
    private static boolean isValidNucleotide(char nucleotide) {
        // Check if it is the character (A, T, C, G)
        return nucleotide == 'A' || nucleotide == 'T' || nucleotide == 'C' || nucleotide == 'G';
    }

    private static boolean areComplementary(char nucleotide1, char nucleotide2) {
        // Check if the nucleotides are complementary
        return (nucleotide1 == 'A' && nucleotide2 == 'T') ||
               (nucleotide1 == 'T' && nucleotide2 == 'A') ||
               (nucleotide1 == 'C' && nucleotide2 == 'G') ||
               (nucleotide1 == 'G' && nucleotide2 == 'C');
    }
}