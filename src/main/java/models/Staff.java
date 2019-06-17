package models;

import java.util.Objects;

public class Staff {
    private String id;
    private String staffname;
    private String password;
    private Type type;



    public Staff(String staffname, String password) {
        this.staffname = staffname;
        this.password = password;
    }

    public Staff(String id, String staffname, String password, Type type) {
        this.id = id;
        this.staffname = staffname;
        this.password = password;
        this.type = type;
    }

    public Staff() {
    }

    public String getstaffname() {
        return staffname;
    }

    public void setstaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff user = (Staff) o;
        return Objects.equals(getstaffname(), user.getstaffname()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getstaffname(), getPassword());
    }
}
