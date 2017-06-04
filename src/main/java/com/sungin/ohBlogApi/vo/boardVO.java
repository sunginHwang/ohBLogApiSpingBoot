package com.sungin.ohBlogApi.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * Created by hwangseong-in on 2017. 6. 3..
 */

public class BoardVO {

    /*게시글 번호*/
    private int boardKey;
    /*게시글 제목*/
    private String title;
    /*게시글 내용*/
    private String content;
    /*게시글 최초 등록일*/
    private Date regiDate;
    /*게시글 수정일*/
    private Date updateDate;
    /*게시글 삭제유무 Y : 삭제 된 글 , N : 삭제 안된 글*/
    private String flag;
    /*게시글 등록 사용자 키*/
    private int memberKey;
    /*게시글 등록 사용자 닉네임*/
    private String memberNickName;
    /*게시글 등록 사용자 아이디*/
    private String memberId;
    /*게시글 대표 이미지 경로*/
    private String boardSubImg;
    /*게시글 카테고리 키*/
    private String codeKey;
    /*게시글 카테고리 키*/
    private int categoryKey;
    /*조회수*/
    private int hits;
    /*게시글 카테고리 이름*/
    private String categoryName;
    /*게시글 카테고리 삭제여부  Y : 삭제  , N : 삭제 안됨 */
    private String delYn;
    /*게시글 갯수*/
    private int limit;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setMemberKey(int memberKey) {
        this.memberKey = memberKey;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public int getBoardKey() {
        return boardKey;
    }

    public void setBoardKey(int boardKey) {
        this.boardKey = boardKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getMemberKey() {
        return memberKey;
    }

    public void setMember_key(int memberKey) {
        this.memberKey = memberKey;
    }

    public String getBoardSubImg() {
        return boardSubImg;
    }

    public void setBoardSubImg(String boardSubImg) {
        this.boardSubImg = boardSubImg;
    }

    public String getCodeKey() {
        return codeKey;
    }

    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    public int getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(int categoryKey) {
        this.categoryKey = categoryKey;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public BoardVO() {
    }

    public BoardVO(int categoryKey, int limit, String flag) {
        this.categoryKey = categoryKey;
        this.limit = limit;
        this.flag = flag;
    }
}

