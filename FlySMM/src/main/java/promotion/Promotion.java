package promotion;

import java.util.List;

import org.hibernate.Session;

import servlets.SessionFactorySingleton;

public abstract class Promotion {
	protected int discountRate;
	protected boolean fidelity;
	protected String idPromo;
	protected String name;
	protected String description;
	protected String promoType;
	
	public void notify_(){
		/*Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		List result = session
				.createQuery("from Costumer where Type_of_customers = 'Fidelity State'")
				.list();
		
		String email = (String) result.get(0);

		session.getTransaction().commit();

		request.setAttribute("promotion", (List<Promotion>) result);*/
		Mail m = new Mail();
		m.sendMail("camv12@hotmail.it","email di prova");
	}
	
	public Promotion(){}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public boolean isFidelity() {
		return fidelity;
	}

	public void setFidelity(boolean fidelity) {
		this.fidelity = fidelity;
	}

	public String getIdPromo() {
		return idPromo;
	}

	public void setIdPromo(String idPromo) {
		this.idPromo = idPromo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPromoType() {
		return promoType;
	}

	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}
}