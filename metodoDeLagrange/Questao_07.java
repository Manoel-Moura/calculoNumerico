package metodoDeLagrange;

public class Questao_07 {
	public static void main(String[] args) {
		double novoX, novoY = 0, x, y;
		double[] Y = { 0.301, 0.477 };
		float[] X = { 2, 3 };

		novoX = 2.5;

		System.out.println("\n");

		System.out.printf("X = %.1f\n", novoX);

		for (int i = 0; i < 2; i++) {
			double p = 1;
			for (int j = 0; j < 2; j++) {
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
