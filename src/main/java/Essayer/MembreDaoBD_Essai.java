package Essayer;

import java.sql.*;
import java.util.*;


public class MembreDaoBD_Essai implements IDao<Membre> {

	@Override
	public boolean create(Membre o) {
		String sql = "INSERT INTO membre (id ,prenom, nom, age, profession, sexe) VALUES (?,?,?,?,?,?)";
		try (PreparedStatement ps = Connexion.getCo().prepareStatement(sql)){
			ps.setInt(1, o.getId());
			ps.setString(2, o.getNom());
			ps.setString(3, o.getPrenom());
			ps.setInt(4, o.getAge());
			ps.setString(5, o.getProfession());
			ps.setString(6, o.getSexe());
			return ps.executeUpdate() == 1;
		}catch(SQLException ex) {
			System.out.println("Erreur de creation SQl: "+ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Membre o) {
		
		String sql = "DELETE FROM membre WHERE id = ?";
		try (PreparedStatement ps = Connexion.getCo().prepareStatement(sql)) { 
			
			ps.setInt(1, o.getId());
			return ps.executeUpdate() == 1;
			
		} catch (SQLException ex) {
			System.out.println("Erreur de Suppression SQL"+ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Membre o) {
		
		String sql = "UPDATE membre SET prenom=?, nom=?, age=?, profession=?, sexe=?, WHERE id = ?";
		try(PreparedStatement ps = Connexion.getCo().prepareStatement(sql)){
			
			ps.setInt(1, o.getId());
			
		}catch(SQLException ex) {
			System.out.println("Erreur de modification SQL"+ex.getMessage());
		}
		return false;
	}

	 @Override
	    public Membre findById(int id) {
	        String sql = "SELECT * FROM membre WHERE id = ?";
	        try (PreparedStatement ps = Connexion.getCo().prepareStatement(sql)) {
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return new Membre(
	                    rs.getInt("id"),
	                    rs.getString("prenom"),
	                    rs.getString("nom"),
	                    rs.getInt("age"),
	                    rs.getString("profession"),
	                    rs.getString("sexe")
	                );
	            }
	        } catch (SQLException ex) {
	            System.out.println("Erreur findById SQL: " + ex.getMessage());
	        }
	        return null;
	    }

	    @Override
	    public List<Membre> findAll() {
	        List<Membre> lst = new ArrayList<>();
	        String sql = "SELECT * FROM membre";
	        try (PreparedStatement ps = Connexion.getCo().prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                lst.add(new Membre(
	                    rs.getInt("id"),
	                    rs.getString("prenom"),
	                    rs.getString("nom"),
	                    rs.getInt("age"),
	                    rs.getString("profession"),
	                    rs.getString("sexe")
	                ));
	            }
	        } catch (SQLException ex) {
	            System.out.println("Erreur findAll SQL: " + ex.getMessage());
	        }
	        return lst;
	    }

}
