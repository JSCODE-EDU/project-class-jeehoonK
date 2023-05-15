package jscode.jscodeproject.repository;


import jscode.jscodeproject.domain.Bulletin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BulletinRepository {

    private final EntityManager em;

    public void save(Bulletin bulletin){
        em.persist(bulletin);
    }

    public List<Bulletin> findAll(){
        return em.createQuery("select b from Bulletin b", Bulletin.class).getResultList();
    }

    //em.find는 primary key만 조회할 수 있습니다.
    public Bulletin findById(Long id) {
        return em.find(Bulletin.class, id);
    }

    public void deleteById(Long id){
        em.remove(findById(id));
    }
}
