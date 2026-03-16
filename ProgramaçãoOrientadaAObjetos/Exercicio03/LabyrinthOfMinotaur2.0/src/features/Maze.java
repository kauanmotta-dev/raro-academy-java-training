package features;

public class Maze {

    char[][] mazeMinotaur;
    char[][] maze;
    int stepsToSpawn;
    int stepsRunner;
    Minotaur minotaur;

    public Maze(Minotaur minotaur){
        this.minotaur = minotaur;
    }

    public void generateMaze(int stepsToSpawn, String mazeString) {
        this.stepsToSpawn = stepsToSpawn;
        String[] mazeStringVetor = mazeString.split("\n");

        int line = mazeStringVetor.length;
        int column = mazeStringVetor[0].length();
        maze = new char[line][column];

        for(int y = 0; y < line; y++){
            for(int x = 0; x < column; x++){
                maze[y][x] = mazeStringVetor[y].charAt(x);
            }
        }
    }

    public void printMaze(char[][] mazePath){
        System.out.println();
        for(char[] column : maze){
            for(char line: column){
                System.out.print(line);
            }
            System.out.print("\n");
        }
    }


    public char[][] getMaze(){
        return maze;
    }

    public void setStepsToSpawn(){
        minotaur.setStepsToSpawn(stepsToSpawn);
    }

    public void incrementSteps(){
        stepsRunner++;
        minotaur.incrementSteps();
    }

    public void stop() {
        minotaur.stop();
    }

    public void addMazePathToMinotaur(char[][] path){
        minotaur.addMazePath(path);
    }

    public void setMazeMinotaur(){
       mazeMinotaur = minotaur.getMazePath();
    }
}