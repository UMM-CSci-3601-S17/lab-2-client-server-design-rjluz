package umm3601.user;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Created by holma198 on 1/29/17.
 */
public class todosController {
    private User[] todos;

    public todosController() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("src/main/data/todos.json");
        todos = gson.fromJson(reader, User[].class);
    }
    // List users
    /*
    public User[] listToDos(Map<String, String[]> queryParams) {
        User[] filteredUsers = todos;

        // Filter age if defined
        if(queryParams.containsKey("age")) {
            int age = Integer.parseInt(queryParams.get("age")[0]);
            filteredUsers = filterUsersByAge(filteredUsers, age);
        }

        return filteredUsers;
    }
    */
}

