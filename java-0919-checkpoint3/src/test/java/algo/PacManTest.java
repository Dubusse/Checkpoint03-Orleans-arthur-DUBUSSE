package algo;

import junit.framework.TestCase;
import org.junit.Test;

public class PacManTest extends TestCase {

    @Test
    public void testTrue() throws Exception {
        assertEquals(true, true);
    }

    @Test
    public void testPlay1() throws Exception {
        char[][] grid = {
            {' '}
        };
        int level = 1;
        assertEquals(0, PacMan.play(grid, level));
    }

    @Test
    public void testPlay2() throws Exception {
        char[][] grid = {
            {'.'}
        };
        int level = 1;
        assertEquals(1, PacMan.play(grid, level));
    }

    @Test
    public void testPlay3() throws Exception {
        char[][] grid = {
            {'o'}
        };
        int level = 1;
        assertEquals(10, PacMan.play(grid, level));
    }

    @Test
    public void testPlay4() throws Exception {
        char[][] grid = {
            {'x'}
        };
        int level = 1;
        assertEquals(100, PacMan.play(grid, level));
    }

    @Test
    public void testPlay5() throws Exception {
        char[][] grid = {
            {'x', 'x'}
        };
        int level = 2;
        assertEquals(400, PacMan.play(grid, level));
    }

    @Test
    public void testPlay6() throws Exception {
        char[][] grid = {
            {'o', '.', '.'},
            {' ', 'x', ' '},
            {'.', '.', 'o'}
        };
        int level = 2;
        assertEquals(224, PacMan.play(grid, level));
    }
}