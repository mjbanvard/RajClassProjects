package memberManagement.dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import memberManagement.model.Member;

public class JpaMemberDao implements Dao<Member> {

	private EntityManager em;

	@Override
	public Member get(int id) {
		return em.find(Member.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getAll() {
		System.out.println("list");
		Query query = em.createQuery("SELECT m FROM Member m");
		return query.getResultList();
	}

	@Override
	public void save(Member m) {
		System.out.println("save");
		executeInsideTransaction(em -> em.persist(m));
	}

	@Override
	public void update(Member m, String[] params) {
		System.out.println("update");
	}

	@Override
	public void delete(Member m) {
		System.out.println("delete");

	}

	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			action.accept(em);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

}
