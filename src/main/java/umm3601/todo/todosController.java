package umm3601.todo;

import com.google.gson.Gson;
import umm3601.todo.Todo;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Arrays;

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

    // Get a single todo
    public static Todo getTodo(String id) {
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }
}

