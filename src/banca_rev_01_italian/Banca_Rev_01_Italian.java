/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca_rev_01_italian;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author cristiannicola
 */
public class Banca_Rev_01_Italian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
 Scanner sc = new Scanner(System.in);       
 String nome;
 String cognome; 
 String email;
 String telefono;
 String login;
 String password;
 int saldo;

 Conto conti[]=new Conto[20];
 
 

 
 //variabili varie
 int num=0;
 int controllo=0;
 boolean check_identity=false;
 boolean check_equal=false;
 int check_position=0;
 Controllo control = new Controllo();
 int numero_conti=0;
 
 

        System.out.println("////////////////////////////////");
        System.out.println("///BENVENUTO NELLA TUA BANCA////");
        System.out.println("////////////////////////////////");
        System.out.println("");
        System.out.println("");
        
        while(controllo!=3){
        System.out.println("");
        System.out.println("");
        System.out.println("Che cosa vuoi fare: ");
        System.out.println("");
        System.out.println("1.CREA CONTO ");
        System.out.println("2.ACCEDI AL CONTO");
        System.out.println("");
        System.out.println("Seleziona funzione");
        controllo = sc.nextInt();
        switch(controllo){
            
            
            case 1: while(conti[num]!=null&&numero_conti<20){
                num++;
            } 
            System.out.println("Conto numero:   "+num);   
            System.out.println("");    
            System.out.println("Inserisci nome: ");
            nome=sc.next();
            System.out.println("Inserisci cognome: ");
            cognome=sc.next();
            System.out.println("Inserisci email: ");
            email=sc.next();
            System.out.println("Inserisci telefono: ");
            telefono=sc.next();
            
            //verifico la presenza di un altro utente con lo stesso username
            do{
            System.out.println("Inserisci login: ");
            login=sc.next();
            
            check_equal=control.check_equal(login, conti,numero_conti);
            if(check_equal){
                System.out.println("L'utente è già esistente, si prega di accedere o di inserire un nuovo username");
            }
            
            }while(check_equal);
 
            System.out.println("Inserisci password: ");
            password=sc.next();
            System.out.println("Inserisci saldo iniziale: ");
            saldo=sc.nextInt();
            Conto c= new Conto(nome,cognome,email,telefono,login,password,saldo);
            conti[num]=c;
            numero_conti++;
            System.out.println("Numero conti"+numero_conti);
                  
            break;
            
            
            
            case 2: 
                
            System.out.println("Inserisci login: ");
            login=sc.next();
            System.out.println("Inserisci password: ");
            password=sc.next();
            
            check_identity=control.checkIdentity(login, password, conti, check_identity,numero_conti);
            check_position=control.checkPosition(login, conti, check_identity,numero_conti);
           
                
                
                if(check_identity){
                    System.out.println("Accesso eseguito");
                    System.out.println("");
                    System.out.println("");
                    /////////MENU CONTO//////////
                    int menu=0;
                    int money_deposited;
                    int money_withdrawn;
                    


                    
                    while(menu!=6){
                    System.out.println("/////MENU DEL CONTO/////");
                    System.out.println("");
                    System.out.println("1. Visualizza generalità ");
                    System.out.println("2. Visualizza saldo");
                    System.out.println("3. Deposita soldi");
                    System.out.println("4. Preleva soldi");
                    System.out.println("5. Visualizza registro operazioni");
                    System.out.println("6. Torna al menu iniziale");
                    System.out.println("");
                    System.out.println("Cosa vuoi fare?");
                    menu=sc.nextInt();
                    System.out.println("");
                    System.out.println("");
                    
                    switch(menu){
                        
                        //visualizza informazioni proprietario conto
                        case 1: 
                                System.out.println("");
                                System.out.println("Di seguito le informazioni del conto");
                                conti[check_position].get_Generality();
                                break;
                                
                        case 2:  
                                System.out.println("");
                                System.out.println("il saldo del suo conto corrente è di "+conti[check_position].getSaldo()+" euro");
                                System.out.println("");
                                break;
                                
                        case 3:        
                                System.out.println("");
                                System.out.println("-----DEPOSITO SOLDI-----");
                                System.out.println("");
                                System.out.println("Quanto vuole depositare?");
                                money_deposited=sc.nextInt();
                                System.out.println("");
                                saldo=conti[check_position].getSaldo()+money_deposited;
                                conti[check_position].setSaldo(saldo);
                                System.out.println("");
                                System.out.println("");
                                Date date = Calendar.getInstance ().getTime();  
                                DateFormat dateFormat =  new  SimpleDateFormat ( "yyyy-mm-dd hh: mm: ss" );  
                                String str=date.toString();
                                String deposito="- Deposito di "+money_deposited +" euro " + "data "+str+"\n";
                                conti[check_position].setRegister(deposito);
                                System.out.println("Nuovo saldo: "+conti[check_position].getSaldo());
                                System.out.println("");
                                break;
                                
                        case 4: 
                               System.out.println("");
                                System.out.println("-----PRELIEVO SOLDI-----");
                                System.out.println("");
                                System.out.println("Quanto vuole prelevare?");
                                money_withdrawn=sc.nextInt();
                                System.out.println("");                                
                                saldo=conti[check_position].getSaldo() - money_withdrawn;
                                if(conti[check_position].getSaldo()<money_withdrawn){
                                    System.out.println("OPERAZIONE FALLITA: Saldo insufficiente"); 
                                    System.out.println("");
                                } else {
                                    saldo=conti[check_position].getSaldo()-money_withdrawn;
                                    conti[check_position].setSaldo(saldo);
                                    Date date_1 = Calendar.getInstance ().getTime();  
                                    DateFormat dateFormat_1 =  new  SimpleDateFormat ( "yyyy-mm-dd hh: mm: ss" );  
                                    String str1=date_1.toString();
                                    String prelievo="- Prelievo di "+money_withdrawn +" euro " + "data "+str1+"\n";
                                    conti[check_position].setRegister(prelievo);
                                    System.out.println("Nuovo saldo: "+conti[check_position].getSaldo());
                                    System.out.println("");
                                }
                                

                                break;
                                
                        case 5:
                            System.out.println("---Registro Movimenti---");
                            System.out.println("");
                            conti[check_position].getMovementList();
                            System.out.println("");
                                
                                
                    }
                    
                }
                
                
        } else {
                    System.out.println("Credenziali errate, Riprova");
                }
        } 
        }    
    }
}
    


