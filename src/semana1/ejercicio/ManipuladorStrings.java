package semana1.ejercicio;

public class ManipuladorStrings {

    public static String invertir(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static boolean esPalindromo(String s) {
        String limpio = s.toLowerCase().replaceAll("\\s+", "");
        return limpio.equals(invertir(limpio));
    }

    public static int contarVocales(String s) {
        int count = 0;
        String vocales = "aeiouAEIOU";
        for (int i = 0; i < s.length(); i++) {
            if (vocales.indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static String construirPiramide(int niveles) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= niveles; i++) {
            // Espacios a la izquierda
            sb.append(" ".repeat(niveles - i));
            // Asteriscos del nivel
            sb.append("*".repeat(2 * i - 1));
            // Salto de línea
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Invertir 'Hola Mundo': " + invertir("Hola Mundo"));
        System.out.println("'Anita lava la tina' es palíndromo: " + esPalindromo("Anita lava la tina"));
        System.out.println("Vocales en 'Murciélago': " + contarVocales("Murciélago"));
        System.out.println("Pirámide de 5 niveles:");
        System.out.println(construirPiramide(5));
    }
}