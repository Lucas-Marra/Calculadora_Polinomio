package br.com.polinomio;

public class Polinomio {
    // Atributos
    private final Integer grau;
    private double[] termos;

    // Construtor
    public Polinomio(int grau) {
        this.grau = grau;
        this.termos = new double[this.grau + 1];
    }

    // Métodos
    // Preenche termos do polinômio
    public void preencheTermos(double n, int i) {
        this.termos[i] = n;
    }

    // Resolve polinômio através de um valor x
    public String resultPoli(double x) {
        double[] temp = new double[this.grau + 1];
        double result = 0;

        // Realiza cada operação individual substituindo o x
        for (int i = 0; i <= this.grau; ++i) {
            temp[i] = this.termos[i] * (Math.pow(x, i));
        }

        // Soma toda a expressão resultante
        for (int i = 0; i <= this.grau; i++) {
            result = result + temp[i];
        }

        return "P(" + x + ") = " + result;
    }

    // Realiza soma de polinômios
    public Polinomio soma(Polinomio poli) {
        int aux = Math.max(this.grau, poli.grau);
        Polinomio result = new Polinomio(aux);

        // Soma verificando se um polinômio é de grau maior que o outro
        for (int i = 0; i <= aux; i++) {
            if (i > this.grau)
                result.termos[i] = poli.termos[i] + 0;
            else if (i > poli.grau)
                result.termos[i] = this.termos[i] + 0;
            else
                result.termos[i] = this.termos[i] + poli.termos[i];
        }

        return result;
    }

    // Realiza multiplicação de polinômios
    public Polinomio multiplicacao(Polinomio poli) {
        int aux = this.grau + poli.grau;
        Polinomio result = new Polinomio(aux);
        System.out.println(result.termos[1]);

        // Multiplicação dos polinômios
        for (int i = 0; i <= poli.grau; i++) {
            for (int j = 0; j <= this.grau; j++) {
                result.termos[i + j] = result.termos[i + j] + (poli.termos[i] * this.termos[j]);
            }
        }

        return result;
    }

    // Imprime polinômios
    public void mostra() {
        System.out.print("\nP(x) = ");
        for (int i = this.grau; i >= 0; --i) {
            if (this.grau.equals(i)) {
                System.out.print(this.termos[i] + "x^" + i);
            } else if (i > 0) {
                System.out.print(this.termos[i] >= 0 ?
                        " + " + this.termos[i] + "x^" + i :
                        " - " + this.termos[i] * -1 + "x^" + i);
            } else {
                System.out.print(this.termos[i] >= 0 ?
                        " + " + this.termos[i] + "\n\n" :
                        " - " + this.termos[i] * -1 + "\n\n");
            }
        }
    }
}