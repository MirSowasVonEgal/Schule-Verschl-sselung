package me.timo;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

public class Decode {

    public static void main(String[] args) {
        /*String message = JOptionPane.showInputDialog("Gebe die Nachricht ein: ");
        int keyCaesar = Integer.parseInt(JOptionPane.showInputDialog("Gebe den Caeser Schlüssel ein: "));
        String keyMegaBuck = JOptionPane.showInputDialog("Gebe den MegaBuck Schlüssel ein: ");*/

        String message = "Ich habe Hunger";
        int keyCaesar = 12;
        String keyMegaBuck = "Auto";

        String decodedMessage = decodeMessage(message, keyCaesar, keyMegaBuck);

        //JOptionPane.showMessageDialog(null, decodedMessage);
    }

    public static char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String decodeMessage(String message, int keyCaesar, String keyMegaBuck) {
        message = message.toUpperCase().replaceAll("\\s", "");
        keyMegaBuck = keyMegaBuck.toUpperCase();
        String decoded = decodeMegaBuck(message, keyMegaBuck);
        System.out.println(decoded);
        return decoded;
    }

    public static String decodeMegaBuck(String message, String keyMegaBuck) {
        char[][] table = new char[keyMegaBuck.length()][(int) Math.ceil((double)message.length() / keyMegaBuck.length())];
        int[] header = getKeyMegaBuckArray(keyMegaBuck);

        int normalArraySize = (int) Math.floor((double)message.length() / keyMegaBuck.length());
        int fullArray = message.length() % keyMegaBuck.length();
        int x = 0;
        for (int i : header) {
            int temp = normalArraySize;
            if(i < fullArray)
                temp++;
            for (int j = 0; j < temp; j++) {
                table[i][j] = message.charAt(j*keyMegaBuck.length() + x);
            }
            x++;
        }

        StringBuilder output = new StringBuilder();
        for (char[] chars : table) {
            for (char current : chars) {
                if(current != 0)
                    output.append(current);
            }
        }
        return output.toString().replaceAll(" ","");
    }
    
    private static int[] getKeyMegaBuckArray(String keyMegaBuck) {
        int[] output = new int[keyMegaBuck.length()];
        String[] splitKeyMegaBuck = keyMegaBuck.split("");
        int k = 0;
        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < keyMegaBuck.length(); j++) {
                if(!Objects.equals(splitKeyMegaBuck[j], "")) {
                    if (alphabet[i] == splitKeyMegaBuck[j].charAt(0)) {
                        splitKeyMegaBuck[j] = "";
                        output[j] = k;
                        k++;
                        i--;
                        break;
                    }
                }
            }
        }
        return output;
    }

}
