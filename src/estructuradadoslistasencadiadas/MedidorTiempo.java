package estructuradadoslistasencadiadas;

/**
 * Clase utilitaria para medir el tiempo de ejecución de operaciones en milisegundos.
 * <p>
 * Utiliza la interfaz funcional {@link Runnable} para recibir la operación a medir.
 * El método {@link #medirTiempo(Runnable)} devuelve el tiempo transcurrido en 
 * milisegundos entre el inicio y el fin de la ejecución.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>{@code
 * long tiempo = MedidorTiempo.medirTiempo(() -> {
 *     // Ejemplo de código cuya duración queremos medir
 *     for (int i = 0; i < 1_000_000; i++) {
 *         Math.sqrt(i);
 *     }
 * });
 * System.out.println("Tiempo de ejecución: " + tiempo + " ms");
 * }</pre>
 *
 * @author  Aaron FullStack
 * @version 1.0
 */
public class MedidorTiempo {
    
    /**
     * Constructor por defecto de la clase.
     */
    public MedidorTiempo(){}
    
    /**
     * Mide el tiempo de ejecución de una operación representada por un {@link Runnable}.
     * <p>
     * El método inicia un contador antes de ejecutar la operación y lo detiene justo después.
     * </p>
     *
     * @param operacion Operación a ejecutar (se pasa como lambda o clase anónima).
     * @return Tiempo transcurrido en milisegundos durante la ejecución de la operación.
     */
    public static long medirTiempo(Runnable operacion) {
        long inicio = System.currentTimeMillis(); // Inicia el tiempo de conteo
        operacion.run(); // Ejecuta la operación
        long fin = System.currentTimeMillis(); // Termina el tiempo de conteo
        return fin - inicio; // devuelve el tiempo en ms    
    }
}
