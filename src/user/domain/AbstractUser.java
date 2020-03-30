package user.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User abstract
 */
abstract public class AbstractUser implements UserInterface {

    /**
     * Basic roles
     */
    public static final Role ROLE_ADMIN = new Role("ROLE_ADMIN", "ADMIN", true);
    public static final Role ROLE_SIMPLE_USER = new Role("ROLE_SIMPLE_USER", "SIMPLE USER", true);

    /**
     * ID of User
     */
    protected int id;

    /**
     * Username of User
     */
    protected String username;

    /**
     * Password of User
     */
    protected String password;

    /**
     * Roles collection of user
     */
    protected Map<String, RoleInterface> roles = new HashMap<>();

    /**
     * Date of creation
     */
    protected Date created;

    /**
     * Date of last update
     */
    protected Date updated;

    public AbstractUser() {
        // Guarantee that every user have "Simple user" role
        roles.put(ROLE_SIMPLE_USER.getCode(), ROLE_SIMPLE_USER);
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Map<String, RoleInterface> getRoles() {
        return this.roles;
    }

    @Override
    public boolean hasRole(RoleInterface role) {
        return this.roles.get(role.getCode()) != null;
    }

    @Override
    public void addRole(RoleInterface role) {
        this.roles.put(role.getCode(), role);
    }

    @Override
    public void deleteRole(RoleInterface role) {
        this.roles.remove(role.getCode());
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
