/*
Program reads a passed file, scans the file, and counts the amount of vowels in the file. Uses a function to get vowels.
First we must read the file and put each character in a list, then it loops through the list to count vowels it prints the # of vowels .

@author KincaidBD
@since 2026-11-14
@version 1.0
*/

// import statements
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class VowelCounter {

    // Function to count vowels in a file, it uses an ArrayList set to Character type to store every character in the text given.
    public static ArrayList<Character> countVowels(String fileName) {

        // Create two ArrayLists, one for all characters and one for vowels
        ArrayList<Character> characterList = new ArrayList<Character>();
        ArrayList<Character> vowelList = new ArrayList<Character>();

        // try to read file, if it fails, print error message and return empty vowelList
        try {
            // Initialize scanner to read the file, inside try block to catch if the file doesnt exist or is unreadable to the computer
            Scanner scanner = new Scanner(new File(fileName));

            // while the file has another line to it
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // it adds every character in the line to the characterList ArrayList
                for (int i = 0; i < line.length(); i++) {
                    characterList.add(line.charAt(i));
                }
            }

            // close the scanner to prevent resource leak
            scanner.close();

        } catch (Exception e) {
            System.out.println("Error reading file."); // print error message if file cannot be read
            return vowelList; //  returns just the list of all vowels found in the file, which will be empty if the file cannot be read
        }

        // Loop through the characterList and check if each character is a vowel, if it is, add it to the vowelList
        for (int i = 0; i < characterList.size(); i++) {
            char character = Character.toLowerCase(characterList.get(i));

            // if statement checking if the character is a vowel
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                // adds the vowel to the vowel list
                vowelList.add(characterList.get(i));
            }
        }

        return vowelList;
    }

    public static void outputVowels(ArrayList<Character> vowels, String fileName) {
        // write the number of vowels found in the file to the output file
        try {
            // Initialize PrintWriter to write to the output file
            PrintWriter writer = new PrintWriter(new File(fileName));
            // write the number of vowels found in the file to the output file
            writer.println("Number of vowels in " + fileName + ": " + vowels.size());
            writer.close();
        } catch (Exception e) {
            // print error message if file cannot be written to
            System.out.println("Error writing to output file.");
        }
        
    }

    // Main method to call the countVowels function and print the number of vowels found in the file
    public static void main(String[] args) {
        // call upon the countVowels function and store the result in an ArrayList of Characters
        ArrayList<Character> vowels = countVowels("/home/vscode/ICS4UC/Assign/Assign-02/Assign-2-JAVA/File.txt");
        // call the outputVowels function to write the number of vowels found in the file to the output file
        outputVowels(vowels, "/home/vscode/ICS4UC/Assign/Assign-02/Assign-2-JAVA/output.txt"); 

    }
}
