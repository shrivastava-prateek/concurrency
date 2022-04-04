package com.debugchaos.concurrency.synchronizationforsequence;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class AppDao {


	@PersistenceContext
	EntityManager manager;
	
	public Optional<Long> getLastAppNo(){
		return manager.createQuery("Select applicationNo from Application order by applicationNo desc").getResultList().stream().findFirst();
	}

	public void saveApplication(Application app){
		manager.persist(app);
	}
}
