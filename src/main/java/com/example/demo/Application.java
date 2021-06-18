package com.example.demo;

import com.example.services.HelloMessageService;

import java.text.MessageFormat;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "com.example.services"})
public class Application implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private HelloMessageService helloService;

    @Autowired
    private Environment environment;

    @Autowired
    PersonalProperties personalProperties;

    @Autowired
    TestYaml testYaml;

    @Autowired
    TypeComplexYaml typeComplexYaml;

    @Value("${cognome}")
    private String cognome;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.setLogStartupInfo(false);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Start application...");
        if (args.length > 0) {
            LOGGER.warn("Get start with argument.");
            System.out.println(helloService.getMessage(args[0].toString()));
        } else {
            LOGGER.warn("Default value");
            System.out.println(helloService.getMessage());
        }
        String message = MessageFormat.format(environment.getProperty("title"), "GRUPPO1");
        System.out.println("message=" + message);
        String message2 = MessageFormat.format("TEST {0} TEST {1}", "UNO", "DUE");
        System.out.println("message2=" + message2);


        System.out.println("nome=" + personalProperties.getNome());
        System.out.println("cognome=" + cognome);
        System.out.println("cognome=" + personalProperties.getCognome());

        System.out.println("db username=" + personalProperties.getDbusername());
        System.out.println("db password=" + personalProperties.getDbpassward());

        System.out.println("test.property1.value1=" + testYaml.getValue1());
        System.out.println("test.property1.value2=" + testYaml.getValue2());
        System.out.println("test.property2=" + testYaml.getProperty2());
        System.out.println("test2=" + testYaml.getTest2());

        System.out.println("ignore=" + String.join(",", testYaml.getIgnore()));

        final MutablePropertySources sources = ((AbstractEnvironment) environment).getPropertySources();

        for (Iterator it = sources.iterator(); it.hasNext(); ) {
            PropertySource propertySource = (PropertySource) it.next();
            System.out.println("Source [" + propertySource.getName() + "] >>> " + propertySource.getSource());
        }

        for (String item : typeComplexYaml.getType()) {
            System.out.println("filenames.type: " + item);
        }

    }
}

