package by.epam.training.kazieva.command;

public enum CommandEnum {
    LOCALE {
        {
            this.command = new LocaleCommand();
        }
    },
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
    GO_TO_EMPTY_PAGE {
        {
            this.command = new GoToEmptyPageCommand();
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
    RESULT {
        {
            this.command = new ResultComand();
        }
    },
    ADD_ABITURIENT {
        {
            this.command = new AddAbiturientCommand();
        }
    },
    DELETE_ABITURIENT {
        {
            this.command = new DeleteAbiturientCommand();
        }
    },
    EDIT_ABITURIENT {
        {
            this.command = new EditAbiturientCommand();
        }
    },
    UPDATE_ABITURIENT {
        {
            this.command = new UpdateAbiturientCommand();
        }
    },
    RESULT_SPECIALITY {
        {
            this.command = new ResultSpecialityComand();
        }
    },
    GO_TO_NEW_SPECIALITY {
        {
            this.command = new GoToNewSpecialityCommand();
        }
    },
    ADD_SPECIALITY {
        {
            this.command = new AddSpecialityCommand();
        }
    },
    DELETE_SPECIALITY {
        {
            this.command = new DeleteSpecialityCommand();
        }
    },
    ALL_USERS {
        {
            this.command = new AllUsersCommand();
        }
    },
    UPDATE_USER_ROLE {
        {
            this.command = new UpdateUserRoleCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
