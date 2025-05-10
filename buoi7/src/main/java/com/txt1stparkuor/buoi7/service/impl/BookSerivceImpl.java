package com.txt1stparkuor.buoi7.service.impl;

import com.txt1stparkuor.buoi7.constant.ErrorMessage;
import com.txt1stparkuor.buoi7.dto.request.BookCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.BookUpdateRequest;
import com.txt1stparkuor.buoi7.dto.response.BookResponse;
import com.txt1stparkuor.buoi7.entity.Author;
import com.txt1stparkuor.buoi7.entity.Book;
import com.txt1stparkuor.buoi7.entity.Category;
import com.txt1stparkuor.buoi7.exception.DuplicateResourceException;
import com.txt1stparkuor.buoi7.exception.NotFoundException;
import com.txt1stparkuor.buoi7.mapper.BookMapper;
import com.txt1stparkuor.buoi7.repository.AuthorRepository;
import com.txt1stparkuor.buoi7.repository.BookRepository;
import com.txt1stparkuor.buoi7.repository.CategoryRepository;
import com.txt1stparkuor.buoi7.service.BookService;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookSerivceImpl implements BookService {
    BookRepository bookRepository;
    BookMapper bookMapper;
    AuthorRepository authorRepository;
    CategoryRepository categoryRepository;
    public List<BookResponse> getAllBooks() {
        return bookMapper.toBookResponseList(bookRepository.findAll());
    }
    public BookResponse createBook(BookCreationRequest request) {
        if (bookRepository.existsByName(request.getName()))
            throw new DuplicateResourceException(ErrorMessage.DUPLICATE_RESOURCE,
                    new String[]{request.getName()});
        Author author=findAuthorByIdOrThrow(request.getAuthorId());
        Category category=findCategoryByIdOrThrow(request.getCategoryId());
        Book book=bookMapper.toBook(request);
        book.setAuthor(author);
        book.setCategory(category);
        return  bookMapper.toBookResponse(bookRepository.save(book));
    }

    @Override
    public BookResponse getBookById(Long id) {
        Book book= findBookByIdOrThrow(id);
        return bookMapper.toBookResponse(book);
    }

    public BookResponse updateBook(Long id, BookUpdateRequest request) {
        Book existingBook= findBookByIdOrThrow(id);
        Author author=findAuthorByIdOrThrow(request.getAuthorId());
        Category category=findCategoryByIdOrThrow(request.getCategoryId());
        bookMapper.updateBook(existingBook, request);
        Book updatedBook= bookRepository.save(existingBook);
        return bookMapper.toBookResponse(updatedBook);
    }

    public void deleteBook(Long id) {
        Book book=findBookByIdOrThrow(id);
        bookRepository.deleteById(id);
    }


    @Override
    public List<BookResponse> searchBooks(String name, BigDecimal price,
                                          Long authorId, Long categoryId) {
        Specification<Book> spec = Specification.where(null);

        if (StringUtils.hasText(name)) {
            spec = spec.and(BookSpecifications.hasNameLike(name));
        }
        if (authorId != null) {
            spec = spec.and(BookSpecifications.hasAuthorId(authorId));
        }
        if (categoryId != null) {
            spec = spec.and(BookSpecifications.hasCategoryId(categoryId));
        }

        List<Book> books = bookRepository.findAll(spec);

        return bookMapper.toBookResponseList(books);
    }

    private Author findAuthorByIdOrThrow(Long id) {
        Author author= authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.Author.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}));
        return author;
    }
    private Category findCategoryByIdOrThrow(Long id) {
        Category category= categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.Category.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}));
        return category;
    }
    private Book findBookByIdOrThrow(Long id) {
        Book book= bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.Book.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}));
        return book;
    }
    private static class BookSpecifications {

        public static Specification<Book> hasNameLike(String name) {
            return (root, query, criteriaBuilder) -> {
                String pattern = "%" + name.toLowerCase() + "%";
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), pattern);
            };
        }

        public static Specification<Book> hasAuthorId(Long authorId) {
            return (root, query, criteriaBuilder) -> {
                Join<Book, Author> authorJoin = root.join("author", JoinType.INNER);
                return criteriaBuilder.equal(authorJoin.get("id"), authorId);
            };
        }

        public static Specification<Book> hasCategoryId(Long categoryId) {
            return (root, query, criteriaBuilder) -> {
                Join<Book, Category> categoryJoin = root.join("category", JoinType.INNER);
                return criteriaBuilder.equal(categoryJoin.get("id"), categoryId);
            };
        }
    }
}
