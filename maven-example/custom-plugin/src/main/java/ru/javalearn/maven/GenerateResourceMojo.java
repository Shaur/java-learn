package ru.javalearn.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Created by OOGIS RG.
 * Yury Glamazdo <glamazdo@oogis.ru>
 * 17.05.16
 */
@Mojo(name = "generate-resource", defaultPhase = LifecyclePhase.COMPILE)
public class GenerateResourceMojo extends AbstractMojo {

    @Parameter(defaultValue = "false")
    private boolean writeDebug;

    @Parameter
    private String[] debugStrings;

    public void execute() throws MojoExecutionException, MojoFailureException {
        if(writeDebug) {
            for (String string : debugStrings)
                getLog().warn(string);
        } else {
            getLog().warn("No debug info");
        }
    }

    public void setWriteDebug(boolean writeDebug) {
        this.writeDebug = writeDebug;
    }
}
