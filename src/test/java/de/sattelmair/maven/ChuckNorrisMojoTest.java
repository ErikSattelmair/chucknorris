package de.sattelmair.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import static org.junit.Assert.assertTrue;

public class ChuckNorrisMojoTest {

    private static final String RESOURCE_PATH = "/de/erik/maven/chucknorris/";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(this.outContent));
    }

    @Test
    public void testChuckNorrisMojo() throws MojoFailureException, MojoExecutionException, IOException {
        final AbstractMojo abstractMojo = new ChuckNorrisMojo();
        abstractMojo.execute();

        final String loggerOutput = this.outContent.toString();
        assertTrue(loggerOutput.contains(Utils.readPicture()));

        //Skip the [info] output at the beginning
        final String quote = loggerOutput.substring(loggerOutput.indexOf("\t") + 3);
        //Skip the line break made by the logger at the end and test it against the quotes
        assertTrue(Utils.readQuotes().contains(quote.substring(0, quote.length() - 1)));
    }

    @After
    public void restoreStreams() {
        System.setOut(this.originalOut);
    }

}
