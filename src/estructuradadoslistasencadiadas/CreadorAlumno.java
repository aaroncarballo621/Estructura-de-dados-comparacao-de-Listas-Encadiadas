package estructuradadoslistasencadiadas;
import java.util.Random;

/**
 * Clase utilitaria para generar instancias de {@link Aluno} con datos ficticios aleatorios.
 * <p>Los atributos generados incluyen:</p>
 * <ul>
 *   <li><b>Nombre completo</b>: compuesto de un nombre y dos apellidos.</li>
 *   <li><b>Matrícula</b>: número aleatorio de 7 dígitos con un dígito verificador.</li>
 *   <li><b>Fecha de nacimiento</b>: día, mes y año válidos en formato <code>dd/MM/yyyy</code>,
 *       con control de años bisiestos.</li>
 * </ul>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>{@code
 * Aluno alumno = CreadorAlumno.generarAlumno();
 * System.out.println(alumno.getNome());
 * System.out.println(alumno.getMatricula());
 * System.out.println(alumno.getDataNascimento());
 * }</pre>
 *
 * @author  Aaron FullStack
 * @version 1.0
 */
public class CreadorAlumno {
    
    /**
     * Constructor por defecto de la clase.
     */
    public CreadorAlumno(){}
    //Conjunto de nombres a sortear
    private static String[] nomes = {"Ana", "João", "Carlos", "Maria", "Pedro", "Juliana", "Lucas", "Fernanda"};
    //Conjunto de apellidos a sortear
    private static String[] sobrenomes = {"Silva", "Souza", "Oliveira", "Costa", "Pereira", "Rodrigues", "Almeida", "Ferreira"};
    //Inicializa el sorteador
    private static Random sortea = new Random();

    /**
     * Genera un alumno con nombre, matrícula y fecha de nacimiento aleatorios.
     * <p>
     * La matrícula consta de un número de 7 cifras y un dígito verificador.
     * La fecha de nacimiento se genera aleatoriamente entre los años 1950 y 2006,
     * respetando los días válidos según el mes y los años bisiestos.
     * </p>
     *
     * @return un objeto {@link Aluno} con datos aleatorios.
     */
    public static Aluno generarAlumno() {
        
        int indiceNome = sortea.nextInt(nomes.length);              // sortea el indice del nombre
        int indiceSobrenome1 = sortea.nextInt(sobrenomes.length);   // sortea el indice del primer apellido
        int indiceSobrenome2 = sortea.nextInt(sobrenomes.length);   // sortea el indice del segundoa apellido
        // Une el nombre completo
        String nome = nomes[indiceNome] + " " + sobrenomes[indiceSobrenome1] + " " + sobrenomes[indiceSobrenome2];

        String matriculaString = String.format("%07d", sortea.nextInt(100000000)+1000000); // 7 números aleatórios
        String verificadorString = String.format("%d", sortea.nextInt(10)); // sortea numero de 0 a 9
        // Une la matricula completo en el formato "1234567-8"
        String matricula = matriculaString + "-" + verificadorString;

        int mes = 1 + sortea.nextInt(12); // sortea un mes cualquiera
        int ano = 1950 + sortea.nextInt(56); // entre 1950 e 2006 si o si debe ser mayor de edad
        int dia;
        if( ano%4 == 0){                        // si es ano biciesto
            if(mes == 2){                       // y es febrero
                dia = 1 + sortea.nextInt(29);   // sortea (1 a 29)
            }
        }
        if(mes == 2){ //si es febrero
            dia = 1 + sortea.nextInt(28);      // sortea (1 a 28)
        }
        //si es un mes con 31 dias
        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            dia = 1 + sortea.nextInt(31);      // sortea (1 a 31)
        }
        else{ //si es un mes con 30 dias
            dia = 1 + sortea.nextInt(30);      // sortea (1 a 30)
        }
        
        
        String dataNascimento = dia + "/" + mes + "/" + ano;
        return new Aluno(nome, matricula, dataNascimento); // devuelve poronto para constrir el objeto.
    }
        
}
