package sn.uasz.l2i.tp3.models;

import java.util.ArrayList;
import java.util.List;

import sn.uasz.l2i.tp3.beans.Membre;

public class MembreService implements IDao<Membre> {

	private List<Membre> membres;
	 
	public MembreService() {
		membres = new ArrayList<Membre>();
	}
	
	@Override
	public boolean create(Membre o) {
		return membres.add(o);
	}

	@Override
	public boolean delete(Membre o) {
		return membres.remove(o);
	}

	@Override
	public boolean update(Membre o) {
		for(Membre m : membres){
			if(m.getId() == o.getId()){
				m.setPrenom(o.getPrenom());
				m.setNom(o.getNom());
				m.setAge(o.getAge());
				m.setProfession(o.getProfession());
				m.setSexe(o.getSexe());
				return true;
			}
		}
		return false;
	}

	@Override
	public Membre findById(int id) {
		for (Membre m : membres) {
			if (m.getId() == id)
				return m;
		}
		return null;
	}

	@Override
	public List<Membre> findAll() {
		return membres;
	}

}
