package Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {
    private static Scanner objScanner = new Scanner(System.in);


    public int validarInput() {
        int numero = 9;
        boolean check = false;

        do {

            try {
                numero = objScanner.nextInt();
               objScanner.nextLine();
                check = true;
            } catch (InputMismatchException e) {
                System.out.println(e.toString());
                System.out.println("debe ingresar un numero entero");
                objScanner.nextLine();

            }

        } while (!check);

        return numero;

    }
}
