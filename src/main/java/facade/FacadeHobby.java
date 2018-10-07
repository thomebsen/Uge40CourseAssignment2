/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.HobbyDTO;
import entity.PersonDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Oliver
 */
public class FacadeHobby {
    
    EntityManagerFactory emf;

    public FacadeHobby(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public List<HobbyDTO> getHobbies(int personId) {
        EntityManager em = emf.createEntityManager();
        List<HobbyDTO> hobbies = null;
        try {
            em.getTransaction().begin();
            TypedQuery<HobbyDTO> query = em.createQuery("SELECT new entity.HobbyDTO(h.hobbyName, h.description, p.firstName, p.lastName) FROM Hobby h JOIN h.persons p WHERE p.id = :personId", HobbyDTO.class);
            query.setParameter("personId", personId);
            hobbies = query.getResultList();
            em.getTransaction().commit();
            for (int i = 0; i < hobbies.size(); i++) {
                System.out.println(hobbies.get(i).getFirstName());
            }
            return hobbies;
        } finally {
            em.close();
        }
    }
    
}
