package ru.job4j.ex;

public class UserStore {

    /**
     * Поиск пользователя в списке
     *
     * @throws UserNotFoundException
     */
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        boolean isExist = false;
        int idx = 0;
        for (idx = 0; idx < users.length; idx++) {
            if (users[idx].getUsername().equals(login)) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            throw new UserNotFoundException("User not found");
        }
        return users[idx];
    }

    /**
     * Проверка пользователя на валидность
     *
     * @throws UserInvalidException
     */
    public static boolean validate(User user) throws UserInvalidException {
        boolean isValid = user.isValid() && user.getUsername().length() > 3;
        if (!isValid) {
            throw new UserInvalidException("User isn't valid");
        }
        return isValid;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Arsentev Petr", false)
        };
        User user;
        try {
            user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
