Classes description:
- src/main/Book - JPA entity with 3 fields - id, book_counter, name
- src/main/BookCounter - class that contains primary key as a counter to the Book entity.
The counter is auto incremented with sequence and is used to count the number of the instances
inserted into the Book table. As we need this value to be unique, it must be incremented atomically upon insert, 
which is why sequence is used. The current solution uses counter-table method as @GeneratedValue is not supported
on non-ID columns and it is more DB-agnostic than using serial data types or triggers in schema.
- src/main/BookService - two simple methods, for adding and retrieving books.
- src/resources/schema.sql - schema definition for our database, for test purposes HSQLDB is used.
- src/test/BookAppApplicationTests - contains a test that starts application, inserts a bunch of book records in 
parallel via the default fork-join pool, and then checks that all previousBookCount values of Book entities are unique.