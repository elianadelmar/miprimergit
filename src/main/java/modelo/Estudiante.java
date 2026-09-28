package modelo;

  

    public class Estudiante {

        private int codigo;
        private String nombre;
        private double notaDesarrollo;
        private double notaMatematica;

        public Estudiante(int codigo, String nombre, double notaDesarrollo, double notaMatematica) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.notaDesarrollo = notaDesarrollo;
            this.notaMatematica = notaMatematica;
        }  

        public double calcularDefinitiva() {
            return (this.notaDesarrollo * 0.60) + (this.notaMatematica * 0.40);
        }
// Método de negocio: Determinar aprobación (&gt;= 3.5) 

        public String calcularAprobacion() {
            if (calcularDefinitiva() >= 3.5) 
                return "SI APRUEBA";
             else {
                return "NO APRUEBA";
            }

        }
    


    

    public void incrementarNotaDesarrollo(double bonificacion) {
        this.notaDesarrollo += bonificacion;
        if (this.notaDesarrollo > 5.0) {
            
          this.notaDesarrollo = 5.0; 
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaDesarrollo() {
        return notaDesarrollo;
    }

    public void setNotaDesarrollo(double notaDesarrollo) {
        this.notaDesarrollo = notaDesarrollo;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }
    }

              


  
