package metodoDeInterpolacaoComEliminacaoDeGauss;

public class Questao_06 {
	public static void main(String[] args) {

		// Numero de Pontos Distintos
		int n = 4;

		// Criando matrizes para substituição
		double[] X = new double[n];

		// Matriz criada a partir dos pontos tabelados
		// a0 + a1x + a2x^2
		double[][] a = { { 1.0, 0.5, 0.25, 0.125, 3.2 }, { 1.0, 0.8, 0.64, 0.512, 3.68 },
				{ 1.0, 1.6, 2.56, 4.096, 4.96 }, { 1.0, 2.0, 4.0, 8.0, 5.6 } };

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

		for (int i = n - 2; i >= 1; i--) {
			X[i] = a[i][n];
			for (int j = i + 1; j < n; j++) {
				X[i] = X[i] - a[i][j] * X[j];
			}
			X[i] = X[i] / a[i][i];
		}

		// Mostrando o Polinomio Interpolador encontrado
		System.out.print("\nPolinomio interpolador:\t");
		System.out.printf("(%.3f) + (%.3f)*x + (%.3f)*x^2 + (%.3f)*x^3", X[0], X[1], X[2], X[3]);

		System.out.println("\n\nValor aproximado de f(0.73) a partir do polinomio encontrado:\t");

		System.out.printf("(%.3f) + (%.3f)*1.00 + (%.3f)*1.00^2 + (%.3f)*1.00^3 = %.3f", X[0], X[1], X[2], X[3],
				f(1.00, X));
	}

	// Determinando o valor de f(0,73).
	public static double f(double x, double[] X) {
		return X[0] + X[1] * x + X[2] * Math.pow(x, 2) + X[3] * Math.pow(x, 3);
	}
}
