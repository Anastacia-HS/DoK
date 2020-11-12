package Movie;

public class Movie {
	private String m_name,genre,open_day;
	private int audience;
	private double rating;
	public Movie() {}
	
	public Movie(String m_name, String genre, String open_day, int audience, double rating) {
		this.m_name = m_name;
		this.genre = genre;
		this.open_day = open_day;
		this.audience = audience;
		this.rating = rating;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getOpen_day() {
		return open_day;
	}

	public void setOpen_day(String open_day) {
		this.open_day = open_day;
	}

	public int getAudience() {
		return audience;
	}

	public void setAudience(int audience) {
		this.audience = audience;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
