package de.erik.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Mojo(name = "chuck_norris")
public class ChuckNorrisMojo extends AbstractMojo {

    private static final String RESOURCE_PATH = "/de/erik/maven/chucknorris/";

    public void execute() throws MojoExecutionException {
        try {
            getLog().info(readPicture());
            getLog().info("Chuck Norris fact of the build:\n");
            getLog().info("\t- " + pickRandomQuote());
        } catch (IOException e) {
            throw new MojoExecutionException(e.getLocalizedMessage());
        }
    }

    private String readPicture() throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(RESOURCE_PATH + "image/chuck.txt")));
        final StringBuilder picture = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            picture.append(line).append("\n");
        }

        return picture.toString();
    }

    private List<String> readQuotes() throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(RESOURCE_PATH + "quotes/quotes.txt")));
        final List<String> quotes = new ArrayList<String>();

        String line;
        while ((line = br.readLine()) != null) {
            quotes.add(line);
        }

        return quotes;
    }

    private String pickRandomQuote() throws IOException {
        final List<String> quotes = readQuotes();

        return quotes.get(new Random().nextInt(quotes.size()));
    }
}
