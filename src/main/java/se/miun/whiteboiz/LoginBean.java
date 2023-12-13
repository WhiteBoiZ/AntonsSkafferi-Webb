package se.miun.whiteboiz;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.UsersEntity;

import java.io.Serializable;
import java.util.List;


@Named
@SessionScoped
@Transactional
public class LoginBean implements Serializable {
    @PersistenceContext
    private EntityManager em;

    private static final long serialVersionUID = 1L;
    private String password;
    private String message, uname;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


    private boolean login(String username, String password){
        List<UsersEntity> users = em.createQuery("select U from UsersEntity U", UsersEntity.class).getResultList();
        for (UsersEntity user : users) {
            if (user.getUsername() == username && user.getPassword() == password){
                return true;
            }
        }
        return false;
    }

    public static HttpSession getSession() {
        return (HttpSession)
                FacesContext.
                        getCurrentInstance().
                        getExternalContext().
                        getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.
                getCurrentInstance().
                getExternalContext().getRequest();
    }

    public static String getUserName()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  session.getAttribute("username").toString();
    }

    public static String getUserId()
    {
        HttpSession session = getSession();
        if ( session != null )
            return (String) session.getAttribute("userid");
        else
            return null;
    }


    public String loginProject() {
        boolean result = login(uname, password);
        if (result) {

            // get Http Session and store username
            HttpSession session = getSession();
            session.setAttribute("username", uname);
            return "index";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));

            // invalidate session, and redirect to other pages
            //message = "Invalid Login. Please Try Again!";
            return "login";
        }
    }



    public String logout() {
        return "login";
    }
}