package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by RJ Holman on 2/2/2017.
 */
public class FilterTodoByLimit {
    @Test
    public void limitTodos() throws IOException {
        todosController tdController = new todosController();
        Todo[] allTodos = tdController.listTodos(new HashMap<>());
        Todo[] todoLim7 = tdController.limitNumTodo(allTodos, 7);
        assertEquals("Incorrect number of todos", 7, todoLim7.length);
        Todo[] todoLim100 = tdController.limitNumTodo(allTodos, 100);
        assertEquals("Incorrect number of todos", 100, todoLim100.length);
    }
}
