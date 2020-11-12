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
public class Controllo {

    public Controllo(){
        
    }
    
        public boolean checkIdentity(String login, String password,Conto[]Conti,boolean check_identity,int numero_conti){
        boolean check_login=false;
        boolean check_password=false;
         check_identity=false;
        int num=9;
        
        for (int i = 0; i < numero_conti; i++) {
            if(Conti[i].getLogin().equals(login)){
                num=i;
                check_login=true;
            }
        }
        
        if(check_login){
            if(password.equals(Conti[num].getPassword())){
                check_password=true;
            }
        }
    
        if(check_login==true&&check_password==true){
            check_identity=true;
        }
        
        return check_identity;
    }
        
        
        
        public int checkPosition(String login,Conto[]Conti,boolean check_identity,int numero_conti){
            
        
        boolean check_login=false;
        check_identity=false;
        int num=34;
        
        
        for (int i = 0; i < numero_conti; i++) {
            if(Conti[i].getLogin().equals(login)){
                num=i;
                check_login=true;
            }
        } 
        return num;
        
        
}
        
        
        public boolean check_equal(String login,Conto[]Conti,int numero_conti){

            boolean check_equal=false;
            for (int i = 0; i < numero_conti; i++) {
            if(Conti[i].getLogin().equals(login)){
                check_equal=true;
            }
            
            
            
        } return check_equal;
}
        
} 

