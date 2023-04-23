package Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {
    private static Scanner objScanner = new Scanner(System.in);


    public int validarInput() {
        int numero = 0;
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


    public double validarDouble() throws NumeroNegativoException {
        double numero = 0;
        boolean check = false;

        do {
            try {
                numero = objScanner.nextDouble();

                if (numero < 0) {
                    throw new NumeroNegativoException("no se puede ingresar un numero negativo,ingrese de nuevo...");
                } else {
                    check = true;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.toString());
                System.out.println("debe ingresar un numero...");
                objScanner.nextLine();

            } catch (NumeroNegativoException e) {
                System.out.println(e.getMessage());
                objScanner.nextLine();
            }
        } while (!check);
        return numero;
    }

    public String cantCaracteres(String tipoDato) throws CantCarcException {

        String dato="";
        do {
            System.out.println("ingrese " + tipoDato);
            dato=objScanner.nextLine();
            try {
                if (dato.length() < 4) {
                    throw new CantCarcException("error debe ingresar mas de 3 caracteres");
                }
            } catch (CantCarcException e) {
                System.out.println(e.toString());
                System.out.println("ingrese de nuevo");
                objScanner.nextLine();
            }
        } while (dato.length() < 3);

        return dato;
    }

}