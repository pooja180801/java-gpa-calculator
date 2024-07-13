public class User {
    private int userid;

    private String userName;

    private int course_duration;


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCourse_duration() {
        return course_duration;
    }

    public void setCourse_duration(int course_duration) {
        this.course_duration = course_duration;
    }

    public User(int userid, String userName, int course_duration) {
        this.userid = userid;
        this.userName = userName;
        this.course_duration = course_duration;
    }
}
