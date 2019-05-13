package de.erik.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.*;

@Mojo(name = "chuck_norris", defaultPhase = LifecyclePhase.INSTALL)
public class ChuckNorrisMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException {
        try {
            getLog().info(Utils.readPicture());
            getLog().info("Chuck Norris fact of the build:");
            getLog().info("\t- " + Utils.pickRandomQuote());
        } catch (IOException e) {
            throw new MojoExecutionException(e.getLocalizedMessage());
        }
    }

}
