
// Tessa Biava
// 06/23/2019
// CST-105
// This is my own work

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextToPigLatin {

	public static void main(String[] args) {
		// this pulls the text file from path
		String filePath = "C:\\Users\\Tessa\\eclipse-workspace\\Exercise 4\\src\\ExerciseText\\";
		String entireText = "";

		// Try-Catch to make sure file is present.
		// BufferedReader is used to read the text from a text input stream
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

			String readLine = "";

			// Start while loop
			while ((readLine = bufferedReader.readLine()) != null) {
				entireText += readLine; // Set each line that is read to the entireText String variable.
			}
			// End while loop

			bufferedReader.close(); // Close the Buffered Reader
		} catch (IOException e) { // Catch starts
			e.printStackTrace(); // helps to understand where the actual problem occurred. It helps to trace the
									// exception.
		} // Catch ends.

		// Run the method printTranslation
		printTranslation(entireText);
	}

	// Print each word from text besides their Pig Latin Translation
	public static void printTranslation(String entireText) {
		String[] wordArray = entireText.split(" "); // split entireText by white space.

		// Loop through every word in the wordArray and print it to console with it's
		// Pig Latin equivalent in a formated fashion.
		for (String word : wordArray) {

			System.out.printf("%-16s%-16s\n", word, translate(word)); // Print the original word and translation in
																		// formated rows to console.
		}
	}

	// Translating into Pig Latin
	public static String translate(String word) {
		// Method variables.
		int vowelIndex = 0;
		int wordLength = word.length();
		String pigLatin = "";

		// Loop through the word marking where the first vowel is.
		for (int i = 0; i < wordLength; i++) {
			// Gets the char at i and sets it to lower case for comparing to vowels.
			char letter = Character.toLowerCase(word.charAt(i));

			// If a letter of a word equals a vowel break loop
			if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
				vowelIndex = i; // Set the value of firstVowel the index of the character in the word.
				break; // Exit loops
			}

		}

		// Rearrange word into Pig Latin.
		// First it tests if it starts with a vowel
		if (vowelIndex == 0) {
			pigLatin = word + "way"; // Put way on end of any word starting with a vowel.
		} else {
			// Create substring of characters to add to the end of the word.
			String toEnd = word.substring(0, vowelIndex);

			// This creates a substring of the new start of the word.
			String newStart = word.substring(vowelIndex, wordLength);

			// Combine both substrings together and add ay.
			pigLatin = newStart + toEnd + "ay";
		}

		return pigLatin.toUpperCase(); // Makes words translated into Pig Latin UPPERCASE
	}

}