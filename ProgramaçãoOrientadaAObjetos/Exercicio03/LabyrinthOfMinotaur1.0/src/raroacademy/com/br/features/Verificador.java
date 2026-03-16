package raroacademy.com.br.features;

public abstract class Verificador {


    protected char[][] caminho;
    protected int x = 1;
    protected int y = 1;
    protected Boolean victory = false;
    protected int contadorDePassos = 0;

    public void run(Maze maze) {
        this.caminho = maze.getMaze();
        while (victory == false) {
            if (verificarCaminho() == false) {
                backtrack();
            }
        }
        if (victory) {
            System.out.println("Vitória! O personagem escapou com sucesso!\n" +
                    "Foi necessário: " + contadorDePassos + " passos\n");
        }
    }

    public boolean verificarCaminho() {

        if (caminho[y][x] == 'S') {
            victory = true;
            return true;
        }

       if (caminho[y][x + 1] == ' ' || caminho[y][x + 1] == 'S') {
            markTrail();
            x++;
            contadorDePassos++;
            return true;
       }
        if (caminho[y + 1][x] == ' ' || caminho[y + 1][x] == 'S') {
            markTrail();
            y++;
            contadorDePassos++;
            return true;
        }
        if (caminho[y][x - 1] == ' ' || caminho[y][x - 1] == 'S') {
            markTrail();
            x--;
            contadorDePassos++;
            return true;
        }
        if (caminho[y - 1][x] == ' ' || caminho[y - 1][x] == 'S') {
            markTrail();
            y--;
            contadorDePassos++;
            return true;
        }
        return false;
    }

    public boolean backtrack() {

        caminho[y][x] = '.';

        if (caminho[y][x - 1] == '.') {
            markTrailWrong();
            x--;
            contadorDePassos++;
            return true;
        }
        if (caminho[y - 1][x] == '.') {
            markTrailWrong();
            y--;
            contadorDePassos++;
            return true;
        }
        if (caminho[y][x + 1] == '.') {
            markTrailWrong();
            x++;
            contadorDePassos++;
            return true;

        }
        if (caminho[y + 1][x] == '.') {
            markTrailWrong();
            y++;
            contadorDePassos++;
            return true;
        }
        return false;
    }


    void markTrail(){
        if (caminho[y][x] != 'E' && caminho[y][x] != 'S' && caminho[y][x] != '#') {
            caminho[y][x] = '.';
        }
    }
    public void markTrailWrong() {
        if (caminho[y][x] == '.') {
            caminho[y][x] = ':';

        }
    }
}