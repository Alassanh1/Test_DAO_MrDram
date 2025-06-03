package sn.uasz.l2i.tp3.models;

import java.util.List;

public interface IDao<T> {
	
	boolean create (T o);
	boolean delete(T o);
	boolean update(T o);
	T findById(int id);
	List<T> findAll();
}


/*


public interface IDao<T>
interface : un contrat ou modèle que d'autres classes devront implémenter

IDao : signifie Interface de DAO (DAO = Data Access Object)

<T> : signifie que cette interface est générique. Elle peut s'appliquer à n'importe quel type de données (par ex. Membre, Sport, etc.)





| Méthode         | But                                   |
| --------------- | ------------------------------------- |
| `create(T o)`   | Ajouter un objet à la base            |
| `delete(T o)`   | Supprimer un objet de la base         |
| `update(T o)`   | Modifier un objet dans la base        |
| `findById(int)` | Chercher un objet par son identifiant |
| `findAll()`     | Récupérer la liste de tous les objets |


✅ Exemple d’utilisation concrète


public class MembreDao implements IDao<Membre> {

    public boolean create(Membre m) {
        // code JDBC INSERT INTO membre ...
    }

    public boolean delete(Membre m) {
        // code JDBC DELETE ...
    }

    public boolean update(Membre m) {
        // code JDBC UPDATE ...
    }

    public Membre findById(int id) {
        // SELECT * FROM membre WHERE id = ?
    }

    public List<Membre> findAll() {
        // SELECT * FROM membre
    }
}








*/



