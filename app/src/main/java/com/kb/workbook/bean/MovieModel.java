package com.kb.workbook.bean;

import java.util.List;

/**
 * Created by 123 on 2017-11-27.
 */

public class MovieModel {

    /**
     * reason : success
     * result : [{"movieId":"251883","movieName":"一路绽放","pic_url":"http://img5.mtime.cn/mt/2017/11/15/182050.26845944_182X243X4.jpg"},{"movieId":"251416","movieName":"炸裂青春","pic_url":"http://img5.mtime.cn/mt/2017/11/14/165712.10446287_182X243X4.jpg"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * movieId : 251883
         * movieName : 一路绽放
         * pic_url : http://img5.mtime.cn/mt/2017/11/15/182050.26845944_182X243X4.jpg
         */

        private String movieId;
        private String movieName;
        private String pic_url;

        public String getMovieId() {
            return movieId;
        }

        public void setMovieId(String movieId) {
            this.movieId = movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }
    }
}
