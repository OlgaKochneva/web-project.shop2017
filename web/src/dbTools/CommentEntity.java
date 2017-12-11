package dbTools;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "comments", schema = "web_lab")
public class CommentEntity {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Text", nullable = false, length = 128)
    private String text;
    @Column(name = "CommentDate", nullable = false, length = 32)
    private String commentDate;
    @Column(name = "UserName", nullable = false, length = 16)
    private String userName;

    public CommentEntity() {
    }

    public CommentEntity(String text, String userName) {
        this.text = text;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        String date = format.format(new Date());
        this.commentDate = date;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (commentDate != null ? !commentDate.equals(that.commentDate) : that.commentDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (commentDate != null ? commentDate.hashCode() : 0);
        return result;
    }
}
