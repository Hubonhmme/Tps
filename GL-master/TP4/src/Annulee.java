class Annulee extends EtatReservation
{
	public EtatReservation annuler()
	{
		throw new IllegalArgumentException(" La reservation est annulée");
	}
	
	public EtatReservation confirmer()
	{
		throw new IllegalArgumentException(" La reservation est annulée");
	}
	
	public EtatReservation payer()
	{
		throw new IllegalArgumentException(" La reservation est annulée");
	}
	
	public Annulee()
	{
	
	}
	
	public String toString()
	{
		return "annulée";
	}
}
