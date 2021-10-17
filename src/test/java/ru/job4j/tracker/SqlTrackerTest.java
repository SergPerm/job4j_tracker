package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream is = SqlTrackerTest.class.getClassLoader().
                getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(is);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("name"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();

    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasThisItem() {
        SqlTracker tracker = new SqlTracker();
        tracker.init(connection);
        Item item = new Item("item");
         assertThat(tracker.add(item), is(item));
    }

    @Test
    public void whenFindByIdThenGetItemWithThisId() {
        SqlTracker tracker = new SqlTracker();
        tracker.init(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void findAll() {
        SqlTracker tracker = new SqlTracker();
        tracker.init(connection);
        Item item1 = new Item("Serg");
        tracker.add(item1);
        Item item2 = new Item("Petr");
        tracker.add(item2);
        Item item3 = new Item("Lana");
        tracker.add(item3);
        assertThat(tracker.findAll().size(), is(3));
    }

    @Test
    public void findByName() {
        SqlTracker tracker = new SqlTracker();
        tracker.init(connection);
        Item item = new Item("Lana");
        tracker.add(item);
        Item item1 = new Item("Serg");
        tracker.add(item1);
        Item item2 = new Item("Petr");
        tracker.add(item2);
        Item item3 = new Item("Lana");
        tracker.add(item3);
        assertThat(tracker.findByName("Lana").size(), is(2));
    }

    @Test
    public void replace() {
        SqlTracker tracker = new SqlTracker();
        tracker.init(connection);
        Item item = new Item("Item");
        tracker.add(item);
        int id = item.getId();
        Item itemWithNewDesc = new Item("Item with new description");
        tracker.replace(id, itemWithNewDesc);
        assertThat(tracker.findById(id).getName(), is("Item with new description"));
    }

    @Test
    public void whenDeleteIdThenTrackerFindByIdGetNull() {
        SqlTracker tracker = new SqlTracker();
        tracker.init(connection);
        Item item = new Item("Item");
        tracker.add(item);
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}