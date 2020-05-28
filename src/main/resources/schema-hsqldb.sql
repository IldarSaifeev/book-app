create sequence book_seq start with 0 increment by 1;

create table book_counter(
  book_count bigint primary key
)

create table Book(
  id uuid primary key,
  book_counter_book_count bigint references book_counter(book_count) unique,
  name varchar(100) not null
);