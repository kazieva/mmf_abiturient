package by.epam.training.kazieva.command;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }

    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
