/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201612332;

import java.util.Scanner;

/**
 *
 * @author mrcar
 */
public class menu {

    //Variables publicas y estaticas para navegacion...
    public static String opcion;//
    public static int num_bodega;
    public static int num_productos;
    public static Scanner leer = new Scanner(System.in);
    
    //variables publicas para arreglos y matrices
    public static String[][] bodega_1=new String[6][21];
    public static String[][] bodega_2=new String[6][21];
    public static String[][] bodega_3=new String[6][21];
    public static String[][] bodega_4=new String[6][21];
    public static String[][] bodega_5=new String[6][21];
    public static String[][] bodega_6=new String[6][21];
    
    public static void main(String[] args) {
        plantilla_tablas();
        menu_principal();
        
        
    }
    
    public static void menu_principal() {
        System.out.println("------------------------");
        System.out.println("║-----Menu-----║");
        System.out.println("║1|Datos de prueba");
        System.out.println("║2|Traslados de bodega");
        System.out.println("║3|Reabastecimiento");
        System.out.println("║4|Salida de productos");
        System.out.println("║5|Kardex");
        System.out.println("║6|Reportes");
        System.out.println("║7|Mostrar Bodegas");
        System.out.println("║8|\033[31mSalir");//el codigo ante puesto \033[34m es para pintar ROJO
        System.out.println("\033[34m→Ingrese valor de opcion:");//el codigo ante puesto \033[34m es para pintar AZUL
        System.out.println("\033[30m------------------------");//el codigo ante puesto \033[30m regresa al colo NEGRO
        
        
        opcion = leer.next();
        
        
        switch(opcion){
            
            case "1":   datos_prueba();
            break;
            
            case "2":   traslados_bodega();
            break;
            
            case "3":   reabastecimiento();
            break;
            
            case "4":   salida_productos();
            break;
            
            case "5":   kardex();
            break;
            
            case "6":   reportes();
            break;
            
            case "7":   mostrar_bodegas();
            break;
            
            case "8":   System.gc();
                        System.exit(0);
                        break;
            default: System.err.println("Ingrese valor numerico");
            
                     menu_principal();
                     break;
                     
        
        
            
            
        }
    }
    
        
public static void datos_prueba(){
                        System.out.println("------------------------");
                        System.out.println("║-----Datos de Prueba-----║");
                        System.out.println("║1|Ingresar Parametros");
                        System.out.println("║2|Limpiar Bodegas");
                        System.out.println("║3|Regresar");
                        System.out.println("------------------------");
        
        opcion = leer.next();
            switch(opcion){
                case "1":   System.out.println("------------------------");
                            System.out.println("║-----Ingreso de Parametros-----║");
                            //pruebas para tablas de datos
                            
                            System.out.println("→Ingrese # de bodega a llenar:");
                            num_bodega = leer.nextInt();
                            ////Inicio para el ingreso de productos
                                           
                            System.out.println("→Ingrese # de productos a ingresar (15-75):");
                            num_productos=leer.nextInt();
                            while(num_productos<=14 || num_productos>=76 ){
                                    System.out.println("\033[31mSolamente puedre ingresar de 15 a 75 productos...\033[30m");
                                    num_productos=leer.nextInt();
                            }
                             System.out.println("\033[32m♦Se ingresaron "+num_productos+" productos aleatoriamente en bodega #"+num_bodega+"\033[30m");
                            switch(num_bodega){
                                case 1:
                                System.out.println("Bodega seleccionada: #"+num_bodega);
                                
        

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_1.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_1[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_1[x][y]);
                                            if (y!=bodega_1[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("termina impresion de prueba en maquinas");
/// FIN EN MAQUINAS
                                
                                break;
                                
                                    
                       
                                case 2:
                                System.out.println("Bodega seleccionada: "+opcion);
                                bodega_1[0][0]="|\033[32mB1\033[30m|";//nombre asignado en la posicion 0,0 abreviado como BODEGA 1
        
                                
        

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_1.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_1[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_1[x][y]);
                                            if (y!=bodega_1[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("termina impresion de prueba en maquinas");
                                break;
                       
                                case 3:
                                System.out.println("Bodega seleccionada: "+opcion);
                                bodega_1[0][0]="|\033[32mB1\033[30m|";//nombre asignado en la posicion 0,0 abreviado como BODEGA 1
        

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_1.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_1[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_1[x][y]);
                                            if (y!=bodega_1[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("termina impresion de prueba en maquinas");
                                break;
                       
                                case 4:
                                System.out.println("Bodega seleccionada: "+opcion);
                                

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_1.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_1[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_1[x][y]);
                                            if (y!=bodega_1[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("termina impresion de prueba en maquinas");
                                break;
                       
                                case 5:
                                System.out.println("Bodega seleccionada: "+opcion);
                                

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_1.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_1[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_1[x][y]);
                                            if (y!=bodega_1[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("termina impresion de prueba en maquinas");
                                break;
                       
                                case 6:
                                System.out.println("Bodega seleccionada: "+opcion);
                                

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_1.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_1[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_1[x][y]);
                                            if (y!=bodega_1[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("termina impresion de prueba en maquinas");
                                break;
                            
                                default:
                                System.out.println("\033[31m Porfavor ingrese # de bodega existente (1-6)");
                                datos_prueba();
                                
                                break;
                            }
                                
            
                            System.out.println("------------------------");
                            break;//freno de caso 1 para el programa datos de prueba
                            
                case "2": System.out.println("------------------------");
                            System.out.println("║-----Vaciar Bodegas-----║");
                            //pruebas para tablas de datos
                            
                            System.out.println("→Ingrese # de bodega a vaciar:");
                            num_bodega = leer.nextInt();
                            System.out.println("La bodega #"+num_bodega+" sera vaciada...");
                            System.out.println("Desea continuar?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            opcion = leer.next();
                            switch(opcion){
                                case "1":   System.out.println("\033[35m•••Vaciando");
                                            System.out.println("→Bodega #"+num_bodega+" vacia \033[30m");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_1[x][y]="-";
                                            }
                                        }
                                        datos_prueba();       
                                    break;
                                    
                                case "2":
                                    System.out.println("☺ Regresando...");
                                    datos_prueba();
                                    break;
                            }
                
                break;
                
                
                default: System.err.println("Error... Ingrese valor numero");
                    System.out.println(" regresando a datos prueba");
                         datos_prueba();
                         break;
            }
            }

        
        
        public static void traslados_bodega(){
            
        }
        
        public static void reabastecimiento(){
            
        }
        
        public static void salida_productos(){
            
        }
        
        public static void kardex(){
            
        }
        
        public static void reportes(){
            
        }
        
        public static void mostrar_bodegas(){
            System.out.println("\033[34m|♣|MOSTRANDO BODEGA #1\033[30m");
            
            for (int x=0; x < bodega_1.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_1[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_1[x][y]);
                                            if (y!=bodega_1[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
            System.out.println("");
            System.out.println("\033[34m|♣|MOSTRANDO BODEGA #2\033[30m");
            
            for (int x=0; x < bodega_2.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_2[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_2[x][y]);
                                            if (y!=bodega_2[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
            System.out.println("");
            System.out.println("\033[34m|♣|MOSTRANDO BODEGA #3\033[30m");
            
            for (int x=0; x < bodega_3.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_3[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_3[x][y]);
                                            if (y!=bodega_3[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
            System.out.println("");
            System.out.println("\033[34m|♣|MOSTRANDO BODEGA #4\033[30m");
            
            for (int x=0; x < bodega_4.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_4[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_4[x][y]);
                                            if (y!=bodega_4[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
            System.out.println("");
            System.out.println("\033[34m|♣|MOSTRANDO BODEGA #5\033[30m");
            
            for (int x=0; x < bodega_5.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_5[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_5[x][y]);
                                            if (y!=bodega_5[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
            System.out.println("");
            System.out.println("\033[34m|♣|MOSTRANDO BODEGA #6\033[30m");
          
            for (int x=0; x < bodega_6.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_6[x].length; y++) {
                                        System.out.printf ("%-4s",bodega_6[x][y]);
                                            if (y!=bodega_6[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
            System.out.println("-----------------------------");
            System.out.println("☺ Regresando a menu pricipal");
            System.out.println("\033[34m→INGRESE CUALQUIER CARACTER PARA CONTINUAR...\033[30m");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            menu.main(null);
                                            break;
                                    }
                                    
        }

    public static void plantilla_tablas() { //este metodo tipo plantilla solamente cargará la primera fila y primera columna...
        //nombre asignado en la posicion 0,0 abreviado como BODEGA 1                        
                                        bodega_1[0][0]="|\033[32mB1\033[30m|";
                                        bodega_2[0][0]="|\033[32mB2\033[30m|";
                                        bodega_3[0][0]="|\033[32mB3\033[30m|";
                                        bodega_4[0][0]="|\033[32mB4\033[30m|";
                                        bodega_5[0][0]="|\033[32mB5\033[30m|";
                                        bodega_6[0][0]="|\033[32mB6\033[30m|";
       //llenado automatico para la primera fila que identifica a los espacios de 1-20 en cada columna  
                                        for(int y=0;y<20;y++){
                                        bodega_1[0][y+1]=("|\033[35mE"+(y+1))+"\033[30m|";
                                        }
                                        for(int y=0;y<20;y++){
                                        bodega_2[0][y+1]=("|\033[35mE"+(y+1))+"\033[30m|";
                                        }
                                        for(int y=0;y<20;y++){
                                        bodega_3[0][y+1]=("|\033[35mE"+(y+1))+"\033[30m|";
                                        }
                                        for(int y=0;y<20;y++){
                                        bodega_4[0][y+1]=("|\033[35mE"+(y+1))+"\033[30m|";
                                        }
                                        for(int y=0;y<20;y++){
                                        bodega_5[0][y+1]=("|\033[35mE"+(y+1))+"\033[30m|";
                                        }
                                        for(int y=0;y<20;y++){
                                        bodega_6[0][y+1]=("|\033[35mE"+(y+1))+"\033[30m|";
                                        }
                                        
        //llenado automatico para la primera columna que identifica a los productos de 1-5 en cada fila  
                                        for(int x=1;x<6;x++){
                                        bodega_1[x][0]=("|\033[34mP"+(x+1))+"\033[30m|";
                                        }
                                        for(int x=1;x<6;x++){
                                        bodega_2[x][0]=("|\033[34mP"+(x+1))+"\033[30m|";
                                        }
                                        for(int x=1;x<6;x++){
                                        bodega_3[x][0]=("|\033[34mP"+(x+1))+"\033[30m|";
                                        }
                                        for(int x=1;x<6;x++){
                                        bodega_4[x][0]=("|\033[34mP"+(x+1))+"\033[30m|";
                                        }
                                        for(int x=1;x<6;x++){
                                        bodega_5[x][0]=("|\033[34mP"+(x+1))+"\033[30m|";
                                        }
                                        for(int x=1;x<6;x++){
                                        bodega_6[x][0]=("|\033[34mP"+(x+1))+"\033[30m|";
                                        }
                                      
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_1[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_1[x][y]="\033[31m-\033[30m";
                                            }
                                            }
                                        }
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_2[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_2[x][y]="\033[31m-\033[30m";
                                            }
                                            }
                                        }
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_3[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_3[x][y]="\033[31m-\033[30m";
                                            }
                                            }
                                        }
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_4[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_4[x][y]="\033[31m-\033[30m";
                                            }
                                            }
                                        }
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_5[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_5[x][y]="\033[31m-\033[30m";
                                            }
                                            }
                                        }
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_6[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_6[x][y]="\033[31m-\033[30m";
                                            }
                                            }
                                        }
    }
 



}
    
    
    

