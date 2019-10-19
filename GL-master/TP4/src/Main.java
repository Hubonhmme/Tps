import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

class Main
{
	public static void main(String[] args)
	{
		//creation des dates et durees
		LocalDateTime time = LocalDateTime.of(2019, 10, 17, 17, 30);
		ZonedDateTime timeParisFr = time.atZone(ZoneId.of("Europe/Paris"));
		Duration duree = Duration.ofHours(1);
		Date dateRes = new Date(2019, 9, 29);
		System.out.println(timeParisFr);
		//compagnies
		Compagnie Compagnie1 = new Compagnie("ISS"); 
		Compagnie Compagnie2 = new Compagnie("HUS");
		//
		//clients
		Client client1 = new Client("Neken","espèce","froid","Allemagne");
		Client client2 = new Client("Phénicienne","carte","froid","Belge");
		Client client3 = new Client("destrolls","espèce","humide","Inconnu");
		//
		//passagers
		Passager passager1=new Passager("Billy","optionnel");
		Passager passager2=new Passager("Philippe","champs");
		//
		//vols
		Compagnie1.creerVol(timeParisFr, duree);
		//
		//reservations
		//Compagnie1.listeVol();
		Vol vol1 = Compagnie1.getVol("ISS0000");
		vol1.creerReservation(dateRes,client1,passager2);
		//
		//Paiement
		//client1.getReservation("ISS0000", 1).payer();
		//passager2.getReservation("ISS0000", 1).confirmer();
		
		System.out.println("Créer une compagnie avec une entête invalide");
		boolean b1 = false;
		try {
			Compagnie compagnie3 = new Compagnie("   ");
		}
		catch (IllegalArgumentException e) {
			b1 = true;
		}
		finally {
			if(b1 == true) {
				System.out.println("test réussi");
			}
			else{
				System.out.println("test raté");
			}
		}
		
		System.out.println("Confirmer sans payer");
		boolean b2 = false;
		try {
			passager2.getReservation("ISS0000", 1).confirmer();
		}
		catch (IllegalArgumentException e) {
			b2 = true;
		}
		finally {
			if(b2 == true) {
				System.out.println("test réussi");
			}
			else{
				System.out.println("test raté");
			}
		}
		
		
		System.out.println("Repayer");
		boolean b3 = false;
		try {
			client1.getReservation("ISS0000", 1).payer();
			client1.getReservation("ISS0000", 1).payer();
		}
		catch (IllegalArgumentException e) {
			b3 = true;
		}
		finally {
			if(b3 == true) {
				System.out.println("test réussi");
			}
			else{
				System.out.println("test raté");
			}
		}
		
		System.out.println("Comfirmer une Annulation");
		boolean b4 = false;
		try {
			passager2.getReservation("ISS0000", 1).confirmer();
			passager2.getReservation("ISS0000", 1).annuler();
			passager2.getReservation("ISS0000", 1).confirmer();
		}
		catch (IllegalArgumentException e) {
			b4 = true;
		}
		finally {
			if(b4 == true) {
				System.out.println("test réussi");
			}
			else{
				System.out.println("test raté");
			}
		}
		
		System.out.println("Rechercher une vol qui n'est pas dans le compagnie");
		boolean b5 = false;
		try {
			Compagnie1.getVol("HUS0001");
		}
		catch (IllegalArgumentException e) {
			b5 = true;
		}
		finally {
			if(b5 == true) {
				System.out.println("test réussi");
			}
			else{
				System.out.println("test raté");
			}
		}
		
		System.out.println("Le client a un paiement non valide");
		boolean b6 = false;
		try {
					Client client4 = new Client("cola","nature","collant","riches");
		}
		catch (IllegalArgumentException e) {
			b6 = true;
		}
		finally {
			if(b6 == true) {
				System.out.println("test réussi");
			}
			else{
				System.out.println("test raté");
			}
		}
		
	}
}
