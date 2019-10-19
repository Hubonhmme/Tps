class Confirmee extends EtatReservation
{
	public EtatReservation confirmer()
	{
		return this;
	}
	
	
	public EtatReservation payer()
	{
		throw new IllegalArgumentException("La reservation a déjà été payée\n");
	}
	
	public Confirmee()
	{
	
	}
	
	public String toString()
	{
		return "confirmée";
	}
}
