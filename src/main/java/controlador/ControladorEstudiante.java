package controlador;

import modelo.Estudiante;
import vista.VistaEstudiant;

public class ControladorEstudiante {

    private VistaEstudiant vista;
    private Estudiante[] arregloEstudiantes;

    public ControladorEstudiante(VistaEstudiant vista) {
        this.vista = vista;
    }

    public void iniciar() {
        int cantidad = vista.solicitarCantidad();
        if (cantidad <= 0) {
            vista.mostrarMensaje("Operación cancelada o cantidad inválida.");
            return;
        }
        arregloEstudiantes = new Estudiante[cantidad];
        for (int i = 0; i < arregloEstudiantes.length;
                i++) {
            int codigo = vista.solicitarCodigo(i + 1);
            String nombre = vista.solicitarNombre();
            double notaDesarrollo = vista.solicitarNota("Desarrollo (60%)");
            double notaMatematica = vista.solicitarNota("Matemáticas (40%)");
            arregloEstudiantes[i] = new Estudiante(codigo, nombre, notaDesarrollo, notaMatematica);
        }
        desplegarReporteGeneral();
        double notaLimite = vista.solicitarNotaLimite();
        desplegarFiltradosPorLimite(notaLimite);
        double bonificacion = vista.solicitarBonificacion();
        aplicarIncrementoDesarrollo(bonificacion);
        vista.mostrarMensaje("=== REPORTE TRAS APLICAR INCREMENTO ===");
        desplegarReporteGeneral();
    }

    private void desplegarReporteGeneral() {
        String reporte = "=== REPORTE GENERAL DE ESTUDIANTES ===\\n\\n";
        for (int i = 0; i < arregloEstudiantes.length;
                i++) {
            Estudiante e = arregloEstudiantes[i];
            reporte += "Código: " + e.getCodigo() + "\\n"
        + "Nombre: " + e.getNombre() + "\\n" 
        + "Nota Desarrollo: " + e.getNotaDesarrollo() + "\\n" 
        + "Nota Matemáticas: " + e.getNotaMatematica() + "\\n" 
        + "Definitiva: " + String.format("%.2f", e.calcularDefinitiva()) + "\\n" 
        + "Estado: " + e.calcularAprobacion() + "\\n" + "-----------------------------------\\n";
        }
        vista.mostrarMensaje(reporte);
    }

    private void desplegarFiltradosPorLimite(double notaLimite) {
        String reporte = "=== ESTUDIANTES CON DEFINITIVA SUPERIOR A " + notaLimite + " ===\\n\\n";
        boolean hayCoincidencias = false;
        for (int i = 0; i < arregloEstudiantes.length;
                i++) {
            Estudiante e = arregloEstudiantes[i];
            if (e.calcularDefinitiva() > notaLimite) {
                reporte += "Código: " + e.getCodigo() + " | Nombre: " + e.getNombre() + " | Definitiva: " + String.format("%.2f", e.calcularDefinitiva()) + "\\n";
                hayCoincidencias = true;
            }
        }
        if (!hayCoincidencias) {
            reporte += "Ningún estudiante supera la nota límite indicada.";
        }
        vista.mostrarMensaje(reporte);
    }

    private void aplicarIncrementoDesarrollo(double bonificacion) {
        for (int i = 0; i < arregloEstudiantes.length;
                i++) {
            arregloEstudiantes[i].incrementarNotaDesarrollo(bonificacion);
        }
    }
}
