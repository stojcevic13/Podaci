package rs.ac.uns.ftn.siit.op.json.example01;

import java.util.List;

public class Book {
	private String ISBN;
	private int Price;
	private int Edition;
	private String Title;
	private String Remark;
	private List<Author> Authors;
	private List<String> Tags;

	public String getISBN() {
		return ISBN;
	}

	// @JsonProperty("ISBN")
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getPrice() {
		return Price;
	}

	// @JsonProperty("Price")
	public void setPrice(int price) {
		Price = price;
	}

	public int getEdition() {
		return Edition;
	}

	// @JsonProperty("Edition")
	public void setEdition(int edition) {
		Edition = edition;
	}

	public String getTitle() {
		return Title;
	}

	// @JsonProperty("Title")
	public void setTitle(String title) {
		Title = title;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public List<Author> getAuthors() {
		return Authors;
	}

	// @JsonProperty("Author")
	public void setAuthors(List<Author> authors) {
		Authors = authors;
	}
	
	public List<String> getTags() {
		return Tags;
	}

	public void setTags(List<String> tags) {
		Tags = tags;
	}

	@Override
	public String toString() {
		return "Book {ISBN=" + ISBN + ", Price=" + Price + ", Edition=" + Edition + ", Title=" + Title + ", Author="
				+ Authors + ", Tags=" + Tags + "}";
	}

	

}
