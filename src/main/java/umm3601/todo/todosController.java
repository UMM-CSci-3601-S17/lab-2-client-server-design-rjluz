package umm3601.todo;

import com.google.gson.Gson;
import umm3601.todo.Todo;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Created by holma198 on 1/29/17.
 */
public class todosController {
    private static Todo[] todos;

    public todosController() throws IOException {
        Gson gson = new Gson();
        FileReader readerT = new FileReader("src/main/data/todos.json");
        todos = gson.fromJson(readerT, Todo[].class);
    }
    // List todos
    public static Todo[] listTodos(Map<String, String[]> queryParams) {
        return todos;
    }
}

