package myBatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	
	// dolgoz� felvitele
	public void saveDolgozo(Dolgozo dolgozo) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("mybatis.DolgozoMapper.insertDolgozo", dolgozo);
		session.commit();
		session.close();
	}
	
	// k�pz�s felvitele
	public void saveKepzes(Kepzes kepzes) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("mybatis.KepzesMapper.insertKepzes", kepzes);
		session.commit();
		session.close();
	}
	
	// dolgoz� hozz�rendel�se k�pz�shez 
	public void dolgozoKepzesOsszerendeles(DolgKepzOsszerendeles dk) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("mybatis.Osszerendeles.osszerendeles", dk);
		session.commit();
		session.close();
	}
	
	// dolgoz� fizet�s�nek m�dos�t�sa
	public void updateFizetes(Dolgozo dolgozo) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("mybatis.DolgozoMapper.updatePayment", dolgozo);
		session.commit();
		session.close();
	}
	
	// dolgoz� beoszt�s�nak m�dos�t�sa
	public void updateBeosztas(Dolgozo dolgozo) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("mybatis.DolgozoMapper.updatePost", dolgozo);
		session.commit();
		session.close();
	}
	
	// k�pz�s id�tartam�nak m�dos�t�sa
	public void updateIdotartam(Kepzes kepzes) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("mybatis.KepzesMapper.updateIdotartam", kepzes);
		session.commit();
		session.close();
	}
	
	// k�pz�s oktat�j�nak m�dos�t�sa
	public void updateOktato(Kepzes kepzes) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("mybatis.KepzesMapper.updateOktato", kepzes);
		session.commit();
		session.close();
	}

	// dolgoz� t�rl�se
	public void deleteDolgozo(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("mybatis.DolgozoMapper.deleteDolgozo", id);
		session.commit();
		session.close();
	}
	
	// k�pz�s t�rl�se
	public void deleteKepzes(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("mybatis.KepzesMapper.deleteKepzes", id);
		session.commit();
		session.close();
	}
	
	// �sszes dolgoz� lek�rdez�se
	public List<Dolgozo> findAllDolgozo() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Dolgozo> dolgozok = session.selectList("mybatis.DolgozoMapper.findAllDolgozo");
		session.close();
		return dolgozok;
	}
	
	// �sszes k�pz�s lek�rdez�se
	public List<Kepzes> findAllKepzes() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Kepzes> kepzesek = session.selectList("mybatis.KepzesMapper.findAllKepzes");
		session.close();
		return kepzesek;
	}
	
	// Param�tern�l magasabb fizet�s� dolgoz�k lek�rdez�se
	public List<Dolgozo> magasabbFizetes(int fizetes) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Dolgozo> dolgozok = session.selectList("mybatis.DolgozoMapper.selectDolgozoByFizetes", fizetes);
		session.close();
		return dolgozok;
	}
	
	// Param�tern�l r�videbb idej� k�pz�sek lek�rdez�se
	public List<Kepzes> rovidebbKepzes(int idotartam) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Kepzes> kepzesek = session.selectList("mybatis.KepzesMapper.selectRovidebbKepzes", idotartam);
		session.close();
		return kepzesek;
	}
	
	// Param�terk�nt megadott oktat�hoz milyen k�pz�s tartozik
	public List<Kepzes> kepzesByOktato(String oktato) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Kepzes> kepzesek = session.selectList("mybatis.KepzesMapper.selectKepzesByOktato", oktato);
		session.close();
		return kepzesek;
	}
	
	// Param�terk�nt megadott fizet�sn�l magasabb fizet�s� dolgoz�k milyen k�pz�sen vett r�szt
	public List<Kozos> selectKepzesByNagyobbFizetes(int fizetes) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Kozos> kepzesByNagyobbFizetes = session.selectList("mybatis.KozosMapper.selectKepzesByNagyobbFizetes", fizetes);
		session.close();
		return kepzesByNagyobbFizetes;
	}
	
	// Param�terk�nt megadott beoszt�s� dolgoz� k�z�l ki milyen k�pz�sen vett r�szt
	public List<Kozos> selectKepzesByBeosztas(String beosztas) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Kozos> kepzesByBeosztas = session.selectList("mybatis.KozosMapper.selectKepzesByBeosztas", beosztas);
		session.close();
		return kepzesByBeosztas;
	}
	
}
