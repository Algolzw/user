package dao.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;

import domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import dao.inter.UserState;
import domain.Userstate;

@Component
public class UserStateImpl implements UserState {

    private SessionFactory sessionFactory;

    @Inject
    public UserStateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void initState(int userId) {
        Session session = this.sessionFactory.openSession();
        String sql = "insert into userState(userId) values(?)";
        Query query = session.createSQLQuery(sql);
        query.setInteger(0, userId);
        int res = query.executeUpdate();
        session.disconnect();
    }

    @Override
    public void initState(int userId, String password) {
        Session session = this.sessionFactory.openSession();
        String sql = "insert into userState(userId,password) values(?,?)";
        Query query = session.createSQLQuery(sql);
        query.setInteger(0, userId).setString(1, password);
        int res = query.executeUpdate();
        session.disconnect();
    }

    @Override
    public void initState(int userId, String password, String email) {
        Session session = this.sessionFactory.openSession();
        String sql = "insert into userState(userId,password,email) values(?,?,?)";
        Query query = session.createSQLQuery(sql);
        query.setInteger(0, userId).setString(1, password).setString(2, email);
        int res = query.executeUpdate();
        session.disconnect();
    }

    @Override
    public void approve(int userId) {
        Session session = this.sessionFactory.openSession();
        String sql = "update userstate set approved = 1 where userId=?";
        Query query = session.createSQLQuery(sql).setInteger(0, userId);
        query.executeUpdate();
        session.disconnect();
    }

    @Override
    public void loginUpdate(int userId) {
        Session session = this.sessionFactory.openSession();
        String sql = "update userState set online=1,lastLoginTime=? where userId=?";
        Query query = session.createSQLQuery(sql)
                .setTimestamp(0, new Timestamp(System.currentTimeMillis()))
                .setInteger(1, userId);
        query.executeUpdate();
        session.disconnect();
    }

    @Override
    public void logoutUpdate(int userId) {
        Session session = this.sessionFactory.openSession();
        String sql = "update userState set online=0 where userId=?";
        Query query = session.createSQLQuery(sql)
                .setInteger(0, userId);
        query.executeUpdate();
        session.disconnect();
    }

    /**
     * @param userId
     * @return
     */
    private Userstate createUserstate(int userId) {
        Userstate state = new Userstate();
        state.setUserId(userId);
        return state;
    }

}
