package Utilities;

import java.security.SecureRandom;
import java.util.Random;

public class RandomData {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String[] DOMAINS = {"yopmail.com", "mailinator.com", "maildrop.cc"};
    public static Random random = new Random();

    public static String generateRandomPassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        sb.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));

        sb.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));

        sb.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));

        sb.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        // Fill the remaining length with random characters
        for (int i = sb.length(); i < length; i++) {
            String validChars = UPPERCASE_LETTERS + LOWERCASE_LETTERS + NUMBERS + SPECIAL_CHARACTERS;
            sb.append(validChars.charAt(random.nextInt(validChars.length())));
        }

        // Shuffle the characters to ensure randomness
        for (int i = sb.length() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
        }

        return sb.toString();
    }

    public static String generateRandomString(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            sb.append(allowedChars.charAt(randomIndex));
        }
        return sb.toString();
    }

    public static String generateRandomName(int length) {
        return generateRandomString(length / 2) + " " + generateRandomString(length / 2);
    }

    public static String generateRandomUsername(int length) {
        return generateRandomString(length);
    }

    public static String generateRandomEmail(int length) {
        String username = generateRandomString(length);
        String domain = DOMAINS[new Random().nextInt(DOMAINS.length)];
        return username + "@" + domain;
    }


    public static String generateRandomWorkEmail(int length) {
        String username = generateRandomString(length);
        String domain = DOMAINS[new Random().nextInt(DOMAINS.length)];
        return username + ".work@" + domain;
    }

}

