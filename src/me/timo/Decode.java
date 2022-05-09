package me.timo;

import javax.swing.*;
import java.util.Arrays;

public class Decode {

    public static void main(String[] args) {
        String message = JOptionPane.showInputDialog("Gebe die Nachricht ein: ");
        int keyCaesar = Integer.parseInt(JOptionPane.showInputDialog("Gebe den Caeser Schlüssel ein: "));
        String keyMegaBuck = JOptionPane.showInputDialog("Gebe den MegaBuck Schlüssel ein: ");

        String decodedMessage = decodeMessage(message, keyCaesar, keyMegaBuck);

        JOptionPane.showMessageDialog(null, decodedMessage);
    }

    public static char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String decodeMessage(String message, int keyCaesar, String keyMegaBuck) {
        int[][] table = new int[keyMegaBuck.length()][(int) Math.ceil((double)message.length() / keyMegaBuck.length())];
        System.out.println(Arrays.deepToString(table));
        return "x";
    }

}
