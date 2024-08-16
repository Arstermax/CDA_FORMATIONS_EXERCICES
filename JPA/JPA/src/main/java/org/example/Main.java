package org.example;

import org.example.ENTITY.OrdinateurEntity;

import javax.persistence.*;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
        EntityManager em = emf.createEntityManager();

        OrdinateurEntity ordi = OrdinateurEntity.builder().name("Ordi3000").dexcriptions("L'ordi le plus puissant que tu connais").price(30).build();

        // Ajoute un ordi à la base de données
        em.getTransaction().begin();
        em.persist(ordi);
        em.getTransaction().commit();

        try {
            OrdinateurEntity ordiFound = em.getReference(OrdinateurEntity.class,1);
            if(ordiFound != null){
                System.out.println(ordiFound);
            }
        }catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        Query query = em.createQuery("select p from OrdinateurEntity p where  p.id = 1" );
        OrdinateurEntity ordinateurFoundQuery = (OrdinateurEntity) query.getSingleResult();

        if (ordinateurFoundQuery != null){
            System.out.println("via que : " +  ordinateurFoundQuery);
        }

        em.close();
        emf.close();
    }
}