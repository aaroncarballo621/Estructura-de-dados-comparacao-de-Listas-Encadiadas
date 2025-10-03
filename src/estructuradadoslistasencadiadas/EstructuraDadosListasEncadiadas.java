package estructuradadoslistasencadiadas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Clase de prueba de rendimiento que compara el uso de diferentes implementaciones de {@link List}
 * en Java: {@link ArrayList}, {@link LinkedList} y {@link Vector}.
 * <p>
 * El programa realiza las siguientes operaciones para cada tipo de lista con una cantidad
 * determinada de alumnos generados aleatoriamente mediante {@link CreadorAlumno}:
 * </p>
 * <ul>
 *   <li><b>Cadastro (inserción):</b> Inserta {@code qtdAlunos} objetos en la lista.</li>
 *   <li><b>Ordenación:</b> Ordena la lista por nombre utilizando {@link Comparator#comparing}.</li>
 *   <li><b>Exportación:</b> Exporta la lista a un archivo CSV mediante {@link ExportadorCSV}.</li>
 * </ul>
 *
 * <p>
 * Se utiliza la clase {@link MedidorTiempo} para calcular el tiempo de ejecución de cada operación
 * en milisegundos. Al final, se muestra una tabla comparativa de tiempos.
 * </p>
 *
 * <p><b>Ejemplo de salida esperada:</b></p>
 * <pre>
 * Cadastrado arrayList com sucesso
 * Cadastrado linkedList com sucesso
 * Cadastrado vector com sucesso
 * ArrayList ordenada
 * LinkedList ordenada
 * Vector ordenado
 * Archivos exportador con exito de arrayList
 * Archivos exportador con exito de linkedList
 * Archivos exportador con exito de vectorList
 * Operacion     ArrayList (ms)  LinkedList (ms)  Vector (ms)
 * Cadastro      1200            1450             3000
 * Ordenacion    900             1500             950
 * Exportacion   400             420              390
 * </pre>
 *
 * <p><b>Nota:</b> La cantidad de alumnos se fija en {@code 350000}, lo que puede generar
 * tiempos elevados dependiendo de la máquina.</p>
 *
 * @author  Aaron FullStack
 * @version 1.0
 */
public class EstructuraDadosListasEncadiadas {
    /**
     * Constructor por defecto de la clase.
     */
    public EstructuraDadosListasEncadiadas(){}

    /**
     * Metodo principal
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int qtdAlunos = 350000;

        List<Aluno> arrayList = new ArrayList<>();
        List<Aluno> linkedList = new LinkedList<>();
        List<Aluno> vector = new Vector<>();
        
        long tiempoCadastroarrayList = MedidorTiempo.medirTiempo(() ->{
        for (int i = 0; i < qtdAlunos; i++) {
            arrayList.add(CreadorAlumno.generarAlumno());
            }
        });
        System.out.println("Cadastrado arrayList com sucesso");
        
        long tiempoCadastrolinkedList = MedidorTiempo.medirTiempo(() ->{
        for (int i = 0; i < qtdAlunos; i++) {
            linkedList.add(CreadorAlumno.generarAlumno());
            }
        });
        System.out.println("Cadastrado linkedList com sucesso");
                
        long tiempoCadastrovector = MedidorTiempo.medirTiempo(() ->{
        for (int i = 0; i < qtdAlunos; i++) {
            vector.add(CreadorAlumno.generarAlumno());
            }
        });
        System.out.println("Cadastrado vector com sucesso");
        
        long tiempoOrdenacionarrayList = MedidorTiempo.medirTiempo(() ->{
        arrayList.sort(Comparator.comparing(Aluno::getNome));
        });
        System.out.println("ArrayList ordenada");
        
        long tiempoOrdenacionlinkedList = MedidorTiempo.medirTiempo(() ->{
        linkedList.sort(Comparator.comparing(Aluno::getNome));
        });
        System.out.println("LinkedList ordenada");
        
        long tiempoOrdenacionvector = MedidorTiempo.medirTiempo(() ->{
        vector.sort(Comparator.comparing(Aluno::getNome));
        });
        System.out.println("Vector ordenado");
        
        long tiempoExportacionarrayList = MedidorTiempo.medirTiempo(() ->{
        ExportadorCSV.exportar(arrayList,"alunos_arrayList.csv");
        });
        System.out.println("Archivos exportador con exito de arrayList");
        
        long tiempoExportacionlinkedList = MedidorTiempo.medirTiempo(() ->{
        ExportadorCSV.exportar(linkedList,"alunos_linkedList.csv");
        });
        System.out.println("Archivos exportador con exito de linkedList");
        
        long tiempoExportacionvector = MedidorTiempo.medirTiempo(() ->{
        ExportadorCSV.exportar(arrayList,"alunos_vector.csv");
        });
        System.out.println("Archivos exportador con exito de vectorList");
        
        System.out.println("\nOperacion\tArrayList (ms)\tLinkedList (ms)\tVector (ms)");
        
        System.out.println("Cadastro\t" + tiempoCadastroarrayList + "\t\t" + 
                                          tiempoCadastrolinkedList + "\t\t" +
                                          tiempoCadastrovector);
        
        System.out.println("Ordenacion\t" + tiempoOrdenacionarrayList + "\t\t" +
                                          tiempoOrdenacionlinkedList + "\t\t" +
                                          tiempoOrdenacionvector);
        
        System.out.println("Exportacion\t" + tiempoExportacionarrayList + "\t\t" + 
                                             tiempoExportacionlinkedList + "\t\t" + 
                                             tiempoExportacionvector);
        
        long tiempoTotalarrayList=tiempoCadastroarrayList+tiempoOrdenacionarrayList+tiempoExportacionarrayList;
        long tiempoTotallinkedList=tiempoCadastrolinkedList+tiempoOrdenacionlinkedList+tiempoExportacionlinkedList;
        long tiempoTotalvector=tiempoCadastrovector+tiempoOrdenacionvector+tiempoExportacionvector;
        
        System.out.println("Tiempo total\t" + tiempoTotalarrayList + "\t\t" +
                                       tiempoTotallinkedList + "\t\t" +
                                       tiempoTotalvector);
        System.out.println("Media       \t" + tiempoTotalarrayList/3 + "\t\t" + 
                                       tiempoTotallinkedList/3 + "\t\t" + 
                                       tiempoTotalvector/3);
    }
}
