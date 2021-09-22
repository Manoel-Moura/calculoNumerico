package metodoDeBisecao;

public class Questao_1 {

	public static void main(String[] args) {

		double a = -3.0;
		double b = 0.0;
		double raiz = 0;

		double e = Math.pow(10, -2);

		if (equacao(a) * equacao(b) < 0.0) {
			// Metodo da bisseção
			int i = 1;
			boolean condicao = true;
			while (condicao) {
				double xi = (a + b) / 2;
				System.out.println("Iteracao[" + i + "]\n\t xi = " + xi + "\n\tf(xi) = " + equacao(xi) + "\n");

				if (equacao(a) * equacao(xi) < 0) {
					b = xi;
				} else {
					a = xi;
				}
				i = i + 1;
				raiz = xi;
				condicao = Math.abs(equacao(xi)) > e;
			}

			System.out.println("Rais da equacao [e]: -> " + raiz);

		} else {
			System.out.println("Não existe raiz!");
		}

	}

	public static double equacao(double x) {
		return Math.pow(x, 3) - 6 * Math.pow(x, 2) - x + 30;

	}

}
