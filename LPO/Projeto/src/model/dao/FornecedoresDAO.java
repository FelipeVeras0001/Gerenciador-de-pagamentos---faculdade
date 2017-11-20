/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Fornecedores;

/**
 *
 * @author R
 */
public class FornecedoresDAO {

    Connection con;

    public FornecedoresDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void Inserir(Fornecedores f) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into fornecedores(razao,CNPJ,telefone,celular,email,endereco,bairro,complemento,UF,cidade,CEP)values(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, f.getRazao());
            stmt.setString(2, f.getCnpj());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getCelular());
            stmt.setString(5, f.getEmail());
            stmt.setString(6, f.getEndereco());
            stmt.setString(7, f.getBairro());
            stmt.setString(8, f.getComplemento());
            stmt.setString(9, f.getUf());
            stmt.setString(10, f.getCidade());
            stmt.setString(11, f.getCep());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "cadastrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Fornecedores> leitura() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fornecedores> fornecedores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from Fornecedores");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedores fornecedor = new Fornecedores();

                fornecedor.setId(rs.getInt("idforn"));
                fornecedor.setRazao(rs.getString("razao"));
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCelular(rs.getString("celular"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setComplemento(rs.getString("complemento"));
                fornecedor.setUf(rs.getString("UF"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setCep(rs.getString("CEP"));

                fornecedores.add(fornecedor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return fornecedores;

    }
    
    public List<Fornecedores> Pesquisar_Fornecedor(String razao) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fornecedores> fornecedores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from Fornecedores where razao like ?");
            stmt.setString(1,"%"+razao+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedores fornecedor = new Fornecedores();

                fornecedor.setId(rs.getInt("idforn"));
                fornecedor.setRazao(rs.getString("razao"));
                fornecedor.setCnpj(rs.getString("CNPJ"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCelular(rs.getString("celular"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setComplemento(rs.getString("complemento"));
                fornecedor.setUf(rs.getString("UF"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setCep(rs.getString("CEP"));

                fornecedores.add(fornecedor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return fornecedores;

    }

    public void alterar(Fornecedores f) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update fornecedores set razao=?,CNPJ=?,telefone=?,celular=?,email=?,endereco=?,bairro=?,complemento=?,UF=?,cidade=?,CEP=? where idforn = ?");
            stmt.setString(1, f.getRazao());
            stmt.setString(2, f.getCnpj());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, f.getCelular());
            stmt.setString(5, f.getEmail());
            stmt.setString(6, f.getEndereco());
            stmt.setString(7, f.getBairro());
            stmt.setString(8, f.getComplemento());
            stmt.setString(9, f.getUf());
            stmt.setString(10, f.getCidade());
            stmt.setString(11, f.getCep());
            stmt.setInt(12, f.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void excluir(Fornecedores f) {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse fornecedor?", "Atenção", JOptionPane.YES_NO_OPTION);
        PreparedStatement stmt = null;

        if (confirma == JOptionPane.YES_OPTION) {
            try {
                stmt = con.prepareStatement("delete from Fornecedores WHERE idforn = ?");
                stmt.setInt(1, f.getId());

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }

        }
    }
}

