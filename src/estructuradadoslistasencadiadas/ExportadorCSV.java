package estructuradadoslistasencadiadas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Clase utilitaria para exportar listas de objetos {@link Aluno} a un archivo CSV.
 * 
 * <p>El archivo generado incluye una cabecera y los datos de cada alumno en formato:</p>
 * <pre>
 * nomecompleto,matricula,dataNascimento
 * </pre>
 * <p>Los valores se separan por comas y el archivo incluye un <b>BOM</b> para que 
 * Excel lo reconozca como UTF-8.</p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>{@code
 * List<Aluno> alumnos = new ArrayList<>();
 * alumnos.add(new Aluno("Ana Almeida", 123, "2000-05-10"));
 * alumnos.add(new Aluno("Carlos Silva", 456, "1999-11-22"));
 * ExportadorCSV.exportar(alumnos, "alumnos.csv");
 * }</pre>
 *
 * @author  Aaron FullStack
 * @version 1.0
 */
public class ExportadorCSV {
    
    /**
     * Constructor por defecto de la clase.
     */
    public ExportadorCSV(){}
    
    /**
     * Exporta una lista de alumnos a un archivo CSV en el sistema de archivos.
     * <p>
     * El archivo incluirá una cabecera con los nombres de las columnas y, a 
     * continuación, los datos de cada alumno. Si el archivo ya existe, se sobrescribirá.
     * </p>
     *
     * @param lista         Lista de objetos {@link Aluno} que serán exportados.
     * @param nombreArchivo Nombre del archivo CSV de salida (con extensión .csv).
     * 
     * @throws RuntimeException si ocurre un error de escritura en el archivo.
     */
    public static void exportar(List<Aluno> lista, String nombreArchivo) {
        try(FileWriter writer = new FileWriter(nombreArchivo)){
            // BOM para que Excel reconozca UTF-8
            writer.write("\uFEFF");

            // Cabecera
            writer.write("nomecompleto,matricula,dataNascimento\n");

            // Datos de cada alumno
            for (Aluno a : lista) {
                writer.write("\"" + a.toString()+ "\n");
            }

            System.out.println("Archivo CSV '" + nombreArchivo + "' creado con exito.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
