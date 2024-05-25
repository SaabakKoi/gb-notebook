package notebook;

import notebook.view.UserView;
import static notebook.util.DBConnector.createDB;

public class Main {
    public static void main(String[] args) {
        createDB();
        UserView view = new UserView();
        view.run();

    }
}
