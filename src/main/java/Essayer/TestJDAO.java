package Essayer;


import java.util.Scanner;

//import sn.uasz.l2i.tp3.models.MembreService;
import sn.uasz.l2i.tp3.models.MembreServiceDB;
import sn.uasz.l2i.tp3.beans.Membre;

public class TestJDAO {

	public static void main(String[] args) {
		MembreServiceDB service = new MembreServiceDB();
		 
		service.create(new Membre(1, "Modou", "SALL", 45, "Enseignant", "M"));
		service.create(new Membre(2, "Fatou", "NDIAYE", 35, "Enseignante", "F"));
		service.create(new Membre(3, "Ndéye", "DIOUF", 43, "Infirmière", "F"));
		service.create(new Membre(4, "Fallou", "DIONE", 38, "Médecin", "M"));
		service.create(new Membre(5, "Soukéye", "CISSE", 31, "Enseignante", "F"));
		service.create(new Membre(6, "Lionel", "Mbaye", 31, "Footballeur", "M"));
 
		System.out.println("Liste des Membres :");
		for (Membre m : service.findAll())
			System.out.println("\t" + m);
 
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Suppression d'un membre selon son id");
		System.out.println("Donner l'id du membre à supprimer :");
		int id = scan.nextInt();
		Membre membre = service.findById(id);
		System.out.println("Membre à supprimer : " + membre);
		service.delete(membre);
 
		System.out.println("Modification d'un membre selon son id");
		System.out.println("Donner l'id du membre à modifier :");
		id = scan.nextInt();
		membre = service.findById(id);
		System.out.println("Membre à modifier : " + membre);
		
		System.out.println("Donner le nouveau prénom :");
		membre.setPrenom(scan.nextLine());
		System.out.println("Donner le nouveau nom :");
		membre.setNom(scan.nextLine());
		System.out.println("Donner la nouvelle profession :");
		membre.setProfession(scan.nextLine());
		//System.out.println("Donner le nouveau sexe :");
		//membre.setSexe(scan.nextLine());
		service.update(membre);
		scan.close();
 
		System.out.println("Liste des membres après les mises à jour :");
		for (Membre m : service.findAll())
			System.out.println("\t" + m);

	}

}
