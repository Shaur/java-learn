package ru.javalearn.maven;

import ru.javalearn.maven.service.ScheduledService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by OOGIS RG.
 * Yury Glamazdo <glamazdo@oogis.ru>
 * 18.05.16
 */
public class Starter {


    public static void main(String[] args) throws IOException, JAXBException {
        ScheduledService service = new ScheduledService();
        service.run();
    }
}
