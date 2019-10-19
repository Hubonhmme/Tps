import java.util.ArrayList;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.regex.Pattern;

class Compagnie
{
	private String entete;
	private NumeroVolFactory fact;
	private ArrayList<Vol> vols;
	
	public Compagnie(String entete)
	{
		if(Pattern.matches("[a-zA-Z]*",entete))
		{
			this.entete=entete;
			this.fact = new NumeroVolFactory(this.entete);
			this.vols = new ArrayList<Vol>();
		}
		else
		{
			throw new IllegalArgumentException("entête" + entete + "invalide");
		}
	} 
	
	public void creerVol(ZonedDateTime depart, Duration duree)
	{

		
			Vol tmp = new Vol(this.fact.GetNumeroVol(), depart, duree);    
			this.vols.add(tmp);
	}
	
	public void listeVol()
	{
		for (int i = 0; i < this.vols.size(); i++)
		{
			System.out.println(this.vols.get(i).getNumeroVol());
		}
	}
	
	public Vol getVol(String id)
	{
		int i=0;
			while (i < this.vols.size())
			{
				if(this.vols.get(i).getNumeroVol().equals(id))
					{
						return vols.get(i);
					}
			i++;
			}
		throw new IllegalArgumentException("Le vol n'existe pas");
	}	
	
}
