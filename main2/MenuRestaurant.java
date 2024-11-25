package main2;

import main2.model2.Ingrediente;
import main2.model2.Plato;

import java.util.ArrayList;
import java.util.Scanner;

    public class MenuRestaurant {
        public static void main(String[] args) {
            ArrayList<Plato> platosMenu = new ArrayList<>();
            Scanner sc = new Scanner(System.in);

            System.out.print("Ingrese la cantidad de platos en el menú: ");
            int cantidadPlatos = sc.nextInt();

            for (int i = 0; i < cantidadPlatos; i++) {
                sc.nextLine();
                System.out.print("Nombre del plato: ");
                String nombrePlato = sc.nextLine();
                System.out.print("Precio del plato: ");
                double precio = sc.nextDouble();
                System.out.print("¿Es una bebida? (true/false): ");
                boolean esBebida = sc.nextBoolean();

                Plato plato = new Plato(nombrePlato, precio, esBebida);

                if (!esBebida) {
                    System.out.print("Ingrese la cantidad de ingredientes para este plato: ");
                    int cantidadIngredientes = sc.nextInt();

                    for (int j = 0; j < cantidadIngredientes; j++) {
                        sc.nextLine();
                        System.out.print("Nombre del ingrediente: ");
                        String nombreIngrediente = sc.nextLine();
                        System.out.print("Cantidad: ");
                        double cantidad = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Unidad de medida: ");
                        String unidadMedida = sc.nextLine();

                        Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidad, unidadMedida);
                        plato.agregarIngrediente(ingrediente);
                    }
                }

                platosMenu.add(plato);
            }

            System.out.println("\nMENÚ:");
            for (Plato plato : platosMenu) {
                System.out.println("Plato: " + plato.getNombreCompleto());
                System.out.println("Precio: $" + plato.getPrecio());
                if (plato.isEsBebida()) {
                    System.out.println("Es una bebida.");
                } else {
                    System.out.println("Ingredientes:");
                    for (Ingrediente ingrediente : plato.getIngredientes()) {
                        System.out.println("  - " + ingrediente.getNombre() + ": " +
                                ingrediente.getCantidad() + " " + ingrediente.getUnidadMedida());
                    }
                }
                System.out.println();
            }

            sc.close();
        }
    }
