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
import model.bean.ContasPagar;
import model.bean.Fornecedores;

public class ContasPagarDAO {

    Connection con;

    public ContasPagarDAO() {
        con = ConnectionFactory.getConnection();

    }

    public void Inserir(ContasPagar cp) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into ContasPagar(idforn,razao,emissao,vencimento,doc,descricao,valorParcela,desconto,dias,juros,valorTotal,situacao)values(?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, cp.getId());
            stmt.setString(2, cp.getRazao());
            stmt.setString(3, cp.getEmissao());
            stmt.setString(4, cp.getVencimento());
            stmt.setString(5, cp.getDoc());
            stmt.setString(6, cp.getDescricao());
            stmt.setFloat(7, cp.getValorparcela());
            stmt.setFloat(8, cp.getDesconto());
            stmt.setInt(9, cp.getDias());
            stmt.setFloat(10, cp.getJuros());
            stmt.setFloat(11, cp.getValortotal());
            stmt.setString(12, cp.getSituacao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "cadastrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void Alterar(ContasPagar cp) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update ContasPagar set idforn=?,razao=?,emissao=?,vencimento=?,doc=?,descricao=?,valorParcela=?,desconto=?,dias=?,juros=?,valorTotal=?,situacao=? where idpagar = ?");
            stmt.setInt(1, cp.getId());
            stmt.setString(2, cp.getRazao());
            stmt.setString(3, cp.getEmissao());
            stmt.setString(4, cp.getVencimento());
            stmt.setString(5, cp.getDoc());
            stmt.setString(6, cp.getDescricao());
            stmt.setFloat(7, cp.getValorparcela());
            stmt.setFloat(8, cp.getDesconto());
            stmt.setInt(9, cp.getDias());
            stmt.setFloat(10, cp.getJuros());
            stmt.setFloat(11, cp.getValortotal());
            stmt.setString(12, cp.getSituacao());
            stmt.setInt(13, cp.getIdpagar());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    

    // Método para alimentar tabela de pesquisa fornecedor para o contas a pagar
    public List<Fornecedores> Pesquisar_Forn(String razao) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Fornecedores> fornecedores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select idforn as ID, razao as Nome_Razao, telefone as Telefone from Fornecedores where razao like ?");
            stmt.setString(1, "%" + razao + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedores fornecedor = new Fornecedores();

                fornecedor.setId(rs.getInt("idforn"));
                fornecedor.setRazao(rs.getString("razao"));

                fornecedores.add(fornecedor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return fornecedores;

    }

    public List<ContasPagar> leitura() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ContasPagar> contasapagar = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from ContasPagar");
            rs = stmt.executeQuery();

            while (rs.next()) {

                ContasPagar contaspagar = new ContasPagar();

                contaspagar.setIdpagar(rs.getInt("idpagar"));
                contaspagar.setId(rs.getInt("idforn"));
                contaspagar.setRazao(rs.getString("razao"));
                contaspagar.setEmissao(rs.getString("emissao"));
                contaspagar.setVencimento(rs.getString("vencimento"));
                contaspagar.setDoc(rs.getString("doc"));
                contaspagar.setDescricao(rs.getString("descricao"));
                contaspagar.setValorparcela(rs.getFloat("valorParcela"));
                contaspagar.setDesconto(rs.getFloat("desconto"));
                contaspagar.setDias(rs.getInt("dias"));
                contaspagar.setJuros(rs.getFloat("juros"));
                contaspagar.setValortotal(rs.getFloat("valortotal"));
                contaspagar.setSituacao(rs.getString("situacao"));

                contasapagar.add(contaspagar);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return contasapagar;

    }

    public List<ContasPagar> Pesquisar_Lancamentos(String razao) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ContasPagar> contasapagar = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from ContasPagar where razao like ?");
            stmt.setString(1,"%"+razao+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                ContasPagar contaspagar = new ContasPagar();

                contaspagar.setIdpagar(rs.getInt("idpagar"));
                contaspagar.setId(rs.getInt("idforn"));
                contaspagar.setRazao(rs.getString("razao"));
                contaspagar.setEmissao(rs.getString("emissao"));
                contaspagar.setVencimento(rs.getString("vencimento"));
                contaspagar.setDoc(rs.getString("doc"));
                contaspagar.setDescricao(rs.getString("descricao"));
                contaspagar.setValorparcela(rs.getFloat("valorParcela"));
                contaspagar.setDesconto(rs.getFloat("desconto"));
                contaspagar.setDias(rs.getInt("dias"));
                contaspagar.setJuros(rs.getFloat("juros"));
                contaspagar.setValortotal(rs.getFloat("valortotal"));
                contaspagar.setSituacao(rs.getString("situacao"));

                contasapagar.add(contaspagar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return contasapagar;

    }


 public void excluir(ContasPagar cp) {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse fornecedor?", "Atenção", JOptionPane.YES_NO_OPTION);
        PreparedStatement stmt = null;

        if (confirma == JOptionPane.YES_OPTION) {
            try {
                stmt = con.prepareStatement("delete from ContasPagar WHERE idpagar = ?");
                stmt.setInt(1, cp.getIdpagar());

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