package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class petStatusOut {

    private long id;
    //private String category;
    private petStatusInner petStatusInner;

    public petStatusOut() {
    }

    public petStatusOut(long id, pojos.petStatusInner petStatusInner) {
        this.id = id;
        this.petStatusInner = petStatusInner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public pojos.petStatusInner getPetStatusInner() {
        return petStatusInner;
    }

    public void setPetStatusInner(pojos.petStatusInner petStatusInner) {
        this.petStatusInner = petStatusInner;
    }

    @Override
    public String toString() {
        return "petStatusOut{" +
                "id=" + id +
                ", petStatusInner=" + petStatusInner +
                '}';
    }
}
