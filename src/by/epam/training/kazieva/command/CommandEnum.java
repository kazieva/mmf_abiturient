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

    },
    RESULT{
        {
            this.command= new ResultComand();
        }
    },
    ADD_ABITURIENT{
        {
            this.command= new AddAbiturientCommand();
        }
    },
    DELETE_ABITURIENT{
        {
            this.command=new DeleteAbiturientCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
