/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201612332;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author mrcar
 */
public class menu {

    //Variables publicas y estaticas para navegacion...
    public static String opcion;//
    public static int opcion_num;
    public static int num_bodega;
    public static int num_productos;
    
    public static int fila_random;
    public static int columna_random;
    
    
    public static Scanner leer = new Scanner(System.in);
    
    //variables publicas para arreglos y matrices
    public static String[][] bodega_1=new String[6][21];
    public static String[][] bodega_2=new String[6][21];
    public static String[][] bodega_3=new String[6][21];
    public static String[][] bodega_4=new String[6][21];
    public static String[][] bodega_5=new String[6][21];
    public static String[][] bodega_6=new String[6][21];
    
    public static int fila_nueva=1;
    public static String estado_nuevo;//este sera el nombre a colocar en la nueva fila ↑ #correlativo /compra o venta
    public static String[][] kardex = new String[100][7];
    
    public static int num_existencias=0, tot_existencias=0, tot_existencias_anterior=0; //existencias
    
    public static int num_entradas=0, tot_entradas=0; //reabastecimiento manual
    public static int num_salidas=0, tot_salidas=0; //realiar pedido
    
    public static int espacios_b1=100,espacios_b2=100,espacios_b3=100, espacios_b4=100,espacios_b5=100,espacios_b6=100;
    
    public static int bodega_salida ,producto_salida, espacio_salida,  bodega_entrada,  producto_entrada, espacio_entrada;
    
    public static boolean bodega1_llena=false;
    public static boolean bodega2_llena=false;
    public static boolean bodega3_llena=false;
    public static boolean bodega4_llena=false;
    public static boolean bodega5_llena=false;
    public static boolean bodega6_llena=false;
    
    public static boolean estado_traslado=false;
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
        System.out.println("║8|Salir");//el codigo ante puesto \033[34m es para pintar ROJO
        System.out.println("->Ingrese valor de opcion:");//el codigo ante puesto \033[34m es para pintar AZUL
        System.out.println("------------------------");//el codigo ante puesto \033[30m regresa al colo NEGRO
 
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
                            try{//inicio de try
                            System.out.println("->Ingrese # de bodega a llenar:");
                            
                                Scanner leer_num = new Scanner(System.in);
                            num_bodega = leer_num.nextInt();
                           
                            while(num_bodega<=0 || num_bodega>=7){
                                System.out.println("Solamente existen bodegas de 1-6...");
                                    num_bodega=leer_num.nextInt();     
                            }
                            
                            
                            ////Inicio para el ingreso de productos
                                           
                            System.out.println("->Ingrese # de productos a ingresar (15-75):");
                            num_productos=leer_num.nextInt();
                            
                            while(num_productos<=14 || num_productos>=76 ){
                                    System.out.println("Solamente puede ingresar de 15 a 75 productos...");
                                    num_productos=leer_num.nextInt();
                                    
                            }
                            
                             System.out.println("♦Se ingresaron "+num_productos+" productos aleatoriamente en bodega #"+num_bodega+"");
                            }catch (Exception e){ //termina catch y reinicia el programa cuando haya un valor que no sea numerico al ingresar bodegas
                                System.err.println("Error: "+e);
                                System.out.println("Ingrese valor numerico");
                                System.err.println("Reiniciando...");
                                datos_prueba();
                            }
                          
                                         num_existencias=num_productos; //dato para kardex
                             tot_existencias=num_existencias+tot_existencias_anterior;
                             
            //metodo kardex para el ingreso por datos de prueba
                            tot_existencias_anterior=tot_existencias_anterior+tot_existencias;// guardara un nuevo valor de las existencias
            kardex[fila_nueva][0]="Saldo Ante.";
            kardex[fila_nueva][5]=""+num_existencias+"         ";
            
            kardex[fila_nueva][6]=""+tot_existencias+"         ";
            fila_nueva++; //contador de filas
            //contador de existencia anterior
            //fin kardex
//---------------------------------------------------------------------------------------------------------------------------------------------------
                             switch(num_bodega){
                                
                        case 1://CARGARA LA BODEGA 1
                                carga_bodega1();
                                imprime_Ebodega();
                                break;

                        case 2: //CARGARA LA BODEGA 2
                                carga_bodega2();
                                imprime_Ebodega();
                                break;
                       
                        case 3: //CARGARA LA BODEGA 3
                                carga_bodega3();
                                imprime_Ebodega();
                                break;
                                
                        case 4: //CARGARA LA BODEGA 4
                                carga_bodega4();
                                imprime_Ebodega();
                                break;
                       
                        case 5: //CARGARA LA BODEGA 5
                                carga_bodega5();
                                imprime_Ebodega();
                                break;
                       
                        case 6: //CARGARA LA BODEGA 6
                                carga_bodega6();
                                imprime_Ebodega();
                                break;
                            
                        default:
                                System.out.println(" Porfavor ingrese # de bodega existente (1-6)");
                                datos_prueba();
                                
                                break;
                            }

                            System.out.println("------------------------");
                            break;//freno de caso 1 para el programa datos de prueba
                            
                case "2":   System.out.println("------------------------");
                            System.out.println("║-----Vaciar Bodegas-----║");
                            //pruebas para tablas de datos
                            
                            System.out.println("->Ingrese # de bodega a vaciar:");
                            num_bodega = leer.nextInt();
                            System.out.println("La bodega #"+num_bodega+" sera vaciada...");
                            System.out.println("Desea continuar?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            opcion = leer.next();
                            switch(opcion){
                                case "1":  
                                    if(num_bodega==1){ System.out.println("•••Vaciando");
                                            System.out.println("->Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_1[x][y]="-";
                                                                }
                                                                }
                                        datos_prueba();
                                }
                                    if(num_bodega==2){ System.out.println("•••Vaciando");
                                            System.out.println("->Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_2[x][y]="-";
                                                                }
                                                                }
                                        datos_prueba();
                                }
                                    if(num_bodega==3){ System.out.println("•••Vaciando");
                                            System.out.println("->Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_3[x][y]="-";
                                                                }
                                                                }
                                        datos_prueba();
                                }
                                    if(num_bodega==4){ System.out.println("•••Vaciando");
                                            System.out.println("->Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_4[x][y]="-";
                                                                }
                                                                }
                                        datos_prueba();
                                }
                                    if(num_bodega==5){ System.out.println("•••Vaciando");
                                            System.out.println("->Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_5[x][y]="-";
                                                                }
                                                                }
                                        datos_prueba();
                                }
                                    if(num_bodega==6){ System.out.println("•••Vaciando");
                                            System.out.println("->Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_6[x][y]="-";
                                                                }
                                                                }
                                        datos_prueba();
                                }
                                    
                                
                                    break;
                                    
                                case "2":
                                    System.out.println("☺ Regresando...");
                                    datos_prueba();
                                    break;
                            }
                
                            break;
                
                case "3":   System.out.println("Regresando a menu principal...");
                            menu.menu_principal();
                            break;
                            
                            
                default: System.err.println("Error... Ingrese valor numero");
                    System.out.println(" regresando a datos prueba");
                         datos_prueba();
                         break;
            }                            

            }
            

        
        
        public static void traslados_bodega(){
            System.out.println("------------------------");
                        System.out.println("║-----Datos de Prueba-----║");
                        System.out.println("║1|Verificar posibles traslados");
                        System.out.println("║2|Realizar traslado");
                        System.out.println("║3|Regresar");
                        System.out.println("------------------------");
        
            opcion = leer.next();
            switch(opcion){
            
                case "1":   System.out.println("║----Posibles traslados-----║");
                            System.out.println("Bodega #1 tiene:"+espacios_b1+" espacios disponibles");
                            System.out.println("Bodega #2 tiene:"+espacios_b2+" espacios disponibles");
                            System.out.println("Bodega #3 tiene:"+espacios_b3+" espacios disponibles");
                            System.out.println("Bodega #4 tiene:"+espacios_b4+" espacios disponibles");
                            System.out.println("Bodega #5 tiene:"+espacios_b5+" espacios disponibles");
                            System.out.println("Bodega #6 tiene:"+espacios_b6+" espacios disponibles");
                            traslados_bodega();
                            break;
                
                case "2":   try{
                            System.out.println("║----Realizar traslados----║");
                            System.out.println("<-Trasladar| De bodega #");
                            opcion_num= leer.nextInt();
                            while(opcion_num<=0 || opcion_num>=7){
                                System.out.println("Solamente existen bodegas de 1-6...");
                                    opcion_num= leer.nextInt();
                            }
                            bodega_salida=opcion_num;
                            
                            System.out.println("<-Trasladar| El producto P#");
                            opcion_num= leer.nextInt();
                            while(opcion_num<=0 || opcion_num>=6){
                                System.out.println("Solamente existen productos de 1-5...");
                                    opcion_num= leer.nextInt();
                            }
                            
                            producto_salida=opcion_num;
                            
                            System.out.println("<-Trasladar| En espacio E#");
                            opcion_num= leer.nextInt();
                            while(opcion_num<=0 || opcion_num>=21){
                                System.out.println("Solamente existen espacios de 1-20...");
                                    opcion_num= leer.nextInt();
                            }
                            espacio_salida=opcion_num;
                            //verificara los datos ingresados para trasladar//si no hay errores proseguira...
                            
                            //fin verificador
                            System.out.println("-------------------------");
                            System.out.println("->Ingresar| A bodega #");
                            opcion_num= leer.nextInt();
                            while(opcion_num<=0 || opcion_num>=7){
                                System.out.println("Solamente existen bodegas de 1-6...");
                                    opcion_num= leer.nextInt();
                            }
                            bodega_entrada=opcion_num;
                            
                            System.out.println("->Ingresar| El producto P#");
                            opcion_num= leer.nextInt();
                            while(opcion_num<=0 || opcion_num>=6){
                                System.out.println("Solamente existen productos de 1-5...");
                                    opcion_num= leer.nextInt();
                            }
                            while(producto_salida!=opcion_num){
                                System.out.println("El producto debe coincidir con Producto #"+producto_salida+"");
                                    opcion_num= leer.nextInt();
                            }
                            producto_entrada=opcion_num;
                            
                            System.out.println("->Ingresar| En espacio E#");
                            opcion_num= leer.nextInt();
                            while(opcion_num<=0 || opcion_num>=221){
                                System.out.println("Solamente existen espacios de 1-20...");
                                    opcion_num= leer.nextInt();
                            }
                            espacio_entrada=opcion_num;
                            
                            
System.out.println("Se trasladara de Bodega #"+bodega_salida+" a Bodega #"+bodega_entrada+" el Producto #"+producto_salida+"|"+producto_entrada+" de Espacio #"+espacio_salida+" a Espacio #"+espacio_entrada+"...");
                    System.out.println("Verificando solicitud...");                         
                    
                    
                    //verificara los datos ingresados para trasladar//si no hay errores proseguira...
                            verificador_bodegas();
                            if(estado_traslado==true){
                        System.out.println("Solicitud completada");
                    }else if(estado_traslado==false){
                        System.out.println("Solicitud fallida");
                    }
                            //fin verificador
                            
                            break;
                            }catch(Exception e){
                                System.err.println("Error: "+e);
                                System.out.println("Ingrese valor numerico");
                                
                            }
                            
                            
                case "3": System.out.println("<-- Regresando");
                menu_principal();
                break;
                default: System.out.println("Ingrese Opcion valida");
                            System.out.println("Reiniciando..");
                            traslados_bodega();
                            break;
                            
            }
        }
        
        public static void reabastecimiento(){
            
        }
        
        public static void salida_productos(){
            
        }
        
    public static void kardex(){
            System.out.println("♦|░MOSTRANDO KARDEX░");
            
            
            for (int x=0; x < fila_nueva; x++) {
                                    System.out.print("|");
                                    for (int y=0; y < kardex[x].length; y++) {
                                        if(kardex[x][y]==null){
                                            kardex[x][y]="-          ";
                                        }
                                        System.out.printf ("%-8s |",kardex[x][y]);
                                            if (y!=kardex[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t |");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
            
            System.out.println("→INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            menu_principal();
                                            break;
                                    }
        }
        
        public static void reportes(){
            
        }
        
    public static void mostrar_bodegas(){
            System.out.println("|♣|MOSTRANDO BODEGA #1");
            
            for (int x=0; x < bodega_1.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_1[x].length; y++) {
                                        System.out.print(bodega_1[x][y]);
                                            if (y!=bodega_1[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }System.out.println("Espacio en bodega: #"+(espacios_b1));
            System.out.println("");
            System.out.println("|♣|MOSTRANDO BODEGA #2");
            
            for (int x=0; x < bodega_2.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_2[x].length; y++) {
                                        System.out.print(bodega_2[x][y]);
                                            if (y!=bodega_2[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular                                              
                                            }
                                                                                }
                                System.out.println("");
                                
                                }System.out.println("Espacio en bodega: #"+(espacios_b2));
            System.out.println("");
            System.out.println("|♣|MOSTRANDO BODEGA #3");
            
            for (int x=0; x < bodega_3.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_3[x].length; y++) {
                                        System.out.print(bodega_3[x][y]);
                                            if (y!=bodega_3[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }System.out.println("Espacio en bodega: #"+(espacios_b3));
            System.out.println("");
            System.out.println("|♣|MOSTRANDO BODEGA #4");
            
            for (int x=0; x < bodega_4.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_4[x].length; y++) {
                                        System.out.print(bodega_4[x][y]);
                                            if (y!=bodega_4[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }System.out.println("Espacio en bodega: #"+(espacios_b4));
            System.out.println("");
            System.out.println("|♣|MOSTRANDO BODEGA #5");
            
            for (int x=0; x < bodega_5.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_5[x].length; y++) {
                                        System.out.print(bodega_5[x][y]);
                                            if (y!=bodega_5[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }System.out.println("Espacio en bodega: #"+(espacios_b5));
            System.out.println("");
            System.out.println("|♣|MOSTRANDO BODEGA #6");
          
            for (int x=0; x < bodega_6.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_6[x].length; y++) {
                                        System.out.print(bodega_6[x][y]);
                                            if (y!=bodega_6[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }System.out.println("Espacio en bodega: #"+(espacios_b6));
            System.out.println("-----------------------------");
            System.out.println("☺ Regresando a menu pricipal");
            System.out.println("→INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            menu.menu_principal();
                                            break;
                                    }
                                    
        }

    public static void plantilla_tablas() { //este metodo tipo plantilla solamente cargará la primera fila y primera columna...
                        
                                        bodega_1[0][0]="|B1|";
                                        bodega_2[0][0]="|B2|";
                                        bodega_3[0][0]="|B3|";
                                        bodega_4[0][0]="|B4|";
                                        bodega_5[0][0]="|B5|";
                                        bodega_6[0][0]="|B6|";
                                       
       //llenado automatico para la primera fila que identifica a los espacios de 1-20 en cada columna  
                                        for(int y=0;y<20;y++){
                                        bodega_1[0][y+1]=("|E"+(y+1))+"|";
                                        }
                                        for(int y=0;y<20;y++){
                                        bodega_2[0][y+1]=("|E"+(y+1))+"|";
                                        }
                                        for(int y=0;y<20;y++){
                                        bodega_3[0][y+1]=("|E"+(y+1))+"|";
                                        }
                                        for(int y=0;y<20;y++){
                                        bodega_4[0][y+1]=("|E"+(y+1))+"|";
                                        }
                                        for(int y=0;y<20;y++){
                                        bodega_5[0][y+1]=("|E"+(y+1))+"|";
                                        }
                                        for(int y=0;y<20;y++){
                                        bodega_6[0][y+1]=("|E"+(y+1))+"|";
                                        }
                                        
        //llenado automatico para la primera columna que identifica a los productos de 1-5 en cada fila  
                                        for(int x=1;x<6;x++){
                                        bodega_1[x][0]=("|P"+(x))+"|";
                                        }
                                        for(int x=1;x<6;x++){
                                        bodega_2[x][0]=("|P"+(x))+"|";
                                        }
                                        for(int x=1;x<6;x++){
                                        bodega_3[x][0]=("|P"+(x))+"|";
                                        }
                                        for(int x=1;x<6;x++){
                                        bodega_4[x][0]=("|P"+(x))+"|";
                                        }
                                        for(int x=1;x<6;x++){
                                        bodega_5[x][0]=("|P"+(x))+"|";
                                        }
                                        for(int x=1;x<6;x++){
                                        bodega_6[x][0]=("|P"+(x))+"|";
                                        }
                                      
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_1[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_1[x][y]="-";
                                                
                                                
                                            }
                                            }
                                        }System.out.println(espacios_b1);
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_2[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_2[x][y]="-";
                                                
                                                
                                            }
                                            }
                                        }
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_3[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_3[x][y]="-";
                                                
                                                
                                            }
                                            }
                                        }
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_4[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_4[x][y]="-";
                                                
                                                
                                            }
                                            }
                                        }
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_5[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_5[x][y]="-";
                                                
                                                
                                            }
                                            }
                                        }
                                        //para llenado automatico de el resto de datos si estan vacios o nullos
                                        for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            if(bodega_6[x][y]==null){//si el valor dentro de la casilla es null lo llenara de otra forma
                                                bodega_6[x][y]="-";
                                                
                                                
                                            }
                                            }
                                        }

                                        
        //configuracion del KARDEX
        kardex[0][0]="Detalle    ";
        kardex[0][1]="Entrada    ";
        kardex[0][2]="Total      ";
        kardex[0][3]="Salida     ";
        kardex[0][4]="Total      ";
        kardex[0][5]="Existencias";
        kardex[0][6]="Total      ";
        
    }
        
        public static void llenado_bodegas(){
            if (num_bodega ==1){
                int contador_prod;
                contador_prod=num_productos;
                espacios_b1=100-num_productos;
                while(contador_prod>0){
                num_randoms();
                    if(bodega_1[fila_random][columna_random]=="-"){//si la cassilla no es null osea no esta ocupada.. la llenara
                        bodega_1[fila_random][columna_random]="B1P"+fila_random+","+columna_random;
                        contador_prod--;
                } else{
                        num_randoms();
                    }
                }
     
            }
            
            if (num_bodega ==2){
                int contador_prod;
                contador_prod=num_productos;
                espacios_b2=100-num_productos;
                while(contador_prod>0){
                num_randoms();
                    if(bodega_2[fila_random][columna_random]=="-"){//si la cassilla no es null osea no esta ocupada.. la llenara
                        bodega_2[fila_random][columna_random]="B2P"+fila_random+","+columna_random;
                        contador_prod--;
                } else{
                        num_randoms();
                    }
                }
            }
            
            if (num_bodega ==3){
                int contador_prod;
                contador_prod=num_productos;
                espacios_b3=100-num_productos;
                while(contador_prod>0){
                num_randoms();
                    if(bodega_3[fila_random][columna_random]=="-"){//si la cassilla no es null osea no esta ocupada.. la llenara
                        bodega_3[fila_random][columna_random]="B3P"+fila_random+","+columna_random;
                        contador_prod--;
                } else{
                        num_randoms();
                    }
                }
            }
            
            if (num_bodega ==4){
                int contador_prod;
                contador_prod=num_productos;
                espacios_b4=100-num_productos;
                while(contador_prod>0){
                num_randoms();
                    if(bodega_4[fila_random][columna_random]=="-"){//si la cassilla no es null osea no esta ocupada.. la llenara
                        bodega_4[fila_random][columna_random]="B4P"+fila_random+","+columna_random;
                        contador_prod--;
                } else{
                        num_randoms();
                    }
                }
     
            }
            
            if (num_bodega ==5){
                int contador_prod;
                contador_prod=num_productos;
                espacios_b5=100-num_productos;
                while(contador_prod>0){
                num_randoms();
                    if(bodega_5[fila_random][columna_random]=="-"){//si la cassilla no es null osea no esta ocupada.. la llenara
                        bodega_5[fila_random][columna_random]="B5P"+fila_random+","+columna_random;
                        contador_prod--;
                }  else{
                        num_randoms();
                    }
                }
            }
            if (num_bodega ==6){
                int contador_prod;
                contador_prod=num_productos;
                espacios_b6=100-num_productos;
                while(contador_prod>0){
                num_randoms();
                    if(bodega_6[fila_random][columna_random]=="-"){//si la cassilla no es null osea no esta ocupada.. la llenara
                        bodega_6[fila_random][columna_random]="B6P"+fila_random+","+columna_random;
                        contador_prod--;
                } else{
                        num_randoms();
                    }
                }
            }
            
        }
        
        public static void num_randoms(){
            fila_random=(int)(Math.random() * 5 + 1); //este solo podra estar comprendido entre la fila 2→6 en el arreglo de 1→5
            columna_random = (int)(Math.random() * 20 + 1); //este solo podra estar comprendido entre columna 2→20 en el arreglo de 1→19
            
        }
 
        public static void imprime_Ebodega(){
            
            System.out.println("Espacios en bodegas: |"+espacios_b1+"|"+espacios_b2+"|"+espacios_b3+"|"+espacios_b4+"|"+espacios_b5+"|"+espacios_b6+"|");
        }
        public static void carga_bodega1(){
         System.out.println("Bodega seleccionada: "+num_bodega);
                                llenado_bodegas();//metodo para llenar bodega
                             

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_1.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_1[x].length; y++) {
                                        System.out.print(bodega_1[x][y]);
                                            if (y!=bodega_1[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("->INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            datos_prueba();
                                            break;
                                    }
    }
        public static void carga_bodega2(){
         System.out.println("Bodega seleccionada: "+num_bodega);
                                llenado_bodegas();//metodo para llenar bodega
                             

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_2.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_2[x].length; y++) {
                                        System.out.print(bodega_2[x][y]);
                                            if (y!=bodega_2[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("->INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            datos_prueba();
                                            break;
                                    }
    }    
        public static void carga_bodega3(){
         System.out.println("Bodega seleccionada: "+num_bodega);
                                llenado_bodegas();//metodo para llenar bodega
                             

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_3.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_3[x].length; y++) {
                                        System.out.print(bodega_3[x][y]);
                                            if (y!=bodega_3[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("->INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            datos_prueba();
                                            break;
                                    }
    }
        public static void carga_bodega4(){
         System.out.println("Bodega seleccionada: "+num_bodega);
                                llenado_bodegas();//metodo para llenar bodega
                             

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_4.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_4[x].length; y++) {
                                        System.out.print(bodega_4[x][y]);
                                            if (y!=bodega_4[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("->INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            datos_prueba();
                                            break;
                                    }
    }    
        public static void carga_bodega5(){
         System.out.println("Bodega seleccionada: "+num_bodega);
                                llenado_bodegas();//metodo para llenar bodega
                             

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_5.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_5[x].length; y++) {
                                        System.out.print(bodega_5[x][y]);
                                            if (y!=bodega_5[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("->INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            datos_prueba();
                                            break;
                                    }
    }
        public static void carga_bodega6() {
       System.out.println("Bodega seleccionada: "+num_bodega);
                                llenado_bodegas();//metodo para llenar bodega
                             

  //PRUEBAS EN MAQUINAS [•_•]→esto imrpimira la matriz completa con espaciado....
                                
                                for (int x=0; x < bodega_6.length; x++) {
                                    System.out.print("");
                                    for (int y=0; y < bodega_6[x].length; y++) {
                                        System.out.print(bodega_6[x][y]);
                                            if (y!=bodega_6[x].length-1) {//cuando imprima la ultima fila pasara a la siguiente
                                                System.out.print("\t");//tabular
                                            }
                                                                                }
                                System.out.println("");
                                }
                                
                                System.out.println("->INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            datos_prueba();
                                            break;
                                    }
    }
    
        public static void verificador_bodegas(){
            //----------------------------------------------------------
            
                
                if(bodega_salida==1 && bodega_1[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }else if(bodega_1[producto_salida][espacio_salida]!="-" && estado_traslado==true ){
                            bodega_1[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B1: Traslado correcto...");
                            estado_traslado = true;
                            espacios_b1--;
     
                    }
            
            
            if( bodega_entrada==1 &&  bodega_1[producto_entrada][espacio_entrada]!="-"){
                            System.out.println("Entrada B1: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            estado_traslado = false;
                        }
            else if (bodega_1[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b1);
                            estado_traslado=true;
                            bodega_1[producto_entrada][espacio_entrada]="B1P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" ingresado" );
                            espacios_b1++;
            }
                        
            //----------------------------------------------------------
            
                
                if(bodega_salida==2 && bodega_2[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }else if(bodega_2[producto_entrada][espacio_entrada]!="-" && estado_traslado==true){
                            bodega_2[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B2: Traslado correcto...");
                            espacios_b2--;
                            estado_traslado = true;
     
                    }
            
            if (bodega_entrada==2 && bodega_2[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b2);
                            estado_traslado=true;
                            bodega_2[producto_entrada][espacio_entrada]="B2P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" ingresado" );
                            espacios_b2++;
            }
                        else if(bodega_2[producto_entrada][espacio_entrada]!="-" ){
                            System.out.println("Entrada B2: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            
                            estado_traslado = false;
                        }
            //----------------------------------------------------------
            
                if(bodega_salida==3 && bodega_3[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }else if(bodega_3[producto_entrada][espacio_entrada]!="-" && estado_traslado==true){
                            bodega_3[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B3: Traslado correcto...");
                            estado_traslado = true;
                            espacios_b3--;
     
                    }
                

            if (bodega_entrada==3 && bodega_3[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b3);
                            estado_traslado=true;
                            bodega_3[producto_entrada][espacio_entrada]="B3P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" ingresado" );
                            espacios_b3++;
            }
                        else if(bodega_3[producto_entrada][espacio_entrada]!="-"){
                            System.out.println("Entrada B3: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            
                            estado_traslado = false;
                        }
            //----------------------------------------------------------
            
                if(bodega_salida==4 && bodega_4[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }else if(bodega_4[producto_entrada][espacio_entrada]!="-" && estado_traslado==true){
                            bodega_4[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B4: Traslado correcto...");
                            espacios_b4--;
                            estado_traslado = true;
     
                    }
                

            if (bodega_entrada==4 && bodega_4[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b4);
                            estado_traslado=true;
                            bodega_4[producto_entrada][espacio_entrada]="B4P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" ingresado" );
                            espacios_b4++;
            }
                        else if(bodega_4[producto_entrada][espacio_entrada]!="-"){
                            System.out.println("Entrada B4: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            
                            estado_traslado = false;
                        }
            //----------------------------------------------------------
            
                if(bodega_salida==5 && bodega_5[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }else if(bodega_5[producto_entrada][espacio_entrada]!="-" && estado_traslado==true){
                            bodega_5[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B5: Traslado correcto...");
                            espacios_b5--;
                            estado_traslado = true;
     
                    }
                

            if (bodega_entrada==5 && bodega_5[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b5);
                            estado_traslado=true;
                            bodega_5[producto_entrada][espacio_entrada]="B5P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" ingresado" );
                            espacios_b5++;
            }
                        else if(bodega_5[producto_entrada][espacio_entrada]!="-"){
                            System.out.println("Entrada B5: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            
                            estado_traslado = false;
                        }
            //----------------------------------------------------------
            
                if(bodega_salida==6 && bodega_6[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }else if(bodega_6[producto_entrada][espacio_entrada]!="-" && estado_traslado==true){
                            bodega_6[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B6: Traslado correcto...");
                            espacios_b6--;
                            estado_traslado = true;
     
                    }
                

            if (bodega_entrada==6 && bodega_6[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b6);
                            estado_traslado=true;
                            bodega_1[producto_entrada][espacio_entrada]="B6P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" ingresado" );
                            espacios_b6++;
            }
                        else if(bodega_6[producto_entrada][espacio_entrada]!="-"){
                            System.out.println("Entrada B6: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            
                            estado_traslado = false;
                        }
                    
                    
                        
                menu_principal();
            
            
            
            
        }
    
    
    
}
    
    
    

