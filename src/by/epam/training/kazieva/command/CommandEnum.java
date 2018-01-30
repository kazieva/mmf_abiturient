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
    EDIT_SPECIALITY{
        {
            this.command = new EditAbiturientCommand();
        }
    },
    UPDATE_SPECIALITYSX{
        {
            this.command = new UpdateAbiturientCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
