class NumeroVolFactory
{
	private String entete;
	private int compteur;
	
	public NumeroVolFactory(String entete)
	{
		this.entete = entete;
		compteur = 0;
	}
	
	public NumeroVol GetNumeroVol()
	{
		String tmp = Integer.toString(this.compteur);
		this.compteur = this.compteur + 1;
		while(tmp.length()<4)
		{
			tmp="0"+tmp;
		}
		tmp = this.entete + tmp;
		return new NumeroVol(tmp);
	}
	
	public static void main(String[] args)
	{
		NumeroVolFactory test = new NumeroVolFactory("ISS");
		NumeroVol num = test.GetNumeroVol();
		System.out.println(num.GetValeur());
		NumeroVol num2 = test.GetNumeroVol();
		System.out.println(num2.GetValeur());
	}
}
