package metodoDeNewton;

public class Questao_02 {
	public static void main(String[] args) {

		double a = -3.0;
		double b = -1.0;

		if (f(a) * f(b) < 0.0) {

			double valorInicial = -1.0;
			System.out.println("Valor inicial = " + valorInicial + "\n");

			double erro = Math.pow(10, -2);

			int numeroMaximoDeInteracoes = 90;

			// Metodo de Newton
			int iteracao = 1;
			int marcador = 1;
			boolean condicao = true;
			System.out.println("Interacao [0]\n\txi = " + valorInicial + "\n\tf(xi) = " + f(valorInicial) + "\n");
			double xi = 0;
			while (condicao) {
				xi = valorInicial - f(valorInicial) / g(valorInicial);
				System.out.println("Iteracao [" + iteracao + "]\n\t xi = " + xi + "\n\tf(xi) = " + f(xi) + "\n");
				valorInicial = xi;
				iteracao = iteracao + 1;

				if (iteracao > numeroMaximoDeInteracoes) {
					marcador = 0;
					break;
				}

				condicao = Math.abs(f(xi)) > erro;
			}

			if (marcador == 1) {
				System.out.println("A raiz da equacao [e] = " + xi);
			} else {
				System.out.println("Não obteve convergencia");
			}
		} else {
			System.out.println("Não existe raiz");
		}
	}

	public static double f(double x) {
		return Math.pow(x, 3) - 6 * Math.pow(x, 2) - x + 30;

	}

	public static double g(double x) {
		return 3 * Math.pow(x, 2) - 6 * 2 * x - 1;
	}
}
