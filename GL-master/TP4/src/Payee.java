class Payee extends EtatReservation
{
	public EtatReservation confirmer()
	{
		EtatReservation tmp = new Confirmee();
		return tmp;
	}
	
	public EtatReservation payer()
	{
		throw new IllegalArgumentException("La reservation a déjà été payée");

	}
	
	public Payee()
	{
	
	}
	
	public String toString()
	{
		return "payée";
	}
}
