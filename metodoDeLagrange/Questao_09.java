package metodoDeLagrange;

public class Questao_09 {
	public static void main(String[] args) {
		double novoX, novoY = 0;
		double[] Y = { 0.000, 52.032, 160.450, 275.961, 370.276 };
		double[] X = { 0, 8, 20, 30, 45 };

		novoX = 25;

		System.out.println("\n");

		System.out.printf("X = %.1f\n", novoX);

		for (int i = 0; i < 5; i++) {
			double p = 1;
			for (int j = 0; j < 5; j++) {
				if (i != j) {
					p = p * (novoX - X[j]) / (X[i] - X[j]);
				}
			}
			novoY = novoY + p * Y[i];
		}

		System.out.printf("\n");
		System.out.printf("O valor aproximado para f(%.2f) é: %.3f\n", novoX, novoY);
	}

}
