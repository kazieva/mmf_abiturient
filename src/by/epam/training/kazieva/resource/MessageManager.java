package by.epam.training.kazieva.resource;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {
    private final static Locale EN = new Locale("en", "EN");
    private final static Locale RU = new Locale("ru", "RU");
    private static final String resourcesMessage = "resources.message";

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(resourcesMessage, EN);

    private MessageManager() {
    }

    public static void setResourceBundle(String lang) {
        if ("EN".equals(lang)) {
            MessageManager.resourceBundle = ResourceBundle.getBundle(resourcesMessage, EN);
        }
        if ("RU".equals(lang)) {
            MessageManager.resourceBundle = ResourceBundle.getBundle(resourcesMessage, RU);
        }
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
