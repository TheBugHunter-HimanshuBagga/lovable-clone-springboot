package com.HimanshuBagga.projects.lovable_clone_springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "projects",
        indexes = {
            @Index(name = "idx_projects_updated_at_desc", columnList = "updated_at DESC, deleted_at"),
                @Index(name = "idx_projects_deleted_at", columnList = "deleted_at")
        }
)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @ManyToOne
    @JoinColumn(name = "owner_Id" , nullable = false)
    User owner; // Many projects belong to One owner

    Boolean isPublic = false; // by default make project Private

    @CreationTimestamp
    Instant createdAt;
    @UpdateTimestamp
    Instant updatedAt;

    Instant deletedAt;


}

/*
            INDEXING

Now imagine a database.

Student Table
ID	Name	Age
1	Rahul	20
2	Amit	19
3	Priya	22
4	Rohan	21
5	Sneha	20

Now you run

SELECT * FROM student
WHERE name='Priya';


Without Index

Database checks

Rahul ❌

Amit ❌

Priya ✅

Done

It looked at every row.

This is called

Full Table Scan

Time Complexity

O(n)

Suppose there are

100 Million rows

Now?

The database may check millions of rows.

Very slow.



With Index

Database creates something like

Amit -> Row 2

Priya -> Row 3

Rahul -> Row 1

Rohan -> Row 4

Sneha -> Row 5

Now

Need Priya?

↓

Go directly to Priya

↓

Return Row 3

Instead of

100 Million comparisons

Maybe only

25 comparisons

Huge improvement.


Why is it faster?
Because databases use
B Tree
or
B+ Tree
internally.
Not HashMap.







Suppose your table is:

ID	Name	Email
1	Himanshu	himanshu@gmail.com
2	Rahul	hb0184@srmist.edu.in
3	Amit	bagga@gmail.com

If you create an index on the email column:

@Table(indexes = {
    @Index(name = "idx_email", columnList = "email")
})

The database creates an internal structure that is conceptually similar to:

bagga@gmail.com        ---> Row 3

hb0184@srmist.edu.in  ---> Row 2

himanshu@gmail.com    ---> Row 1
 */
