package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class JPATest01 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_sesion01");
		EntityManager em = fabrica.createEntityManager();

		List<Usuario> lstUsuarios = em.createQuery("Select a From Usuario a", Usuario.class).getResultList();
		System.out.println("==============================================");
		
		/*Mostrar cantidad de usuarios*/
		System.out.println("nro de usuarios:" +lstUsuarios.size());
		System.out.println("==============================================");
		
		/*Listar todos los usuarios*/
		System.out.println("Lista de usuarios:");
		System.out.println("-----------------");
		for(Usuario u: lstUsuarios){
			System.out.println("usuario: "+u.getNomUsua()+ " " + u.getApeUsua()+ " "+ u.getClaUsua());
		}
		System.out.println("==============================================");

	}

}
