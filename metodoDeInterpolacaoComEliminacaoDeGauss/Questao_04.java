package metodoDeInterpolacaoComEliminacaoDeGauss;

public class Questao_04 {
	public static void main(String[] args) {

		// Numero de Pontos Distintos
		int n = 3;

		// Criando matrizes para substituição
		double[] X = new double[n];

		// Matriz criada a partir dos pontos tabelados
		// a0 + a1x + a2x^2
		double[][] a = { { 1.0, 0.0, 0.0, 0.0 }, { 1.0, 0.524, 0.274576, 0.328 }, { 1.0, 0.785, 0.616225, 0.560 } };

		// Utilizando elimiação de Gauss para encontrar o polinomio interpolador
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double ratio = a[j][i] / a[i][i];
				for (int K = 0; K < n + 1; K++) {
					a[j][K] = a[j][K] - ratio * a[i][K];
				}

			}

		}

		X[n - 1] = a[n - 1][n] / a[n - 1][n - 1];

		for (int i = n - 1; i >= 1; i--) {
			X[i] = a[i][n];
			for (int j = i + 1; j < n; j++) {
				X[i] = X[i] - a[i][j] * X[j];
			}
			X[i] = X[i] / a[i][i];
		}

		// Mostrando o Polinomio Interpolador encontrado
		System.out.print("\nPolinomio interpolador:\t");
		System.out.printf("(%.3f) + (%.3f)*x + (%.3f)*x^2", X[0], X[1], X[2]);

		System.out.println("\n\nValor aproximado de f(0.73) a partir do polinomio encontrado:\t");

		System.out.printf("(%.3f) + (%.3f)*0.73 + (%.3f)*0.73^2 = %.3f", X[0], X[1], X[2], f(0.73, X));
	}

	// Determinando o valor de f(0,73).
	public static double f(double x, double[] X) {
		return X[0] + X[1] * x + X[2] * Math.pow(x, 2);
	}

}
