/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca_rev_01_italian;

/**
 *
 * @author cristiannicola
 */
public class Persona {
        
private String nome;
private String cognome; 
private String email;
private String telefono;
    
    public Persona(String nome,String cognome, String email, String telefono){

    this.nome=nome;
    this.cognome=cognome;
    this.email=email;
    this.telefono=telefono;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
   
     public void setCognome(String cognome){
        this.cognome=cognome;
    }
   
     public void setEmail(String email){
        this.email=email;
    }
     
     public void setTelefono(String telefono){
         this.telefono=telefono;
     }
   
     public void getTutto(){
         System.out.println("Nome: "+nome+"\n"+"Cognome: "+cognome+"\n"+"Email: "+email+"\n"+"Telefono: "+ telefono+"\n");
     }
     
    
     
}


