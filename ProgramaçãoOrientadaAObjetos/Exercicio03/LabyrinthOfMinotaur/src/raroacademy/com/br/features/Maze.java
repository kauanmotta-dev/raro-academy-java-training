package raroacademy.com.br.features;

public class Maze {

    private char[][] maze;
    private int minotaurSpawn;

    public void generateMaze(int minotaurSpawn, String mazeString) {
        this.minotaurSpawn = minotaurSpawn;
        String[] quebraLinhas = mazeString.split("\n");

        this.maze = new char[quebraLinhas.length][];
        for (int i = 0; i < quebraLinhas.length; i++) {
            maze[i] = quebraLinhas[i].toCharArray();
        }
    }

    public char[][] getMaze() {
        return maze;
    }
    public int getMinotaurSpawn() {return minotaurSpawn; }
}
