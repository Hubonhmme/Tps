import java.util.ArrayList;

class Client
{
	private String nom;
	private String paiement;
	private String contact;
	private String reference;
	private ArrayList<Reservation> reservations;
	
	public Client(String nom,String paiement,String contact,String reference)
	{
		if((paiement.equals("carte"))==false && paiement.equals("chèque")==false && paiement.equals("espèce")==false)
		{
			throw new IllegalArgumentException("moyen de paiement non valide");
		}
		this.nom = nom;
		this.paiement = paiement;
		this.contact = contact;
		this.reference = reference;
		this.reservations = new ArrayList<Reservation>();
	}
	
	public void AjouterReservation(Reservation reservation)
	{
		this.reservations.add(reservation);
	}
	
	public Reservation getReservation(String idVol, double identifiant)
	{
		for(int i = 0; i < reservations.size(); i++)
		{
			String idVolRes = reservations.get(i).getNumeroVol();
			double idRes = reservations.get(i).Identifiant;
			if(idVol.equals(idVolRes) && idRes == identifiant)
			{
				return reservations.get(i);
			}
		}
		throw new IllegalArgumentException("Ce client n'a pas le vol indiqué");
	}
	
	public String toString()
	{
		return this.nom;
	}
}
