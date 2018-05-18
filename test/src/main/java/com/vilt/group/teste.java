package com.vilt.group;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class teste {
	
	Random random = new Random();

	public String calcularRaio(Double diametro) {
		Double result = diametro / 2;
		return "O raio de um circulo com " + diametro + " de diametro e: " + result;
	}

	public String calcularTriangulo(int i, int j, int k) {
		if (i <= 0 || j <= 0 || k <= 0) {
			return "Os lados: " + i + ", " + j + " e " + k + " nao formam um triangulo";
		}
		if (i == j && i == k && j == k)
			return "Triangulo equilatero, com os lados: " + i + ", " + j + " e " + k;
		else if (i == j || i == k || j == k)
			return "Trinagulo isosceles: " + i + ", " + j + " e " + k;
		else
			return "Triangulo escaleno: " + i + ", " + j + " e " + k;
	}

	public int gerarNumeroI() {
		return random.nextInt(100);
	}
	
	public Double gerarNumeroD() {
		return random.nextDouble();
	}
}
