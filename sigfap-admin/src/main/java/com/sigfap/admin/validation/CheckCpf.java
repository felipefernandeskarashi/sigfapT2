package com.sigfap.admin.validation;

public class CheckCpf {
	public CheckCpf() {
		
	}
	
	public boolean verificaCpf(String cpf) {
		return verifica(cpf);
	}

	private boolean verifica(String cpf) {
		
		String valor = cpf;
		int i = 10, cont = 0; // i usado para a multiplicação de 10 até 2 para os 9 elementos do cpf
		int multi = 0; // Guarda a multiplicação dos 9 primeiros elementos do cpf
		int resto, sub;
		int firstNumber = Integer.parseInt(valor.substring(cont, cont+1)); // cont = 0 vai até 1 para pegar o primeiro valor do cpf
		int valorDeVerificacao = 0;
			if (Integer.parseInt(valor.substring(9,10)) == 0)
				valorDeVerificacao = Integer.parseInt(valor.substring(10,11));
			else
				valorDeVerificacao = Integer.parseInt(valor.substring(9,11));
			
			
		int valorMontadoParaVerificao = 0;
		
		multi = firstNumber * i;
		i--; // i passa ter 9
		cont++;
		/* Ideia Geral:
		 * Distribua os 9 primeiros dígitos do CPF na primeira linha de uma tabela, 
		 * e na linha abaixo distribua os pesos 10, 9, 8, 7, 6, 5, 4, 3, 2 
		 * Calcule a somatória dos resultados das multiplicações, while à seguir faz isso
		 * */
		while (i > 1) {
			firstNumber = Integer.parseInt(valor.substring(cont, cont+1));
			multi += (firstNumber * i);
			i--;
			cont++;
		}
		
		/* O resultado obtido será restoido por 11. Considere como quociente apenas 
		 * o valor inteiro obtido na restoisão, o sub da restoisão será responsável pelo
		 *  cálculo do primeiro dígito verificador.
		 * */
		resto = multi % 11; 
		//Para calcular o dígito verificador, você deve subtrair o sub encontrado de onze.
		sub = 11 - resto;
		/* Se o resultado da subtração for maior que 9, o dígito verificador é ZERO. 
		 * Caso contrário, o dígito verificador é o resultado dessa subtração. 
		 * */
		if (sub <= 9) 
			valorMontadoParaVerificao = sub;
		else
			valorMontadoParaVerificao = 0;
		
		char valorAntigo = valor.charAt(9); // Valor que será trocado na String
		String valorNovoTransacao = Integer.toString(valorMontadoParaVerificao); // Convertendo inteiro para String
		
		char valorNovo = valorNovoTransacao.charAt(0);  // Convertendo String para caracter
		

		String stringValorNovo = valor.substring(0, 9) + valor.substring(9, 10).replace(valorAntigo, valorNovo) + valor.substring(10, 11);
		
		
		
		// Cálcular o Segundo dígito
		cont = 0;
		i = 11;
		firstNumber = Integer.parseInt(stringValorNovo.substring(cont, cont+1)); // cont = 0 vai até 1 para pegar o primeiro valor do cpf
		
		multi = firstNumber * i;

		i--; // i passa ter 9
		cont++;
		/* Ideia Geral:
		 * Distribua os 9 primeiros dígitos do CPF na primeira linha de uma tabela, 
		 * e na linha abaixo distribua os pesos 10, 9, 8, 7, 6, 5, 4, 3, 2 
		 * Calcule a somatória dos resultados das multiplicações, while à seguir faz isso
		 * */
		while (i > 1) {
			firstNumber = Integer.parseInt(stringValorNovo.substring(cont, cont+1));
			multi += (firstNumber * i);
			i--;
			cont++;
		}	
		
		
		/* O resultado obtido será restoido por 11. Considere como quociente apenas 
		 * o valor inteiro obtido na restoisão, o sub da restoisão será responsável pelo
		 *  cálculo do primeiro dígito verificador.
		 * */
		resto = multi % 11; 
		//Para calcular o dígito verificador, você deve subtrair o sub encontrado de onze.
		sub = 11 - resto;
		/* Se o resultado da subtração for maior que 9, o dígito verificador é ZERO. 
		 * Caso contrário, o dígito verificador é o resultado dessa subtração. 
		 * */		
		
		if (sub <= 9)
			valorMontadoParaVerificao = (valorMontadoParaVerificao*10) + sub;
		else
			valorMontadoParaVerificao = (valorMontadoParaVerificao*10);
		
		if (valorDeVerificacao == valorMontadoParaVerificao)
			return true;
		else
			return false;
	}
}
