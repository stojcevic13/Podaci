package rs.ac.uns.ftn.siit.op.yaml.vjezba.ex3;

import java.util.ArrayList;
import java.util.List;


public class Invoice {

	private String invoice;
	private String date;
	private Person billTo;
	private Person shipTo;
	private List<Product> product;
	private double tax;
	private double total;
	private String comments;
	
	public Invoice() {
		this.product = new ArrayList<Product>();
	}

	public Invoice(String invoice, String date, Person billTo, Person shipTo, List<Product> product, double tax,
			double total, String comments) {
		this();
		this.invoice = invoice;
		this.date = date;
		this.billTo = billTo;
		this.shipTo = shipTo;
		this.product = product;
		this.tax = tax;
		this.total = total;
		this.comments = comments;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Person getBillTo() {
		return billTo;
	}

	public void setBillTo(Person billTo) {
		this.billTo = billTo;
	}

	public Person getShipTo() {
		return shipTo;
	}

	public void setShipTo(Person shipTo) {
		this.shipTo = shipTo;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billTo == null) ? 0 : billTo.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((shipTo == null) ? 0 : shipTo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (billTo == null) {
			if (other.billTo != null)
				return false;
		} else if (!billTo.equals(other.billTo))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (invoice == null) {
			if (other.invoice != null)
				return false;
		} else if (!invoice.equals(other.invoice))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (shipTo == null) {
			if (other.shipTo != null)
				return false;
		} else if (!shipTo.equals(other.shipTo))
			return false;
		if (Double.doubleToLongBits(tax) != Double.doubleToLongBits(other.tax))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invoice [invoice=" + invoice + ", date=" + date + ", billTo=" + billTo + ", shipTo=" + shipTo
				+ ", pruduct=" + product + ", tax=" + tax + ", total=" + total + ", comments=" + comments + "]";
	}
	
	
}
