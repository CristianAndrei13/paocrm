package user.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User abstract
 */
abstract public class AbstractUser implements UserInterface {

    /**
     * ID of User
     */
    protected int id;

    /**
     * Username of User
     */
    protected String username;

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
    public Map<String, RoleInterface> getRoles() {
        return this.roles;
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
