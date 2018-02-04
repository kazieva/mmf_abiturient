package by.epam.training.kazieva.listener;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    private static final Logger logger = Logger.getLogger(SessionListener.class);
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info("session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info("session destroyed");
    }
}
