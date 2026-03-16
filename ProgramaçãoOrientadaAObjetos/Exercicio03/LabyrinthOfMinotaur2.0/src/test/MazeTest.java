package test;

import features.*;
import org.junit.Test;

public class MazeTest {

    @Test
    public void shouldGenerateMaze(){

        Minotaur minotaur = new Minotaur();
        Maze maze = new Maze(minotaur);
        maze.generateMaze(5,"######\n" +
                                                  "#E  S#\n" +
                                                  "######");
        maze.printMaze(maze.getMaze());
    }

    @Test
    public void shouldPath() throws InterruptedException {

        Minotaur minotaur = new Minotaur();
        Maze maze = new Maze(minotaur);
        maze.generateMaze(5,"######\n" +
                                                  "#E  S#\n" +
                                                  "######");
        Runner runner = new Runner(maze);
        Thread thread = new Thread(runner);
        thread.start();
        thread.join();
        maze.printMaze(runner.getPath());
    }

    @Test
    public void shouldTestBackTrack() throws InterruptedException {

        Minotaur minotaur = new Minotaur();
        Maze maze = new Maze(minotaur);
        maze.generateMaze(5,"########\n" +
                                                  "#E #####\n" +
                                                  "#   #S##\n" +
                                                  "# ###  #\n" +
                                                  "#     ##\n" +
                                                  "########");

        Runner runner = new Runner(maze);
        Thread thread = new Thread(runner);
        thread.start();
        thread.join();
        maze.printMaze(runner.getPath());
    }

    @Test
    public void shouldTestMinotaur() throws InterruptedException {

        Minotaur minotaur = new Minotaur();
        Maze maze = new Maze(minotaur);
        maze.generateMaze(2,"#######\n" +
                                                   "#E   S#\n" +
                                                   "#######");
        Runner runner = new Runner(maze);

        Thread threadRunner = new Thread(runner);
        Thread threadMinotaur = new Thread(minotaur);

        maze.setMazeMinotaur();
        threadMinotaur.start();
        Thread.sleep(50);
        threadRunner.start();
        threadRunner.join();
        threadMinotaur.join();
        maze.printMaze(runner.getPath());
    }

    @Test
    public void shouldTestLabirinthOfMinotaurs() throws InterruptedException {

        Minotaur minotaur = new Minotaur();
        Maze maze = new Maze(minotaur);
        maze.generateMaze(7,"#########################\n" +
                                                   "#E    #     #       #   #\n" +
                                                   "### # # ### # ##### # # #\n" +
                                                   "#   #   #   #     # # # #\n" +
                                                   "# ##### # ####### # # # #\n" +
                                                   "#     # #       # # # # #\n" +
                                                   "##### # ####### # # # # #\n" +
                                                   "#   # #     #   #   #   #\n" +
                                                   "# # # ##### # ######### #\n" +
                                                   "# #     #   #         # #\n" +
                                                   "# ##### # ########### # #\n" +
                                                   "#     #             #   #\n" +
                                                   "#######################S#");
        Runner runner = new Runner(maze);

        Thread threadRunner = new Thread(runner);
        Thread threadMinotaur = new Thread(minotaur);

        maze.setMazeMinotaur();
        threadMinotaur.start();
        Thread.sleep(50);
        threadRunner.start();
        threadRunner.join();
        threadMinotaur.join();
        maze.printMaze(runner.getPath());
    }
}