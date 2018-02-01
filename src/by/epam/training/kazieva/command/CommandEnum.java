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
    GO_TO_REGISTRATION {
        {
            this.command = new GoToRegistrsionCommand();
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
    },
    EDIT_ABITURIENT{
        {
            this.command = new EditAbiturientCommand();
        }
    },
    UPDATE_ABITURIENT{
        {
            this.command = new UpdateAbiturientCommand();
        }
    },
    RESULT_SPECIALITY{
        {
            this.command= new ResultSpecialityComand();
        }
    },
    ADD_SPECIALITY{
        {
            this.command= new AddSpecialityCommand();
        }
    },
    DELETE_SPECIALITY{
        {
            this.command=new DeleteSpecialityCommand();
        }
    },
    ALL_USERS{
        {
            this.command=new AllUsersCommand();
        }
    },
    UPDATE_USER_ROLE{
        {
            this.command = new UpdateUserRoleCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
