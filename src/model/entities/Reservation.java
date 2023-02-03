package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.entities.exceptions.DomainException;

public class Reservation {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Integer roomNumber;
	private LocalDate chekIn;
	private LocalDate checkOut;

	public Reservation(Integer roomNumber, LocalDate chekIn, LocalDate checkOut) {
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

	public LocalDate getChekIn() {
		return chekIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		Duration temp = Duration.between(chekIn.atStartOfDay(), checkOut.atStartOfDay());
		return temp.toDays();

	}

	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {

		LocalDate now = LocalDate.now();

		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.chekIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + dtf.format(chekIn) + ", check-out: " + dtf.format(checkOut)
				+ ", " + duration() + " nights";
	}

}
