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
 * @author mr8ug
 */
public class menu {

    //Variables publicas y estaticas para navegacion...
    static String opcion;//
    static int opcion_num;
    static int num_bodega;
    static int num_productos;
    static int num_ingreso;
    static int num_salida;
    
    //
    
            
    //
    static int unidades_ingresadas;
    static int fila_random;
    static int columna_random;
    
    
    static Scanner leer = new Scanner(System.in);
    static Scanner leer_num = new Scanner(System.in);
    
    //variables publicas para arreglos y matrices
    static String[][] bodega_1=new String[6][21];
    static String[][] bodega_2=new String[6][21];
    static String[][] bodega_3=new String[6][21];
    static String[][] bodega_4=new String[6][21];
    static String[][] bodega_5=new String[6][21];
    static String[][] bodega_6=new String[6][21];
    
    
    static int fila_nueva=1;
    static String estado_nuevo;//este sera el nombre a colocar en la nueva fila ↑ #correlativo /compra o venta
    static String[][] kardex = new String[100][7];
    
    static int num_existencias=0, tot_existencias=0, tot_existencias_anterior=0; //existencias
    
    static int num_entradas=0, tot_entradas=0; //reabastecimiento manual
    static int num_salidas=0, tot_salidas=0; //realiar pedido
    
    static int espacios_b1=100,espacios_b2=100,espacios_b3=100, espacios_b4=100,espacios_b5=100,espacios_b6=100;
    
    static int bodega_salida ,producto_salida, espacio_salida,  bodega_entrada,  producto_entrada, espacio_entrada;
    
    static boolean bodega1_llena=false;
    static boolean bodega2_llena=false;
    static boolean bodega3_llena=false;
    static boolean bodega4_llena=false;
    static boolean bodega5_llena=false;
    static boolean bodega6_llena=false;
    
    static boolean estado_traslado=false;
    static boolean estado_autoR=false;
    static boolean estado_mR=false;
    
    static boolean productos_existentes=false;
    static boolean venta_realizada=false;
    
    static int existencias_venta;
    
    static int contador_productos;
    static int contador_espacioP;
    static int seleccion_producto;
    static int vendido;
    
    static int[] reporte1 = new int[6];
    public static void main(String[] args) {
        plantilla_tablas();
        menu_principal();
        
        
    }
    
    static void menu_principal() {
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
            case "7":   mostrar_bodega1();
                        mostrar_bodega2();
                        mostrar_bodega3();
                        mostrar_bodega4();
                        mostrar_bodega5();
                        mostrar_bodega6();
                        System.out.println("->INGRESE CUALQUIER CARACTER PARA REGRESAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            menu_principal();
                                            break;
                                    }
                        
            break;
            case "8":   System.gc();
                        System.exit(0);
                        break;
            default: System.err.println("Ingrese valor numerico");
            
                     menu_principal();
                     break;        
        }
    }
        
    static void datos_prueba(){
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
                            
                             
                            }catch (Exception e){ //termina catch y reinicia el programa cuando haya un valor que no sea numerico al ingresar bodegas
                                System.out.println("Error: "+e);
                                System.out.println("Ingrese valor numerico");
                                System.out.println("Reiniciando...");
                                leer_num=null;
                                datos_prueba();
                            }
            
            
//---------------------------------------------------------------------------------------------------------------------------------------------------
                             switch(num_bodega){
                                
                        case 1://CARGARA LA BODEGA 1
                            if((espacios_b1-num_productos)>=0){
                                System.out.println("♦Se ingresaron "+num_productos+" productos aleatoriamente en bodega #"+num_bodega+"");
                                    espacios_b1=espacios_b1-num_productos;
                                    kardex_pruebas();
                                carga_bodega1();
                                
                                
                            }else{
                                System.out.println("Error: el ingreso de productos supera el limite, puede ingresar "+espacios_b1+" unidades");
                                System.out.println("Regresando...");
                                datos_prueba();
                            }
                            
                                break;

                        case 2: //CARGARA LA BODEGA 2
                                if((espacios_b2-num_productos)>=0){
                                    System.out.println("♦Se ingresaron "+num_productos+" productos aleatoriamente en bodega #"+num_bodega+"");
                                    espacios_b2=espacios_b2-num_productos;
                                    kardex_pruebas();
                                carga_bodega2();
                                
                                
                            }else{
                                System.out.println("Error: el ingreso de productos supera el limite, puede ingresar "+espacios_b2+" unidades");
                                System.out.println("Regresando...");
                                datos_prueba();
                            }
                                
                                break;
                       
                        case 3: //CARGARA LA BODEGA 3
                                if((espacios_b3-num_productos)>=0){
                                    System.out.println("♦Se ingresaron "+num_productos+" productos aleatoriamente en bodega #"+num_bodega+"");
                                    espacios_b3=espacios_b3-num_productos;
                                    kardex_pruebas();
                                carga_bodega3();
                                
                                
                            }else{
                                System.out.println("Error: el ingreso de productos supera el limite, puede ingresar "+espacios_b3+" unidades");
                                System.out.println("Regresando...");
                                datos_prueba();
                            }
                                
                                break;
                                
                        case 4: //CARGARA LA BODEGA 4
                                if((espacios_b4-num_productos)>=0){
                                    System.out.println("♦Se ingresaron "+num_productos+" productos aleatoriamente en bodega #"+num_bodega+"");
                                    espacios_b4=espacios_b4-num_productos;
                                    kardex_pruebas();
                                carga_bodega4();
                                
                                
                            }else{
                                System.out.println("Error: el ingreso de productos supera el limite, puede ingresar "+espacios_b4+" unidades");
                                System.out.println("Regresando...");
                                datos_prueba();
                            }
                                
                                break;
                       
                        case 5: //CARGARA LA BODEGA 5
                                if((espacios_b5-num_productos)>=0){
                                    System.out.println("♦Se ingresaron "+num_productos+" productos aleatoriamente en bodega #"+num_bodega+"");
                                    espacios_b5=espacios_b5-num_productos;
                                    kardex_pruebas();
                                carga_bodega5();
                                
                                
                            }else{
                                System.out.println("Error: el ingreso de productos supera el limite, puede ingresar "+espacios_b5+" unidades");
                                System.out.println("Regresando...");
                                datos_prueba();
                            }
                                
                                break;
                       
                        case 6: //CARGARA LA BODEGA 6
                                if((espacios_b6-num_productos)>=0){
                                    System.out.println("♦Se ingresaron "+num_productos+" productos aleatoriamente en bodega #"+num_bodega+"");
                                    espacios_b6=espacios_b6-num_productos;
                                    kardex_pruebas();
                                carga_bodega6();
                                
                                
                            }else{
                                System.out.println("Error: el ingreso de productos supera el limite, puede ingresar "+espacios_b6+" unidades");
                                System.out.println("Regresando...");
                                datos_prueba();
                            }
                                
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
                                    papelero();

                                    break;
                                    
                                case "2":
                                    System.out.println("☺ Regresando...");
                                    datos_prueba();
                                    break;
                                    
                                default: 
                                    System.out.println("Ingrese opcion valida...");
                                    System.out.println("Regresando...");
                                    datos_prueba();
                                    break;
                            }
                
                            break;
                
                case "3":   System.out.println("Regresando a menu principal...");
                            menu_principal();
                            break;
                            
                            
                default: System.out.println("Error... Ingrese valor numero");
                        System.out.println(" regresando a datos prueba");
                         datos_prueba();
                         break;
            }                            

            }
            
    static void traslados_bodega(){
                        System.out.println("---------------------------");
                        System.out.println("║-----Datos de Prueba-----║");
                        System.out.println("║1|Verificar posibles traslados");
                        System.out.println("║2|Realizar traslado");
                        System.out.println("║3|Regresar");
                        System.out.println("---------------------------");
        
            opcion = leer.next();
            switch(opcion){
            
                case "1":   System.out.println("║----Posibles traslados-----║");
                            System.out.println("----------------------------------------------------");
                            System.out.println("Bodega #1 tiene:"+espacios_b1+" espacios disponibles");
                            System.out.println("----------------------------------------------------");
                            System.out.println("Bodega #2 tiene:"+espacios_b2+" espacios disponibles");
                            System.out.println("----------------------------------------------------");
                            System.out.println("Bodega #3 tiene:"+espacios_b3+" espacios disponibles");
                            System.out.println("----------------------------------------------------");
                            System.out.println("Bodega #4 tiene:"+espacios_b4+" espacios disponibles");
                            System.out.println("----------------------------------------------------");
                            System.out.println("Bodega #5 tiene:"+espacios_b5+" espacios disponibles");
                            System.out.println("----------------------------------------------------");
                            System.out.println("Bodega #6 tiene:"+espacios_b6+" espacios disponibles");
                            System.out.println("----------------------------------------------------");
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
        
    static void reabastecimiento(){
        System.out.println("------------------------");
        System.out.println("║----- Reabastecimiento -----║");
        System.out.println("║1|Reabastecer automatizado");
        System.out.println("║2|Reabastecer manual");
        System.out.println("║3|Regresar");
        System.out.println("------------------------");
        
        opcion = leer.next();
            switch(opcion){
                case "1": System.out.println("----- Reabastecer Automatizado -----");
                
                try{
                    System.out.println("-> Ingrese el numero de Bodega a Reabastecer:");
                    
                    num_bodega = leer_num.nextInt();
                    }catch(Exception e){
                    System.err.println("Error: "+e);
                    System.out.println("Ingrese valor numerico valido");
                    System.out.println("◄ Regresando");
                    reabastecimiento();
                }
                    while(num_bodega<=0 || num_bodega>=7){
                                System.out.println("Solamente existen bodegas de 1-6...");
                                    num_bodega=leer_num.nextInt();     
                            }
                
                    System.out.println("Bodega seleccionada: #"+num_bodega);
                    System.out.println("Verificando solicitud");
                    verificador_autoReabastecimiento();
                    
                    if(estado_autoR==true){
                        System.out.println("Se han reabastecido productos en Bodega #"+num_bodega+" satisfactoriamente");
                        
                    }else if(estado_autoR==false){
                        System.out.println("No hay mas productos a reabastecer en Bodega #"+num_bodega);
                    }
                
                    
                    System.out.println("-----------------------------");
            System.out.println("◄ Regresando");
            System.out.println("→INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            reabastecimiento();
                                            break;
                                    }
                    break;
                    
                case "2": System.out.println("----- Reabastecer Manual -----");
                    try{
                    System.out.println("Ingrese # de Bodega");
                    num_bodega=leer.nextInt();
                    while(num_bodega<=0 || num_bodega>=7){
                                System.out.println("Solamente existen bodegas de 1-6...");
                                    num_bodega=leer_num.nextInt();     
                            }
                    System.out.println("Ingrese # de Producto");
                    num_productos=leer.nextInt();
                    while(num_productos<=0 || num_productos>=6){
                                System.out.println("Solamente existen productos de 1-5...");
                                    num_productos=leer_num.nextInt();     
                            }
                    System.out.println("Ingrese # de Unidades");
                    num_ingreso=leer.nextInt();
                    while(num_ingreso>20){
                                System.out.println("Solamente puede ingresar 1-20 unidades...");
                                    num_ingreso=leer_num.nextInt();     
                            }
                    }catch(Exception e){
                        System.out.println("Por favor ingrese valores numericos validos...");
                        System.out.println("Reiniciando...");
                        reabastecimiento();
                    }
                    verificador_mReabastecimiento();
                    
                    
                    if(estado_mR==true){
                        System.out.println("Completado: Se han ingresado "+num_ingreso+" unidades de Producto #"+num_productos);
                        unidades_ingresadas=num_ingreso;
                        kardex_mReabastecimiento(num_bodega,num_productos,num_ingreso);
                        
                        
                    }
                    if(estado_mR==false){
                        System.out.println("Error: el ingreso de productos supera el limite, puede ingresar "+espacios_b1+" unidades");
                        System.out.println("Regresando...");
                        reabastecimiento();
                    }
                    
                    System.out.println("-----------------------------");
                    System.out.println("◄ Regresando");
                    System.out.println("→INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            reabastecimiento();
                                            break;
                                    }
                    
                    
                        break;
                    
                case "3":System.out.println("<--Regresando...");
                        menu_principal();
                        break;
                        
                default:System.err.println("Error... Ingrese valor numero");
                        System.out.println(" regresando a reabastecimiento...");
                        reabastecimiento();
                        break;
                
        }
        }
        
    static void salida_productos(){
        System.out.println("------------------------");
        System.out.println("║----- Salida de Productos -----║");
        System.out.println("║1|Realizar Pedido");
        System.out.println("║2|Regresar");
        System.out.println("------------------------");
        opcion = leer.next();
        
        switch(opcion){
            case "1": 
                System.out.println("------------------------");
                System.out.println("║----- Realizar Pedido -----║");
                try{
                System.out.println("←Pedido: Ingrese Unidades: E#");
                num_salida=leer_num.nextInt();
                while(num_salida<=0 || num_salida>=120){
                    System.out.println("Unidades de X producto de (1-120)");
                    num_salida=leer_num.nextInt();
                }
                
                
                System.out.println("←Pedido: Ingrese Producto: P#");
                num_productos=leer_num.nextInt();
                while(num_productos<=0 || num_productos>=6){
                    System.out.println("Solamente existen productos de 1-5...");
                            num_productos= leer.nextInt();
                }
                }catch(Exception e){
                    System.out.println("Error: "+e);
                    System.out.println("Ingrese valores numericos validos validos");
                }
                
                System.out.println("Verificando Existencia de "+num_salida+" Unidades de P#"+num_productos);
                verificar_existencias();
                        if(productos_existentes==true){
                    System.out.println("Realizando Operacion");
                    vender(num_productos,num_salida);
                    if(venta_realizada=true){
                        System.out.println("Venta de unidades completada...");
                        kardex_salida(num_bodega,num_productos,num_salida);
                        salida_productos();
                    }
                }
                if(productos_existentes==false){
                    System.out.println("No hay suficientes unidades del Producto #"+num_productos);
                    System.out.println("Regresando...");
                    salida_productos();
                }

                
                break;
                
            case "2":System.out.println("Regresando...");
            menu_principal();
            break;
            
            default: System.out.println("Ingrese opcion valida");
                salida_productos();
                break;
        }
    }
     
    static void reportes(){
            System.out.println("------------------------");
        System.out.println("║----- REPORTES -----║");
        System.out.println("║1|BODEGA CON MAYOR CANTIDAD DE TODOS LOS PRODUCTOS");
        System.out.println("║2|BODEGA CON MAYOR CANTIDAD DE PRODUCTOS (POR TIPO) ");
        System.out.println("║3|PROMEDIO DE EXISTENCIAS POR TIPO DE PRODUCTO ");
        System.out.println("║4|REGRESAR");
        System.out.println("------------------------");
        opcion=leer.next();
        
        switch(opcion){
            
            case "1":   System.out.println("BODEGA CON MAYOR CANTIDAD DE TODOS LOS PRODUCTOS");
                
                
                if(espacios_b1<espacios_b2 && espacios_b1<espacios_b3 && espacios_b1<espacios_b4 && espacios_b1<espacios_b5 &&espacios_b1<espacios_b6){
                    System.out.println("La bodega 1 tiene "+(100-espacios_b1)+" productos en total");
                }
                if(espacios_b2<espacios_b1 && espacios_b2<espacios_b3 && espacios_b2<espacios_b4 && espacios_b2<espacios_b5 &&espacios_b2<espacios_b6){
                    System.out.println("La bodega 2 tiene "+(100-espacios_b2)+" productos en total");
                }
                if(espacios_b3<espacios_b1 && espacios_b3<espacios_b2 && espacios_b3<espacios_b4 && espacios_b3<espacios_b5 &&espacios_b3<espacios_b6){
                    System.out.println("La bodega 3 tiene "+(100-espacios_b3)+" productos en total");
                }
                if(espacios_b4<espacios_b1 && espacios_b4<espacios_b2 && espacios_b4<espacios_b3 && espacios_b4<espacios_b5 &&espacios_b4<espacios_b6){
                    System.out.println("La bodega 4 tiene "+(100-espacios_b4)+" productos en total");
                }
                if(espacios_b5<espacios_b1 && espacios_b5<espacios_b2 && espacios_b5<espacios_b3 && espacios_b5<espacios_b4 &&espacios_b5<espacios_b6){
                    System.out.println("La bodega 5 tiene "+(100-espacios_b5)+" productos en total");
                }
                if(espacios_b6<espacios_b1 && espacios_b6<espacios_b2 && espacios_b6<espacios_b3 && espacios_b6<espacios_b4 &&espacios_b6<espacios_b5){
                    System.out.println("La bodega 6 tiene "+(100-espacios_b6)+" productos en total");
                }
                
                System.out.println("B1|P"+(100-espacios_b1)+";"+"B2|P"+(100-espacios_b2)+";"+"B3|P"+(100-espacios_b3)+";"+"B4|P"+(100-espacios_b4)+";"+"B5|P"+(100-espacios_b5)+";"+"B6|P"+(100-espacios_b6)+";");
                System.out.println("→INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            reportes();
                                            break;
                                    }
                
                    
                        
            break;
            
            case "2":   System.out.println("║----BODEGA CON MAYOR CANTIDAD DE PRODUCTOS (SEPARADAS POR CADA TIPO DE PRODUCTO----║");
                    int unidades_existentes1=0;
                    int unidades_existentes2=0;
                    int unidades_existentes3=0;
                    int unidades_existentes4=0;
                    int unidades_existentes5=0;
            if(espacios_b1<espacios_b2 && espacios_b1<espacios_b3 && espacios_b1<espacios_b4 && espacios_b1<espacios_b5 &&espacios_b1<espacios_b6){
                    System.out.println("La bodega 1 tiene "+(100-espacios_b1)+" productos en total");
                    
                    
                    for(int k=1;k<21;k++){
                        if(bodega_1[1][k]!="-"){
                        unidades_existentes1++;
                        }
                    }System.out.println("El Producto #1 tiene "+unidades_existentes1+" unidades en Bodega #1");
                    for(int k=1;k<21;k++){
                        if(bodega_1[2][k]!="-"){
                        unidades_existentes2++;
                        }
                    }System.out.println("El Producto #2 tiene "+unidades_existentes2+" unidades en Bodega #1");
                    for(int k=1;k<21;k++){
                        if(bodega_1[3][k]!="-"){
                        unidades_existentes3++;
                        }
                    }System.out.println("El Producto #3 tiene "+unidades_existentes3+" unidades en Bodega #1");
                    for(int k=1;k<21;k++){
                        if(bodega_1[4][k]!="-"){
                        unidades_existentes4++;
                        }
                    }System.out.println("El Producto #4 tiene "+unidades_existentes4+" unidades en Bodega #1");
                    for(int k=1;k<21;k++){
                        if(bodega_1[5][k]!="-"){
                        unidades_existentes5++;
                        }
                    }System.out.println("El Producto #5 tiene "+unidades_existentes5+" unidades en Bodega #1");    
                }
                        
                if(espacios_b2<espacios_b1 && espacios_b2<espacios_b3 && espacios_b2<espacios_b4 && espacios_b2<espacios_b5 &&espacios_b2<espacios_b6){
                    System.out.println("La bodega 2 tiene "+(100-espacios_b2)+" productos en total");
                    for(int k=1;k<21;k++){
                        if(bodega_2[1][k]!="-"){
                        unidades_existentes1++;
                        }
                    }System.out.println("El Producto #1 tiene "+unidades_existentes1+" unidades en Bodega #2");
                    for(int k=1;k<21;k++){
                        if(bodega_2[2][k]!="-"){
                        unidades_existentes2++;
                        }
                    }System.out.println("El Producto #2 tiene "+unidades_existentes2+" unidades en Bodega #2");
                    for(int k=1;k<21;k++){
                        if(bodega_2[3][k]!="-"){
                        unidades_existentes3++;
                        }
                    }System.out.println("El Producto #3 tiene "+unidades_existentes3+" unidades en Bodega #2");
                    for(int k=1;k<21;k++){
                        if(bodega_2[4][k]!="-"){
                        unidades_existentes4++;
                        }
                    }System.out.println("El Producto #4 tiene "+unidades_existentes4+" unidades en Bodega #2");
                    for(int k=1;k<21;k++){
                        if(bodega_2[5][k]!="-"){
                        unidades_existentes5++;
                        }
                    }System.out.println("El Producto #5 tiene "+unidades_existentes5+" unidades en Bodega #2"); 
                }
                if(espacios_b3<espacios_b1 && espacios_b3<espacios_b2 && espacios_b3<espacios_b4 && espacios_b3<espacios_b5 &&espacios_b3<espacios_b6){
                    System.out.println("La bodega 3 tiene "+(100-espacios_b3)+" productos en total");
                    for(int k=1;k<21;k++){
                        if(bodega_3[1][k]!="-"){
                        unidades_existentes1++;
                        }
                    }System.out.println("El Producto #1 tiene "+unidades_existentes1+" unidades en Bodega #3");
                    for(int k=1;k<21;k++){
                        if(bodega_3[2][k]!="-"){
                        unidades_existentes2++;
                        }
                    }System.out.println("El Producto #2 tiene "+unidades_existentes2+" unidades en Bodega #3");
                    for(int k=1;k<21;k++){
                        if(bodega_3[3][k]!="-"){
                        unidades_existentes3++;
                        }
                    }System.out.println("El Producto #3 tiene "+unidades_existentes3+" unidades en Bodega #3");
                    for(int k=1;k<21;k++){
                        if(bodega_3[4][k]!="-"){
                        unidades_existentes4++;
                        }
                    }System.out.println("El Producto #4 tiene "+unidades_existentes4+" unidades en Bodega #3");
                    for(int k=1;k<21;k++){
                        if(bodega_3[5][k]!="-"){
                        unidades_existentes5++;
                        }
                    }System.out.println("El Producto #5 tiene "+unidades_existentes5+" unidades en Bodega #3"); 
                }
                if(espacios_b4<espacios_b1 && espacios_b4<espacios_b2 && espacios_b4<espacios_b3 && espacios_b4<espacios_b5 &&espacios_b4<espacios_b6){
                    System.out.println("La bodega 4 tiene "+(100-espacios_b4)+" productos en total");
                    for(int k=1;k<21;k++){
                        if(bodega_4[1][k]!="-"){
                        unidades_existentes1++;
                        }
                    }System.out.println("El Producto #1 tiene "+unidades_existentes1+" unidades en Bodega #4");
                    for(int k=1;k<21;k++){
                        if(bodega_4[2][k]!="-"){
                        unidades_existentes2++;
                        }
                    }System.out.println("El Producto #2 tiene "+unidades_existentes2+" unidades en Bodega #4");
                    for(int k=1;k<21;k++){
                        if(bodega_4[3][k]!="-"){
                        unidades_existentes3++;
                        }
                    }System.out.println("El Producto #3 tiene "+unidades_existentes3+" unidades en Bodega #4");
                    for(int k=1;k<21;k++){
                        if(bodega_4[4][k]!="-"){
                        unidades_existentes4++;
                        }
                    }System.out.println("El Producto #4 tiene "+unidades_existentes4+" unidades en Bodega #4");
                    for(int k=1;k<21;k++){
                        if(bodega_4[5][k]!="-"){
                        unidades_existentes5++;
                        }
                    }System.out.println("El Producto #5 tiene "+unidades_existentes5+" unidades en Bodega #4"); 
                }
                if(espacios_b5<espacios_b1 && espacios_b5<espacios_b2 && espacios_b5<espacios_b3 && espacios_b5<espacios_b4 &&espacios_b5<espacios_b6){
                    System.out.println("La bodega 5 tiene "+(100-espacios_b5)+" productos en total");
                    for(int k=1;k<21;k++){
                        if(bodega_5[1][k]!="-"){
                        unidades_existentes1++;
                        }
                    }System.out.println("El Producto #1 tiene "+unidades_existentes1+" unidades en Bodega #5");
                    for(int k=1;k<21;k++){
                        if(bodega_5[2][k]!="-"){
                        unidades_existentes2++;
                        }
                    }System.out.println("El Producto #2 tiene "+unidades_existentes2+" unidades en Bodega #5");
                    for(int k=1;k<21;k++){
                        if(bodega_5[3][k]!="-"){
                        unidades_existentes3++;
                        }
                    }System.out.println("El Producto #3 tiene "+unidades_existentes3+" unidades en Bodega #5");
                    for(int k=1;k<21;k++){
                        if(bodega_5[4][k]!="-"){
                        unidades_existentes4++;
                        }
                    }System.out.println("El Producto #4 tiene "+unidades_existentes4+" unidades en Bodega #5");
                    for(int k=1;k<21;k++){
                        if(bodega_5[5][k]!="-"){
                        unidades_existentes5++;
                        }
                    }System.out.println("El Producto #5 tiene "+unidades_existentes5+" unidades en Bodega #5"); 
                }
                if(espacios_b6<espacios_b1 && espacios_b6<espacios_b2 && espacios_b6<espacios_b3 && espacios_b6<espacios_b4 &&espacios_b6<espacios_b5){
                    System.out.println("La bodega 6 tiene "+(100-espacios_b6)+" productos en total");
                    for(int k=1;k<21;k++){
                        if(bodega_6[1][k]!="-"){
                        unidades_existentes1++;
                        }
                    }System.out.println("El Producto #1 tiene "+unidades_existentes1+" unidades en Bodega #6");
                    for(int k=1;k<21;k++){
                        if(bodega_6[2][k]!="-"){
                        unidades_existentes2++;
                        }
                    }System.out.println("El Producto #2 tiene "+unidades_existentes2+" unidades en Bodega #6");
                    for(int k=1;k<21;k++){
                        if(bodega_6[3][k]!="-"){
                        unidades_existentes3++;
                        }
                    }System.out.println("El Producto #3 tiene "+unidades_existentes3+" unidades en Bodega #6");
                    for(int k=1;k<21;k++){
                        if(bodega_6[4][k]!="-"){
                        unidades_existentes4++;
                        }
                    }System.out.println("El Producto #4 tiene "+unidades_existentes4+" unidades en Bodega #6");
                    for(int k=1;k<21;k++){
                        if(bodega_6[5][k]!="-"){
                        unidades_existentes5++;
                        }
                    }System.out.println("El Producto #5 tiene "+unidades_existentes5+" unidades en Bodega #6"); 
                }
                
                System.out.println("B1|P"+(100-espacios_b1)+";"+"B2|P"+(100-espacios_b2)+";"+"B3|P"+(100-espacios_b3)+";"+"B4|P"+(100-espacios_b4)+";"+"B5|P"+(100-espacios_b5)+";"+"B6|P"+(100-espacios_b6)+";");
                System.out.println("→INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            reportes();
                                            break;
                                    }
                                    
                                    break;
            case "3":   System.out.println("║----PROMEDIO DE EXISTENCIAS POR TIPO DE PRODUCTO----║");
                        System.out.println("");
                        
                        num_productos=1;
                        verificar_promedio();
                        System.out.println("--------------------------------------------------------");
                        
                        num_productos=2;
                        verificar_promedio();
                        System.out.println("--------------------------------------------------------");
                        
                        num_productos=3;
                        verificar_promedio();
                        System.out.println("--------------------------------------------------------");
                        
                        num_productos=4;
                        verificar_promedio();
                        System.out.println("--------------------------------------------------------");
                        
                        num_productos=5;
                        verificar_promedio();
                        System.out.println("--------------------------------------------------------");
                        
                        System.out.println("→INGRESE CUALQUIER CARACTER PARA CONTINUAR...");
                                    opcion=leer.next();
                                    switch(opcion){
                                        default: 
                                            reportes();
                                            break;
                                    }
                        
                       
            break;
            
            case "4":   System.out.println("Regresando...");
                        menu_principal();
                        break;
                        
            default:    System.out.println("Ingrese opcion valida...");
                        reportes();
                        break;
            
            
        }//switch
        
    }
    
    
    static void kardex(){
            
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
    static void kardex_pruebas(){
            //metodo kardex para el ingreso por datos de prueba              
        num_existencias=num_existencias+num_productos; //dato para kardex              
        tot_existencias=num_existencias*5;
            kardex[fila_nueva][0]="Saldo Ante.     ";
            kardex[fila_nueva][5]=""+num_existencias+"        ";
            kardex[fila_nueva][6]=""+tot_existencias+"        ";
            fila_nueva++; //contador de filas
            //contador de existencia anterior
            //fin kardex
        }
    static void kardex_aReabastecimiento(int b, int P){
        
        num_existencias=num_existencias+(unidades_ingresadas);
        tot_existencias=num_existencias*5;
            kardex[fila_nueva][0]="Compra→RA B"+b+"P"+P+"  ";
            kardex[fila_nueva][1]=""+(unidades_ingresadas)+"        ";
            kardex[fila_nueva][2]=""+(unidades_ingresadas)*5+"        ";
            kardex[fila_nueva][5]=""+num_existencias+"      ";
            
            kardex[fila_nueva][6]=""+tot_existencias+"      ";
            fila_nueva++; //contador de filas
    }
    static void kardex_mReabastecimiento(int b, int P, int u){
        
        num_existencias=num_existencias+(unidades_ingresadas);
        tot_existencias=num_existencias*5;
            kardex[fila_nueva][0]="Compra→RM B"+b+"P"+P+"|"+u;
            kardex[fila_nueva][1]=""+(unidades_ingresadas)+"   ";
            kardex[fila_nueva][2]=""+(unidades_ingresadas)*5+"   ";
            kardex[fila_nueva][5]=""+num_existencias+"        ";
            
            kardex[fila_nueva][6]=""+tot_existencias+"        ";
            fila_nueva++; //contador de filas
    }
    static void kardex_salida(int b, int p, int u){
        
        num_existencias=num_existencias-(u);
        tot_existencias=tot_existencias-(u*5);
        kardex[fila_nueva][0]="Ventas→B"+b+"P"+p+"|"+u+" ";
            kardex[fila_nueva][3]="-"+(u)+"  ";
            kardex[fila_nueva][4]="-"+(u)*5+"  ";
            kardex[fila_nueva][5]=""+num_existencias+"        ";
            
            kardex[fila_nueva][6]=""+tot_existencias+"        ";
            fila_nueva++; //contador de filas
    }
        
    
        //estos metodos solo imprimiran la bodega
    static void mostrar_bodega1(){
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
        }
    static void mostrar_bodega2(){
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
        }
    static void mostrar_bodega3(){
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
        }
    static void mostrar_bodega4(){
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
        }
    static void mostrar_bodega5(){
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
        }
    static void mostrar_bodega6(){
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
            System.out.println("");                     
        }
   
    

    static void plantilla_tablas() { //este metodo tipo plantilla solamente cargará la primera fila y primera columna...
                        
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
        kardex[0][0]="Detalle         ";
        kardex[0][1]="Entrada    ";
        kardex[0][2]="Total      ";
        kardex[0][3]="Salida     ";
        kardex[0][4]="Total      ";
        kardex[0][5]="Existencias";
        kardex[0][6]="Total      ";
        
    }

    static void num_randoms(){
            fila_random=(int)(Math.random() * 5 + 1); //este solo podra estar comprendido entre la fila 2→6 en el arreglo de 1→5
            columna_random = (int)(Math.random() * 20 + 1); //este solo podra estar comprendido entre columna 2→20 en el arreglo de 1→19
            
        }//para el ingreso aleatorio de productos
 //estos metodos de carga bodega incluyen el dado para cargar datos aleatoriamente...
    static void carga_bodega1(){
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
    static void carga_bodega2(){
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
    static void carga_bodega3(){
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
    static void carga_bodega4(){
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
    static void carga_bodega5(){
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
    static void carga_bodega6() {
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
    static void llenado_bodegas(){
            if (num_bodega ==1){
                int contador_prod;
                contador_prod=num_productos;
                
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
            
        }//metodoq ue llena los aleatorios
    static void verificador_bodegas(){
            //----------------------------------------------------------
            
                //verificara cuando la bodega de salida no sea un espacio vacio, si el estado de traslado en algun momento cambia a falso
                //por no cumplir con mostrara el error de que el producto no existe y regresara---
                //si el estado de la salida se mantiene en verdadero este realizara el cambio por el producto de salida a "-" vacio 
                if(bodega_salida==1 && bodega_1[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en el Espacio#"+espacio_salida+" de la Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }
                 if(bodega_salida==1 && bodega_1[producto_salida][espacio_salida]!="-" || (bodega_salida==1 && estado_traslado==true)){
                            bodega_1[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B1: Traslado correcto...");
                            espacios_b1++;
                            estado_traslado = true;
                            
                    }
            //verificara si el espacio de destino esta ocupado.. si esta ocupado no ingresara el producto y marcara falso
            //en la salida de las bodegas se requiere el estado del traslado... si esto termina falso, la salida sera falsa tambien
            //no vaciara el producto y no ingresara el producto
            
            
            if (bodega_entrada==1 && bodega_1[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b1);
                            estado_traslado=true;
                            bodega_1[producto_entrada][espacio_entrada]="B1P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" en el Espacio#"+espacio_entrada+" de la Bodega #"+bodega_entrada+" ingresado" );
                            espacios_b1--;
            }
            else if( bodega_entrada==1 &&  bodega_1[producto_entrada][espacio_entrada]!="-" && estado_traslado==false){
                            System.out.println("Entrada B1: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            estado_traslado = false;
                        }
                        
            //----------------------------------------------------------
            
                
                if(bodega_salida==2 && bodega_2[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en el Espacio#"+espacio_salida+" de la Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }
                if( bodega_salida==2 && bodega_2[producto_salida][espacio_salida]!="-" || (bodega_salida==2 && estado_traslado==true)){
                            bodega_2[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B2: Traslado correcto...");
                            espacios_b2++;
                            estado_traslado = true;
     
                    }
            
            if (bodega_entrada==2 && bodega_2[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b2);
                            estado_traslado=true;
                            bodega_2[producto_entrada][espacio_entrada]="B2P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" en el Espacio#"+espacio_entrada+" de la Bodega #"+bodega_entrada+" ingresado" );
                            espacios_b2--;
            }
            else if(bodega_entrada==2 && bodega_2[producto_entrada][espacio_entrada]!="-" && estado_traslado==false ){
                            System.out.println("Entrada B2: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            
                            estado_traslado = false;
                        }
            
            
            //----------------------------------------------------------
            
                if(bodega_salida==3 && bodega_3[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en el Espacio#"+espacio_salida+" de la Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }
                if(bodega_salida==3 && bodega_3[producto_salida][espacio_salida]!="-" || (bodega_salida==3 && estado_traslado==true)){
                            bodega_3[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B3: Traslado correcto...");
                            estado_traslado = true;
                            espacios_b3++;
     
                    }
                

            if (bodega_entrada==3 && bodega_3[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b3);
                            estado_traslado=true;
                            bodega_3[producto_entrada][espacio_entrada]="B3P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" en el Espacio#"+espacio_entrada+" de la Bodega #"+bodega_entrada+" ingresado" );
                            espacios_b3--;
            }
            else if(bodega_entrada ==3 && bodega_3[producto_entrada][espacio_entrada]!="-" && estado_traslado==false){
                            System.out.println("Entrada B3: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            
                            estado_traslado = false;
                        }
            
            //----------------------------------------------------------
                if(bodega_salida==4 && bodega_4[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en el Espacio#"+espacio_salida+" de la Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }
                if(bodega_salida==4 && bodega_4[producto_salida][espacio_salida]!="-" || (bodega_salida==4 && estado_traslado==true)){
                            bodega_4[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B4: Traslado correcto...");
                            espacios_b4++;
                            estado_traslado = true;
     
                    }
            
            if (bodega_entrada==4 && bodega_4[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b5);
                            estado_traslado=true;
                            bodega_4[producto_entrada][espacio_entrada]="B4P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" en el Espacio#"+espacio_entrada+" de la Bodega #"+bodega_entrada+" ingresado" );
                            espacios_b4--;
            }
            else if(bodega_entrada==4 && bodega_4[producto_entrada][espacio_entrada]!="-" && estado_traslado==false ){
                            System.out.println("Entrada B4: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            
                            estado_traslado = false;
                        }
            
            //----------------------------------------------------------
                if(bodega_salida==5 && bodega_5[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en el Espacio#"+espacio_salida+" de la Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }
                if(bodega_salida==5 && bodega_5[producto_salida][espacio_salida]!="-" || (bodega_salida==5 && estado_traslado==true)){
                            bodega_5[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B5: Traslado correcto...");
                            espacios_b5++;
                            estado_traslado = true;
     
                    }
            
            if (bodega_entrada==5 && bodega_5[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b5);
                            estado_traslado=true;
                            bodega_5[producto_entrada][espacio_entrada]="B5P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" en el Espacio#"+espacio_entrada+" de la Bodega #"+bodega_entrada+" ingresado" );
                            espacios_b5--;
            }
            else if(bodega_entrada==5 && bodega_5[producto_entrada][espacio_entrada]!="-" && estado_traslado==false ){
                            System.out.println("Entrada B5: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            
                            estado_traslado = false;
                        }
            
            //----------------------------------------------------------
                if(bodega_salida==6 && bodega_6[producto_salida][espacio_salida]=="-" && estado_traslado==false){
                            estado_traslado=false;
                            System.out.println("•Producto #"+producto_salida+" en el Espacio#"+espacio_salida+" de la Bodega #"+bodega_salida+" no existe" );
                            System.out.println("<-- Regresando...");
                            traslados_bodega();
                        }
                if(bodega_salida==6 && bodega_6[producto_salida][espacio_salida]!="-" || (bodega_salida==6 && estado_traslado==true)){
                            bodega_6[producto_salida][espacio_salida]="-";
                            
                            System.out.println("Salida B6: Traslado correcto...");
                            espacios_b6++;
                            estado_traslado = true;
     
                    }
                

            if (bodega_entrada==6 && bodega_6[producto_entrada][espacio_entrada]=="-"){
                        //verifica si el espacio esta vacio
                            System.out.println("Espacio disponible..."+espacios_b6);
                            estado_traslado=true;
                            bodega_6[producto_entrada][espacio_entrada]="B6P"+producto_entrada+","+espacio_entrada;
                            System.out.println("•Producto #"+producto_entrada+" en el Espacio#"+espacio_entrada+" de la Bodega #"+bodega_entrada+" ingresado");
                            espacios_b6--;
            }
            else if(bodega_entrada==6 && bodega_6[producto_entrada][espacio_entrada]!="-" && estado_traslado==false){
                            System.out.println("Entrada B6: Traslado incorrecto...");
                            System.out.println("Espacio Ocupado");
                            
                            estado_traslado = false;
                        }
                    
                    if(estado_traslado==true){
                        System.out.println("---->Solicitud Completa!!");
                    }else if(estado_traslado==false){
                        System.out.println("<----Solicitud Incompleta... Verifique datos.");
                    }
                        
               traslados_bodega();
            
            
            
            
        }
    
    static void verificador_autoReabastecimiento(){

                verificador_auto(1);
                verificador_auto(2);
                verificador_auto(3);
                verificador_auto(4);
                verificador_auto(5);

        }      
    static void verificador_mReabastecimiento(){
                verificador_manual(num_productos,num_ingreso);    
        }
    static void verificador_auto(int producto){
                
            if(num_bodega==1){
            
                int contador_unidades=0;

                    for(int E=1;E<21;E++){
                        if (bodega_1[producto][E]!="-"){
                            contador_unidades++;
                        }
                     
                    }if(contador_unidades<4){
                        System.out.println("El Producto#"+producto+" tiene "+contador_unidades+" unidades... Se llenara");
                        for(int E=1;E<21;E++){
                            bodega_1[producto][E]="B1P"+producto+","+E;
                        }
                        espacios_b1=espacios_b1-(20-contador_unidades);
                        unidades_ingresadas=(20-contador_unidades);
                        estado_autoR=true;
                        kardex_aReabastecimiento(num_bodega,producto);
                    }else{
                        estado_autoR=false;
                    }
            }
            if(num_bodega==2){
            
                int contador_unidades=0;

                    for(int E=1;E<21;E++){
                        if (bodega_2[producto][E]!="-"){
                            contador_unidades++;
                        }
                        
                    }if(contador_unidades<4){
                        System.out.println("El Producto#"+producto+" tiene "+contador_unidades+" unidades... Se llenara");
                        for(int E=1;E<21;E++){
                            bodega_2[producto][E]="B2P"+producto+","+E;
                        }
                        espacios_b2=espacios_b2-(20-contador_unidades);
                        unidades_ingresadas=(20-contador_unidades);
                        estado_autoR=true;
                        kardex_aReabastecimiento(num_bodega,producto);
                    }else{
                        estado_autoR=false;
                    }
            }
            if(num_bodega==3){
            
                int contador_unidades=0;

                    for(int E=1;E<21;E++){
                        if (bodega_3[producto][E]!="-"){
                            contador_unidades++;
                        }
                        
                    }if(contador_unidades<4){
                        System.out.println("El Producto#"+producto+" tiene "+contador_unidades+" unidades... Se llenara");
                        for(int E=1;E<21;E++){
                            bodega_3[producto][E]="B3P"+producto+","+E;
                        }
                        espacios_b3=espacios_b3-(20-contador_unidades);
                        unidades_ingresadas=(20-contador_unidades);
                        estado_autoR=true;
                        kardex_aReabastecimiento(num_bodega,producto);
                    }else{
                        estado_autoR=false;
                    }
            }
            if(num_bodega==4){
            
                int contador_unidades=0;

                    for(int E=1;E<21;E++){
                        if (bodega_4[producto][E]!="-"){
                            contador_unidades++;
                        }
                        
                    }if(contador_unidades<4){
                        System.out.println("El Producto#"+producto+" tiene "+contador_unidades+" unidades... Se llenara");
                        for(int E=1;E<21;E++){
                            bodega_4[producto][E]="B4P"+producto+","+E;
                        }
                        espacios_b4=espacios_b4-(20-contador_unidades);
                        unidades_ingresadas=(20-contador_unidades);
                        estado_autoR=true;
                        kardex_aReabastecimiento(num_bodega,producto);
                    }else{
                        estado_autoR=false;
                    }
            }
            if(num_bodega==5){
            
                int contador_unidades=0;

                    for(int E=1;E<21;E++){
                        if (bodega_5[producto][E]!="-"){
                            contador_unidades++;
                        }
                        
                    }if(contador_unidades<4){
                        System.out.println("El Producto#"+producto+" tiene "+contador_unidades+" unidades... Se llenara");
                        for(int E=1;E<21;E++){
                            bodega_5[producto][E]="B5P"+producto+","+E;
                        }
                        espacios_b5=espacios_b5-(20-contador_unidades);
                        unidades_ingresadas=(20-contador_unidades);
                        estado_autoR=true;
                        kardex_aReabastecimiento(num_bodega,producto);
                    }else{
                        estado_autoR=false;
                    }
            }
            if(num_bodega==6){
            
                int contador_unidades=0;

                    for(int E=1;E<21;E++){
                        if (bodega_6[producto][E]!="-"){
                            contador_unidades++;
                        }
                        
                    }if(contador_unidades<4){
                        System.out.println("El Producto#"+producto+" tiene "+contador_unidades+" unidades... Se llenara");
                        for(int E=1;E<21;E++){
                            bodega_6[producto][E]="B6P"+producto+","+E;
                        }
                        espacios_b6=espacios_b6-(20-contador_unidades);
                        unidades_ingresadas=(20-contador_unidades);
                        estado_autoR=true;
                        kardex_aReabastecimiento(num_bodega,producto);
                    }else{
                        estado_autoR=false;
                    }
            }
        }   
    static void verificador_manual(int producto,int ingreso){
        
        if(num_bodega==1){
            
            try{
            int contador_unidades=0;

            int lim_max=0;
            //---------------------contara las unidades en bodega
            for(int a=1;a<21;a++){
                if(bodega_1[producto][a]!="-"){
                contador_unidades++;
                }
            }System.out.println("Existen: "+contador_unidades+" de Producto #"+num_productos);
            //-------------
            if(contador_unidades==20){
                System.out.println("No hay mas espacios...");
                estado_mR=false;
            }
            if(contador_unidades<20){
            for(int b=1;b<21;b++){
                bodega_1[producto][b]="-";
            }System.out.println("Actualizando Producto #"+producto);
            
            for(int c=1;c<=contador_unidades+ingreso;c++){
                bodega_1[producto][c]="B1P"+producto+","+c;
            }
                espacios_b1=espacios_b1-ingreso;
                mostrar_bodega1();
                estado_mR=true;
                
            }
            
            }catch(Exception e){
                System.out.println("Error: "+e);
                System.out.println("Regresando...");
                reabastecimiento();
                    }
        }
        if(num_bodega==2){
            try{
            int contador_unidades=0;

            int lim_max=0;
            //---------------------contara las unidades en bodega
            for(int a=1;a<21;a++){
                if(bodega_2[producto][a]!="-"){
                contador_unidades++;
                }
            }System.out.println("Existen: "+contador_unidades+" de Producto #"+num_productos);
            //-------------
            if(contador_unidades==20){
                System.out.println("No hay mas espacios...");
                estado_mR=false;
            }
            if(contador_unidades<20){
            for(int b=1;b<21;b++){
                bodega_2[producto][b]="-";
            }System.out.println("Actualizando Producto #"+producto);
            
            for(int c=1;c<=contador_unidades+ingreso;c++){
                bodega_2[producto][c]="B2P"+producto+","+c;
            }
                espacios_b2=espacios_b2-ingreso;
                mostrar_bodega2();
                estado_mR=true;
                
            }
            
            }catch(Exception e){
                System.out.println("Error: "+e);
                System.out.println("Regresando...");
                reabastecimiento();
                    }
        } 
        if(num_bodega==3){
            try{
            int contador_unidades=0;

            int lim_max=0;
            //---------------------contara las unidades en bodega
            for(int a=1;a<21;a++){
                if(bodega_3[producto][a]!="-"){
                contador_unidades++;
                }
            }System.out.println("Existen: "+contador_unidades+" de Producto #"+num_productos);
            //-------------
            if(contador_unidades==20){
                System.out.println("No hay mas espacios...");
                estado_mR=false;
            }
            if(contador_unidades<20){
            for(int b=1;b<21;b++){
                bodega_3[producto][b]="-";
            }System.out.println("Actualizando Producto #"+producto);
            
            for(int c=1;c<=contador_unidades+ingreso;c++){
                bodega_3[producto][c]="B3P"+producto+","+c;
            }
                espacios_b3=espacios_b3-ingreso;
                mostrar_bodega3();
                estado_mR=true;
                
            }
            
            }catch(Exception e){
                System.out.println("Error: "+e);
                System.out.println("Regresando...");
                reabastecimiento();
                    }
        } 
        if(num_bodega==4){
            try{
            int contador_unidades=0;

            int lim_max=0;
            //---------------------contara las unidades en bodega
            for(int a=1;a<21;a++){
                if(bodega_4[producto][a]!="-"){
                contador_unidades++;
                }
            }System.out.println("Existen: "+contador_unidades+" de Producto #"+num_productos);
            //-------------
            if(contador_unidades==20){
                System.out.println("No hay mas espacios...");
                estado_mR=false;
            }
            if(contador_unidades<20){
            for(int b=1;b<21;b++){
                bodega_4[producto][b]="-";
            }System.out.println("Actualizando Producto #"+producto);
            
            for(int c=1;c<=contador_unidades+ingreso;c++){
                bodega_4[producto][c]="B4P"+producto+","+c;
            }
                espacios_b4=espacios_b4-ingreso;
                mostrar_bodega4();
                estado_mR=true;
                
            }
            
            }catch(Exception e){
                System.out.println("Error: "+e);
                System.out.println("Regresando...");
                reabastecimiento();
                    }
        } 
        if(num_bodega==5){
            try{
            int contador_unidades=0;

            int lim_max=0;
            //---------------------contara las unidades en bodega
            for(int a=1;a<21;a++){
                if(bodega_5[producto][a]!="-"){
                contador_unidades++;
                }
            }System.out.println("Existen: "+contador_unidades+" de Producto #"+num_productos);
            //-------------
            if(contador_unidades==20){
                System.out.println("No hay mas espacios...");
                estado_mR=false;
            }
            if(contador_unidades<20){
            for(int b=1;b<21;b++){
                bodega_5[producto][b]="-";
            }System.out.println("Actualizando Producto #"+producto);
            
            for(int c=1;c<=contador_unidades+ingreso;c++){
                bodega_5[producto][c]="B5P"+producto+","+c;
            }
                espacios_b5=espacios_b5-ingreso;
                mostrar_bodega5();
                estado_mR=true;
                
            }
            }catch(Exception e){
                System.out.println("Error: "+e);
                System.out.println("Regresando...");
                reabastecimiento();
                    }
        } 
        if(num_bodega==6){
            try{
            int contador_unidades=0;

            int lim_max=0;
            //---------------------contara las unidades en bodega
            for(int a=1;a<21;a++){
                if(bodega_6[producto][a]!="-"){
                contador_unidades++;
                }
            }System.out.println("Existen: "+contador_unidades+" de Producto #"+num_productos);
            //-------------
            if(contador_unidades==20){
                System.out.println("No hay mas espacios...");
                estado_mR=false;
            }
            if(contador_unidades<20){
            for(int b=1;b<21;b++){
                bodega_6[producto][b]="-";
            }System.out.println("Actualizando Producto #"+producto);
            
            for(int c=1;c<=contador_unidades+ingreso;c++){
                bodega_6[producto][c]="B6P"+producto+","+c;
            }
                espacios_b6=espacios_b6-ingreso;
                mostrar_bodega6();
                estado_mR=true;
                
            }
            }catch(Exception e){
                System.out.println("Error: "+e);
                System.out.println("Regresando...");
                reabastecimiento();
                    }
        } 
        
    }
        
    static void papelero(){
            System.out.println("Reiniciando Kardex...");
            //metodo kardex para el reinicio ->reiniciando valores de kardex
            tot_existencias_anterior=0;
            num_existencias=0;
            tot_existencias=0;// guardara un nuevo valor de las existencias
            while(fila_nueva>1){//buscara el valor de la fila en el kardex hasta que deje de ser mayor a 1 este borrara las filas...
                kardex[fila_nueva][0]=null;
                kardex[fila_nueva][5]=null;
            
                kardex[fila_nueva][6]=null;//total
                fila_nueva--; //contador de filas
                //contador de existencia anterior
            }
            //fin kardex
                                    
                                    if(num_bodega==1){ System.out.println("•••Vaciando Bodega #"+num_bodega);
                                        System.out.println("→| Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_1[x][y]="-";
                                                                }
                                                                }
                                            espacios_b1=100;
                                        datos_prueba();
                                }
                                    if(num_bodega==2){ System.out.println("•••Vaciando Bodega #"+num_bodega);
                                            System.out.println("→| Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_2[x][y]="-";
                                                                }
                                                                }
                                            espacios_b2=100;
                                        datos_prueba();
                                }
                                    if(num_bodega==3){ System.out.println("•••Vaciando Bodega #"+num_bodega);
                                            System.out.println("→| Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_3[x][y]="-";
                                                                }
                                                                }
                                            espacios_b3=100;
                                        datos_prueba();
                                }
                                    if(num_bodega==4){ System.out.println("•••Vaciando Bodega #"+num_bodega);
                                            System.out.println("→| Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_4[x][y]="-";
                                                                }
                                                                }
                                            espacios_b4=100;
                                        datos_prueba();
                                }
                                    if(num_bodega==5){ System.out.println("•••Vaciando Bodega #"+num_bodega);
                                            System.out.println("→| Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_5[x][y]="-";
                                                                }
                                                                }
                                            espacios_b5=100;
                                        datos_prueba();
                                }
                                    if(num_bodega==6){ System.out.println("•••Vaciando Bodega #"+num_bodega);
                                            System.out.println("→| Bodega #"+num_bodega+" vacia ");
                                            
                                            //modificacion de revision de nulos convirtiendolos a nulos totales
                                            for(int x=1;x<6;x++){
                                            for(int y=1;y<21;y++){
                                            bodega_6[x][y]="-";
                                                                }
                                                                }
                                            espacios_b6=100;
                                        datos_prueba();
                                }
        }
    
    static void verificar_existencias(){
        
            
            int unidades_existentes=0;
            for(int k=1;k<21;k++){
                if(bodega_1[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                } if(bodega_2[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                } if(bodega_3[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                } if(bodega_4[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                } if(bodega_5[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                } if(bodega_6[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                }
                
            }System.out.println("Unidades de Existentes del Producto #"+num_productos+" :"+unidades_existentes);
            if(unidades_existentes==0){
                productos_existentes=false;
            }
            if(unidades_existentes>0){
                productos_existentes=true;
                existencias_venta=unidades_existentes;
            }
        
        
    }
    
    static void verificar_promedio(){
        
            
            int unidades_existentes=0;
            for(int k=1;k<21;k++){
                if(bodega_1[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                } if(bodega_2[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                } if(bodega_3[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                } if(bodega_4[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                } if(bodega_5[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                } if(bodega_6[num_productos][k]!="-"){
                    unidades_existentes++;
                    
                }
                
            }System.out.println("Promedio de Existencias del Producto #"+num_productos+" :"+(unidades_existentes)/5);
            
        
        
    }
    
    static void vender(int producto,int salida){
            
        int unidades_restantes=salida;
        int lim_bodega1=20;//0
        int lim_bodega2=20;//20
        int lim_bodega3=20;//40
        int lim_bodega4=20;//60
        int lim_bodega5=20;//80
        int lim_bodega6=20;//100        
        
        
        //------------------------------------

        System.out.println("Repartiendo unidades por bodega....");
        
        
         //-----------------   
         if(salida<=20){
        int contador_unidades=0;
        
        for(int a=1;a<21;a++){
            if(bodega_1[producto][a]!="-"){
                contador_unidades++;
            }
        } 
        //vacio
        for(int i=1;i<21;i++){
            bodega_1[producto][i]="-";
        }
        //ordenado y llenado
        for(int b=1;b<=contador_unidades;b++){
            bodega_1[producto][b]="B1P"+producto+","+b;
        }

        int limite=contador_unidades-salida;
             
        //vacio
        for(int i=1;i<21;i++){
            bodega_1[producto][i]="-";
        }
        //ordenado y llenado
        for(int d=1;d<=limite;d++){
            bodega_1[producto][d]="B1P"+producto+","+d;
        }
        espacios_b1=espacios_b1+salida;
            
        venta_realizada=true;
        } 
        
        
        
        //-------------------------------------------------
        if(venta_realizada==true){
            System.out.println("Se ha vendido: "+salida+" unidades");    
        }else if(venta_realizada==false){
            System.out.println("Fallo al realizar venta.. Regresando");
            salida_productos();
        }
        //-----------------------------------------------------    
        
                    
    }
    
}    