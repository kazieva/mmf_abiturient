package by.epam.training.kazieva.command.factory;

import by.epam.training.kazieva.command.ActionCommand;
import by.epam.training.kazieva.command.CommandEnum;
import by.epam.training.kazieva.command.EmptyCommand;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    private static final Logger logger = Logger.getLogger(ActionFactory.class);

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        logger.info(action);
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + ": command not found or wrong! ");
        }
        return current;
    }
}