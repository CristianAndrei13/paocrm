package core.domain.helper;

import java.util.Date;

/**
 * Basic schema of a Core domain
 */
abstract public class BasicDomain {

    /**
     * Id of object
     */
    protected int id;

    /**
     * Date of creation
     */
    protected Date created;

    /**
     * Date of last update
     */
    protected Date updated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
