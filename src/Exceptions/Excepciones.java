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
               // System.out.println(e.getMessage());
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

        String dato = "";
        do {
            System.out.println("ingrese " + tipoDato);
            dato = objScanner.nextLine();
            try {
                if (dato.length() < 4) {
                    throw new CantCarcException("error debe ingresar mas de 3 caracteres");
                }
            } catch (CantCarcException e) {
                System.out.println(e.toString());
               // System.out.println("ingrese de nuevo");
                //objScanner.nextLine();
            }
        } while (dato.length() < 3);

        return dato;
    }

    public String valNumString(String tipoDato) throws StringNumerico,IllegalArgumentException {
        boolean check = false;
        String dni = "";
        do {

            try {
                System.out.println("ingrese " + tipoDato);
                dni= objScanner.nextLine();

                if (!dni.matches("\\d+")) {
                    throw new StringNumerico("ingrese solo numeros");
                }
                if (dni.length() < 8) {
                    throw new IllegalArgumentException("debe minimo 8 digitos ");
                }
                check = true;
            } catch (StringNumerico | IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }

        }while (!check);
        return dni;
    }

    public String valLetrasString(String tipoDato) throws StringNumerico,IllegalArgumentException {
        boolean check = false;
        String dato = "";
        do {

            try {
                System.out.println("ingrese " + tipoDato);
                dato= objScanner.nextLine();

                if (dato.matches("\\d+")) {
                    throw new StringNumerico("ingrese solo letras");
                }
                if (dato.length() < 3) {
                    throw new IllegalArgumentException("debe ingresar 3 caracteres minimo");
                }
                check = true;
            } catch (StringNumerico | IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }

        }while (!check);
        return dato;
    }

}

