import java.io.*;
import javax.swing.*;

public class pract1b{

    public static void main(String[] args){

        new NewAlumno("","","",1,"");

        int i,promedioGrupo=0,contador=0;
        int total= Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de alumnos que vas a dar de alta al sistema "));

    Alumno al[]= new Alumno[total];

    for(i=0;i<total;i++){

             al[i] = new Alumno();
             al[i].nombre = JOptionPane.showInputDialog("Nombre del Alumno nuevo: " + (i +1));
			 al[i].promedioPoo=Integer.parseInt(JOptionPane.showInputDialog("promedioPoo del Alumno nuevo : " + (i + 1)));
             al[i].direccion = JOptionPane.showInputDialog("Direccion del Alumno nuevo: " + (i +1));
             al[i].sexo = JOptionPane.showInputDialog("Sexo del Alumno nuevo: " + (i +1));
			 al[i].telefono = JOptionPane.showInputDialog("Telefono del Alumno nuevo: " + (i +1));
    }

    for(i=0;i<total;i++){
		contador=contador+1;
		JOptionPane.showMessageDialog(null, "Nombre: " + al[i].nombre + ", Sexo: " + al[i].sexo + ", Direccion: " + al[i].direccion
		+ ", Promdio: " + al[i].promedioPoo + ", Telefono: " + al[i].telefono + "\n");
		promedioGrupo+=al[i].promedioPoo;
    }
    
    promedioGrupo=promedioGrupo/(contador);
    JOptionPane.showMessageDialog(null, "promedio del grupo " + promedioGrupo);
    
    }
}

class Alumno {
    String nombre, telefono, direccion, sexo;
    int promedioPoo;
   }

class NewAlumno {
    String nombre, sexo, direccion, telefono;
     int promedioPoo;
 
     public NewAlumno(String in1, String in2, String in3, int in4, String in5){
         nombre=in1;
         sexo=in2;
         direccion = in3;
         promedioPoo=in4;
         telefono=in5;
     }
     public String toString(){
        return nombre;
    }
    
    public String getSexo(){
    
        return sexo;
    
    }
    public String getDireccion(){

        return direccion;

    }
	public String getTelefono() {
		return telefono;
	}
    public int getpromedioPoo(){

        return promedioPoo;

    }
}    