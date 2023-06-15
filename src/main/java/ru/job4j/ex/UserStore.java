package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        boolean found = false;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return new User(login, true);
            }
        }
        if (!found) {
            throw new UserNotFoundException("User Not Found");
        }
        return null;
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

