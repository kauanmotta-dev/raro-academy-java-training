package Test;

import raroacademy.com.br.features.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeTest {


    @Test
    public void shouldCreateMaze() {

        Maze maze = new Maze();
        maze.generateMaze(5,"##########\n" +
                                             "#E #     #\n" +
                                             "#  # ### #\n" +
                                             "## # # S #\n" +
                                             "#     #  #\n" +
                                             "##########");

        char[][] actual = maze.getMaze();
        char[][] expected = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', 'E', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#'},
                {'#', '#', ' ', '#', ' ', '#', ' ', 'S', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRunnerRun(){

        Maze maze = new Maze();
        maze.generateMaze(5,"##########\n" +
                                             "#E #     #\n" +
                                             "#  # ### #\n" +
                                             "## # # S #\n" +
                                             "#     #  #\n" +
                                             "##########");

        Runner runner = new Runner();
        runner.run(maze);
        assertTrue(runner.printCaminho());
    }

    @Test
    public void shouldMinotaurSpawn() throws InterruptedException {
        Maze maze = new Maze();
        maze.generateMaze(2,"######\n" +
                                                   "#E   S\n" +
                                                   "######");

        Runner runner = new Runner();
        Minotaur minotaur = new Minotaur(runner, maze.getMinotaurSpawn(), maze.getMaze());
        runner.setMinotaur(minotaur);

        Thread minotaurThread = new Thread(minotaur);
        minotaurThread.start();

        Thread runnerThread = new Thread(() -> runner.run(maze));
        runnerThread.start();

        // Espera um pouco para o jogo rodar
        Thread.sleep(2000);

        // Para as threads
        minotaur.stop();
        runnerThread.interrupt();

        assertTrue(runner.isGameOver() || runner.hasVictory());
    }





    //-----------------------------------------------------------------------------------
    // TESTE DE MAPAS
    //-----------------------------------------------------------------------------------

    @Test
    public void shouldMapOne(){

        Maze maze = new Maze();
        maze.generateMaze(5,"#####\n" +
                                             "#E  #\n" +
                                             "# # #\n" +
                                             "#  S#\n" +
                                             "#####"
        );

        Runner runner = new Runner();
        runner.run(maze);
        assertTrue(runner.printCaminho());
    }

    @Test
    public void shouldMapTwo(){

        Maze maze = new Maze();
        maze.generateMaze(5,"#######\n" +
                                             "#E #  #\n" +
                                             "#  ## #\n" +
                                             "##    #\n" +
                                             "# ## ##\n" +
                                             "#S    #\n" +
                                             "#######"

        );

        Runner runner = new Runner();
        runner.run(maze);
        assertTrue(runner.printCaminho());
    }

    @Test
    public void shouldMapTree(){

        Maze maze = new Maze();
        maze.generateMaze(5,"##########\n" +
                                             "#E#      #\n" +
                                             "# # #### #\n" +
                                             "# # #  # #\n" +
                                             "#   ## # #\n" +
                                             "###    # #\n" +
                                             "#   ###  #\n" +
                                             "# #   ####\n" +
                                             "#   #   S#\n" +
                                             "##########\n"

        );

        Runner runner = new Runner();
        runner.run(maze);
        assertTrue(runner.printCaminho());
    }

    @Test
    public void shouldMapFour(){

        Maze maze = new Maze();
        maze.generateMaze(5,"############\n" +
                                             "#E#        #\n" +
                                             "# # #### # #\n" +
                                             "# #    # # #\n" +
                                             "# ### ## # #\n" +
                                             "#   #    # #\n" +
                                             "# # ###### #\n" +
                                             "# #      # #\n" +
                                             "# ### ##   #\n" +
                                             "#     #### #\n" +
                                             "#   #    S #\n" +
                                             "############\n"

        );

        Runner runner = new Runner();
        runner.run(maze);
        assertTrue(runner.printCaminho());
    }


    //Caminho sem passagem possível, foi necessário abrir a parede
    @Test
    public void shouldMapFive(){

        Maze maze = new Maze();
        maze.generateMaze(5,"####################\n" +
                                             "#E     #      #    #\n" +
                                             "# #### # #### # ## #\n" +
                                             "# #    #    #   #  #\n" +
                                             "# # ###### # # # ###\n" +
                                             "# #      # # #     #\n" +
                                             "# ###### # # ##### #\n" +
                                             "#        # #   #   #\n" +
                                             "######## # ### # # #\n" +
                                             "#      #       #S  #\n" +
                                             "####################\n"

        );

        Runner runner = new Runner();
        runner.run(maze);
        assertTrue(runner.printCaminho());
    }

    @Test
    public void shouldMapSix(){

        Maze maze = new Maze();
        maze.generateMaze(5,"#########################\n" +
                                             "#E      #     #         #\n" +
                                             "### ### ### # # ####### #\n" +
                                             "#     #     # #       # #\n" +
                                             "# ##### ##### ####### # #\n" +
                                             "#     #       #     # # #\n" +
                                             "##### # ####### ### # # #\n" +
                                             "#     #         #   #   #\n" +
                                             "# ########### # ####### #\n" +
                                             "#             #       # #\n" +
                                             "############### ##### # #\n" +
                                             "#                   # S #\n" +
                                             "#########################\n"

        );

        Runner runner = new Runner();
        runner.run(maze);
        assertTrue(runner.printCaminho());
    }
}