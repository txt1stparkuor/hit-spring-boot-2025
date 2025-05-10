package com.txt1stparkuor.buoi7.constant;

public class UrlConstant {
    public static class Book {
        private Book() {}
        public static final String PRE_FIX = "/books";
        public static final String GET_BOOKS = PRE_FIX;
        public static final String GET_BOOK = PRE_FIX + "/{id}";
        public static final String CREATE_BOOK = PRE_FIX;
        public static final String UPDATE_BOOK = PRE_FIX + "/{id}";
        public static final String DELETE_BOOK = PRE_FIX + "/{id}";
    }

    public static class Author {
        private Author() {}
        public static final String PRE_FIX = "/authors";
        public static final String GET_AUTHORS = PRE_FIX;
        public static final String GET_AUTHOR = PRE_FIX + "/{id}";
        public static final String CREATE_AUTHOR = PRE_FIX;
        public static final String UPDATE_AUTHOR = PRE_FIX + "/{id}";
        public static final String DELETE_AUTHOR = PRE_FIX + "/{id}";
    }
    public static class Category {
        private Category() {}
        public static final String PRE_FIX = "/categorys";
        public static final String GET_CATEGORIES = PRE_FIX;
        public static final String GET_CATEGORY= PRE_FIX + "/{id}";
        public static final String CREATE_CATEGORY= PRE_FIX;
        public static final String UPDATE_CATEGORY= PRE_FIX + "/{id}";
        public static final String DELETE_CATEGORY= PRE_FIX + "/{id}";
    }
}