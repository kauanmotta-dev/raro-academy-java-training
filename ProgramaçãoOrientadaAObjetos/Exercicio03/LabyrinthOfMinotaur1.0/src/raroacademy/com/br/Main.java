package raroacademy.com.br;

import raroacademy.com.br.features.*;

public class Main {
    public static void main(String[] args) {
        String mazeStr =
                "##########\n" +
                        "#E       #\n" +
                        "#   ###  #\n" +
                        "#   #S#  #\n" +
                        "##########";

        // Cria e configura o labirinto
        Maze maze = new Maze();
        maze.generateMaze(5, mazeStr); // 5 passos para spawnar o Minotauro

        // Instancia o Runner e o Minotauro
        Runner runner = new Runner();
        Minotaur minotaur = new Minotaur(runner, maze.getMinotaurSpawn(), maze.getMaze());
        runner.setMinotaur(minotaur);

        // Cria a Thread para o Minotauro e inicia
        Thread minotaurThread = new Thread(minotaur);
        minotaurThread.start();

        // Executa o Runner
        runner.run(maze);
        runner.printCaminho();
    }
}
