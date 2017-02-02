package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by RJ Holman on 2/2/2017.
 */
public class FilterTodosByStatus {
    @Test
    public void countCompleteTodos() throws IOException {
        todosController tdController = new todosController();
        Todo[] allTodos = tdController.listTodos(new HashMap<>());
        Todo[] todoComplete = tdController.completeTodos(allTodos, "complete");
        assertEquals("Incorrect number of todos", 143, todoComplete.length);
        Todo[] todoIncomplete = tdController.completeTodos(allTodos, "incomplete");
        assertEquals("Incorrect number of todos", 157, todoIncomplete.length);
    }
}
