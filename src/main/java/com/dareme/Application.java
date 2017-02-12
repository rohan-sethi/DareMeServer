package com.dareme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

@SpringBootApplication
@ComponentScan({"com.dareme"})
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
//        String[] beanDefinitionNames = configurableApplicationContext.getBeanDefinitionNames();
//        System.out.println("Bean definition names: ");
//        for (String s: beanDefinitionNames){
//            System.out.println(s);
//        }

        new Application().initialize(6060);
    }
    public void initialize(int port){

        try {
            ServerSocket sc = new ServerSocket(port);
            //Show Server GUI

            //Listen to server port and accept clients connections
            while(true){
                Socket client = sc.accept();
                System.out.println("New client Connected to the server");
                //Per each client create a ClientHandler
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.UK);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("i18n/messages");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
}
