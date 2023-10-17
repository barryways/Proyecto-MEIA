/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jmanc
 */
public class loginModel {
    public final String[] MESSAGES ={
      "Contraseña insegura",
    "Contraseña poco segura",
    "Contraseña segura",
    "Contraseña muy segura"
    };
      private ArrayList<Integer> scoreData;
        private ArrayList<Range> scoreRanges;
        
        public loginModel() {
        try {
            scoreData = readScoreData();
            scoreRanges = readRanges();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private class Range{
         int start;
    int end;
    String message;



    public Range(int start, int end, String message) {
        this.start = start;
        this.end = end;
        this.message = message;
    }

    public boolean isWithin(int score) {
        return score >= start && score <= end;
    }
    }
    
        
    private ArrayList<Integer> readScoreData() throws IOException {
    ArrayList<Integer> data = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
        data.add(Integer.parseInt(line.trim()));
    }
    reader.close();
    return data;
}

   private int calculateScore(String password) {
        int score = 0;
        if (password.length() < scoreData.get(0)) {
            return score;
        }

        score += scoreData.get(1) * password.length();
        score += scoreData.get(2) * countUppercase(password);
        score += countLetters(password) + scoreData.get(3);
        score += countDigits(password) + scoreData.get(4);
        score += countSymbols(password) * (password.length() + scoreData.get(5));
        if (isOnlyLetters(password)) {
            score -= scoreData.get(6);
        }
        if (isOnlyDigits(password)) {
            score -= scoreData.get(7);
        }
        return score;
    }
    private int countUppercase(String password) {
        int count = 0;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }
 private int countLetters(String password) {
        int count = 0;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }
  private int countDigits(String password) {
        int count = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }
    private int countSymbols(String password) {
        return password.length() - countLetters(password) - countDigits(password);
    }
      private boolean isOnlyLetters(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOnlyDigits(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
private ArrayList<Range> readRanges() throws IOException {
    ArrayList<Range> ranges = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader("ranges.txt"));
    String line;
    int index = 0;
    while ((line = reader.readLine()) != null && index < MESSAGES.length) {
        String[] parts = line.split(",");
        int start = Integer.parseInt(parts[0].trim());
        int end = Integer.parseInt(parts[1].trim());
        String message = MESSAGES[index];
        ranges.add(new Range(start, end, message));
        index++;
    }
    reader.close();
    return ranges;
}

    private String displayScore(int score) {
    for (Range range : scoreRanges) {
        if (range.isWithin(score)) {
            return range.message;
        }
    }
    return "Contraseña desconocida";
}
 public String verifyPassword(String password) {
    int score = calculateScore(password);
    return displayScore(score);
}       
}
