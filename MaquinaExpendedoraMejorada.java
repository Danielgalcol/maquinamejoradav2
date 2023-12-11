public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    //Cuenta n? billetes
    private int numBilletesVendidos;

    private boolean premios;

    private int billetesVendidos;

    private int billetesDisponibles;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino,boolean hayPremios,  int billetesQueremosVender) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        premios = hayPremios;
        billetesDisponibles = billetesQueremosVender;
        billetesVendidos = 0;
    }

    /**
     * nuevo constructor
     */
    public MaquinaExpendedoraMejorada(boolean hayPremios, int billetesQueremosVender){
        precioBillete = 10;
        estacionOrigen = "Leon";
        estacionDestino = "Oviedo";
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        numBilletesVendidos = 0;
        premios = hayPremios;
        billetesDisponibles = billetesQueremosVender;
        billetesVendidos = 0;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(billetesDisponibles > billetesVendidos){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }   
        }
        else{
            System.out.println("Lo sentimos ha habido un error al introducir dinero ya que no hay m?s billetes.");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        
        if(billetesVendidos >= billetesDisponibles){
            System.out.println("Lo sentimos ya se han vendido todos los billetes.");
        }

        else{
            if(premios == false){
                if (balanceClienteActual >= precioBillete) {        
                    // Simula la impresion de un billete
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("# " + precioBillete + " euros.");
                    System.out.println("##################");
                    System.out.println();         

                    // Actualiza el total de dinero acumulado en la maquina
                    totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                    // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                    balanceClienteActual = balanceClienteActual - precioBillete;
                    billetesVendidos++;
                }
                else {
                    System.out.println("Necesitas introducir " + (precioBillete - balanceClienteActual) + " euros mas!");

                }    
            }
            else{
                if (balanceClienteActual >= precioBillete) {        
                    // Simula la impresion de un billete
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("# " + precioBillete + " euros.");
                    System.out.println("##################");
                    System.out.println();         

                    // Actualiza el total de dinero acumulado en la maquina
                    totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                    // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                    balanceClienteActual = balanceClienteActual - precioBillete;
                    billetesVendidos++;
                    if(billetesVendidos > 0 && billetesVendidos %3 == 0){
                        System.out.println("#Enhorabuena querido cliente usted se ha ganado un descuento de " + (precioBillete*0.1) +  "$ para comprar en el Carrefour");
                        
                    }
                }
                else {
                    System.out.println("Necesitas introducir " + (precioBillete - balanceClienteActual) + " euros mas!");

                } 
            }
        }       
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
