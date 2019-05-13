package de.erik.maven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    private static final String RESOURCE_PATH = "/de/erik/maven/chucknorris/";

    public static String readPicture() throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(Utils.class.getResourceAsStream(RESOURCE_PATH + "image/chuck.txt")));
        final StringBuilder picture = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            picture.append(line).append("\n");
        }

        br.close();

        return picture.toString();
    }

    public static List<String> readQuotes() throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(Utils.class.getResourceAsStream(RESOURCE_PATH + "quotes/quotes.txt")));
        final List<String> quotes = new ArrayList<String>();

        String line;
        while ((line = br.readLine()) != null) {
            quotes.add(line);
        }

        br.close();

        return quotes;
    }

    public static String pickRandomQuote() throws IOException {
        final List<String> quotes = readQuotes();

        return quotes.get(new Random().nextInt(quotes.size()));
    }

}
