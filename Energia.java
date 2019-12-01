package lista_16;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Energia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numResidencia[] = new int [100], qtKWH[] = new int [100], i, consomeMais100 = 0, menorConsumo = Integer.MAX_VALUE,casaMenorConsumo = 0;
		float valorLiquido[] = new float [100], valorBruto[] = new float [100], valorDesconto = 0;
		char flag = 'S';
		DecimalFormat df = new DecimalFormat("#,##0.00");
		DecimalFormat perc = new DecimalFormat("0.00'%'");
		Scanner leia = new Scanner(System.in);
		
		for (i = 0; i < 100 && flag != 'N' ; i++) {
			
		
		do {
			System.out.println("Digite o número de sua residência: ");
			numResidencia[i] = leia.nextInt();

			if (numResidencia[i] <= 0) {
				System.err.println("Erro o número de sua residência tem que ser maior que ZERO!!");
			}
		} while (numResidencia[i] <= 0);

		do {
			System.out.println("Digite a quantidade de KWH que sua casa consumiu: ");
			qtKWH[i] = leia.nextInt();
			if (qtKWH[i] < 0) {
				System.err.println("Erro a quantidade de KWH tem que ser maior que ZERO!!");
			}
		} while (qtKWH[i] < 0);

		// CALCULOS
		
		valorBruto[i] = qtKWH[i] * 0.30f;
		
		if(valorBruto[i] < 100) {
			
			valorDesconto = valorBruto[i] * 0.15f;	
		}
		valorLiquido[i] = valorBruto[i] - valorDesconto;
		
		if(valorBruto[i] > 100) {
			consomeMais100+=valorBruto[i];
		}
		
		if(valorBruto[i] < menorConsumo) {
			menorConsumo = (int) valorBruto[i];
			casaMenorConsumo = numResidencia[i];
		}
		
		System.out.println("==============RESULTADOS INTERMEDIÁRIOS===============");
		System.out.println("A) O valor bruto a ser pago por cada residência da rua é: " + df.format(valorBruto[i]));
		System.out.println("B) O valor líquido a ser pago por cada residência da rua é: " + df.format(valorLiquido[i]));
		System.out.println("======================================================");
		System.out.println("");
		do {
			System.out.println("Deseja sair S/N:");
			flag = leia.next().toUpperCase().charAt(0);
			
		} while (flag != 'S' && flag != 'N');
		
		
		}
		System.out.println("==============RESULTADOS FINAIS===============");
		
		System.out.println("A) Percentual das residências que consomem mais que R$100,00: " + perc.format(consomeMais100 / i));
		System.out.println("B) A casa " + casaMenorConsumo+ " que tem menor consumo de todas as casas consultadas que é:" + menorConsumo);
		for (int j = 0; j < i; j++) {
			System.out.println("=============================");
			System.out.println("Número Residência: " + numResidencia[j]);
			System.out.println("Quantidade KWh   :" + qtKWH[j]);
			System.out.println("Valor Bruto      :" + df.format(valorBruto[j]));
			System.out.println("Valor Líquido    :" + df.format(valorLiquido[j]));
		}
	}

}
