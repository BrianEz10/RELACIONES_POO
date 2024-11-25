package main2.model2;

import java.util.ArrayList;

    public class Plato {
        private String nombreCompleto;
        private double precio;
        private boolean esBebida;
        private ArrayList<Ingrediente> ingredientes;

        // Constructor
        public Plato(String nombreCompleto, double precio, boolean esBebida) {
            this.nombreCompleto = nombreCompleto;
            this.precio = precio;
            this.esBebida = esBebida;
            this.ingredientes = new ArrayList<>();
        }

        /// Métod para agregar ingredientes
        public void agregarIngrediente(Ingrediente ingrediente) {
            if (!esBebida) {
                ingredientes.add(ingrediente);
            }
        }

        // Getters y setters
        public String getNombreCompleto() {
            return nombreCompleto;
        }

        public void setNombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public boolean isEsBebida() {
            return esBebida;
        }

        public void setEsBebida(boolean esBebida) {
            this.esBebida = esBebida;
        }

        public ArrayList<Ingrediente> getIngredientes() {
            return ingredientes;
        }
    }
