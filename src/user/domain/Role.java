package user.domain;

/**
 * Role for users class
 */
public class Role implements RoleInterface {

    /**
     * Name of role
     */
    private String name;

    /**
     * Name of code
     */
    private String code;

    /**
     * If it an default role created by app developers (cannot be changed by the end-users)
     */
    private boolean defaultCreated;

    public Role(String code, String name, boolean isDefaultCreated) {
        this.code = code;
        this.name = name;
        this.defaultCreated = isDefaultCreated;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public boolean isDefaultCreated() {
        return this.defaultCreated;
    }
}
