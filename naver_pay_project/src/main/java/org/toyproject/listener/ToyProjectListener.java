package org.toyproject.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Log4j2
public class ToyProjectListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce){
        log.info("-----------init--------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        log.info("-----------Destroyed----------");
    }
}

