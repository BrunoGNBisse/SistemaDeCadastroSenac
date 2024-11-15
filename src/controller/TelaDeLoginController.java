package controller;

import view.*;
import model.*;


import java.util.ArrayList;



public class TelaDeLoginController extends TelaDeLoginView {
    public static void logarController(){
        // chama o metodo da model
        ArrayList<String> resultados = new ArrayList<String>(TelaDeLoginModel.logarModel(txtLogin.getText(), String.valueOf(txtSenha.getPassword()))) ;
        resultados.size();
    }    
}
