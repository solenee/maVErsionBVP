package commandesEnLigne;

public interface Utilisateur_itf {
	
	public int getId();
	public void setId(int _id);
	
	public void setNom(String toto);
	public String getNom();

	public void setPrenom(String toto);
	public String getPrenom();

	public void setEmail(String mail);
	public String getEmail();

	public void setIdentifiant(String id);
	public String getIdentifiant();

	public void setMotDePasse(String mdp);
	public String getMotDePasse();

}
