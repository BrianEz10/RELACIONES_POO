package main3;


import main3.model3.DetalleFactura;
import main3.model3.Factura;

import java.util.Scanner;

public class Facturacion {
    private static final String[][] articulos = {
            {"101", "Leche", "25"},
            {"102", "Gaseosa", "30"},
            {"103", "Fideos", "15"},
            {"104", "Arroz", "28"},
            {"105", "Vino", "120"},
            {"106", "Manteca", "20"},
            {"107", "Lavandina", "18"},
            {"108", "Detergente", "46"},
            {"109", "Jabón en Polvo", "96"},
            {"110", "Galletas", "60"}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la fecha de la factura: ");
        String fecha = sc.nextLine();
        System.out.print("Ingrese el número de la factura: ");
        long numeroFactura = sc.nextLong();
        sc.nextLine();
        System.out.print("Ingrese el cliente: ");
        String cliente = sc.nextLine();

        Factura factura = new Factura(fecha, numeroFactura, cliente);

        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese el código del artículo: ");
            String codigo = sc.nextLine();

            String[] articulo = buscarArticulo(codigo);
            if (articulo == null) {
                System.out.println("El código ingresado no existe, intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese la cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine();

            double precioUnitario = Double.parseDouble(articulo[2]);
            double descuento = cantidad > 5 ? precioUnitario * 0.1 : 0;
            double subtotal = (precioUnitario - descuento) * cantidad;

            DetalleFactura detalle = new DetalleFactura(codigo, articulo[1], cantidad, precioUnitario, descuento, subtotal);
            factura.agregarDetalle(detalle);

            System.out.print("¿Desea ingresar otro artículo? (si/no): ");
            continuar = sc.nextLine().equalsIgnoreCase("si");
        }

        factura.calcularMontoTotal();

        System.out.println("\nFactura:");
        System.out.println("Fecha: " + factura.getFechaFactura());
        System.out.println("Número: " + factura.getNumeroFactura());
        System.out.println("Cliente: " + factura.getCliente());
        System.out.println("Detalles:");
        for (DetalleFactura detalle : factura.getDetallesFactura()) {
            System.out.printf("%s %s %d $%.2f $%.2f $%.2f\n",
                    detalle.getCodigoArticulo(),
                    detalle.getNombreArticulo(),
                    detalle.getCantidad(),
                    detalle.getPrecioUnitario(),
                    detalle.getDescuentoItem(),
                    detalle.getSubtotal());
        }
        System.out.printf("Total: $%.2f\n", factura.getTotalCalculadoFactura());
    }

    // Métod para buscar un artículo
    private static String[] buscarArticulo(String codigo) {
        for (String[] articulo : articulos) {
            if (articulo[0].equals(codigo)) {
                return articulo;
            }
        }
        return null;
    }
}

