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
import model.bean.ContasReceber;
import model.bean.Alunos;

public class ContasReceberDAO {

    Connection con;

    public ContasReceberDAO() {
        con = ConnectionFactory.getConnection();

    }

    public void Inserir(ContasReceber cr) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into ContasReceber(matricula,nome,emissao,vencimento,parcela,descricao,valorParcela,desconto,dias,juros,valorTotal,situacao)values(?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, cr.getMatricula());
            stmt.setString(2, cr.getNome());
            stmt.setString(3, cr.getEmissao());
            stmt.setString(4, cr.getVencimento());
            stmt.setInt(5, cr.getParcela());
            stmt.setString(6, cr.getDescricao());
            stmt.setFloat(7, cr.getValorparcela());
            stmt.setFloat(8, cr.getDesconto());
            stmt.setInt(9, cr.getDias());
            stmt.setFloat(10, cr.getJuros());
            stmt.setFloat(11, cr.getValortotal());
            stmt.setString(12, cr.getSituacao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "cadastrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void Alterar(ContasReceber cr) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update ContasReceber set matricula=?,nome=?,emissao=?,vencimento=?,parcela=?,descricao=?,valorParcela=?,desconto=?,dias=?,juros=?,valorTotal=?,situacao=? where idreceber = ?");
            stmt.setInt(1, cr.getMatricula());
            stmt.setString(2, cr.getNome());
            stmt.setString(3, cr.getEmissao());
            stmt.setString(4, cr.getVencimento());
            stmt.setInt(5, cr.getParcela());
            stmt.setString(6, cr.getDescricao());
            stmt.setFloat(7, cr.getValorparcela());
            stmt.setFloat(8, cr.getDesconto());
            stmt.setInt(9, cr.getDias());
            stmt.setFloat(10, cr.getJuros());
            stmt.setFloat(11, cr.getValortotal());
            stmt.setString(12, cr.getSituacao());
            stmt.setInt(13, cr.getIdreceber());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    

    // Método para alimentar tabela de pesquisa fornecedor para o contas a pagar
    public List<Alunos> Pesquisar_Aluno(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Alunos> alunos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select IdMatricula as ID, nome as Nome, cpf as CPF from Alunos where nome like ?");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Alunos aluno = new Alunos();

                aluno.setId(rs.getInt("matricula"));
                aluno.setNome(rs.getString("nome"));

                alunos.add(aluno);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return alunos;

    }

    public List<ContasReceber> leitura() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ContasReceber> contasareceber = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from ContasReceber");
            rs = stmt.executeQuery();

            while (rs.next()) {

                ContasReceber contasreceber = new ContasReceber();

                contasreceber.setIdreceber(rs.getInt("idreceber"));
                contasreceber.setMatricula(rs.getInt("matricula"));
                contasreceber.setNome(rs.getString("nome"));
                contasreceber.setEmissao(rs.getString("emissao"));
                contasreceber.setVencimento(rs.getString("vencimento"));
                contasreceber.setParcela(rs.getInt("parcela"));
                contasreceber.setDescricao(rs.getString("descricao"));
                contasreceber.setValorparcela(rs.getFloat("valorParcela"));
                contasreceber.setDesconto(rs.getFloat("desconto"));
                contasreceber.setDias(rs.getInt("dias"));
                contasreceber.setJuros(rs.getFloat("juros"));
                contasreceber.setValortotal(rs.getFloat("valortotal"));
                contasreceber.setSituacao(rs.getString("situacao"));

                contasareceber.add(contasreceber);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return contasareceber;

    }

    public List<ContasReceber> Pesquisar_Lancamentos(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ContasReceber> contasareceber = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from ContasReceber where nome like ?");
            stmt.setString(1,"%"+nome+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                
               ContasReceber contasreceber = new ContasReceber();

                contasreceber.setIdreceber(rs.getInt("idreceber"));
                contasreceber.setMatricula(rs.getInt("matricula"));
                contasreceber.setNome(rs.getString("nome"));
                contasreceber.setEmissao(rs.getString("emissao"));
                contasreceber.setVencimento(rs.getString("vencimento"));
                contasreceber.setParcela(rs.getInt("parcela"));
                contasreceber.setDescricao(rs.getString("descricao"));
                contasreceber.setValorparcela(rs.getFloat("valorParcela"));
                contasreceber.setDesconto(rs.getFloat("desconto"));
                contasreceber.setDias(rs.getInt("dias"));
                contasreceber.setJuros(rs.getFloat("juros"));
                contasreceber.setValortotal(rs.getFloat("valortotal"));
                contasreceber.setSituacao(rs.getString("situacao"));

                contasareceber.add(contasreceber);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContasReceberDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return contasareceber;

    }


 public void excluir(ContasReceber cr) {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse lançamento?", "Atenção", JOptionPane.YES_NO_OPTION);
        PreparedStatement stmt = null;

        if (confirma == JOptionPane.YES_OPTION) {
            try {
                stmt = con.prepareStatement("delete from ContasReceber WHERE idreceber = ?");
                stmt.setInt(1, cr.getIdreceber());

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