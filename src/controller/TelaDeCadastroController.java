package controller;

import model.*;
import view.*;



public class TelaDeCadastroController extends TelaDeCadastroView{
    public static void cadastrarController(){
        TelaDeCadastroModel.cadastrarModel(txtNome.getText(),txtEmail.getText(), String.valueOf(txtSenha.getPassword()));
    }

    
}
