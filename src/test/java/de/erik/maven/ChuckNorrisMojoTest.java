package de.erik.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Test;

public class ChuckNorrisMojoTest {

    @Test
    public void testChuckNorrisMojo() throws MojoFailureException, MojoExecutionException {
        final AbstractMojo abstractMojo = new ChuckNorrisMojo();
        abstractMojo.execute();
    }

}
