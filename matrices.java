import java.io.*;
import javax.swing.*;

public class matrices{

    public static void main(String[] args){

        MatrizInt m1=new MatrizInt(3,2);
        MatrizFloat m2=new MatrizFloat(2,3);
        m1.initMatriz();
        m1.printMatriz();
        m2.initMatriz();
        m2.printMatriz();
    }

}

class Matriz{
    int filas;
    int columnas;

    public Matriz(int f, int c){
        filas=f;
        columnas=c;
    }

}

class MatrizInt extends Matriz{
    int arre[][];
    

    public MatrizInt(int f, int c){
        super(f, c);
        arre=new int[filas][columnas];
    }

    public void initMatriz(){
        String result="";
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                arre[i][j]=(int)Math.floor(Math.random()*10);
                result+=arre[i][j]+"  ";
            }
            result+="\n";
        }
        JOptionPane.showMessageDialog(null, result,"Matriz Int",3);
    }

    public void printMatriz(){
        int i,j;
        System.out.print("Matriz Int\n");
        for(i=0;i<filas;i++){
            for(j=0;j<columnas;j++){
                System.out.print(arre[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }

}

class MatrizFloat extends Matriz{
    float arre[][];

    public MatrizFloat(int f, int c){
        super(f, c);
        arre=new float[filas][columnas];
    }

    public void initMatriz(){
        String result="";
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                arre[i][j]=(float)(Math.floor(Math.random()*100)/10);
                result+=arre[i][j]+"  ";
            }
            result+="\n";
        }
        JOptionPane.showMessageDialog(null, result,"Matriz Float",3);
    }

    public void printMatriz(){
        int i,j;
        System.out.print("\n\nMatriz Float\n");
        for(i=0;i<filas;i++){
            for(j=0;j<columnas;j++){
                System.out.print(arre[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }

}
