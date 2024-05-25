package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.model.repository.GBRepository;
import notebook.model.repository.impl.UserRepository;
import notebook.util.Commands;

import java.util.Scanner;

import static notebook.util.DBConnector.DB_PATH;

public class UserView {
    private final UserController userController;

    public UserView() {
        GBRepository repository = new UserRepository(DB_PATH);
        this.userController = new UserController(repository);
    }

    public void run(){
        Commands com;

        while (true) {
            String command = userController.prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    User u = userController.createUser();
                    userController.saveUser(u);
                    break;
                case READ:
                    String id = userController.prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case DELETE:
                    String idUser = userController.prompt("Enter user id: ");
                    userController.removeUser(idUser, userController.removeUser());
                    break;
                case LIST:
                    System.out.println(userController.readAll());
                    break;
                case UPDATE:
                    String userId = userController.prompt("Enter user id: ");
                    userController.updateUser(userId, userController.createUser());
            }
        }
    }
}
