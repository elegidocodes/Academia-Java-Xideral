package semana1.ejercicio;

public class HolaMundoMejorado {
    static void main(String[] args) {
        // Declarar variables
        String nombre = "Ana";
        int edad = 25;
        double altura = 1.68;
        boolean esActivo = true;

        // Concatenación con +
        String mensaje1 = "Me llamo " + nombre + ", tengo " + edad
                + " anios, mido " + altura + "m y estoy "
                + (esActivo ? "activo" : "inactivo") + ".";
        System.out.println(mensaje1);

        // Usando String.format()
        String mensaje2 = String.format(
                "Me llamo %s, tengo %d anios, mido %.2f m y estoy %s.",
                nombre, edad, altura, esActivo ? "activo" : "inactivo"
        );
        System.out.println(mensaje2);
    }
}