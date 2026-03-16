package raroacademy.com.br.features;

public class Runner extends Verificador {

    private Minotaur minotaur;


    public void setMinotaur(Minotaur minotaur) {
        this.minotaur = minotaur;
    }

    private volatile boolean gameOver = false;

    public boolean isGameOver() {
        return gameOver;
    }

    public void run(Maze maze) {
        this.caminho = maze.getMaze();
        while (!victory) {
            if (caminho[y][x] == 'M') {
                System.out.println("GAME OVER! O Minotauro pegou você em [" + y + "][" + x + "]");
                gameOver = true;
                if (minotaur != null) minotaur.stop();
                return;
            }

            if (!verificarCaminho()) {
                backtrack();
            }

            if (caminho[y][x] == 'S') {
                victory = true;
                System.out.println("Vitória! O personagem escapou com sucesso!\n" +
                        "Foi necessário: " + contadorDePassos + " passos\n");
                if (minotaur != null) minotaur.stop();
            }
        }
    }















    public boolean printCaminho() {
        for (char[] linha : caminho) {
            for (char coluna : linha) {
                System.out.print(coluna);
            }
            System.out.println();
        }
        return true;
    }
    public int getContadorDePassos() {
        return contadorDePassos;
    }

    public boolean hasVictory() {
        return victory;
    }
}
