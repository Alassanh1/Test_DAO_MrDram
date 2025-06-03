package sn.uasz.l2i.tp3.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.uasz.l2i.tp3.beans.Membre;
import sn.uasz.l2i.tp3.connexion.Connexion;

public class MembreServiceDB implements IDao<Membre> {

	@Override
	public boolean create(Membre o) {
		try {
            String req = "insert into membre values(" + o.getId() + ",'" + o.getPrenom()+ "','" + o.getNom() + "'," + o.getAge() + ",'" + o.getProfession() + "', '" + o.getSexe() + "')";
            Statement st = Connexion.getCo().createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de requête SQL");
        }
        return false;
	}

	@Override
	public boolean delete(Membre o) {
		try {
			String req = "delete from membre where id=" + o.getId();
			Statement st = Connexion.getCo().createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de requête SQL");
        }
        return false;
	}

	@Override
	public boolean update(Membre o) {
		try {
            String req = "update membre set nom ='"+o.getNom()+"', prenom ='"+o.getPrenom()+"' where id = "+o.getId();
            Statement st = Connexion.getCo().createStatement();
            if(st.executeUpdate(req) == 1) {
            	return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de requête SQL");
        }
		return false;
	}

	@Override
	public Membre findById(int id) {
		try {
            String req = "select * from membre where id=" + id;
            Statement st = Connexion.getCo().createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                return new Membre(rs.getInt("id"), rs.getString("prenom"), rs.getString("nom"), rs.getInt("age"), rs.getString("profession"), rs.getString("sexe"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de requête SQL");
        }
        return null;
	}

	@Override
	public List<Membre> findAll() {
		List<Membre> lst = new ArrayList<Membre>();
		try {
            String req = "select * from membre";
            Statement st = Connexion.getCo().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                lst.add(new Membre(rs.getInt("id"), rs.getString("prenom"), rs.getString("nom"), rs.getInt("age"), rs.getString("profession"), rs.getString("sexe")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de requête SQL");
        }
		return lst;
	}

}
