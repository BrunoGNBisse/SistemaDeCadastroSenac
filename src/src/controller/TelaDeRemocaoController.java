package controller;

import view.*;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TelaDeRemocaoController extends TelaDeRemocaoView{
    public static void removerController(){
        TelaDeRemocaoModel.removerModel(String.valueOf(cbxId.getSelectedItem()));
    }

    public static void popularCbxIdController(){
        TelaDeRemocaoModel.popularCbxIdModel();
    }

    public static void adicionarItemCbxId(String str){
        cbxId.addItem(str);
    }

    public static void preencherCampos(String nome, String email){
        txtNome.setText(nome);
        txtEmail.setText(email);
    }

    public static void atualizarCamposController(){
        TelaDeRemocaoModel.atualizarCamposModel(String.valueOf(cbxId.getSelectedItem()));
    }
}
