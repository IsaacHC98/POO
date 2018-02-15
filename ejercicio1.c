#include <stdio.h>
#include <stdlib.h>

#define CLEAR() system("CLS") //este define permite limpiar la pantalla cuando se le llame mas adelante.
#define MATERIAS 2 //Aqui se especifica el numero de materias que tendra cada alumno.

typedef struct{ //Esta estructura contiene la informacion de las materias de los alumnos.
    char nombre[30];
    float calificacion;
}calificaciones;

typedef struct{ //Esta estructura contiene la informacion de los alumnos y una estructura como la anterior.
    char matricula[10];
    char nombre[50];
    calificaciones cal[MATERIAS];
    float promedio;
}grupo;

//Prototipos de funciones
void registrar(grupo *alumnos);
void guardar(grupo alumnos);
void imprimir(grupo alumnos);

int main(){
    grupo alumnos;
    char opcion;
        do
    {   CLEAR(); //Menu.
        puts("============================");
        puts("//----------MENU----------//");
        puts("============================\n");
        puts("1) Dar de alta a un alumno");
        puts("2) Mostrar alumnos");
        puts("0) Salir\n");
        printf("Opcion:");
        setbuf(stdin, 0); //Limpiar el buffer para mayor seguridad
        opcion=getchar();

        switch(opcion) //Switch para elegir la funcion.
        {
            case '1':   registrar(&alumnos);
                        guardar(alumnos);
                    break;
            case '2':   imprimir(alumnos);
                    break;
        }
    }while (opcion!=48);
    return 0;
}

//Funcion que te pide los datos de los alumnos que se daran de alta.
void registrar(grupo *alumnos){
    float califTotal=0;
    int i;
    CLEAR(); //Opcion que limpia pantalla.
    printf("Ingrese la matricula del alumno: ");
    setbuf(stdin,0);
    gets(alumnos->matricula); //Se guarda por apuntadores en la estructura de los alumnos.
    printf("Ingrese el nombre del alumno: ");
    setbuf(stdin,0);
    gets(alumnos->nombre);
    for(i=0;i<MATERIAS;i++){ //Se pide la información de las materias, se usa ciclo para poder capturar todas las materias necesarias.
        printf("Ingrese la materia %d: \n",i+1);
        setbuf(stdin,0);
        gets(alumnos->cal[i].nombre);
        printf("Ingrese el promedio de esa materia: \n");
        setbuf(stdin,0);
        scanf("%f",&alumnos->cal[i].calificacion);
        califTotal+=alumnos->cal[i].calificacion; //Se suman los promedios para sacar el promedio general.
    }
    alumnos->promedio=califTotal/MATERIAS; //Se guarda el promedio general del alumno.
    califTotal=0; //Se reinicia la variable para que no haya errores en proximos registros.
    printf("Promedio general: %.2f\n",alumnos->promedio);
    setbuf(stdin,0);
    getchar();
}

//Funcion que guarda en un archivo los registros de los alumnos.
void guardar(grupo alumnos){
    FILE *flujo;
    flujo=fopen("calificaciones.dat","ab"); //Se abre el archivo, si no hay archivo lo crea y si existe escribe al final.
    if(flujo){
        fwrite(&alumnos,sizeof(grupo),1,flujo); //Se escribe en el archivo.
        fclose(flujo);
    }
    else{ //Si no se pudo abrir se manda un mensaje de error.
        printf("ERROR No se pudo abrir el archivo.");
    }
}

//Funcion que imprime los datos de los alumnos.
void imprimir(grupo alumnos){
    FILE *flujo;
    int numAlumnos=0,i;
    float suma=0,promFinal=0;
    flujo=fopen("calificaciones.dat","rb"); //Se abre el archivo en modo de lectura.
    if(flujo){
        while(fread(&alumnos,sizeof(grupo),1,flujo)>0){ //Se leen los bloques del tamano de la estructura.
            printf("\nNOMBRE: %s",alumnos.nombre);
            printf("\nMATRICULA: %s",alumnos.matricula);
            for(i=0;i<MATERIAS;i++){ //Ciclo para imprimir materias y calificaciones.
                printf("\n%s: %.2f",alumnos.cal[i].nombre,alumnos.cal[i].calificacion);
                suma+=alumnos.cal[i].calificacion;
            }
            printf("\nPROMEDIO FINAL: %.2f\n",(float)suma/MATERIAS);
            setbuf(stdin,0);
            getchar();
            promFinal+=(float)suma/MATERIAS; //Se guarda el promedio final de cada alumno para calcular el promedio grupal.
            suma=0;
            numAlumnos++; //Se aumenta el numero total de alumnos
        }
        printf("\nPROMEDIO DEL GRUPO: %.2f",(float)promFinal/numAlumnos); //Se calcula e imprime el promedio grupal.
        getchar();
        fclose(flujo);
    }
    else{
        printf("ERROR No se pudo abrir el archivo.");
    }
}
