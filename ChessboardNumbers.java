package pl.adik.Szachownica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChessboardNumbers {
	//Deklaracja maciezy
	private static int[][] chessboard;
	//Lista zachowujaca najwyzsze wyniki (gdyby trafilo sie tak ze jest wiecej niz 1 taki sam wynik)
	private static ArrayList<String> resultList = new ArrayList<>();
	

	public static void main(String[] args) {
		//Przypisanie 
		chessboard = new int[8][8];
		Random rand = new Random();
		//Wpisanie do tablic "losowych" liczb
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				chessboard[i][j] = rand.nextInt(100);
			}
		}
		showChessboard();
		System.out.println();
		System.out.println("Suma liczb przyległych do pola to: " + choosenPosition(3, 5));
		System.out.println();
		chessboardScore();
		System.out.println();

	}
	//Metoda wypisujaca szachwonice liczb
	public static void showChessboard() {
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				//W if'ce aby wyrownac kolumny
				if(chessboard[i][j] > 9) {
					System.out.print(chessboard[i][j] + " ");
				} else {
					System.out.print(" " + chessboard[i][j] + " ");
				}
			}
			System.out.println();
		}	
	}
	//Metoda wyliczajace sume pol na ktore moze stanac wieza bez pola na ktorym stoi
	//Pole wskazane przez uzytkownika
	public static int choosenPosition(int x, int y) {
		
		int sumAll = 0;
		//Suma pol z X z wylaczeniem pola wiezy
		for(int i=0; i<8; i++) {
			if(i != y-1) {
				sumAll += chessboard[x-1][i];
			}
		}
		//Suma pol z Y z wylaczeniem pola wiezy
		for(int i=0; i<8; i++) {
			if(i != x-1) {
				sumAll += chessboard[i][y-1];
			}
		}
		return sumAll;
	}
	//Szachownica wynikow i najwyzsze wyniki
	public static void chessboardScore() {
		
		int temp = 0;
		int sumAll = 0;
		//Dwa fory aby przejsc po kazdym polu
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				//Suma przyleglych pol
				for(int i=0; i<8; i++) {
					if(i != y) {
						sumAll += chessboard[x][i];
					}
				}
				for(int i=0; i<8; i++) {
					if(i != x) {
						sumAll += chessboard[i][y];
					}	
				}
				//Wypisuje szachownice wynikow
				System.out.print(sumAll + " ");
				//Sprawdza czy suma pol jest wieksza od dotychczasowego wyniku
				if(sumAll >= temp) {
					//Jesli taki sam to dopisze do listy wynikow
					if(temp == sumAll) {
						resultList.add(String.format("Pole %d, %d = %d", x, y, sumAll));
					} else {
						resultList.clear();
						resultList.add(String.format("Pole %d, %d = %d", x+1, y+1, sumAll));
					}
					//Przypisanie najwyzszego wyniku do tymczasowej zmiennej
					temp = sumAll;
				}
				sumAll = 0;
			}
			System.out.println();
		}
		System.out.println("\nNajwiększe wyniki to:");
		//Wypisanie wyniku lub wynikow pod szachownica
		for(String s: resultList) {
			System.out.println(s);
		}
		
	}
	
}










