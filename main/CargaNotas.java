package main;

import main.model.Alumno;
import main.model.Nota;
import java.util.ArrayList;
import java.util.Scanner;

public class CargaNotas {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = sc.nextInt();

        for (int i = 0; i < cantidadAlumnos; i++) {
            sc.nextLine();
            System.out.print("Nombre del alumno: ");
            String nombre = sc.nextLine();
            System.out.print("Legajo: ");
            long legajo = sc.nextLong();

            Alumno alumno = new Alumno(nombre, legajo);

            System.out.print("Cantidad de notas para el alumno: ");
            int cantidadNotas = sc.nextInt();

            for (int j = 0; j < cantidadNotas; j++) {
                sc.nextLine(); // Limpiar buffer
                System.out.print("Cátedra: ");
                String catedra = sc.nextLine();
                System.out.print("Nota: ");
                double nota = sc.nextDouble();

                alumno.agregarNota(new Nota(catedra, nota));
            }
            alumnos.add(alumno);
        }

        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombreCompleto());
            System.out.println("Promedio: " + alumno.calcularPromedio());
        }
    }
}
