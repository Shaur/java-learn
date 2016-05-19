package ru.javalearn.maven;


import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
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
        Expression e = new ExpressionBuilder("3 * exp(3) - 2 / (x - 2)")
                .variable("x").build().setVariable("x", 5);
        
        LOG.info(String.valueOf(e.evaluate()));
        LOG.debug("I'm alive!");
        LOG.error("Something wrong");
    }
}
