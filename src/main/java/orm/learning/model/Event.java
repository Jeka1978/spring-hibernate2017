package orm.learning.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Evegeny on 16/03/2017.
 */
@Entity
public class Event {
    @ManyToOne
    @JoinColumn(name = "personID")
    private Person myOwner;
}
