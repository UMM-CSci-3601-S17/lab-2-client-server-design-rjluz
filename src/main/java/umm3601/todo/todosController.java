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
        // Filter body by user input string.
        if(queryParams.containsKey("contains")) {
            String usrIn = queryParams.get("contains")[0];
            filterTodos = bodyContainsTodos(filterTodos, usrIn);
        }

        // Filter age if defined
        if(queryParams.containsKey("status")) {
            String cont = queryParams.get("status")[0];
            filterTodos = completeTodos(filterTodos, cont);
        }

        // Filter number of results if defined
        if(queryParams.containsKey("limit")) {
            int Todolimit = Integer.parseInt(queryParams.get("limit")[0]);
            filterTodos = limitNumTodo(filterTodos, Todolimit);
        }

        return filterTodos;
    }

    // limit the number of results (put at end of listTodos function).
    public static Todo[] limitNumTodo(Todo[] filterTodos, int Tlimit) {
        Todo[] showlist = new Todo[Tlimit];
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

    // filter todos based on complete or incomplete status.
    public static Todo[] completeTodos(Todo[] filterTodos, String complete) {
        boolean comp = true;
        if(complete.equals("incomplete")) { comp = false;}
        boolean finalComp = comp;
        return Arrays.stream(filterTodos).filter(x -> x.status == finalComp).toArray(Todo[]::new);
    }

    // filter todos based on contents in body.
    public static Todo[] bodyContainsTodos(Todo[] filterTodos, String userInput) {
        return Arrays.stream(filterTodos).filter(x -> x.body.contains(userInput)).toArray(Todo[]::new);
    }

    // Get a single todo with id
    public static Todo getTodo(String id) {
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }
}

