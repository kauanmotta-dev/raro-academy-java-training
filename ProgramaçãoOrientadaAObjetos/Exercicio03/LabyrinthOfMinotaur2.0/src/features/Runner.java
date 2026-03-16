package features;

public class Runner implements Runnable{

    char[][] path;
    Boolean victory = false;
    Boolean gameOver = false;
    Maze maze;

    public Runner(Maze maze){
        this.maze = maze;
    }
@Override
    public void run() {
        addStepsToSpawn();
        path = maze.getMaze();
        if(toWalk(1,1)){
            System.out.println();
            System.out.println("||End of the minotaur's labyrinth||");
            if (victory){
                System.out.println("Victory! The runner passed the maze!");
            } else if (gameOver){
                System.out.println("Game Over! The runner was captured by the minotaur!");
            }
        } else{
            System.out.println();
            System.out.println("The runner can't find a way");
        }
        maze.stop();
    }

    boolean toWalk(int y, int x) {

        //Verifica Vitória/Derrota, marcando o local
        if (path[y][x] == ('S')) {
            victory = true;
            return true;
        }
        if (path[y][x] == ('M')) {
            gameOver = true;
            return true;
        }
        if (path[y][x] == ' ') {
            path[y][x] = '.';
            addMazePathToMinotaur();
            maze.setMazeMinotaur();
        }

        //Procura lado para andar
        if (path[y][x + 1] != '#' && path[y][x + 1] != '.' && path[y][x + 1] != ':'){
            incrementSteps();
            if(toWalk(y, x + 1))return true;
            }
        if(path[y + 1][x] != '#' && path[y + 1][x] != '.' && path[y + 1][x] != ':'){
            incrementSteps();
            if(toWalk(y + 1, x))return true;
            }
        if (path[y][x - 1] != '#' && path[y][x - 1] != '.' && path[y][x - 1] != ':'){
            incrementSteps();
            if(toWalk(y, x - 1))return true;
            }
        if (path[y - 1][x] != '#' && path[y - 1][x] != '.' && path[y - 1][x] != ':'){
            incrementSteps();
            if(toWalk(y - 1, x))return true;
            }

        //Backtrack
        path[y][x] = ':';
        if (path[y - 1][x] == '.') {if(toWalk(y - 1, x)) return true; incrementSteps();}
        if (path[y][x - 1] == '.') {if(toWalk(y, x - 1)) return true; incrementSteps();}
        if (path[y + 1][x] == '.') {if(toWalk(y + 1, x)) return true; incrementSteps();}
        if (path[y][x + 1] == '.') {if(toWalk(y, x + 1)) return true; incrementSteps();}
        return false;
    }

    public void incrementSteps(){
        maze.incrementSteps();
        try{
            Thread.sleep(100);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public char[][] getPath() {
        return path;
    }

    public void addStepsToSpawn(){
        maze.setStepsToSpawn();
    }

    public void addMazePathToMinotaur(){
        maze.addMazePathToMinotaur(path);
    }
}