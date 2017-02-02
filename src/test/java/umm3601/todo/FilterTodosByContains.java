package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by RJ Holman on 2/2/2017.
 */
public class FilterTodosByContains {
    @Test
    public void countContainingTodos() throws IOException {
        todosController tdController = new todosController();
        Todo[] allTodos = tdController.listTodos(new HashMap<>());
        Todo[] todoCon_tempor = tdController.bodyContainsTodos(allTodos, "tempor");
        assertEquals("Incorrect number of todos", 68, todoCon_tempor.length);
        Todo[] todoCon_anim = tdController.bodyContainsTodos(allTodos, "anim");
        assertEquals("Incorrect number of todos", 85, todoCon_anim.length);
    }
    @Test
    public void firstOwnerContainingTodos() throws IOException {
        todosController tdController = new todosController();
        Todo[] allTodos = tdController.listTodos(new HashMap<>());
        Todo[] todoCon_est = tdController.bodyContainsTodos(allTodos, "est");
        Todo firstTodo_est = todoCon_est[0];
        assertEquals("Incorrect Todo", "Fry", firstTodo_est.owner);

    }
}
