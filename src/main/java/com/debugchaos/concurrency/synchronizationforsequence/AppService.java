package com.debugchaos.concurrency.synchronizationforsequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
@Transactional
public class AppService {

	@Autowired
	AppDao appDao;

	@PersistenceContext
	EntityManager manager;

	@EventListener
	public void appReady(ApplicationReadyEvent event) {

		manager.persist(new TableLock(Application.class.getSimpleName()));
	}

	public Long generateAppNo(){

		manager.createQuery("Select t from TableLock t Where t.tableName=:tableName", TableLock.class)
				.setParameter("tableName", "Application").setLockMode(LockModeType.PESSIMISTIC_WRITE)
				.getResultList().stream().findFirst().orElse(null);

		Long newAppNo;
		Optional<Long> lastAppNo = appDao.getLastAppNo();

		Application app = new Application();


		if(lastAppNo.isPresent()){
			app.setApplicationNo(lastAppNo.get()+1);
		}
		else{
			app.setApplicationNo(1L);
		}

		newAppNo = app.getApplicationNo();
		appDao.saveApplication(app);

//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return newAppNo;
	}

}
