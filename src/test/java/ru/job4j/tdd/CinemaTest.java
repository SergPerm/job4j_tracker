package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CinemaTest {

    @Test
    @Ignore
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 12, 04, 12, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    @Ignore
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(List.of(new Session3D())));
    }

    @Test
    @Ignore
    public void add() {
        Cinema cinema = new Cinema3D();
        Session sess = new Session3D();
        cinema.add(sess);
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions.get(0), is(sess));
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenCreateWrongSessionThenException() {
        Cinema cinema = new Cinema3D();
        Session sess = new Session3D();
        cinema.add(sess);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenInvalidPlaceThenException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 12, 04, 12, 0);
        Ticket ticket = cinema.buy(account, 500, 500, date);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenPlaceAlreadyBookingThenException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 12, 04, 12, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenInvalidDateThenException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        LocalDateTime nextYear = LocalDateTime.now().plusMonths(2);
        date.set(nextYear.getYear(), nextYear.getMonthValue(), nextYear.getDayOfMonth(),
                nextYear.getHour(), nextYear.getMinute());
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }
}