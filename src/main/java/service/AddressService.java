package service;

import bl.SessionUtil;
import dao.AddressDAO;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class AddressService extends SessionUtil implements AddressDAO{
    @Override
    public void add(Address address) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.save(address);

        // close session with transaction
        closeTransactionSession();
    }

    @Override
    public List<Address> getAll() throws SQLException {
        // open session with transaction
        openTransactionSession();

        String sql = "SELECT * FROM ADDRESS";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addressList = query.list();

        // close session with transaction
        closeTransactionSession();

        return addressList;
    }

    @Override
    public Address getById(Long id) throws SQLException {
        // open session with transaction
        openTransactionSession();

        String sql = "SELECT * FROM ADDRESS WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);

        Address address = (Address) query.getSingleResult();

        // close session with transaction
        closeTransactionSession();

        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.update(address);

        // close session with transaction
        closeTransactionSession();
    }

    @Override
    public void remove(Address address) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(address);

        // close session with transaction
        closeTransactionSession();
    }
}
