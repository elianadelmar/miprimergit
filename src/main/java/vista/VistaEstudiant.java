package vista;
import javax.swing.JOptionPane;

public class VistaEstudiant {

    public int solicitarCantidad() {
        String input = JOptionPane.showInputDialog("Ingrese el número de estudiantes a registrar:");
        if (input == null) return 0;
        return Integer.parseInt(input.trim());
    }

    public int solicitarCodigo(int numeroEstudiante) {
        int codigo = 0;
        while (codigo <= 21000) {
            String input = JOptionPane.showInputDialog("Estudiante #" + numeroEstudiante + "\n Ingrese código (debe ser mayor a 21000):");
            if (input == null) return 0;
            codigo = Integer.parseInt(input.trim());
            if (codigo <= 21000) {
                JOptionPane.showMessageDialog(null, "Error: El código debe ser superior a 21000.");
            }
        }
        return codigo;
    }

    public String solicitarNombre() {
        return JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
    }

    public double solicitarNota(String materia) {
        String input = JOptionPane.showInputDialog("Ingrese la nota de " + materia + " (0.0 - 5.0):");
        if (input == null) return 0.0;
        return Double.parseDouble(input.trim());
    }

    public double solicitarNotaLimite() {
        String input = JOptionPane.showInputDialog("Ingrese la nota límite para filtrar (entre 0.0 y 4.9):");
        if (input == null) return 0.0;
        return Double.parseDouble(input.trim());
    }

    public double solicitarBonificacion() {
        String input = JOptionPane.showInputDialog("Ingrese la cifra de incremento para Desarrollo (entre 0.0 y 0.5):");
        if (input == null) return 0.0;
        return Double.parseDouble(input.trim());
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}

