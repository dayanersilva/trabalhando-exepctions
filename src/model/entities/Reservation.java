package model.entities;

import java.time.Duration;
import java.time.LocalDateTime;

public class Reservation {

	private Integer roomNumber;
	private LocalDateTime chekIn;
	private LocalDateTime checkOut;

	public Reservation(Integer roomNumber, LocalDateTime chekIn, LocalDateTime checkOut) {
		this.roomNumber = roomNumber;
		this.chekIn = chekIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDateTime getChekIn() {
		return chekIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}

	public long duration() {
		Duration tempo = Duration.between(chekIn, checkOut);
		return tempo.toDays();

	}

	public void updateDates(LocalDateTime checkIn, LocalDateTime checkOut) {
		this.chekIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room ";
	}

}
