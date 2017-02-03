package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by RJ Holman on 2/2/2017.
 */
public class FilterTodosByCategory {
    @Test
    public void countCategoryTodos() throws IOException {
        todosController tdController = new todosController();
        Todo[] allTodos = tdController.listTodos(new HashMap<>());
        Todo[] todo_homework = tdController.categoryTodos(allTodos, "homework");
        assertEquals("Incorrect number of todos", 79, todo_homework.length);
        Todo[] todo_software = tdController.categoryTodos(allTodos, "software design");
        assertEquals("Incorrect number of todos", 74, todo_software.length);
    }

    @Test
    public void firstCategoryTodos() throws IOException {
        todosController tdController = new todosController();
        Todo[] allTodos = tdController.listTodos(new HashMap<>());
        Todo[] todo_groceries = tdController.categoryTodos(allTodos, "groceries");
        Todo firstTodo_groceries = todo_groceries[0];
        assertTrue(firstTodo_groceries.category.equals("groceries"));
    }
}
