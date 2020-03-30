package user.domain;

import java.util.Map;

/**
 * User interface
 */
public interface UserInterface {

    int getId();

    String getUsername();

    String getPassword();

    Map<String, RoleInterface> getRoles();

    boolean hasRole(RoleInterface role);

    void addRole(RoleInterface role);

    void deleteRole(RoleInterface role);
}
