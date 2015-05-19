import java.util.Scanner;
import ing.unibs.esercitazioni.mylib.*;

/**
 * Classe principale del progetto Tamagotchi
 * 
 * @author Gruppo B
 *
 */
public class TamaMain {
	
	public static final int MIN_DA_DARE = 0; // Costante con il valore minimo di carezze o biscotti da dare in un turno
	public static final int MAX_DA_DARE = 10; // Costante con il valore massimo di carezze o biscotti da dare in un turno
	public static final int MIN = 0; // Valore minimo inziale per affetto e cibo
	public static final int MAX = 100; // Valore massimo iniziale per affetto e cibo
	public static final String SALUTO = "Ciao e benvenuto nel tuo nuovo Tamagotchi!";
	public static final String SCELTA = "Scegli tra: 1) Dai carezze; 2) Dai cibo; 3) Esci dal gioco.";
	public static final String ERRORE = "Hai immesso un valore non valido!";
	public static final String ARRIVEDERCI = "Ciao e grazie per aver giocato!";
	public static final String CREA_1 = "Inserisci il nome del tuo tamagotchi:";
	public static final String CREA_2 = "Inserisci il valore di affetto del tuo tamagotchi:";
	public static final String CREA_3 = "Inserisci il valore di sazietà del tuo tamagotchi:";
	
	/**
	 * Metodo main del progetto Tamagotchi
	 */
	public static void main(String[] args) {
		
		System.out.println(SALUTO);
		
		Tamagotchi tama = creaTama();
		
		int scelta = 0;
		Scanner in = MyUtil.creaLettore();
		
		do {
			
			System.out.println(SCELTA);
			
			scelta = in.nextInt();
			
			switch(scelta) {
			
			case 1: 
				
				tama.daiCarezze(MyUtil.randomInt(MIN_DA_DARE, MAX_DA_DARE));
				System.out.println(tama.toString()); 
				break;
				
			case 2: 
				
				tama.daiBiscotti(MyUtil.randomInt(MIN_DA_DARE, MAX_DA_DARE)); 
				System.out.println(tama.toString());
				break;
				
			case 3: break;
			
			default: System.out.println(ERRORE);
			
			}
			
		} while (!tama.morto() && scelta != 3);
		
		System.out.println(ARRIVEDERCI);
		
	}
	
	/**
	 * Metodo utilizzato per la creazione del tamagotchi all'inizio del gioco
	 * 
	 * @return Un tamagotchi creato con le specifiche date dall'utente
	 */
	public static Tamagotchi creaTama() {
		
		String nome;
		double affetto;
		double cibo;
		
		Scanner in = MyUtil.creaLettore();
		
		System.out.println(CREA_1);
		nome = in.next();
		System.out.println(CREA_2);
		affetto = MyUtil.leggiDouble(MIN, MAX);
		System.out.println(CREA_3);
		cibo = MyUtil.leggiDouble(MIN, MAX);
		
		return new Tamagotchi(nome, affetto, cibo);
		
	}
	
}
