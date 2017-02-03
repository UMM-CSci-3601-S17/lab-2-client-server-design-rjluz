package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by RJ Holman on 2/2/2017.
 */
public class FilterTodosByOwner {
    @Test
    public void countOwnerTodos() throws IOException {
        todosController tdController = new todosController();
        Todo[] allTodos = tdController.listTodos(new HashMap<>());
        Todo[] todo_Blanche = tdController.ownerTodos(allTodos, "Blanche");
        assertEquals("Incorrect number of todos", 43, todo_Blanche.length);
        Todo[] todo_Fry = tdController.ownerTodos(allTodos, "Fry");
        assertEquals("Incorrect number of todos", 61, todo_Fry.length);
    }

    @Test
    public void firstOwnerTodos() throws IOException {
        todosController tdController = new todosController();
        Todo[] allTodos = tdController.listTodos(new HashMap<>());
        Todo[] todo_Barry = tdController.ownerTodos(allTodos, "Barry");
        Todo firstTodo_Barry = todo_Barry[0];
        assertTrue(firstTodo_Barry.owner.equals("Barry"));
        Todo[] todo_Dawn = tdController.ownerTodos(allTodos, "Dawn");
        Todo firstTodo_Dawn = todo_Dawn[0];
        assertTrue(firstTodo_Dawn.owner.equals("Dawn"));
    }
}
