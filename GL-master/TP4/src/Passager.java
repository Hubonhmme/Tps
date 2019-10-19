import java.util.ArrayList;

class Passager
{
	private String nom;
	private String contact;
	private ArrayList<Reservation> reservations;
	
	public Passager(String nom,String contact)
	{
		this.nom = nom;
		this.contact = contact;
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
