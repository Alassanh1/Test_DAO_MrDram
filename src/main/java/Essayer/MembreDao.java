package Essayer;

import java.util.ArrayList;
import java.util.List;

public class MembreDao implements IDao<Membre> {
	
	private List<Membre> membres;
	public MembreDao () {
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
		
		for (Membre m : membres) {
			if (m.getId() == o.getId()) {
				
				m.setNom(o.getNom());
				
				m.setPrenom(o.getPrenom());
				
				m.setAge(o.getAge());
				
				m.setProfession(o.getProfession());
				
				m.setSexe(o.getSexe());
				
				
			}
		}
		
		return true;
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
