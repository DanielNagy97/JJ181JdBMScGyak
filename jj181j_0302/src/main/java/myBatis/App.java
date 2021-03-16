package myBatis;

import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		DAO dao = new DAO();
		Dolgozo dolgozo = new Dolgozo();
		Kepzes kepzes = new Kepzes();
		Scanner scanner = new Scanner(System.in);
		int input;
		do {
			System.out.println("V�lasszon m�veletet!");
			System.out.println("1\tdolgoz� felvitele");
			System.out.println("2\tdolgoz� fizet�s�nek m�dos�t�sa");
			System.out.println("3\tdolgoz� beoszt�s�nak m�dos�t�sa");
			System.out.println("4\tdolgoz� t�rl�se");
			System.out.println("5\tk�pz�s felvitele");
			System.out.println("6\tk�pz�s hossz�nak m�dos�t�sa");
			System.out.println("7\tk�pz�s oktat�j�nak m�dos�t�sa");
			System.out.println("8\tk�pz�s t�rl�se");
			System.out.println("9\t�sszes dolgoz� lek�rdez�se");
			System.out.println("10\t�sszes k�pz�s lek�rdez�se");
			System.out.println("11\tparam�tern�l magasabb fizet�s� dolgoz�k lek�rdez�se");
			System.out.println("12\tr�videbb idej� k�pz�sek lek�rdez�se");
			System.out.println("13\tparam�terk�nt megadott oktat�hoz tartoz� k�pz�sek");
			System.out.println("14\tparam�terk�nt megadott fizet�sn�l magasabb fizet�s� dolgoz�k milyen k�pz�sken vettek r�szt");
			System.out.println("15\tparam�terk�nt megadott beoszt�s�ak k�z�l ki milyen k�pz�sen vett r�szt");
			System.out.println("16\tdolgoz� �s k�pz�s �sszerendel�se");
			System.out.println("0\tkil�p�s");
			input = scanner.nextInt();
			
			switch(input) {
			case 0: {
				input = 0;
				break;
			}
			case 1: {
				// dolgoz� felvitele
				System.out.println("Dolgoz� ID-ja:");
				dolgozo.setDid(scanner.nextInt());
				System.out.println("Dolgoz� neve:");
				dolgozo.setDnev(scanner.next());
				System.out.println("Dolgoz� beoszt�sa:");
				dolgozo.setBeosztas(scanner.next());
				System.out.println("Dolgoz� fizet�se:");
				dolgozo.setFizetes(scanner.nextInt());
				dao.saveDolgozo(dolgozo);
				System.out.println("Dolgoz� t�rolva a k�vetkez� adatokkal: ID: " + dolgozo.getDid() + ", N�v: " + dolgozo.getDnev() + ", Beoszt�s:" + dolgozo.getBeosztas() + ", Fizet�s: " + dolgozo.getFizetes());
				break;
			}
			
			case 2: {
				// dolgoz� fizet�s�nek m�dos�t�sa
				Dolgozo dolgozo1 = new Dolgozo();
				System.out.println("Dolgoz� ID-ja:");
				dolgozo1.setDid(scanner.nextInt());
				System.out.println("Dolgoz� �j fizet�se:");
				dolgozo1.setFizetes(scanner.nextInt());
				dao.updateFizetes(dolgozo1);
				System.out.println("Dolgoz� fizet�se m�dos�tva: ID: " + dolgozo1.getDid() + ", �j fizet�s: " + dolgozo1.getFizetes());	
				break;
			}
			
			case 3: {
				// dolgoz� beoszt�s�nak m�dos�t�sa
				Dolgozo dolgozo2 = new Dolgozo();
				System.out.println("Dolgoz� ID-ja:");
				dolgozo2.setDid(scanner.nextInt());
				System.out.println("Dolgoz� �j beoszt�sa:");
				dolgozo2.setBeosztas(scanner.next());
				dao.updateBeosztas(dolgozo2);
				System.out.println("Dolgoz� beoszt�sa m�dos�tva: ID: " + dolgozo2.getDid() + ", �j beoszt�s: " + dolgozo2.getBeosztas());
				break;
			}
			
			case 4: {
				// dolgoz� t�rl�se
				System.out.println("T�rlend� dolgoz� ID-ja:");
				dao.deleteDolgozo(scanner.nextInt());
				System.out.println("T�r�lve.");
				break;
			}
			
			case 5: {
				// k�pz�s felvitele
				System.out.println("K�pz�s ID-ja:");
				kepzes.setKid(scanner.nextInt());
				System.out.println("K�pz�s neve:");
				kepzes.setKnev(scanner.next());
				System.out.println("K�pz�s oktat�ja:");
				kepzes.setOktato(scanner.next());
				System.out.println("K�pz�s id�tartama:");
				kepzes.setIdotartam(scanner.nextInt());
				dao.saveKepzes(kepzes);
				System.out.println("K�pz�s t�rolva a k�vetkez� adatokkal: ID: " + kepzes.getKid() + ", N�v: " + kepzes.getKnev() + ", Oktat�: " + kepzes.getOktato() + ", Id�tartam: " + kepzes.getIdotartam());
				break;
			}
			
			case 6: {
				// k�pz�s hossz�nak m�dos�t�sa
				Kepzes kepzes1 = new Kepzes();
				System.out.println("K�pz�s ID-ja:");
				kepzes1.setKid(scanner.nextInt());
				System.out.println("K�pz�s �j id�tartama:");
				kepzes1.setIdotartam(scanner.nextInt());
				dao.updateIdotartam(kepzes1);
				System.out.println("K�pz�s id�tartama m�dos�tva: ID: " + kepzes1.getKid() + ", �j id�tartam: " + kepzes1.getIdotartam());
				break;
			}
			
			case 7: {
				// k�pz�s oktat�j�nak m�dos�t�sa
				Kepzes kepzes2 = new Kepzes();
				System.out.println("K�pz�s ID-ja:");
				kepzes2.setKid(scanner.nextInt());
				System.out.println("K�pz�s �j oktat�ja:");
				kepzes2.setOktato(scanner.next());
				dao.updateOktato(kepzes2);
				System.out.println("K�pz�s oktat�ja m�dos�tva: ID: " + kepzes2.getKid() + ", �j oktat�: " + kepzes2.getOktato());
				break;
			}
			
			case 8: {
				// k�pz�s t�rl�se
				System.out.println("T�rlend� k�pz�s ID-ja:");
				dao.deleteKepzes(scanner.nextInt());
				System.out.println("T�r�lve.");
				break;
			}
			
			case 9: {
				// �sszes dolgoz� lek�rdez�se
				List<Dolgozo> osszesDolgozo = dao.findAllDolgozo();
				System.out.println("�sszes dolgoz�:");
				for(Dolgozo d : osszesDolgozo) {
					System.out.println("ID: " + d.getDid() + ", N�v: " + d.getDnev() + ", Beoszt�s:" + d.getBeosztas() + ", Fizet�s: " + d.getFizetes());
				}
				break;
			}
			
			case 10: {
				// �sszes k�pz�s lek�rdez�se
				List<Kepzes> osszesKepzes = dao.findAllKepzes();
				System.out.println("�sszes k�pz�s:");
				for(Kepzes k : osszesKepzes) {
					System.out.println("ID: " + k.getKid() + ", N�v: " + k.getKnev() + ", Oktat�: " + k.getOktato() + ", Id�tartam: " + k.getIdotartam());
				}	
				break;
			}
			
			case 11: {
				// param�tern�l magasabb fizet�s� dolgoz�k lek�rdez�se
				System.out.println("Adja meg azt az �rt�ket, amelyn�l magasabb fizet�s� dolgoz�k nev�t k�ri list�zni:");
				List<Dolgozo> dolgozoByFizetes = dao.magasabbFizetes(scanner.nextInt());
				for(Dolgozo d : dolgozoByFizetes) {
					System.out.println("N�v: " + d.getDnev() + ", Fizet�s: " + d.getFizetes());
				}
				break;
			}
			
			case 12: {
				// param�tern�l r�videbb idej� k�pz�sek lek�rdez�se
				System.out.println("Adja meg azt az �rt�ket, amelyn�l r�videbb idej� k�pz�sek nev�t k�ri list�zni:");
				List<Kepzes> kepzesByIdotartam = dao.rovidebbKepzes(scanner.nextInt());
				for(Kepzes k : kepzesByIdotartam) {
					System.out.println("N�v: " + k.getKnev() + ", Id�tartam: " + k.getIdotartam());
				}
				break;
			}
			
			case 13: {
				// param�terk�nt megadott oktat�hoz tartoz� k�pz�sek
				System.out.println("Adja meg azt az oktat�t, akihez tartoz� k�pz�sek nev�t k�ri list�zni:");
				List<Kepzes> kepzesByOktato = dao.kepzesByOktato(scanner.next());
				for(Kepzes k : kepzesByOktato) {
					System.out.println("N�v: " + k.getKnev() + ", Oktat�: " + k.getOktato());
				}
				break;
			}
			
			case 14: {
				// param�terk�nt megadott fizet�sn�l magasabb fizet�s� dolgoz�k milyen k�pz�sken vettek r�szt
				System.out.println("Adja meg azt a fizet�s�rt�ket, amelyn�l magasabb fizet�s�ek �ltal elv�gzett k�pz�sek list�j�t k�ri.");
				List<Kozos> kepzesByNagyobbFizetes = dao.selectKepzesByNagyobbFizetes(scanner.nextInt());
				for(Kozos k : kepzesByNagyobbFizetes) {
					System.out.println("Dolgoz� neve: " + k.getDnev() + ", k�pz�s neve: " + k.getKnev() + ", dolgoz� fizet�se: " + k.getFizetes());
				}
				break;
			}
			
			case 15: {
				// param�terk�nt megadott beoszt�s�ak k�z�l ki milyen k�pz�sen vett r�szt
				System.out.println("Adja meg azt a beoszt�st, amelyhez kapcsol�d�an a k�pz�sek list�z�s�t k�ri");
				List<Kozos> kepzesByBeosztas = dao.selectKepzesByBeosztas(scanner.next());
				for(Kozos k : kepzesByBeosztas) {
					System.out.println("Dolgoz� neve: " + k.getDnev() + ", k�pz�s neve: " + k.getKnev());
				}
				break;
			}
			
			case 16: {
				// dolgoz� �s k�pz�s �sszerendel�se
				System.out.println("Adja meg a dolgoz� ID-j�t, akit k�pz�shez szeretne rendelni:");
				DolgKepzOsszerendeles dk = new DolgKepzOsszerendeles();
				dk.setDid(scanner.nextInt());
				System.out.println("Adja meg a k�pz�s ID-j�t, amelyhez " + dk.getDid() + " ID-j� dolgoz�t szeretn� rendelni.");
				dk.setKid(scanner.nextInt());
				dao.dolgozoKepzesOsszerendeles(dk);	
				System.out.println("�sszerendelve.");
				break;
			}
			
			default: {
				System.out.println("Nem l�tez� men�pont.");					
				break;
			}	
		}
			
	} while(input != 0);
	
	scanner.close();
	
}
}
