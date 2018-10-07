/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.CityInfo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Oliver
 */
public class FacadeCityInfo implements FacadeCityInfoInterface {

    EntityManagerFactory emf;

    public FacadeCityInfo(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<CityInfo> getAllZipCodes() {
        EntityManager em = emf.createEntityManager();
        List<CityInfo> zipCodes = null;
        try {
            em.getTransaction().begin();
            //SELECT NEW entity.PersonDTO(p.firstName, p.lastName, p.email) FROM Person p WHERE CityInfo.zipCode =" + zipCode, PersonDTO.class)
            TypedQuery query = em.createQuery("SELECT z.zipCode From CityInfo z", CityInfo.class);
            zipCodes = query.getResultList();
            em.getTransaction().commit();
            return zipCodes;
        } finally {
            em.close();
        }
    }
    

    public List<CityInfo> getAllCityInfo() {
        EntityManager em = emf.createEntityManager();
        List<CityInfo> zipCodes = null;
        try {
            em.getTransaction().begin();
            //SELECT NEW entity.PersonDTO(p.firstName, p.lastName, p.email) FROM Person p WHERE CityInfo.zipCode =" + zipCode, PersonDTO.class)
            TypedQuery query = em.createQuery("SELECT z.city, z.zipCode  From CityInfo z", CityInfo.class);
            zipCodes = query.getResultList();
            em.getTransaction().commit();
            return zipCodes;
        } finally {
            em.close();
        }
    }

}
