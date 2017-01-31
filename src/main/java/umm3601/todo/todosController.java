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
        Todo[] filterTodos = todos;
        // Filter number of results if defined

        if(queryParams.containsKey("limit")) {
            int Todolimit = Integer.parseInt(queryParams.get("limit")[0]);
            filterTodos = limitNumTodo(filterTodos, Todolimit);
        }

        return filterTodos;
    }

    // limit the number of results (put at end of listTodos function).
    public static Todo[] limitNumTodo(Todo[] filterTodos, int Tlimit) {
        Todo[] showlist = new Todo[]{null};
        int tracker = 0;
        int whatsLeft = Tlimit;
        if (filterTodos.length > Tlimit) {
            while (whatsLeft > 0) {
                showlist[tracker] = filterTodos[tracker];
                tracker++;
                whatsLeft--;
            }
            return showlist;
        }
            else {return filterTodos; }
    }

    // Get a single todo with id
    public static Todo getTodo(String id) {
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }
}

