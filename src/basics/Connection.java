package basics;

/**
 * Created by user on 5/2/2016.
 */
public class Connection {

    public int id;
    public String fromname;
    public String toname;
    public int idf;
    public int idt;
    public boolean value;

    @Override
    public String toString() {
        return  "fromname='" + fromname + '\'' +
                ", toname='" + toname + '\'' +
                ", idf='" + idf + '\'' +
                ", idt='" + idt + '\'' +
                '}';
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getToname() {
        return toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public int getIdt() {
        return idt;
    }

    public void setIdt(int idt) {
        this.idt = idt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
