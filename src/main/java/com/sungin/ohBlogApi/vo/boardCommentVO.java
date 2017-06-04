package com.sungin.ohBlogApi.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by hwangseong-in on 2017. 6. 3..
 */

public class BoardCommentVO {
    /*게시글 댓글 키*/
    private int commentKey;
    /*댓글에 해당되는 게시글 키*/
    private int boardKey;
    /*댓글 작성자*/
    private int memberKey;
    /*댓글 작성자 닉네임*/
    private String memberNickName;
    /*댓글 본문*/
    private String commentContent;
    /*댓글 최초 작성일*/
    private Date regiDate;
    /*댓글 수정일*/
    private Date updateDate;
    /*삭제 여부 Y : 삭제  , N : 삭제 안됨*/
    private String flag;

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public int getCommentKey() {
        return commentKey;
    }

    public void setCommentKey(int commentKey) {
        this.commentKey = commentKey;
    }

    public int getBoardKey() {
        return boardKey;
    }

    public void setBoardKey(int boardKey) {
        this.boardKey = boardKey;
    }

    public int getMemberKey() {
        return memberKey;
    }

    public void setMemberKey(int memberKey) {
        this.memberKey = memberKey;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
