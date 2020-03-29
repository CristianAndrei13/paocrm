package user.domain;

import java.util.Map;

/**
 * User interface
 */
public interface UserInterface {

    int getId();

    String getUsername();

    Map<String, RoleInterface> getRoles();

    void addRole(RoleInterface role);

    void deleteRole(RoleInterface role);
}
