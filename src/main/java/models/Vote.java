package models;

public class Vote {
    private User student;
    private User staff;
    private User faculty;

    public Vote(User student, User staff, User faculty) {
        this.student = student;
        this.staff = staff;
        this.faculty = faculty;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    public User getFaculty() {
        return faculty;
    }

    public void setFaculty(User faculty) {
        this.faculty = faculty;
    }
}
