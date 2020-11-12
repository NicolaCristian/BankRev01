/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca_rev_01_italian;

import java.util.ArrayList;

/**
 *
 * @author cristiannicola
 */
public class Conto extends Persona {
    
    
    
    private String login;
    private String password;
    private int saldo;
    private ArrayList <String> movements_list= new ArrayList();

    
    
    public Conto(String nome, String cognome, String email, String telefono,String login, String password,int saldo){

        super(nome, cognome, email, telefono);
        this.login=login;
        this.password=password;
        this.saldo=saldo;
        

        
    }
    
      public void setLogin(String login){
        this.login=login;
    }
      public void setPassword(String password){
        this.password=password;
    }
    
      public void setSaldo(int saldo){
        this.saldo=saldo;
    }
      
      public void setRegister(String register){
          movements_list.add(register);
      }
    
      
      
      public String getLogin(){
           return login;
       }
       
      public String getPassword(){
           return password;
       }
      
       public int getSaldo(){
           return saldo;
       }
       

       
       
    @Override
       public void getTutto(){
           super.getTutto();
           System.out.println("login: "+login+"\n"+"Password: "+password+"\n"+"Saldo: "+saldo);
       }
       
       
       public void get_Generality(){
         super.getTutto();
       }
       
       
    public void getMovementList(){
        for (int i = 0; i < movements_list.size(); i++) {
            System.out.println(movements_list.get(i));
        }
        ;  
    }  
 
    }
       
       



