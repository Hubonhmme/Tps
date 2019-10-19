class IdentifiantFactory
{
	private double compteur;
	
	public IdentifiantFactory()
	{
		this.compteur = 0;
	}
	
	public double GetIdentifiant()
	{
		this.compteur = this.compteur + 1;
		return this.compteur;
	}
}
