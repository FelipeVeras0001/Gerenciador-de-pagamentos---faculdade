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
import model.bean.Alunos;

/**
 *
 * @author R
 */
public class AlunosDAO {

    Connection con;

    public AlunosDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void Inserir(Alunos a) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into Alunos(nome,cpf,rg,sexo,dataMatricula,dataNasc,telefone,celular,email,endereco,bairro,complemento,UF,cidade,CEP)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getCpf());
            stmt.setString(3, a.getRg());
            stmt.setString(4, a.getSexo());
            stmt.setString(5, a.getDataMatric());
            stmt.setString(6, a.getDataNasc());
            stmt.setString(7, a.getTelefone());
            stmt.setString(8, a.getCelular());
            stmt.setString(9, a.getEmail());
            stmt.setString(10, a.getEndereco());
            stmt.setString(11, a.getBairro());
            stmt.setString(12, a.getComplemento());
            stmt.setString(13, a.getUf());
            stmt.setString(14, a.getCidade());
            stmt.setString(15, a.getCep());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "cadastrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Alunos> leitura() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Alunos> alunos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from Alunos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Alunos aluno = new Alunos();

                aluno.setId(rs.getInt("idMatricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setRg(rs.getString("rg"));
                aluno.setSexo(rs.getString("sexo"));
                aluno.setDataMatric(rs.getString("dataMatricula"));
                aluno.setDataNasc(rs.getString("dataNasc"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setEmail(rs.getString("email"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setComplemento(rs.getString("complemento"));
                aluno.setUf(rs.getString("UF"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setCep(rs.getString("CEP"));

                alunos.add(aluno);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return alunos;

    }
    
    public List<Alunos> Pesquisar_Alunos(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Alunos> alunos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from Alunos where nome like ?");
            stmt.setString(1,"%"+nome+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Alunos aluno = new Alunos();

                aluno.setId(rs.getInt("idMatricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setRg(rs.getString("rg"));
                aluno.setSexo(rs.getString("sexo"));
                aluno.setDataMatric(rs.getString("dataMatricula"));
                aluno.setDataNasc(rs.getString("dataNasc"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setEmail(rs.getString("email"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setComplemento(rs.getString("complemento"));
                aluno.setUf(rs.getString("UF"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setCep(rs.getString("CEP"));

                alunos.add(aluno);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return alunos;

    }

    public void alterar(Alunos a) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update Alunos set nome=?,cpf=?,rg=?,sexo=?,dataMatricula=?,dataNasc=?,telefone=?,celular=?,email=?,endereco=?,bairro=?,complemento=?,UF=?,cidade=?,CEP=? where idMatricula = ?");
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getCpf());
            stmt.setString(3, a.getRg());
            stmt.setString(4, a.getSexo());
            stmt.setString(5, a.getDataMatric());
            stmt.setString(6, a.getDataNasc());
            stmt.setString(7, a.getTelefone());
            stmt.setString(8, a.getCelular());
            stmt.setString(9, a.getEmail());
            stmt.setString(10, a.getEndereco());
            stmt.setString(11, a.getBairro());
            stmt.setString(12, a.getComplemento());
            stmt.setString(13, a.getUf());
            stmt.setString(14, a.getCidade());
            stmt.setString(15, a.getCep());
            stmt.setInt(16, a.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void excluir(Alunos a) {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse aluno?", "Atenção", JOptionPane.YES_NO_OPTION);
        PreparedStatement stmt = null;

        if (confirma == JOptionPane.YES_OPTION) {
            try {
                stmt = con.prepareStatement("delete from Alunos WHERE idMatricula = ?");
                stmt.setInt(1, a.getId());

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

