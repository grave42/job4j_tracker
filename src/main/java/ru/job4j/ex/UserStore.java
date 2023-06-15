package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        boolean userFound = false;
        int index = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                userFound = true;
                index = i;
                break;
            }
            if (!userFound) {
                throw new UserNotFoundException("User Not Found");

            }
        }
        return new User(users[index].getUsername(), true);
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("Invalid User");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException u) {
            u.printStackTrace();
    }
}
}
