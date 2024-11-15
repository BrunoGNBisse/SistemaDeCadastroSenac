
package model;

import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDeRemocaoModel {
    public static void removerModel(String id){
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlRemoverId = "delete from `db_senac`.`tbl_senac` where `id` = " + id + ";";
            Statement stmSqlRemoverId = conexao.createStatement();
            stmSqlRemoverId.addBatch(strSqlRemoverId);
            stmSqlRemoverId.executeBatch();
            TelaDeRemocaoController.notificarUsuario("O id " + id + " foi removido com sucesso.");
        } catch (Exception e) {
            TelaDeRemocaoController.notificarUsuario("Ops! Problema no servidor, tente novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
    }
    public static void popularCbxIdModel(){
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlPopularCbxId = "select * from `db_senac`.`tbl_senac` order by `id` asc;";
            Statement stmSqlPopularCbxId = conexao.createStatement();
            ResultSet rstSqlPopularCbxId = stmSqlPopularCbxId.executeQuery(strSqlPopularCbxId);
            while (rstSqlPopularCbxId.next()) {
                TelaDeRemocaoController.adicionarItemCbxId(rstSqlPopularCbxId.getString("id"));
            }
            stmSqlPopularCbxId.close();
        } catch (Exception e) {
            TelaDeRemocaoController.notificarUsuario("Ops! Ocorreu um problema no servidor e não será possível carregar os ids neste momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
    }

    public static void atualizarCamposModel(String strId){
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where id = " + strId + ";";
            Statement stmSqlAtualizarCampos = conexao.createStatement();
            ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos);
            if (rstSqlAtualizarCampos.next()) {
                TelaDeRemocaoController.preencherCampos(rstSqlAtualizarCampos.getString("nome"),rstSqlAtualizarCampos.getString("email"));
                
            } else {
                TelaDeRemocaoController.notificarUsuario("Id não encontrado.");
            }
        } catch (Exception e) {
            TelaDeRemocaoController.notificarUsuario("Ops! Problema no servidor. Tente novamente mais tarde.");
            System.err.println("Erro: " + e);
        }
    }
}
