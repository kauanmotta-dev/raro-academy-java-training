import features.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Minotaur minotaur = new Minotaur();
        Maze maze = new Maze(minotaur);
        Runner runner = new Runner(maze);

        Thread threadMinotaur = new Thread(minotaur);
        Thread threadRunner = new Thread(runner);


        Scanner scanner = new Scanner(System.in);
        Maps maps = new Maps();

        //Switch the Maze by player
        System.out.print("Choose how many steps the Runner must take for the Minotaur to spawn: ");
        int answerSteps = scanner.nextInt();
        System.out.println();
        maps.printMazeList();
        int answerOption = scanner.nextInt();
        System.out.println();
        maps.getMaze(answerOption);

        //(int Quantidades de Passos para spawnar o Minotaur,
        //String labirinto desejado)
        maze.generateMaze(answerSteps, maps.getMaze(answerOption));

        maze.setMazeMinotaur();
        threadMinotaur.start();
        threadRunner.start();
        threadRunner.join();
        threadMinotaur.join();
        maze.printMaze(runner.getPath());
    }
}