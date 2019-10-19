abstract class EtatReservation
{
	public EtatReservation annuler()
	{
		EtatReservation tmp = new Annulee();
		return tmp;
	}
	
	public EtatReservation confirmer()
	{
		throw new IllegalArgumentException("Il est imposible de confirmer\n");
	}
	
	abstract public EtatReservation payer();
	
	abstract public String toString();
}
