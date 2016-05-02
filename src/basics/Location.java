package basics;

/**
 * Created by user on 5/2/2016.
 */
public class Location {
    public String name;
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "  id=" + id ;
    }
}
