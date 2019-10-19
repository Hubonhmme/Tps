class EnAttente extends EtatReservation
{

	public EtatReservation confirmer()
	{
		throw new IllegalArgumentException("La reservation n'a pas été payée\n");
	}
	
	public EtatReservation payer()
	{
		EtatReservation tmp = new Payee();
		return tmp;
	}
	
	public EnAttente()
	{
	
	}
	
	public String toString()
	{
		return "en attente";
	}
}
