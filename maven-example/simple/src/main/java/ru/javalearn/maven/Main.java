package ru.javalearn.maven;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by OOGIS RG.
 * Yury Glamazdo <glamazdo@oogis.ru>
 * 17.05.16
 */
public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.debug("I'm alive!");
        LOG.error("Something wrong");
    }
}
