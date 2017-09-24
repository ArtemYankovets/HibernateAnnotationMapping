package service;

import bl.SessionUtil;
import dao.ProjectDAO;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ProjectService extends SessionUtil implements ProjectDAO {
    @Override
    public void add(Project project) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.save(project);

        // close session with transaction
        closeTransactionSession();
    }

    @Override
    public List<Project> getAll() throws SQLException {
        // open session with transaction
        openTransactionSession();

        String sql = "SELECT * FROM PROJECT";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projectList = query.list();

        // close session with transaction
        closeTransactionSession();

        return projectList;
    }

    @Override
    public Project getById(Long id) throws SQLException {
        // open session with transaction
        openTransactionSession();

        String sql = "SELECT * FROM PROJECT WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id", id);

        Project project = (Project) query.getSingleResult();

        // close session with transaction
        closeTransactionSession();

        return project;
    }

    @Override
    public void update(Project project) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.update(project);

        // close session with transaction
        closeTransactionSession();
    }

    @Override
    public void remove(Project project) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(project);

        // close session with transaction
        closeTransactionSession();
    }
}