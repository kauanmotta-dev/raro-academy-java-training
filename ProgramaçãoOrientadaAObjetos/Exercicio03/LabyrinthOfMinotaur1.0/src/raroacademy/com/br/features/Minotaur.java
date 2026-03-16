package raroacademy.com.br.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Minotaur implements Runnable {

    private final Runner runner;
    private final char[][] caminho;
    private final int spawnInterval;
    private final Random random = new Random();
    private volatile boolean running = true;

    public Minotaur(Runner runner, int spawnInterval, char[][] caminho) {
        this.runner = runner;
        this.spawnInterval = spawnInterval;
        this.caminho = caminho;
    }

    private boolean isValidSpawn(int x, int y) {
        if (y < 0 || y >= caminho.length || x < 0 || x >= caminho[0].length) {
            return false;
        }
        char c = caminho[y][x];
        return c == ' ';
    }

    private void spawnMinotaur() {
        List<int[]> freeSpaces = new ArrayList<>();
        for (int y = 0; y < caminho.length; y++) {
            for (int x = 0; x < caminho[0].length; x++) {
                if (isValidSpawn(x, y)) {
                    freeSpaces.add(new int[]{x, y}); // <-- este estava faltando
                }
            }
        }

        if (!freeSpaces.isEmpty()) {
            int[] pos = freeSpaces.get(random.nextInt(freeSpaces.size()));
            caminho[pos[1]][pos[0]] = 'M';
            System.out.println("Minotauro spawnou em [" + pos[1] + "][" + pos[0] + "]");
        }
    }


    @Override
    public void run() {
        int lastSpawnStep = 0;
        while (running && !runner.hasVictory()) {
            int passos = runner.getContadorDePassos();
            if (passos >= lastSpawnStep + spawnInterval) {
                spawnMinotaur();
                lastSpawnStep = passos;
            }
            try {
                Thread.sleep(200); // espera 200ms e verifica de novo
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    public void stop() {
        running = false;
    }
}