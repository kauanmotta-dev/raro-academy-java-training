package features;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Minotaur implements Runnable {

    char[][] mazePath;
    List<int[]> localSpawn = new ArrayList<>();
    Random random = new Random();
    int posY = 0;
    int posX = 0;
    int runnerSteps = 0;
    int lastSpawnStep = 0;
    int stepToSpawn = 0;
    volatile boolean active = true;

    @Override
    public void run() {
        while (active) {
            if ((runnerSteps - lastSpawnStep) == stepToSpawn && runnerSteps != 0) {
                spawn();
                System.out.println("Minotaur spawned at: [" + posY + "," + posX + "]");
                lastSpawnStep = runnerSteps;
            }
            try{
                Thread.sleep(50);
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public void spawn() {
        //Verifica locais para spawn
        localSpawn.clear();
        for (int y = 0; y < mazePath.length; y++) {
            for (int x = 0; x < mazePath[0].length; x++) {
                if (mazePath[y][x] == ' ') {
                    localSpawn.add(new int[]{y, x});
                }
            }
        }
        //Apaga o ultimo spawn
        if (mazePath[posY][posX] == 'M') {
            mazePath[posY][posX] = ' ';
        }
        //Adiciona o novo spawn
        int[] local = localSpawn.get(random.nextInt(localSpawn.size()));
        posY = local[0];
        posX = local[1];
        mazePath[posY][posX] = 'M';
    }

    public void incrementSteps() {
        runnerSteps++;
    }

    public void setStepsToSpawn(int setStepToSpawn) {
        stepToSpawn = setStepToSpawn;
    }

    public boolean stop() {
        return active = false;
    }

    public void addMazePath(char[][] Path) {
        mazePath = Path;
    }

    public char[][] getMazePath() {
        return mazePath;
    }
}