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
    public static String opcion;
    public static Scanner leer = new Scanner(System.in);
    
    //variables publicas para arreglos y matrices
    public static String[][] bodega_1=new String[21][6];
    public static String[][] bodega_2=new String[21][6];
    public static String[][] bodega_3=new String[21][6];
    public static String[][] bodega_4=new String[21][6];
    public static String[][] bodega_5=new String[21][6];
    public static String[][] bodega_6=new String[21][6];
    
    public static void main(String[] args) {
        
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
                            opcion = leer.next();
                            switch(opcion){
                            case "1":
                                System.out.println("Bodega seleccionada: "+opcion);
                                bodega_1[0][0]="B1";
                                bodega_1[1][1]="bodega 1 activa";
                                System.out.println(bodega_1[1][1]);
                                
                                
                                System.out.println("probando impresion de tablas... con printf");///PRUEBAS EN HUMANOS :v
        //el 20 son el numero de espacios que quedaran.. si quiero ingresar 4 columnas tendre que agregar otro "%-20s antes de \n→ejemplo sacado de: http://ingmmurillo.blogspot.com/2010/01/utilizacion-del-metodo-printf-para.html
                                System.out.printf("%-20s%-20s%-20s\n",bodega_1[0][0],bodega_1[0][1],bodega_1[0][2]);
                                break;
                       
                            case "2":
                                System.out.println("Bodega seleccionada: "+opcion);
                                bodega_2[0][0]="B5";
                                bodega_2[1][1]="bodega 2 activa";
                                System.out.println(bodega_2[1][1]);
                                break;
                       
                            case "3":
                                System.out.println("Bodega seleccionada: "+opcion);
                                bodega_3[0][0]="B3";
                                bodega_3[1][1]="bodega 3 activa";
                                System.out.println(bodega_3[1][1]);
                                break;
                       
                            case "4":
                                System.out.println("Bodega seleccionada: "+opcion);
                                bodega_4[0][0]="B4";
                                bodega_4[1][1]="bodega 4 activa";
                                System.out.println(bodega_4[1][1]);
                                break;
                       
                            case "5":
                                System.out.println("Bodega seleccionada: "+opcion);
                                bodega_5[0][0]="B5";
                                bodega_5[1][1]="bodega 5 activa";
                                System.out.println(bodega_5[1][1]);
                                break;
                       
                            case "6":
                                System.out.println("Bodega seleccionada: "+opcion);
                                bodega_6[0][0]="B6";
                                bodega_6[1][1]="bodega 6 activa";
                                System.out.println(bodega_6[1][1]);
                                break;
                            
                            default:
                                System.out.println("\033[31m Porfavor ingrese # de bodega existente (1-6)");
                                datos_prueba();
                                opcion="1";
                                break;
                            }
            
                            System.out.println("------------------------");
                            
                            
                            
                default: System.err.println("Error... Ingrese valor numero");
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
            
        }
    
    
    
    }
    
    
    

