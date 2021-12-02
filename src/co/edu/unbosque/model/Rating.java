package co.edu.unbosque.model;

public class Rating implements Comparable{
	int arbitro;
	boolean enuso;
	int rating;
	
	public Rating(int a, int b, int c) {
		arbitro = a;
		if(a==b) {
			rating = -1000000000;	
		}
		else {
			rating = c;
		}
	}

	public int getArbitro() {
		return arbitro;
	}

	public void setArbitro(int arbitro) {
		this.arbitro = arbitro;
	}

	public boolean isEnuso() {
		return enuso;
	}

	public void setEnuso(boolean enuso) {
		this.enuso = enuso;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public int compareTo(Object o) {
        int compare = ((Rating) o).getRating();
        return compare-this.rating;
	}

}
