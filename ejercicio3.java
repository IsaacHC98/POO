import java.io.*;
import javax.swing.*;


public class ejercicio3{

    public static void main(String[] args){

        int i,promedioGrupo=0,contador=0;
        int totalAl=Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de alumnos que vas a dar de alta "));//Se pregunta por el numero
        int totalPr=Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de profesores que vas a dar de alta "));//de alumnos y profesores

    Alumno al[]=new Alumno[totalAl]; //Se declara un arreglo de alumnos del tamano que se indico al principio
    Profesor pr[]=new Profesor[totalPr];//Lo mismo pero para los profesores

    for(i=0;i<totalAl;i++){
        //Este ciclo pregunta por toda la informacion de los alumnos que se daran de alta en el sistema.
        al[i] = new Alumno();
        al[i].setNombre(JOptionPane.showInputDialog("Nombre del Alumno nuevo: " + (i +1)));
        al[i].setCorreo(JOptionPane.showInputDialog("Correo del Alumno nuevo: " + (i +1)));
        al[i].setTelefono(JOptionPane.showInputDialog("Telefono del Alumno nuevo: " + (i +1)));
        al[i].setDireccion(JOptionPane.showInputDialog("Direccion del Alumno nuevo: " + (i +1)));
        al[i].setGenero(JOptionPane.showInputDialog("Genero del Alumno nuevo: " + (i +1)));
        al[i].setMatricula(JOptionPane.showInputDialog("Matricula del Alumno nuevo: " + (i +1)));
        al[i].setPromedio(Float.parseFloat(JOptionPane.showInputDialog("Promedio del Alumno nuevo : " + (i + 1))));
    }

    for(i=0;i<totalPr;i++){
        //Este ciclo pregunta por toda la informacion de los profesores que se daran de alta en el sistema.
        pr[i] = new Profesor();
        pr[i].setNombre(JOptionPane.showInputDialog("Nombre del Profesor nuevo: " + (i +1)));
        pr[i].setCorreo(JOptionPane.showInputDialog("Correo del Profesor nuevo: " + (i +1)));
        pr[i].setTelefono(JOptionPane.showInputDialog("Telefono del Profesor nuevo: " + (i +1)));
        pr[i].setDireccion(JOptionPane.showInputDialog("Direccion del Profesor nuevo: " + (i +1)));
        pr[i].setGenero(JOptionPane.showInputDialog("Genero del Profesor nuevo: " + (i +1)));
        pr[i].setNum_emp(Integer.parseInt(JOptionPane.showInputDialog("Numero de empleado del Profesor nuevo: " + (i+1))));
        pr[i].setSueldo(Float.parseFloat(JOptionPane.showInputDialog("Sueldo del Profesor nuevo: " + (i+1))));
        pr[i].setGrado(JOptionPane.showInputDialog("Grado del Profesor nuevo: " + (i+1)));
    }

    for(i=0;i<totalAl;i++){ //Este ciclo imprime la informacion de todos los alumnos de forma iterativa
		contador=contador+1; //Se cuentan los alumnos
        JOptionPane.showMessageDialog(null, "Nombre: " + al[i].getNombre() + "\nMatricula: " + al[i].getMatricula() + "\nCorreo: " + al[i].getCorreo() + 
        "\nGenero: " + al[i].getGenero() + "\nDireccion: " + al[i].getDireccion() + "\nPromedio: " + al[i].getPromedio() + "\nTelefono: " + al[i].getTelefono() + 
        "\n","Alumno " + (i+1),3);
		promedioGrupo+=al[i].promedio; //Se suman todos los promedios
    }
    
    promedioGrupo=promedioGrupo/(contador); //Se calcula el promedio del grupo y despues lo imprime en pantalla.
    JOptionPane.showMessageDialog(null, "promedio del grupo " + promedioGrupo, "Promedio Grupal",3);
    
    for(i=0;i<totalPr;i++){ //Este ciclo imprime la informacion de todos los profesores de forma iterativa.
        JOptionPane.showMessageDialog(null, "Nombre: " + pr[i].getNombre() + "\nCorreo: " + pr[i].getCorreo() + "\nTelefono: " + pr[i].getTelefono()
        + "\nDireccion: " + pr[i].getDireccion() + "\nGenero: " + pr[i].getGenero() + "\nNumero de empleado: " + pr[i].getNumEmp() + "\nSueldo: "
        + pr[i].getSueldo() + "\nGrado: " + pr[i].getGrado() + "\n", "Profesor " + (i+1),3);
    }

    }
}

class Persona{
    String nombre, correo, telefono, direccion, genero;
    int edad;

    //Sets//
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

    public void setTelefono(String telefono){
        this.telefono=telefono;
    }

    public void setDireccion(String direccion){
        this.direccion=direccion;
    }

    public void setGenero(String genero){
        this.genero=genero;
    }

    public void setEdad(int edad){
        this.edad=edad;
    }
    //Gets//
    public String getNombre(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getGenero(){
        return genero;
    }

    public int getEdad(){
        return edad;
    }
}

class Alumno extends Persona{
    String matricula;
    float promedio;

    //Sets//
    public void setMatricula(String matricula){
        this.matricula=matricula;
    }

    public void setPromedio(float promedio){
        this.promedio=promedio;
    }
    //Gets//
    public String getMatricula(){
        return matricula;
    }

    public float getPromedio(){
        return promedio;
    }
}

class Profesor extends Persona{
    int num_emp;
    float sueldo;
    String grado;

    //Sets//
    public void setNum_emp(int num_emp){
        this.num_emp=num_emp;
    }

    public void setSueldo(float sueldo){
        this.sueldo=sueldo;
    }

    public void setGrado(String grado){
        this.grado=grado;
    }
    //Gets//
    public int getNumEmp(){
        return num_emp;
    }

    public float getSueldo(){
        return sueldo;
    }

    public String getGrado(){
        return grado;
    }
}
