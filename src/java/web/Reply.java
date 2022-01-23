/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adriaan
 */
@Entity
@Table(name = "replies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reply.findAll", query = "SELECT r FROM Reply r")
    , @NamedQuery(name = "Reply.findById", query = "SELECT r FROM Reply r WHERE r.id = :id")
    , @NamedQuery(name = "Reply.findByReplyText", query = "SELECT r FROM Reply r WHERE r.replyText = :replyText")})
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "reply_text")
    private String replyText;
    @JoinColumn(name = "comment_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Comment commentFk;
    @JoinColumn(name = "user_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userFk;

    public Reply() {
    }

    public Reply(Integer id) {
        this.id = id;
    }

    public Reply(Integer id, String replyText) {
        this.id = id;
        this.replyText = replyText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public Comment getCommentFk() {
        return commentFk;
    }

    public void setCommentFk(Comment commentFk) {
        this.commentFk = commentFk;
    }

    public User getUserFk() {
        return userFk;
    }

    public void setUserFk(User userFk) {
        this.userFk = userFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reply)) {
            return false;
        }
        Reply other = (Reply) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Reply[ id=" + id + " ]";
    }
    
}
