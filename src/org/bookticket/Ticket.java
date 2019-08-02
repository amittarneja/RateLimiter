package org.bookticket;

import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.NotNull;

@XmlRootElement
public class Ticket {

	@NotNull
	private String movie;
	private String ticketClass;
	private double price;
	private int order;

	public Ticket(String movie, String ticketClass, double price) {
		this.movie = movie;
		this.ticketClass = ticketClass;
		this.price = price;
		this.order = getOrder();
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getTicketClass() {
		return ticketClass;
	}

	public void setTicketClass(String ticketClass) {
		this.ticketClass = ticketClass;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Movie: ").append(movie).append(" TicketClass: ").append(ticketClass).append(" Price: ")
				.append(price);
		return sb.toString();
	}

}
