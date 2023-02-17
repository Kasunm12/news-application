package com.orelit.myapplication.dto;

import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ScienceNewsDTO {
    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    ArrayList <Data> data;

    public ScienceNewsDTO(String category, boolean success, ArrayList<Data> data) {
        this.category = category;
        this.success = success;
        this.data = data;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("author")
        @Expose
        private String author;

        @SerializedName("content")
        @Expose
        private String content;

        @SerializedName("date")
        @Expose
        private String date;

        @SerializedName("id")
        @Expose
        private String id;

        @SerializedName("imageUrl")
        @Expose
        private String imageUrl;

        @SerializedName("readMoreUrl")
        @Expose
        private String readMoreUrl;

        @SerializedName("time")
        @Expose
        private String time;

        @SerializedName("title")
        @Expose
        private String title;

        @SerializedName("url")
        @Expose
        private String url;

        public Data(String author, String content, String date, String id, String imageUrl, String readMoreUrl, String time, String title, String url) {
            this.author = author;
            this.content = content;
            this.date = date;
            this.id = id;
            this.imageUrl = imageUrl;
            this.readMoreUrl = readMoreUrl;
            this.time = time;
            this.title = title;
            this.url = url;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getReadMoreUrl() {
            return readMoreUrl;
        }

        public void setReadMoreUrl(String readMoreUrl) {
            this.readMoreUrl = readMoreUrl;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
