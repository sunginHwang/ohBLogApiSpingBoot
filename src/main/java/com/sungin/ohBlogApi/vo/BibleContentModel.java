package com.sungin.ohBlogApi.vo;

/**
 * Created by hwangseong-in on 2017. 3. 13..
 */
public class BibleContentModel {

    /*성경종류 인덱스*/
    private int bibleIndex;
    /*성경종류 이름*/
    private String bibleName;
    /*성경 책 인덱스*/
    private int bookKindIdx;
    /*신세기 구세기 구분*/
    private int bibleKind;
    /*성경 언어 구분*/
    private String language;
    /*책 이름 */
    private String bookName;
    /*해당 성경 책 최대 장 수*/
    private int bookMaxChapter;
    /*해당 성경 책 최대 절 수*/
    private int chapterMaxParagraph;
    /*성경 절 말씀 내용*/
    private String paragraphValue;
    /*성경 장 */
    private int chapter;
    /*성경 절*/
    private int paragraph;

    public int getBibleIndex() {
        return bibleIndex;
    }

    public void setBibleIndex(int bibleIndex) {
        this.bibleIndex = bibleIndex;
    }

    public String getBibleName() {
        return bibleName;
    }

    public void setBibleName(String bibleName) {
        this.bibleName = bibleName;
    }

    public int getBookKindIdx() {
        return bookKindIdx;
    }

    public void setBookKindIdx(int bookKindIdx) {
        this.bookKindIdx = bookKindIdx;
    }

    public int getBibleKind() {
        return bibleKind;
    }

    public void setBibleKind(int bibleKind) {
        this.bibleKind = bibleKind;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookMaxChapter() {
        return bookMaxChapter;
    }

    public void setBookMaxChapter(int bookMaxChapter) {
        this.bookMaxChapter = bookMaxChapter;
    }

    public int getChapterMaxParagraph() {
        return chapterMaxParagraph;
    }

    public void setChapterMaxParagraph(int chapterMaxParagraph) {
        this.chapterMaxParagraph = chapterMaxParagraph;
    }

    public String getParagraphValue() {
        return paragraphValue;
    }

    public void setParagraphValue(String paragraphValue) {
        this.paragraphValue = paragraphValue;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getParagraph() {
        return paragraph;
    }

    public void setParagraph(int paragraph) {
        this.paragraph = paragraph;
    }



}
