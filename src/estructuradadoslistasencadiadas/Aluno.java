package estructuradadoslistasencadiadas;

/**
 * Instancia un alumno con nombre completo, matrícula y fecha de nacimiento.
 * <p>
 * Incluye un método {@link #toString()} para mostrar la información en formato legible en la lista encadiada.
 * </p>
 *
 * <p><b>Ejemplo de uso:</b></p>
 * <pre>{@code
 * Aluno alumno = new Aluno("Ana Almeida", "1234567-8", "10/05/2000");
 * System.out.println(alumno);                      
 * Saida:
 * Ana Almeida | 1234567-8 | 10/05/2000
 * }</pre>
 *
 * @author  Aaron FullStack
 * @version 1.0
 */
public class Aluno {
    
    private String nome;
    private String matricula;
    private String dataNascimento;
    
    /**
     * Construye un nuevo objeto {@link Aluno}.
     *
     * @param nome           Nombre completo del alumno.
     * @param matricula      Matrícula del alumno en formato 1234567-8.
     * @param dataNascimento Fecha de nacimiento en formato dd/MM/yyyy.
     */
    public Aluno(String nome, String matricula, String dataNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }

    /**
     * Obtiene el nombre completo del alumno.
     *
     * @return el nombre del alumno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Reescribe el metodo toString para grabar los objetos en las listas encadiadas
     * <p>
     * El formato es: <code>nome | matricula | dataNascimento</code>.
     * </p>
     *
     * @return datos en formato CSV.
     */
    @Override
    public String toString() {
        return nome + "," + matricula + "," + dataNascimento;
    }
}
