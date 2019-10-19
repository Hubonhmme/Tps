import java.util.ArrayList;
import java.time.ZonedDateTime;
import java.util.Date;
import java.time.Duration;

class Vol
{
	private NumeroVol identifiant;
	private ZonedDateTime depart;
	private Duration duree;
	private boolean estOuvert;
	private ArrayList<Reservation> reservations;
	private IdentifiantFactory fact;
	
	public Vol(NumeroVol id, ZonedDateTime depart, Duration duree)      //IN: compagnie
	{
		this.depart=depart;
		this.duree=duree;
		this.identifiant=id;
		this.estOuvert=true;
		this.fact = new IdentifiantFactory();
		this.reservations = new ArrayList<Reservation>();
		System.out.println("le vol " + this.identifiant.GetValeur() +" a été créé\n");
	}
	
	public void creerReservation(Date date, Client client, Passager passager)
	{
		if(this.estOuvert)
		{
			Reservation tmp = new Reservation(date, this, this.fact.GetIdentifiant(),client,passager);
			passager.AjouterReservation(tmp);
			client.AjouterReservation(tmp);
		}
		else
		{
			System.out.println("le vol n'est pas ouvert à la réservation");
		}
	}
	public String getNumeroVol()
	{
		return this.identifiant.GetValeur();
	}
	
	public Duration duree()
	{
		return this.duree;
	}
	
	public ZonedDateTime arrivee()
	{
		return this.depart.plus(this.duree);
	}

	public void ouvrir()
	{
		this.estOuvert=true;
	}
	
	public void fermee()
	{
		this.estOuvert=false;
	}
}
