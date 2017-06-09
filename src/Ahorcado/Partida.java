// --------------------------------------------------------
    // Code generated by Papyrus Java
// --------------------------------------------------------

package Ahorcado;

import java.util.Scanner;

import com.sun.media.sound.ModelStandardTransform;

import Ahorcado.Horca;
import Ahorcado.Palabra;

/************************************************************/
/**
 * 
 */
public class Partida {
	/**
	 * 
	 */
	public static Horca horca;
	/**
	 * 
	 */
	public static Palabra palabra;

	/**
	 * Muestra el estado de la horca y los resultados de palabra
	 */
	public static void mostrarProgreso() {
		
		horca.dibujar();
		palabra.mostrarResultados();
		
	}

	/**
	 * 
	 * @return letra 
	 */
	public static char pedirLetra() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una letra: ");
		char letra = entrada.nextLine().charAt(0);
		
		return letra;
	}

	/**
	 * Pide la respuesta y devuelve true si era la que buscábamos
	 * @return true si era la que búscamos o false en caso contrario
	 */
	public static boolean resolver() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce la respuesta ");
		return palabra.comprobarPalabra(entrada.nextLine());
			
		
	}

	/**
	 * Comprueba tanto si hemos agotado los fallos como si hemos acertado las letras
	 * @return fin 
	 */
	public static boolean comprobarFinal() {
	return	horca.comprobarSiPerdido() || palabra.comprobarSiGanado();
	}
	public static int elegirDelMenu(){
		Scanner entrada = new Scanner(System.in);

		System.out.println("Elige una opción:");
		System.out.println("1.Letra");
		System.out.println("2. Resolver");
		System.out.println("3.Abandonar");
		return entrada.nextInt();
	}
	
	public static void main(String[] args) {
		 horca = new Horca();
		 palabra = new Palabra();
		boolean noHaResueltoMal = true;
	
		palabra.elegirPalabra();
		while (!comprobarFinal() && noHaResueltoMal){
			
			switch (elegirDelMenu()){
				case 1: 
				palabra.comprobarLetra(pedirLetra());
				mostrarProgreso();
				
					break;
				case 2 :
					
					if(resolver()){ 
						System.out.println("Has ganado");
				
					}else System.out.println("Lo siento, has perdido");
					noHaResueltoMal = false;
					break;
				case 3:
					System.exit(0);
				default:
						break;
			
			}
			
			pedirLetra();
		}
	}
};
