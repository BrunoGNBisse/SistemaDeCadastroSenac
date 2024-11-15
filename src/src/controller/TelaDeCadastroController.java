package controller;

import model.*;
import view.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeCadastroController extends TelaDeCadastroView{
    public static void cadastrarController(){
        TelaDeCadastroModel.cadastrarModel(txtNome.getText(),txtEmail.getText(), String.valueOf(txtSenha.getPassword()));
    }

    
}
