import java.util.ArrayList;
import java.util.Date;

class Reservation
{
	public Date date;
	public double Identifiant;
	public EtatReservation etat;
	private Vol vol;
	private Client client;
	private Passager passager;
	
	public Reservation(Date date, Vol vol, double Identifiant, Client client, Passager passager) //IN Vol
	{
		this.date = date;
		this.etat = new EnAttente();
		this.vol= vol;
		this.Identifiant= Identifiant;
		this.client = client;
		this.passager = passager;
		System.out.println("la réservation " + Double.toString(this.Identifiant) + " du vol " + this.vol.getNumeroVol() + " du client " + client.toString() + " pour le passager " + passager.toString() + " a bien été crée\n");
	}
	
	public void annuler()
	{
		this.etat = this.etat.annuler();
	}
	
	public void confirmer()
	{
		this.etat = this.etat.confirmer();
	}
	
	public void payer()
	{
		this.etat = this.etat.payer();
	}
	
	public String getNumeroVol()
	{
		return this.vol.getNumeroVol();
	} 
	
	public void getEtat()
	{
		System.out.println("la réservation est " + this.etat.toString());
	}
}
