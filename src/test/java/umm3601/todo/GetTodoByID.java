package umm3601.todo;

/**
 * Created by RJ Holman on 2/2/2017.
 */
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class GetTodoByID {
    @Test
    public void getBlanche() throws IOException {
        todosController TDController = new todosController();
        Todo todo = TDController.getTodo("58895985a22c04e761776d54");
        assertEquals("Incorrect name", "Blanche", todo.owner);
    }

    @Test
    public void getFry() throws IOException {
        todosController TDController = new todosController();
        Todo todo = TDController.getTodo("58895985c1849992336c219b");
        assertEquals("Incorrect name", "Fry", todo.owner);
    }

    @Test
    public void getBarry() throws IOException {
        todosController TDController = new todosController();
        Todo todo = TDController.getTodo("58895985f0a4bbea24084abf");
        assertEquals("Incorrect name", "Barry", todo.owner);
    }

}
